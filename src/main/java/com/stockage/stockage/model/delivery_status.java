package com.stockage.stockage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "delivery_status")
@EntityListeners(AuditingEntityListener.class)
public class delivery_status implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer delivery_status_id;

    @NotBlank
    private String delivery_rewrite;

    @NotBlank
    private String delivery_description;

    public Integer getDelivery_status_id() {
        return delivery_status_id;
    }

    public void setDelivery_status_id(Integer delivery_status_id) {
        this.delivery_status_id = delivery_status_id;
    }

    public String getDelivery_rewrite() {
        return delivery_rewrite;
    }

    public void setDelivery_rewrite(String delivery_rewrite) {
        this.delivery_rewrite = delivery_rewrite;
    }

    public String getDelivery_description() {
        return delivery_description;
    }

    public void setDelivery_description(String delivery_description) {
        this.delivery_description = delivery_description;
    }
}
