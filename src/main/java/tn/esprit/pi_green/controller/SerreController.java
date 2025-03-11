package tn.esprit.pi_green.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.pi_green.entity.Serre;
import tn.esprit.pi_green.services.SerreService;

import java.util.List;

@RestController
@RequestMapping("/entity/serres")
public class SerreController {
    private final SerreService serreService;

    public SerreController(SerreService serreService) {
        this.serreService = serreService;
    }

    @GetMapping
    public List<Serre> getAllSerres() {
        return serreService.getAllSerres();
    }
}
