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

import com.Dealer_Vehicle_Management_System.Entity.Dealer;
import com.Dealer_Vehicle_Management_System.Repository.DealerRepository;

@RestController
public class DealerController {
	@Autowired
    private DealerRepository dealerRepository;

    // Create
    @PostMapping("/Createdata")
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    // Read All
    @GetMapping("/showdata")
    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        Optional<Dealer> dealer = dealerRepository.findById(id);
        return dealer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Dealer> updateDealer(@PathVariable Long id, @RequestBody Dealer dealerDetails) {
        Optional<Dealer> dealer = dealerRepository.findById(id);
        if (dealer.isPresent()) {
            Dealer updatedDealer = dealer.get();
            updatedDealer.setName(dealerDetails.getName());
            updatedDealer.setEmail(dealerDetails.getEmail());
            updatedDealer.setSubscriptionType(dealerDetails.getSubscriptionType());
            return ResponseEntity.ok(dealerRepository.save(updatedDealer));
        }
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDealer(@PathVariable Long id) {
        if (dealerRepository.existsById(id)) {
            dealerRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
