package tn.esprit.pi_green.services;

import org.springframework.stereotype.Service;
import tn.esprit.pi_green.entity.Serre;
import tn.esprit.pi_green.repository.SerreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SerreService {
    private final SerreRepository serreRepository;

    public SerreService(SerreRepository serreRepository) {
        this.serreRepository = serreRepository;
    }

    // Read: Get all serres
    public List<Serre> getAllSerres() {
        return serreRepository.findAll();
    }

    // Read: Get a single serre by its id
    public Optional<Serre> getSerreById(int id) {
        return serreRepository.findById(id);
    }

    // Create: Add a new serre
    public Serre createSerre(Serre serre) {
        return serreRepository.save(serre);
    }

    // Update: Update an existing serre
    public Serre updateSerre(int id, Serre serreDetails) {
        Optional<Serre> optionalSerre = serreRepository.findById(id);

        if (optionalSerre.isPresent()) {
            Serre serre = optionalSerre.get();
            serre.setName(serreDetails.getName());
            serre.setLocation(serreDetails.getLocation());
            serre.setTemperature(serreDetails.getTemperature());
            serre.setHumidity(serreDetails.getHumidity());
            serre.setPlantes(serreDetails.getPlantes());
            serre.setMateriels(serreDetails.getMateriels());

            return serreRepository.save(serre);
        } else {
            // Handle case where serre with the given id does not exist
            throw new RuntimeException("Serre not found with id: " + id);
        }
    }

    // Delete: Delete a serre by its id
    public void deleteSerre(int id) {
        Optional<Serre> optionalSerre = serreRepository.findById(id);

        if (optionalSerre.isPresent()) {
            serreRepository.delete(optionalSerre.get());
        } else {
            // Handle case where serre with the given id does not exist
            throw new RuntimeException("Serre not found with id: " + id);
        }
    }
}
