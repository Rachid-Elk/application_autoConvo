//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.config;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import rachid.demo.model.entity.Candidat;
import rachid.demo.model.entity.Province;
import rachid.demo.repository.CandidatRepository;
import rachid.demo.repository.JourExclueRepository;
import rachid.demo.repository.ParametreRepository;
import rachid.demo.repository.ProvinceRepository;

@Configuration
public class DataInitializer {
    CommandLineRunner initData(CandidatRepository candidatRepository, JourExclueRepository jourExclueRepository, ParametreRepository parametreRepository, ProvinceRepository provinceRepository) {
        return (args) -> {
            if (provinceRepository.count() == 0L) {
                Province p1 = new Province(1L, "PROVINCE A");
                Province p2 = new Province(2L, "PROVINCE B");
                Province p3 = new Province(3L, "PROVINCE C");
                Province p4 = new Province(4L, "PROVINCE D");
                Province p5 = new Province(5L, "PROVINCE E");
                provinceRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
            }

            if (candidatRepository.count() == 0L) {
                Province provinceA = (Province)provinceRepository.findById(1L).orElse((Object)null);
                Province provinceB = (Province)provinceRepository.findById(2L).orElse((Object)null);

                for(int i = 1; i <= 100; ++i) {
                    Candidat c1 = new Candidat("A00" + i, "NomA" + i, "PrenomA" + i, provinceA);
                    Candidat c2 = new Candidat("B00" + i, "NomB" + i, "PrenomB" + i, provinceB);
                    candidatRepository.saveAll(Arrays.asList(c1, c2));
                }
            }

        };
    }
}
