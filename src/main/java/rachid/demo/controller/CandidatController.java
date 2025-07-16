//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package rachid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import rachid.demo.model.dto.CandidatSearchCriteria;
import rachid.demo.model.entity.Candidat;
import rachid.demo.repository.CandidatRepository;
import rachid.demo.repository.ProvinceRepository;
import rachid.demo.services.AttributionService;
import rachid.demo.services.CandidatServiceImpl;
import rachid.demo.services.CentreServiceImpl;
import rachid.demo.services.ProvinceServiceImpl;

import java.io.PrintStream;
import java.util.List;

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
    @Autowired
    private ProvinceServiceImpl provinceService;
    @Autowired
    private CentreServiceImpl centreService;

//    @GetMapping({"/candidats"})
//    public String afficherCandidats(Model model) {
//        List<Candidat> candidats = this.candidatServiceImpl.listerCandidats();
//
//        for(Candidat c : candidats) {
//            PrintStream var10000 = System.out;
//            String var10001 = c.getNom();
//            var10000.println("Candidat : " + var10001 + " - Province : " + (c.getProvince() != null ? c.getProvince().getNom() : "Aucune"));
//        }
//
//        model.addAttribute("candidats", candidats);
//        return "candidats";
//    }

//    @GetMapping("/candidats")
//    public String listCandidats(@ModelAttribute CandidatSearchCriteria filter,
//                                @RequestParam(defaultValue = "0") int page,
//                                @RequestParam(defaultValue = "10") int size,
//                                Model model) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "nom"));
//        Page<Candidat> result = candidatServiceImpl.getFilteredCandidats(filter, pageable);
//
//        model.addAttribute("candidats", result.getContent());
//        model.addAttribute("totalPages", result.getTotalPages());
//        model.addAttribute("totalItems", result.getTotalElements());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("filter", filter);
//        model.addAttribute("provinceValues", provinceService.getAllNom());
//        model.addAttribute("centreValues", centreService.getAllNom());
//
//        return "candidats";
//    }

//    @GetMapping("/candidats")
//    public String listCandidats(
//            @ModelAttribute("criteria") CandidatSearchCriteria criteria,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size,
//            Model model
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Candidat> candidats = candidatServiceImpl.getFilteredCandidats(criteria, pageable);
//
//        model.addAttribute("candidats", candidats.getContent());
//        model.addAttribute("criteria", criteria); // requis pour les champs input
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", candidats.getTotalPages());
//        model.addAttribute("pageSize", size);
//        model.addAttribute("totalItems", candidats.getTotalElements());
//
//        return "candidats";
//    }

    @GetMapping("/candidats")
    public String listCandidats(
            @ModelAttribute("criteria") CandidatSearchCriteria criteria,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Candidat> candidats = candidatServiceImpl.getFilteredCandidats(criteria, pageable);

        model.addAttribute("candidats", candidats.getContent());
        model.addAttribute("criteria", criteria);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", candidats.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("totalItems", candidats.getTotalElements());

        model.addAttribute("provinceValues", provinceRepository.findDistinctNom());
        model.addAttribute("centreValues", provinceRepository.findDistinctCentreNom());

        return "candidats";
    }
    @GetMapping({"/attribuer-dates"})
    public String attribuerDates(Model model) {
        this.attributionService.attribuerDates();
        return "redirect:/resultats";
    }

//    @GetMapping({"/resultats"})
//    public String afficherResultats(Model model) {
//        List<AttributionResultDTO> resultats = this.candidatRepository.getAttributionResults();
//        model.addAttribute("resultats", resultats);
//        return "resultats";
//    }

}
