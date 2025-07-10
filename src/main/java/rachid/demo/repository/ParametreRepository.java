//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rachid.demo.model.entity.Parametre;

import java.util.Optional;

public interface ParametreRepository extends JpaRepository<Parametre, String> {


    Optional<Parametre> findTopByOrderByIdDesc();

}
