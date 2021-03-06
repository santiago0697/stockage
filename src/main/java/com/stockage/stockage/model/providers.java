package com.stockage.stockage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "providers")
@EntityListeners(AuditingEntityListener.class)
public class providers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provider_id;

    @NotBlank
    private String provider_name;

    @NotBlank
    private String provider_rewrite;

    @NotBlank
    private String provider_email;

    @NotBlank
    private String provider_phone;

    @NotBlank
    private String provider_address;

    public Integer getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_rewrite() {
        return provider_rewrite;
    }

    public void setProvider_rewrite(String provider_rewrite) {
        this.provider_rewrite = provider_rewrite;
    }

    public String getProvider_email() {
        return provider_email;
    }

    public void setProvider_email(String provider_email) {
        this.provider_email = provider_email;
    }

    public String getProvider_phone() {
        return provider_phone;
    }

    public void setProvider_phone(String provider_phone) {
        this.provider_phone = provider_phone;
    }

    public String getProvider_address() {
        return provider_address;
    }

    public void setProvider_address(String provider_address) {
        this.provider_address = provider_address;
    }

    public void getCustomInfo() {
        System.out.println(String.format("provider_id: %d\nprovider_name: %s\nprovider_rewrite: %s\nprovider_email: %s\nprovider_phone: %s\nprovider_address: %s",
                provider_id, provider_name, provider_rewrite, provider_email, provider_phone, provider_address));
    }
}
