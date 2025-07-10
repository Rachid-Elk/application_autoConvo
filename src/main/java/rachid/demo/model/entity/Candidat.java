
package rachid.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

import lombok.*;

@Entity
@Table(
        name = "candidat"
)

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Candidat {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private @NotEmpty @Size(
            min = 4,
            max = 8
    ) String cin;
    private @NotEmpty @Size(
            min = 3,
            max = 50
    ) String nom;
    private @NotEmpty @Size(
            min = 3,
            max = 50
    ) String prenom;
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private LocalDate dateAttribuee;
    @Column(length = 1)
    private String sexe; // "M" ou "F"

    @Column
    private Integer categorie; // 1, 2, 3
    @ManyToOne
    @JoinColumn(
            name = "province_id"
    )
    private Province province;

    public Candidat(String cin, String nom, String prenom, Province province) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.province = province;
    }

    public Candidat(String cin, String nom, String prenom, Province province, LocalDate dateAttribuee) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.province = province;
        this.dateAttribuee = dateAttribuee;
    }

}
