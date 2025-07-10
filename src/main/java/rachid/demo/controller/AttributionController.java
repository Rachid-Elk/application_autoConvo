package rachid.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import rachid.demo.model.dto.AttributionResult;

import rachid.demo.model.dto.AttributionResultDTO;
import rachid.demo.services.AttributionServiceImpl;

import java.util.List;

@Controller
public class AttributionController {

    @Autowired
    private AttributionServiceImpl attributionServiceImpl;

    @GetMapping("/resultats")
    public String afficherResultats(Model model) {
        List<AttributionResultDTO> resultats = attributionServiceImpl.getAttributionResults();
        model.addAttribute("resultats", resultats);
        return "resultats";
    }
}


