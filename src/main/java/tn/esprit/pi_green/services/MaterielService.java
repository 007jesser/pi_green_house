package tn.esprit.pi_green.services;

import org.springframework.stereotype.Service;
import tn.esprit.pi_green.entity.Materiel;
import tn.esprit.pi_green.repository.MaterielRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MaterielService {

    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    // Create Material
    public Materiel createMateriel(Materiel materiel) {
        return materielRepository.save(materiel);
    }

    // Read All Materials
    public List<Materiel> getAllMateriels() {
        return materielRepository.findAll();
    }

    // Material by ID
    public Optional<Materiel> getMaterielById(int id) {
        return materielRepository.findById(id);
    }

    // Update Materiel
    public Materiel updateMateriel(int id, Materiel materielDetails) {
        return materielRepository.findById(id).map(materiel -> {
            materiel.setType(materielDetails.getType());
            materiel.setModele(materielDetails.getModele());
            materiel.setStatut(materielDetails.getStatut());
            materiel.setEmplacement(materielDetails.getEmplacement());
            materiel.setDateInstallation(materielDetails.getDateInstallation());
            return materielRepository.save(materiel);
        }).orElseThrow(() -> new RuntimeException("Materiel not found"));
    }

    // Delete Materiel
    public void deleteMateriel(int id) {
        materielRepository.deleteById(id);
    }
}
