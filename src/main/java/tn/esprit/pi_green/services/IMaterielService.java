package tn.esprit.pi_green.services;

import tn.esprit.pi_green.entity.Materiel;
import java.util.List;
import java.util.Optional;

public interface IMaterielService {
    // Create Materials
    Materiel createMateriel(Materiel materiel);

    // Read All Materials
    List<Materiel> getAllMateriels();

    // Read Materials by ID
    Optional<Materiel> getMaterielById(int id);

    // Update Materiel
    Materiel updateMateriel(int id, Materiel materielDetails);

    // Delete Materiel
    void deleteMateriel(int id);
}
