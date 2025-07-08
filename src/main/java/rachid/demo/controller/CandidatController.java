//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.controller;

import java.io.PrintStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import rachid.demo.model.dto.AttributionResultDTO;
import rachid.demo.model.entity.Candidat;
import rachid.demo.repository.CandidatRepository;
import rachid.demo.repository.ProvinceRepository;
import rachid.demo.services.AttributionService;
import rachid.demo.services.CandidatServiceImpl;

@CrossOrigin({"*"})
@Controller
public class CandidatController {
    @Autowired
    private CandidatServiceImpl candidatServiceImpl;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private CandidatRepository candidatRepository;
    @Autowired
    private AttributionService attributionService;

    @GetMapping({"/candidats"})
    public String afficherCandidats(Model model) {
        List<Candidat> candidats = this.candidatServiceImpl.listerCandidats();

        for(Candidat c : candidats) {
            PrintStream var10000 = System.out;
            String var10001 = c.getNom();
            var10000.println("Candidat : " + var10001 + " - Province : " + (c.getProvince() != null ? c.getProvince().getNom() : "Aucune"));
        }

        model.addAttribute("candidats", candidats);
        return "candidats";
    }

    @GetMapping({"/attribuer-dates"})
    public String attribuerDates(Model model) {
        this.attributionService.attribuerDates();
        return "candidats";
    }

    @GetMapping({"/resultats"})
    public String afficherResultats(Model model) {
        List<AttributionResultDTO> resultats = this.candidatRepository.getAttributionResults();
        model.addAttribute("resultats", resultats);
        return "resultats";
    }
}
