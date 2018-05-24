package com.stockage.stockage.repository;

import com.stockage.stockage.model.delivery_status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryStatusRepository extends JpaRepository<delivery_status, Integer> {

    @Query("SELECT ds FROM delivery_status ds where ds.delivery_rewrite = ?1")
    Optional<delivery_status> getByRewrite(String rewrite);
}
