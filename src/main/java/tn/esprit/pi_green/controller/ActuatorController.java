package tn.esprit.pi_green.controller;

import tn.esprit.pi_green.entity.Actuator;
import tn.esprit.pi_green.repository.ActuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actuators")
public class ActuatorController {

    @Autowired
    private ActuatorRepository actuatorRepository;

    // 🟢 Get all actuators
    @GetMapping
    public List<Actuator> getAllActuators() {
        return actuatorRepository.findAll();
    }

    // 🟢 Get actuator by type
    @GetMapping("/{type}")
    public Optional<Actuator> getActuatorByType(@PathVariable String type) {
        return actuatorRepository.findByType(type);
    }

    // 🔄 Update actuator state (ON/OFF)
    @PutMapping("/{type}/{state}")
    public Actuator updateActuatorState(@PathVariable String type, @PathVariable boolean state) {
        Actuator actuator = actuatorRepository.findByType(type)
                .orElse(new Actuator(null, type, !state)); // Create if not found

        actuator.setState(state);
        return actuatorRepository.save(actuator);
    }
}
