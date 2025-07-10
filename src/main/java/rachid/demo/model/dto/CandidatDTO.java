package rachid.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidatDTO {
    private Long id;
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;
    private Integer categorie;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateAttribuee;
    private String provinceNom;
    private String centreNom;

    // Getters & Setters
}