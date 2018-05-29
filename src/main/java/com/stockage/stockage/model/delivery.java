package com.stockage.stockage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

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

    @NotBlank
    private String delivery_address;

    /*@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate*/
    private Date depart_date_delivery;

    private Date custom_delivery_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distributors_id", nullable = false)
    private distributors distributors;

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

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Date getDepart_date_delivery() {
        return depart_date_delivery;
    }

    public void setDepart_date_delivery(Date depart_date_delivery) {
        this.depart_date_delivery = depart_date_delivery;
    }

    public Date getCustom_delivery_date() {
        return custom_delivery_date;
    }

    public void setCustom_delivery_date(Date custom_delivery_date) {
        this.custom_delivery_date = custom_delivery_date;
    }

    public com.stockage.stockage.model.distributors getDistributors() {
        return distributors;
    }

    public void setDistributors(com.stockage.stockage.model.distributors distributors) {
        this.distributors = distributors;
    }
}
