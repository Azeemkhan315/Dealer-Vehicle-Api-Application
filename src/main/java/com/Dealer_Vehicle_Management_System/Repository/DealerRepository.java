package com.Dealer_Vehicle_Management_System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Dealer_Vehicle_Management_System.Entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Long>{

}
