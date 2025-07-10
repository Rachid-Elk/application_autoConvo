//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
        name = "jourexclue"
)
@Entity
public class JourExclue {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(
            shape = Shape.STRING,
            pattern = "yyyy-MM-dd"
    )
    private LocalDate jourFerie;
    private String description;

    public JourExclue(LocalDate of) {
    }

}
