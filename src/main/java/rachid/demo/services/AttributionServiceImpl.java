package rachid.demo.services;

import jakarta.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rachid.demo.model.dto.AttributionResultDTO;
import rachid.demo.model.entity.*;
import rachid.demo.repository.*;


@Service
public class AttributionServiceImpl implements AttributionService {
    @Autowired
    private  CandidatRepository candidatRepository;
    @Autowired
    private  ProvinceRepository provinceRepository;
    @Autowired
    private  ParametreRepository parametreRepository;
    @Autowired
    private  JourExclueRepository jourExclueRepository;
    @Autowired
    private  CentreRepository centreRepository;


    @Autowired
    public AttributionServiceImpl(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    public List<AttributionResultDTO> getAttributionResults() {
        return candidatRepository.getAttributionResults();
    }


    ////attribuer date par centre
    @Transactional

    public void attribuerDates() {
        Parametre param = parametreRepository.findTopByOrderByIdDesc()
                .orElseThrow(() -> new IllegalStateException("⚠️ Paramètre non défini !"));

        int totalCandidatsParJour = param.getTotalParJour();
        int maxParProvinceParJour = param.getMaxParProvinceParJour();
        LocalDate dateDebut = param.getDateDebut();

        List<LocalDate> joursExclus = jourExclueRepository.findAll()
                .stream()
                .map(JourExclue::getJourFerie)
                .collect(Collectors.toList());

        List<Centre> centres = centreRepository.findAll();

        for (Centre centre : centres) {
            List<Province> provinces = provinceRepository.findByCentre(centre);
            int nbProvinces = provinces.size();
            int[] nbAttribue = new int[nbProvinces];
            int indexStart = 0;
            int jourOffset = 0;

            while (true) {
                // Chercher prochain jour non férié
                LocalDate jourActuel;
                do {
                    jourActuel = dateDebut.plusDays(jourOffset++);
                } while (joursExclus.contains(jourActuel) || isWeekend(jourActuel));

                Arrays.fill(nbAttribue, 0);
                int candidatsJour = 0;

                // 1er tour : max par province
                for (int i = 0; i < nbProvinces; i++) {
                    int index = (indexStart + i) % nbProvinces;
                    Province province = provinces.get(index);
                    List<Candidat> candidats = candidatRepository.findByProvinceAndDateAttribueeIsNull(province);

                    int j = 0;
                    while (j < candidats.size()
                            && nbAttribue[index] < maxParProvinceParJour
                            && candidatsJour < totalCandidatsParJour) {
                        Candidat c = candidats.get(j++);
                        c.setDateAttribuee(jourActuel);
                        candidatRepository.save(c);
                        nbAttribue[index]++;
                        candidatsJour++;
                    }
                }

                // 2e tour : compléter jusqu'à 250
                if (candidatsJour < totalCandidatsParJour) {
                    for (int i = 0; i < nbProvinces; i++) {
                        int index = (indexStart + i) % nbProvinces;
                        Province province = provinces.get(index);
                        List<Candidat> candidats = candidatRepository.findByProvinceAndDateAttribueeIsNull(province);

                        int j = 0;
                        while (j < candidats.size() && candidatsJour < totalCandidatsParJour) {
                            Candidat c = candidats.get(j++);
                            c.setDateAttribuee(jourActuel);
                            candidatRepository.save(c);
                            nbAttribue[index]++;
                            candidatsJour++;
                        }
                    }
                }

                // Vérifier s’il reste des candidats pour ce centre
                boolean resteCandidats = provinces.stream()
                        .flatMap(p -> candidatRepository.findByProvinceAndDateAttribueeIsNull(p).stream())
                        .anyMatch(c -> true);

                indexStart = (indexStart + 1) % nbProvinces;
                if (!resteCandidats) break;
            }
        }

        System.out.println("✅ Attribution des dates terminée pour tous les centres.");
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}






















////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by FernFlower decompiler)
////
//
//package rachid.demo.services;
//
//import jakarta.transaction.Transactional;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import rachid.demo.model.dto.AttributionResult;
//import rachid.demo.model.dto.CandidatDTO;
//import rachid.demo.model.entity.*;
//import rachid.demo.repository.*;
//
//@Service
//public class AttributionServiceImpl implements AttributionService {
//    @Autowired
//    private  CandidatRepository candidatRepository;
//    @Autowired
//    private  ProvinceRepository provinceRepository;
//    @Autowired
//    private  ParametreRepository parametreRepository;
//    @Autowired
//    private  JourExclueRepository jourExclueRepository;
//    @Autowired
//    private  CentreRepository centreRepository;
//
////attribuer date par Province
////    @Transactional
////    public void attribuerDates() {
////        Parametre param = this.parametreRepository.findFirstByOrderByIdAsc();
////        if (param == null) {
////            throw new IllegalStateException("⚠️ Paramètre non défini !");
////        } else {
////            int totalParJour = param.getTotalParJour();
////            int maxParProvinceParJour = param.getMaxParProvinceParJour();
////            LocalDate dateDebut = param.getDateDebut();
////            List<Province> provinces = this.provinceRepository.findAll();
////            List<LocalDate> joursExclus = (List)this.jourExclueRepository.findAll().stream().map(JourExclue::getJourFerie).collect(Collectors.toList());
////            List<Candidat> candidats = this.candidatRepository.findByDateAttribueeIsNull();
////            System.out.println("candidatsAttri :" + String.valueOf(candidats));
////            int indexStart = 0;
////
////            for(int jourOffset = 0; !candidats.isEmpty(); indexStart = (indexStart + 1) % provinces.size()) {
////                LocalDate jourActuel = dateDebut.plusDays((long)(jourOffset++));
////                if (!joursExclus.contains(jourActuel) && !this.isWeekend(jourActuel)) {
////                    Map<Long, Integer> attribueParProvince = new HashMap();
////
////                    for(Province p : provinces) {
////                        attribueParProvince.put(p.getId(), 0);
////                    }
////
////                    int totalCandidatsDuJour = 0;
////                    System.out.println("totalCandidatsDuJour :" + totalCandidatsDuJour);
////
////                    for(int i = 0; i < provinces.size(); ++i) {
////                        Province currentProvince = (Province)provinces.get((indexStart + i) % provinces.size());
////                        int attribues = 0;
////                        Iterator<Candidat> it = candidats.iterator();
////
////                        while(it.hasNext() && attribues < maxParProvinceParJour && totalCandidatsDuJour < totalParJour) {
////                            Candidat c = (Candidat)it.next();
////                            if (c.getProvince().getId().equals(currentProvince.getId())) {
////                                c.setDateAttribuee(jourActuel);
////                                ++attribues;
////                                ++totalCandidatsDuJour;
////                                it.remove();
////                            }
////                        }
////
////                        attribueParProvince.put(currentProvince.getId(), attribues);
////                    }
////
////                    if (totalCandidatsDuJour < totalParJour) {
////                        for(int i = 0; i < provinces.size(); ++i) {
////                            Province currentProvince = (Province)provinces.get((indexStart + i) % provinces.size());
////                            Iterator<Candidat> it = candidats.iterator();
////
////                            while(it.hasNext() && totalCandidatsDuJour < totalParJour) {
////                                Candidat c = (Candidat)it.next();
////                                if (c.getProvince().getId().equals(currentProvince.getId())) {
////                                    c.setDateAttribuee(jourActuel);
////                                    ++totalCandidatsDuJour;
////                                    it.remove();
////                                }
////                            }
////                        }
////                    }
////                }
////            }
////
////            this.candidatRepository.saveAll(this.candidatRepository.findAll());
////        }
////    }
//
//
////attribuer date par centre
//    @Transactional
//
//    public void attribuerDates() {
//        Parametre param = parametreRepository.findTopByOrderByIdDesc()
//                .orElseThrow(() -> new IllegalStateException("⚠️ Paramètre non défini !"));
//
//        int totalCandidatsParJour = param.getTotalParJour();
//        int maxParProvinceParJour = param.getMaxParProvinceParJour();
//        LocalDate dateDebut = param.getDateDebut();
//
//        List<LocalDate> joursExclus = jourExclueRepository.findAll()
//                .stream()
//                .map(JourExclue::getJourFerie)
//                .collect(Collectors.toList());
//
//        List<Centre> centres = centreRepository.findAll();
//
//        for (Centre centre : centres) {
//            List<Province> provinces = provinceRepository.findByCentre(centre);
//            int nbProvinces = provinces.size();
//            int[] nbAttribue = new int[nbProvinces];
//            int indexStart = 0;
//            int jourOffset = 0;
//
//            while (true) {
//                // Chercher prochain jour non férié
//                LocalDate jourActuel;
//                do {
//                    jourActuel = dateDebut.plusDays(jourOffset++);
//                } while (joursExclus.contains(jourActuel) || isWeekend(jourActuel));
//
//                Arrays.fill(nbAttribue, 0);
//                int candidatsJour = 0;
//
//                // 1er tour : max par province
//                for (int i = 0; i < nbProvinces; i++) {
//                    int index = (indexStart + i) % nbProvinces;
//                    Province province = provinces.get(index);
//                    List<Candidat> candidats = candidatRepository.findByProvinceAndDateAttribueeIsNull(province);
//
//                    int j = 0;
//                    while (j < candidats.size()
//                            && nbAttribue[index] < maxParProvinceParJour
//                            && candidatsJour < totalCandidatsParJour) {
//                        Candidat c = candidats.get(j++);
//                        c.setDateAttribuee(jourActuel);
//                        candidatRepository.save(c);
//                        nbAttribue[index]++;
//                        candidatsJour++;
//                    }
//                }
//
//                // 2e tour : compléter jusqu'à 250
//                if (candidatsJour < totalCandidatsParJour) {
//                    for (int i = 0; i < nbProvinces; i++) {
//                        int index = (indexStart + i) % nbProvinces;
//                        Province province = provinces.get(index);
//                        List<Candidat> candidats = candidatRepository.findByProvinceAndDateAttribueeIsNull(province);
//
//                        int j = 0;
//                        while (j < candidats.size() && candidatsJour < totalCandidatsParJour) {
//                            Candidat c = candidats.get(j++);
//                            c.setDateAttribuee(jourActuel);
//                            candidatRepository.save(c);
//                            nbAttribue[index]++;
//                            candidatsJour++;
//                        }
//                    }
//                }
//
//                // Vérifier s’il reste des candidats pour ce centre
//                boolean resteCandidats = provinces.stream()
//                        .flatMap(p -> candidatRepository.findByProvinceAndDateAttribueeIsNull(p).stream())
//                        .anyMatch(c -> true);
//
//                indexStart = (indexStart + 1) % nbProvinces;
//                if (!resteCandidats) break;
//            }
//        }
//
//        System.out.println("✅ Attribution des dates terminée pour tous les centres.");
//    }
//
//    private boolean isWeekend(LocalDate date) {
//        DayOfWeek day = date.getDayOfWeek();
//        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
//    }
//
//
//
//    public List<AttributionResult> getAttributionResults() {
//        return candidatRepository.getAttributionResults();
//    }
//
//}
