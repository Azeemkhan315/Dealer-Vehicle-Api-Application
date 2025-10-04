package com.Dealer_Vehicle_Management_System.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Dealer_Vehicle_Management_System.Entity.Vehicle;
import com.Dealer_Vehicle_Management_System.Repository.VehicleRepository;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
	@Autowired
    private VehicleRepository vehicleRepository;

    // Create
    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Read All
     

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        return vehicle.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            Vehicle updatedVehicle = vehicle.get();
            updatedVehicle.setDealer(vehicleDetails.getDealer());
            updatedVehicle.setModel(vehicleDetails.getModel());
            updatedVehicle.setPrice(vehicleDetails.getPrice());
            updatedVehicle.setStatus(vehicleDetails.getStatus());
            return ResponseEntity.ok(vehicleRepository.save(updatedVehicle));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Fetch vehicles of PREMIUM dealers
    @GetMapping("/premium")
    public List<Vehicle> getVehiclesByPremiumDealers() {
        return vehicleRepository.findByDealerSubscriptionType("PREMIUM");
    }

}
