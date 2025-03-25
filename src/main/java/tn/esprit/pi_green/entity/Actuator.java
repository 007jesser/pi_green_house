package tn.esprit.pi_green.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actuators")
@Getter  // Lombok will generate the getter methods
@Setter  // Lombok will generate the setter methods
public class Actuator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String type; // Ventilation, Heater, Humidifier, etc.

    @Column(nullable = false)
    private boolean state; // true = ON, false = OFF

    public Actuator() {}

    public Actuator(Long id, String type, boolean state) {
        this.id = id;
        this.type = type;
        this.state = state;
    }
}
