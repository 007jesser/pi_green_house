package tn.esprit.pi_green.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.pi_green.entity.Serre;

@Repository
public interface SerreRepository extends JpaRepository<Serre, Integer> {
}
