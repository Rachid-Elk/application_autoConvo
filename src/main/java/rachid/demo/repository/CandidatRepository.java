//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rachid.demo.model.dto.AttributionResultDTO;
import rachid.demo.model.entity.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Long> {
    List<Candidat> findByDateAttribueeIsNull();

    @Query("SELECT new rachid.demo.dto.AttributionResultDTO(p.id, p.nom, c.dateAttribuee, COUNT(c)) FROM Candidat c JOIN c.province p GROUP BY p.id, p.nom, c.dateAttribuee")
    List<AttributionResultDTO> getAttributionResults();
}
