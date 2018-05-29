package com.stockage.stockage.repository;

import com.stockage.stockage.model.labels_templates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelsTemplateRepository extends JpaRepository<labels_templates, Integer> {
}
