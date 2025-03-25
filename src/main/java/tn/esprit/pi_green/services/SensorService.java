package tn.esprit.pi_green.services;

import tn.esprit.pi_green.entity.Sensor;
import tn.esprit.pi_green.entity.Actuator;
import tn.esprit.pi_green.repository.SensorRepository;
import tn.esprit.pi_green.repository.ActuatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private ActuatorRepository actuatorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public Sensor saveSensor(Sensor sensor) {
        Sensor savedSensor = sensorRepository.save(sensor);

        switch (sensor.getType()) {
            case "Temperature":
                controlTemperature(sensor.getValue());
                break;
            case "Humidity":
                controlHumidity(sensor.getValue());
                break;
            case "Sunlight":
                controlSunlight(sensor.getValue());
                break;
            case "CO2":
                controlCO2(sensor.getValue());
                break;
        }

        return savedSensor;
    }

    // 🟢 TEMPERATURE CONTROL (Ventilation & Heater)
    private void controlTemperature(double temp) {
        // Ventilation Logic
        setActuatorState("Ventilation", temp > 25);

        // Heater Logic
        setActuatorState("Heater", temp < 15);
    }

    // 💧 HUMIDITY CONTROL (Humidifier)
    private void controlHumidity(double humidity) {
        setActuatorState("Humidifier", humidity < 40);
    }

    // ☀️ SUNLIGHT CONTROL (Watering System)
    private void controlSunlight(double sunlight) {
        setActuatorState("Watering System", sunlight > 80);
    }

    // 🌱 CO2 CONTROL (CO2 Regulator)
    private void controlCO2(double co2Level) {
        setActuatorState("CO2 Regulator", co2Level > 800);
    }

    // 🛠️ Generic function to turn actuators ON/OFF
    private void setActuatorState(String actuatorType, boolean state) {
        // Find the actuator or create a new one
        Actuator actuator = actuatorRepository.findByType(actuatorType)
                .orElseGet(() -> {
                    System.out.println("⚠️ Actuator '" + actuatorType + "' not found. Creating a new one...");
                    return new Actuator(null, actuatorType, state); // Initialize with correct state
                });

        // Update only if there's a change in state
        if (actuator.isState() != state) {
            actuator.setState(state);
            actuatorRepository.save(actuator);
            System.out.println("🔧 " + actuatorType + " set to " + (state ? "ON" : "OFF"));
        } else {
            System.out.println("✅ " + actuatorType + " is already " + (state ? "ON" : "OFF"));
        }
    }

}

