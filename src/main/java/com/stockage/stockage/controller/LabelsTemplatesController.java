package com.stockage.stockage.controller;


import com.stockage.stockage.exception.ResourceNotFoundException;
import com.stockage.stockage.model.distributors;
import com.stockage.stockage.model.labels_templates;
import com.stockage.stockage.repository.DistributorsRepository;
import com.stockage.stockage.repository.LabelsTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("labels_templates")
public class LabelsTemplatesController {

    @Autowired
    LabelsTemplateRepository labelsTemplateRepository;
    @Autowired
    DistributorsRepository distributorsRepository;

    @GetMapping("/all")
    public List<labels_templates> getAll() {
        return labelsTemplateRepository.findAll();
    }

    @PostMapping("/insert/distributor/{distributors_id}")
    public labels_templates createTemplate(@PathVariable(value = "distributors_id") Integer distributors_id,
                                           @Valid @RequestBody labels_templates labels_templates) {

        distributors d = distributorsRepository.findById(distributors_id)
                .orElseThrow(() -> new ResourceNotFoundException("Distribuidor", "distributors_id", distributors_id));

        labels_templates.setDistributors(d);

        return labelsTemplateRepository.save(labels_templates);
    }

    @GetMapping("/get/{labels_id}")
    public labels_templates getLabel(@PathVariable(value = "labels_id") Integer labels_id) {
        return labelsTemplateRepository.findById(labels_id)
                .orElseThrow(() -> new ResourceNotFoundException("Label", "labels_id", labels_id));
    }
}
