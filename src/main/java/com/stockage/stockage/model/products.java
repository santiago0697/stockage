package com.stockage.stockage.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer products_id;

    @NotBlank
    private String products_name;

    private String products_description;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date products_date_added;

    private Integer products_status;

    private String products_image;

    private Integer products_qty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private providers provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", nullable = false)
    private locations location;

    public Integer getProducts_id() {
        return products_id;
    }

    public void setProducts_id(Integer products_id) {
        this.products_id = products_id;
    }

    public String getProducts_name() {
        return products_name;
    }

    public void setProducts_name(String products_name) {
        this.products_name = products_name;
    }

    public String getProducts_description() {
        return products_description;
    }

    public void setProducts_description(String products_description) {
        this.products_description = products_description;
    }

    public Date getProducts_date_added() {
        return products_date_added;
    }

    public void setProducts_date_added(Date products_date_added) {
        this.products_date_added = products_date_added;
    }

    public Integer getProducts_status() {
        return products_status;
    }

    public void setProducts_status(Integer products_status) {
        this.products_status = products_status;
    }

    public String getProducts_image() {
        return products_image;
    }

    public void setProducts_image(String products_image) {
        this.products_image = products_image;
    }

    public Integer getProducts_qty() {
        return products_qty;
    }

    public void setProducts_qty(Integer products_qty) {
        this.products_qty = products_qty;
    }

    public providers getProvider() {
        return provider;
    }

    public void setProvider(providers provider) {
        this.provider = provider;
    }

    public locations getLocation() {
        return location;
    }

    public void setLocation(locations location) {
        this.location = location;
    }
}
