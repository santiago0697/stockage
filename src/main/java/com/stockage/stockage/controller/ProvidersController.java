package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.providers;
import com.stockage.stockage.repository.ProvidersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<providers> getAllProviders() {
        return providersRepository.findAll();
    }

    // Create new Provider
    @PostMapping("/insert")
    public providers createProvider(@Valid @RequestBody providers provider) {
        return providersRepository.save(provider);
    }

    // Get single provider by ID
    @GetMapping("/getById/{id}")
    public providers getProviderById(@PathVariable(value = "id") Integer provider_id) {
        return providersRepository.findById(provider_id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "id", provider_id));
    }

    // Get single provider by rewrite
    @GetMapping("getByRewrite/{rewrite}")
    public providers getProviderByRewrite(@PathVariable(value = "rewrite") String rewrite) {
        return providersRepository.getByRewrite(rewrite)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "rewrite", rewrite));
    }

    // Update provider
    @PutMapping("/update/{id}")
    public providers updateProvider(@PathVariable(value = "id") Integer provider_id, @Valid @RequestBody providers newProvider) {
        providers p = providersRepository.findById(provider_id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "rewrite", provider_id));

        p.setProvider_name(newProvider.getProvider_name());
        p.setProvider_rewrite(newProvider.getProvider_rewrite());
        p.setProvider_email(newProvider.getProvider_email());
        p.setProvider_phone(newProvider.getProvider_phone());
        p.setProvider_address(newProvider.getProvider_address());

        return providersRepository.save(p);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProvider(@PathVariable(value = "id") Integer provider_id) {
        providers p = providersRepository.findById(provider_id)
                .orElseThrow(() -> new ResourceNotFoundException("Provider", "provider_id", provider_id));

        providersRepository.delete(p);

        return ResponseEntity.ok().build();
    }
}
