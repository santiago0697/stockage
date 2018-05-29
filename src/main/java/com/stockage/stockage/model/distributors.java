package com.stockage.stockage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "distributors")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class distributors implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer distributors_id;

    @NotBlank
    private String distributors_name;

    @NotBlank
    private String distributors_rewrite;

    private String distributors_description;

    @NotBlank
    private String distributors_email;

    private Integer distributors_phone;

    private String distributors_logo;

    private Integer distributors_min_delivery;

    public Integer getDistributors_id() {
        return distributors_id;
    }

    public void setDistributors_id(Integer distributors_id) {
        this.distributors_id = distributors_id;
    }

    public String getDistributors_name() {
        return distributors_name;
    }

    public void setDistributors_name(String distributors_name) {
        this.distributors_name = distributors_name;
    }

    public String getDistributors_rewrite() {
        return distributors_rewrite;
    }

    public void setDistributors_rewrite(String distributors_rewrite) {
        this.distributors_rewrite = distributors_rewrite;
    }

    public String getDistributors_description() {
        return distributors_description;
    }

    public void setDistributors_description(String distributors_description) {
        this.distributors_description = distributors_description;
    }

    public String getDistributors_email() {
        return distributors_email;
    }

    public void setDistributors_email(String distributors_email) {
        this.distributors_email = distributors_email;
    }

    public Integer getDistributors_phone() {
        return distributors_phone;
    }

    public void setDistributors_phone(Integer distributors_phone) {
        this.distributors_phone = distributors_phone;
    }

    public String getDistributors_logo() {
        return distributors_logo;
    }

    public void setDistributors_logo(String distributors_logo) {
        this.distributors_logo = distributors_logo;
    }

    public Integer getDistributors_min_delivery() {
        return distributors_min_delivery;
    }

    public void setDistributors_min_delivery(Integer distributors_min_delivery) {
        this.distributors_min_delivery = distributors_min_delivery;
    }
}
