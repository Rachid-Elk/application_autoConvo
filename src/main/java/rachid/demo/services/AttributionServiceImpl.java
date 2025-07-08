//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.services;

import jakarta.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Generated;
import org.springframework.stereotype.Service;
import rachid.demo.model.entity.Candidat;
import rachid.demo.model.entity.JourExclue;
import rachid.demo.model.entity.Parametre;
import rachid.demo.model.entity.Province;
import rachid.demo.repository.CandidatRepository;
import rachid.demo.repository.JourExclueRepository;
import rachid.demo.repository.ParametreRepository;
import rachid.demo.repository.ProvinceRepository;

@Service
public class AttributionServiceImpl implements AttributionService {
    private final CandidatRepository candidatRepository;
    private final ProvinceRepository provinceRepository;
    private final ParametreRepository parametreRepository;
    private final JourExclueRepository jourExclueRepository;

    @Transactional
    public void attribuerDates() {
        Parametre param = this.parametreRepository.findFirstByOrderByIdAsc();
        if (param == null) {
            throw new IllegalStateException("⚠️ Paramètre non défini !");
        } else {
            int totalParJour = param.getTotalParJour();
            int maxParProvinceParJour = param.getMaxParProvinceParJour();
            LocalDate dateDebut = param.getDateDebut();
            List<Province> provinces = this.provinceRepository.findAll();
            List<LocalDate> joursExclus = (List)this.jourExclueRepository.findAll().stream().map(JourExclue::getJourFerie).collect(Collectors.toList());
            List<Candidat> candidats = this.candidatRepository.findByDateAttribueeIsNull();
            System.out.println("candidatsAttri :" + String.valueOf(candidats));
            int indexStart = 0;

            for(int jourOffset = 0; !candidats.isEmpty(); indexStart = (indexStart + 1) % provinces.size()) {
                LocalDate jourActuel = dateDebut.plusDays((long)(jourOffset++));
                if (!joursExclus.contains(jourActuel) && !this.isWeekend(jourActuel)) {
                    Map<Long, Integer> attribueParProvince = new HashMap();

                    for(Province p : provinces) {
                        attribueParProvince.put(p.getId(), 0);
                    }

                    int totalCandidatsDuJour = 0;
                    System.out.println("totalCandidatsDuJour :" + totalCandidatsDuJour);

                    for(int i = 0; i < provinces.size(); ++i) {
                        Province currentProvince = (Province)provinces.get((indexStart + i) % provinces.size());
                        int attribues = 0;
                        Iterator<Candidat> it = candidats.iterator();

                        while(it.hasNext() && attribues < maxParProvinceParJour && totalCandidatsDuJour < totalParJour) {
                            Candidat c = (Candidat)it.next();
                            if (c.getProvince().getId().equals(currentProvince.getId())) {
                                c.setDateAttribuee(jourActuel);
                                ++attribues;
                                ++totalCandidatsDuJour;
                                it.remove();
                            }
                        }

                        attribueParProvince.put(currentProvince.getId(), attribues);
                    }

                    if (totalCandidatsDuJour < totalParJour) {
                        for(int i = 0; i < provinces.size(); ++i) {
                            Province currentProvince = (Province)provinces.get((indexStart + i) % provinces.size());
                            Iterator<Candidat> it = candidats.iterator();

                            while(it.hasNext() && totalCandidatsDuJour < totalParJour) {
                                Candidat c = (Candidat)it.next();
                                if (c.getProvince().getId().equals(currentProvince.getId())) {
                                    c.setDateAttribuee(jourActuel);
                                    ++totalCandidatsDuJour;
                                    it.remove();
                                }
                            }
                        }
                    }
                }
            }

            this.candidatRepository.saveAll(this.candidatRepository.findAll());
        }
    }

    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    @Generated
    public AttributionServiceImpl(final CandidatRepository candidatRepository, final ProvinceRepository provinceRepository, final ParametreRepository parametreRepository, final JourExclueRepository jourExclueRepository) {
        this.candidatRepository = candidatRepository;
        this.provinceRepository = provinceRepository;
        this.parametreRepository = parametreRepository;
        this.jourExclueRepository = jourExclueRepository;
    }
}
