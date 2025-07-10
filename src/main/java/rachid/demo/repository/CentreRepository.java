package rachid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rachid.demo.model.entity.Centre;

import java.util.List;

public interface CentreRepository extends JpaRepository<Centre, Long> {

    // Tous les noms de centres
    @Query("SELECT c.nom FROM Centre c")
    List<String> findAllNoms();
}
