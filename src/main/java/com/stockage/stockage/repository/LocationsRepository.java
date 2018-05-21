package com.stockage.stockage.repository;

import com.stockage.stockage.model.locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationsRepository extends JpaRepository<locations, Integer> {

    @Query("SELECT l FROM locations l where l.location_rewrite = ?1")
    Optional<locations> getByRewrite(String rewrite);
}
