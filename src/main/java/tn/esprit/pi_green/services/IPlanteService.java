package tn.esprit.pi_green.services;

import tn.esprit.pi_green.entity.Plante;
import java.util.List;
import java.util.Optional;

public interface IPlanteService {
    // Read: Get all plantes
    List<Plante> getAllPlantes();

    // Read: Get a single plante by its id
    Optional<Plante> getPlanteById(int id);

    // Create: Add a new plante
    Plante addPlante(Plante plante);

    // Update: Update an existing plante
    Plante updatePlante(int id, Plante updatedPlante);

    // Delete: Delete a plante by its id
    boolean deletePlante(int id);
}
