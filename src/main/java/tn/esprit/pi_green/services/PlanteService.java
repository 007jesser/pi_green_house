package tn.esprit.pi_green.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pi_green.entity.Plante;
import tn.esprit.pi_green.entity.Plante;
import tn.esprit.pi_green.repository.PlanteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PlanteService {

    @Autowired
    private PlanteRepository planteRepository;

    //Add a new Plante
    public Plante addPlante(Plante plante) {
        return planteRepository.save(plante);
    }

    //Get all Plantes
    public List<Plante> getAllPlantes() {
        return planteRepository.findAll();
    }

    // ✅ Get a single Plante by ID
    public Optional<Plante> getPlanteById(int id) {
        return planteRepository.findById(id);
    }

    // ✅ Update an existing Plante
    public Plante updatePlante(int id, Plante updatedPlante) {
        return planteRepository.findById(id).map(plante -> {
            plante.setName(updatedPlante.getName());
            plante.setSpecies(updatedPlante.getSpecies());
            plante.setGrowthStage(updatedPlante.getGrowthStage());
            plante.setTemperatureRequirement(updatedPlante.getTemperatureRequirement());
            plante.setHumidityRequirement(updatedPlante.getHumidityRequirement());
            plante.setLastWatered(updatedPlante.getLastWatered());
            plante.setHealthStatus(updatedPlante.getHealthStatus());
            plante.setSerre(updatedPlante.getSerre());
            return planteRepository.save(plante);
        }).orElse(null); // Or throw an exception if needed
    }

    // ✅ Delete a Plante
    public boolean deletePlante(int id) {
        if (planteRepository.existsById(id)) {
            planteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
