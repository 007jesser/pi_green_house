package tn.esprit.pi_green.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materiel")
@Getter
@Setter
public class Materiel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String modele;

    @Column(nullable = false)
    private String statut;

    private String emplacement;

    @Column(name = "date_installation", nullable = false)
    private LocalDateTime dateInstallation;

    @ManyToOne
    @JoinColumn(name = "serre_id", nullable = false)
    private Serre serre;
}
