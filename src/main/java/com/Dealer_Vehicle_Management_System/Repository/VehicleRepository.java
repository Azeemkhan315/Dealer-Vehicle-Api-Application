package com.Dealer_Vehicle_Management_System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dealer_Vehicle_Management_System.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	List<Vehicle> findByDealerSubscriptionType(String subscriptionType);

}
