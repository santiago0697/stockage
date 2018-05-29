package com.stockage.stockage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "labels_templates")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class labels_templates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer labels_id;

    @NotBlank
    private String labels_template;

    private String labels_size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributors_id", nullable = false)
    private distributors distributors;

    public Integer getLabels_id() {
        return labels_id;
    }

    public void setLabels_id(Integer labels_id) {
        this.labels_id = labels_id;
    }

    public String getLabels_template() {
        return labels_template;
    }

    public void setLabels_template(String labels_template) {
        this.labels_template = labels_template;
    }

    public String getLabels_size() {
        return labels_size;
    }

    public void setLabels_size(String labels_size) {
        this.labels_size = labels_size;
    }

    public com.stockage.stockage.model.distributors getDistributors() {
        return distributors;
    }

    public void setDistributors(com.stockage.stockage.model.distributors distributors) {
        this.distributors = distributors;
    }
}
