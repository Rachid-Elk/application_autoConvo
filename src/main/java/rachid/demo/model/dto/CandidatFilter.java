package rachid.demo.model.dto;

import lombok.Data;

@Data
public class CandidatFilter {
    private String province;
    private String centre;
    private String sexe;
    private Integer categorie;
    private String sortBy;
    private String sortDirection;
}
