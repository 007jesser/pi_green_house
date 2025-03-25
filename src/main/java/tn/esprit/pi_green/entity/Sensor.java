package tn.esprit.pi_green.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type; // Temperature, Humidity, Sunlight, CO2, etc.

    @Column(nullable = false)
    private double value;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    public Sensor() {}

    public Sensor(String type, double value, LocalDateTime timestamp) {
        this.type = type;
        this.value = value;
        this.timestamp = timestamp;
    }

}
