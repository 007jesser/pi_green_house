package tn.esprit.pi_green.repository;

import tn.esprit.pi_green.entity.Actuator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ActuatorRepository extends JpaRepository<Actuator, Long> {
    Optional<Actuator> findByType(String type);
}
