package com.stockage.stockage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "locations")
@EntityListeners(AuditingEntityListener.class)
public class locations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer location_id;

    @NotBlank
    private String location_name;

    private String location_rewrite;

    public Integer getLocation_id() {
        return location_id;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getLocation_rewrite() {
        return location_rewrite;
    }

    public void setLocation_rewrite(String location_rewrite) {
        this.location_rewrite = location_rewrite;
    }
}
