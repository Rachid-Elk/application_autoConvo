package rachid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rachid.demo.model.entity.Centre;
import rachid.demo.model.entity.Province;

import java.util.List;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

    // Recherche par nom
    Province findByNom(String nom);

    // Provinces liées à un centre donné
    List<Province> findByCentre(Centre centre);

    // Tous les noms de provinces
    @Query("SELECT p.nom FROM Province p")
    List<String> findAllNoms();
}
