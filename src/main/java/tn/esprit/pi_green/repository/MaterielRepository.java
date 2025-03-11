package tn.esprit.pi_green.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi_green.entity.Materiel;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Integer> {
}
