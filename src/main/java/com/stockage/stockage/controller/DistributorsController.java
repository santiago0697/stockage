package com.stockage.stockage.controller;

import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.distributors;
import com.stockage.stockage.repository.DistributorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("distributors")
public class DistributorsController {

    @Autowired
    DistributorsRepository distributorsRepository;

    @GetMapping("/all")
    public List<distributors> getAll() {
        return distributorsRepository.findAll();
    }

    @PostMapping("/insert")
    public distributors createDistributor(@Valid @RequestBody distributors newDistributor) {
        return distributorsRepository.save(newDistributor);
    }

    @GetMapping("/get/{distributors_id}")
    public distributors getDistributor(@PathVariable(value = "distributors_id") Integer distributors_id) {
        return distributorsRepository.findById(distributors_id)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor", "distributors_id", distributors_id));
    }

    @PutMapping("/update/{distributors_id}")
    public distributors updateDistributor(@PathVariable(value = "distributors_id") Integer distributors_id,
                                          @Valid @RequestBody distributors distributors) {
        distributors d = distributorsRepository.findById(distributors_id)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor", "distributors_id", distributors_id));

        d.setDistributors_name(distributors.getDistributors_name());
        d.setDistributors_rewrite(distributors.getDistributors_rewrite());
        d.setDistributors_description(distributors.getDistributors_description());
        d.setDistributors_email(distributors.getDistributors_email());
        d.setDistributors_phone(distributors.getDistributors_phone());
        d.setDistributors_logo(distributors.getDistributors_logo());
        d.setDistributors_min_delivery(distributors.getDistributors_min_delivery());

        return distributorsRepository.save(d);
    }

    @DeleteMapping("/delete/{distributors_id}")
    public ResponseEntity<?> deleteDistributor(@PathVariable(value = "distributors_id") Integer distributors_id) {

        distributors d = distributorsRepository.findById(distributors_id)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor", "distributors_id", distributors_id));
        distributorsRepository.delete(d);

        return ResponseEntity.ok().build();
    }
}
