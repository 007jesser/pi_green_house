package tn.esprit.pi_green.entity;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "serre")
public class Serre implements Serializable {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    private float temperature;
    private float humidity;

    @OneToMany(mappedBy = "serre", cascade = CascadeType.ALL)
    private List<Plante> plantes;

    @OneToMany(mappedBy = "serre", cascade = CascadeType.ALL)
    private List<Materiel> materiels;

}
