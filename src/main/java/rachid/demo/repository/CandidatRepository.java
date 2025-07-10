package rachid.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import rachid.demo.model.dto.AttributionResultDTO;
import rachid.demo.model.entity.Candidat;
import rachid.demo.model.entity.Province;

import java.util.List;

public interface CandidatRepository extends CrudRepository<Candidat, Long>, JpaSpecificationExecutor<Candidat> {

    // Tous les candidats sans date attribuée
    List<Candidat> findByDateAttribueeIsNull();

    // Candidats par province sans date attribuée
    List<Candidat> findByProvinceAndDateAttribueeIsNull(Province province);

    // Liste groupée des résultats d’attribution
    @Query("""
        SELECT new rachid.demo.model.dto.AttributionResultDTO(
            c.province.centre.nom,
            c.province.nom,
            c.dateAttribuee,
            COUNT(c)
        )
        FROM Candidat c
        GROUP BY c.province.centre.nom, c.province.nom, c.dateAttribuee
        ORDER BY c.province.centre.nom, c.dateAttribuee
    """)
    List<AttributionResultDTO> getAttributionResults();

    // Valeurs distinctes des provinces
    @Query("SELECT DISTINCT c.province.nom FROM Candidat c WHERE c.province IS NOT NULL")
    List<String> getDistinctProvinceValues();

    // Valeurs distinctes des centres
    @Query("SELECT DISTINCT p.centre.nom FROM Candidat c JOIN c.province p WHERE p.centre IS NOT NULL")
    List<String> getDistinctCentreValues();
}
