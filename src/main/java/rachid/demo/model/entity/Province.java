//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;

import lombok.*;

@Entity
@Table(
        name = "province"
)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nom;

    @ManyToOne
    @JoinColumn(name = "centre_id")
    private Centre centre;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    private List<Candidat> candidats;

    @Override
    public String toString() {
        return nom;
    }

    public Province(Long id, String nom, Centre centre) {
        this.id = id;
        this.nom = nom;
        this.candidats = candidats;
    }

    public Province(String provinceA) {
    }

    public Province(long l, String provinceA) {
    }

    public Province(String provinceA, Centre centre1) {
    }

}
