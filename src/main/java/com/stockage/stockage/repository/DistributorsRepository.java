package com.stockage.stockage.repository;

import com.stockage.stockage.model.distributors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorsRepository extends JpaRepository <distributors, Integer>{
}
