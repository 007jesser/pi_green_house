package tn.esprit.pi_green.services;

import tn.esprit.pi_green.entity.Serre;
import java.util.List;
import java.util.Optional;

public interface ISerreService {
    // Read: Get all serres
    List<Serre> getAllSerres();

    // Read: Get a single serre by its id
    Optional<Serre> getSerreById(int id);

    // Create: Add a new serre
    Serre createSerre(Serre serre);

    // Update: Update an existing serre
    Serre updateSerre(int id, Serre serreDetails);

    // Delete: Delete a serre by its id
    void deleteSerre(int id);
}
