package com.stockage.stockage.controller;

import com.stockage.stockage.model.Providers;
import com.stockage.stockage.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/providers")
public class ProvidersController {

    @Autowired
    ProvidersRepository providersRepository;

    // Get all providers
    @GetMapping("/all")
    public List<Providers> getAllProviders() {
        return providersRepository.findAll();
    }

    // Create new Provider
    @PostMapping("/insert")
    public Providers createProvider(@Valid @RequestBody Providers provider) {
        return providersRepository.save(provider);
    }
}
