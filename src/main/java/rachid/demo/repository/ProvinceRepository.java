//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rachid.demo.model.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Province findByNom(String provinceA);
}
