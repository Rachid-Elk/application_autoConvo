//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

import lombok.*;

@Entity
@Table(
        name = "parametre"
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Parametre {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private int totalParJour;
    private int maxParProvinceParJour;
    private LocalDate dateDebut;


}
