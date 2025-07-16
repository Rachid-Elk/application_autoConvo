package rachid.demo.model.dto;// CandidatSearchCriteria.java
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CandidatSearchCriteria {
    private String cin;
    private String nom;
    private String prenom;
    private String sexe;

    private List<String> provinceNomList = new ArrayList<>();
    private List<String> centreNomList = new ArrayList<>();
    private List<Integer> categorieList = new ArrayList<>();
}
