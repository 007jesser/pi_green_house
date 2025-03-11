package tn.esprit.pi_green.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.pi_green.entity.Plante;
import tn.esprit.pi_green.entity.Plante;
import tn.esprit.pi_green.services.*;
import java.util.List;

@RestController
@RequestMapping("/entity/plantes")
public class PlantController {
    private final PlanteService planteService;

    public PlantController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @GetMapping
    public List<Plante> getAllPlantes() {
        return planteService.getAllPlantes();
    }
}
