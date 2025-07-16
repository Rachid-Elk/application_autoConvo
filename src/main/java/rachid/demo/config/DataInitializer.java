package rachid.demo.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import rachid.demo.model.entity.*;
import rachid.demo.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer {

    private final CentreRepository centreRepository;
    private final ProvinceRepository provinceRepository;
    private final CandidatRepository candidatRepository;
    private final ParametreRepository parametreRepository;
    private final JourExclueRepository jourExclueRepository;

    public DataInitializer(CentreRepository centreRepository,
                           ProvinceRepository provinceRepository,
                           CandidatRepository candidatRepository,
                           ParametreRepository parametreRepository,
                           JourExclueRepository jourExclueRepository) {
        this.centreRepository = centreRepository;
        this.provinceRepository = provinceRepository;
        this.candidatRepository = candidatRepository;
        this.parametreRepository = parametreRepository;
        this.jourExclueRepository = jourExclueRepository;
    }

    @PostConstruct
    public void init() {
        // 1. Création des centres
        Centre centreCasa = Centre.builder().nom("Casablanca").build();
        Centre centreRabat = Centre.builder().nom("Rabat").build();
        Centre centreMarrakech = Centre.builder().nom("Marrakech").build();
        centreRepository.saveAll(List.of(centreCasa, centreRabat, centreMarrakech));

        // 2. Création des provinces liées aux centres
        Province provinceCasa = Province.builder().nom("Aïn Sebaâ").centre(centreCasa).build();
        Province provinceDerb = Province.builder().nom("Derb Sultan").centre(centreCasa).build();
        Province provinceSalé = Province.builder().nom("Salé").centre(centreRabat).build();
        Province provinceTarga = Province.builder().nom("Targa").centre(centreMarrakech).build();
        provinceRepository.saveAll(List.of(provinceCasa, provinceDerb, provinceSalé, provinceTarga));

        // 3. Création du paramètre de convocation
        Parametre parametre = Parametre.builder()
                .totalParJour(100)
                .maxParProvinceParJour(50)
                .dateDebut(LocalDate.of(2025, 7, 1))
                .build();
        parametreRepository.save(parametre);

        // 4. Création des jours exclus
        JourExclue jour1 = JourExclue.builder()
                .jourFerie(LocalDate.of(2025, 7, 20))
                .description("Fête nationale")
                .build();
        jourExclueRepository.save(jour1);

        // 5. Génération des candidats
        Random random = new Random();
        List<Candidat> candidats = new ArrayList<>();
        long cinCounter = 100000;

        List<Province> provinces = List.of(provinceCasa, provinceDerb, provinceSalé, provinceTarga);

        for (Province province : provinces) {
            for (int j = 0; j < 125; j++) {
                String cin = "C" + cinCounter++;
                if (cin.length() > 8) {
                    cin = cin.substring(0, 8);
                }

                String nom = "Nom" + cinCounter;
                String prenom = "Prenom" + cinCounter;
                String sexe = random.nextBoolean() ? "M" : "F";
                int categorie = 1 + random.nextInt(3); // 1, 2 ou 3

                Candidat candidat = Candidat.builder()
                        .cin(cin)
                        .nom(nom)
                        .prenom(prenom)
                        .sexe(sexe)
                        .categorie(categorie)
                        .province(province)
                        .dateAttribuee(null)
                        .build();

                candidats.add(candidat);
            }
        }

        candidatRepository.saveAll(candidats);

        System.out.println("✅ Initialisation des données terminée avec succès.");
    }
}







//package rachid.demo.config;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.stereotype.Component;
//import rachid.demo.model.entity.*;
//import rachid.demo.repository.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public class DataInitializer {
//
//    private final CentreRepository centreRepository;
//    private final ProvinceRepository provinceRepository;
//    private final CandidatRepository candidatRepository;
//    private final ParametreRepository parametreRepository;
//    private final JourExclueRepository jourExclueRepository;
//
//    public DataInitializer(CentreRepository centreRepository,
//                           ProvinceRepository provinceRepository,
//                           CandidatRepository candidatRepository,
//                           ParametreRepository parametreRepository,
//                           JourExclueRepository jourExclueRepository) {
//        this.centreRepository = centreRepository;
//        this.provinceRepository = provinceRepository;
//        this.candidatRepository = candidatRepository;
//        this.parametreRepository = parametreRepository;
//        this.jourExclueRepository = jourExclueRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//        // 1. Création des centres
//        Centre centreCasa = Centre.builder().nom("Casablanca").build();
//        Centre centreRabat = Centre.builder().nom("Rabat").build();
//        Centre centreMarrakech = Centre.builder().nom("Marrakech").build();
//        centreRepository.saveAll(List.of(centreCasa, centreRabat, centreMarrakech));
//
//        // 2. Création des provinces liées aux centres
//        Province provinceCasa = Province.builder().nom("Aïn Sebaâ").centre(centreCasa).build();
//        Province provinceDerb = Province.builder().nom("Derb Sultan").centre(centreCasa).build();
//        Province provinceSalé = Province.builder().nom("Salé").centre(centreRabat).build();
//        Province provinceTarga = Province.builder().nom("Targa").centre(centreMarrakech).build();
//        provinceRepository.saveAll(List.of(provinceCasa, provinceDerb, provinceSalé, provinceTarga));
//
//        // 3. Création des paramètres
//        Parametre parametre = Parametre.builder()
//                .totalParJour(100)
//                .maxParProvinceParJour(50)
//                .dateDebut(LocalDate.of(2025, 7, 1))
//                .build();
//        parametreRepository.save(parametre);
//
//        // 4. Création des jours exclus (jours fériés)
//        JourExclue jour1 = JourExclue.builder()
//                .jourFerie(LocalDate.of(2025, 7, 20))
//                .description("Fête nationale")
//                .build();
//        jourExclueRepository.save(jour1);
//
//        // 5. Création des candidats (au moins 500)
//        Random random = new Random();
//        List<Candidat> candidats = new ArrayList<>();
//        long cinCounter = 100000;
//
//        List<Province> provinces = List.of(provinceCasa, provinceDerb, provinceSalé, provinceTarga);
//
//        for (Province province : provinces) {
//            for (int j = 0; j < 125; j++) {  // 125 * 4 provinces = 500 candidats
//                // Génération d'un cin valide : longueur 7 (ex: C100000)
//                String cin = "C" + cinCounter++;
//                if (cin.length() > 8) { // Juste en sécurité, tronquer si trop long
//                    cin = cin.substring(0, 8);
//                }
//
//                String nom = "Nom" + cinCounter;
//                String prenom = "Prenom" + cinCounter;
//                String sexe = random.nextBoolean() ? "M" : "F";
//                int categorie = 1 + random.nextInt(3);
//
//                Candidat candidat = Candidat.builder()
//                        .cin(cin)
//                        .nom(nom)
//                        .prenom(prenom)
//                        .province(province)
//                        .sexe(sexe)
//                        .categorie(categorie)
//                        .dateAttribuee(null)
//                        .build();
//
//                candidats.add(candidat);
//            }
//        }
//
//        candidatRepository.saveAll(candidats);
//
//        System.out.println("Initialisation des données terminée avec succès.");
//    }
//}
