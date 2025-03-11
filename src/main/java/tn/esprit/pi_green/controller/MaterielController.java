package tn.esprit.pi_green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi_green.entity.Materiel;
import tn.esprit.pi_green.services.MaterielService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/materiel")
public class MaterielController {

    @Autowired
    private MaterielService materielService;

    @PostMapping
    public Materiel createMateriel(@RequestBody Materiel materiel) {
        return materielService.createMateriel(materiel);
    }
    @GetMapping
    public List<Materiel> getAllMateriels() {
        return materielService.getAllMateriels();
    }

    @GetMapping("/{id}")
    public Optional<Materiel> getMaterielById(@PathVariable int id) {
        return materielService.getMaterielById(id);
    }

    @PutMapping("/{id}")
    public Materiel updateMateriel(@PathVariable int id, @RequestBody Materiel materielDetails) {
        return materielService.updateMateriel(id, materielDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMateriel(@PathVariable int id) {
        materielService.deleteMateriel(id);
    }
}
