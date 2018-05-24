package com.stockage.stockage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "delivery")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class delivery implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer delivery_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id", nullable = false)
    private products products_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_status_id", nullable = false)
    private delivery_status delivery_status_id;

    public Integer getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Integer delivery_id) {
        this.delivery_id = delivery_id;
    }

    public products getProducts_id() {
        return products_id;
    }

    public void setProducts_id(products products_id) {
        this.products_id = products_id;
    }

    public delivery_status getDelivery_status_id() {
        return delivery_status_id;
    }

    public void setDelivery_status_id(delivery_status delivery_status_id) {
        this.delivery_status_id = delivery_status_id;
    }
}
