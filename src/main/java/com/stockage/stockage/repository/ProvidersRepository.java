package com.stockage.stockage.repository;

import com.stockage.stockage.model.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProvidersRepository extends JpaRepository<Providers, Integer> {

}
