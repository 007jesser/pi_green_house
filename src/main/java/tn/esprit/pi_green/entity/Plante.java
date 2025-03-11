package tn.esprit.pi_green.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "plante")
public class Plante implements Serializable {

    // ✅ Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    @Column(nullable = false)
    private String growthStage;

    private float temperatureRequirement;
    private float humidityRequirement;
    private LocalDateTime lastWatered;

    @Column(nullable = false)
    private String healthStatus;

    @ManyToOne
    @JoinColumn(name = "serre_id", nullable = false)
    private Serre serre;

}
