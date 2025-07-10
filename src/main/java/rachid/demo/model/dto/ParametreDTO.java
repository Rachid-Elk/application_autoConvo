package rachid.demo.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametreDTO {
    private Long id;
    private int totalParJour;
    private int maxParProvinceParJour;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    // Getters & Setters
}