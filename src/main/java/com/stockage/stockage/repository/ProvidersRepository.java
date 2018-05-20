package com.stockage.stockage.repository;

import com.stockage.stockage.model.providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProvidersRepository extends JpaRepository<providers, Integer> {

    @Query("SELECT p FROM providers p where p.provider_rewrite = ?1")
    Optional<providers> getByRewrite(String rewrite);

}
