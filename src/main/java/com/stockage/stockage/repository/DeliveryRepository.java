package com.stockage.stockage.repository;

import com.stockage.stockage.model.delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<delivery, Integer> {
}
