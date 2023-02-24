package com.niemannproject.digitalpersonalorganizer.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provider {

    @OneToMany
    @JoinColumn(name = "provider_id")
    private final List<Prescription> prescriptions = new ArrayList<>();

    @NotBlank
    @Size(min = 3, message = "Provider Role must contain at least three characters")
    private String providerRole;

    @NotBlank
    @Size(min = 3, message = "Provider Name must contain at least three characters")
    private String providerName;

    @NotBlank
    @Size(min = 9, max = 10, message = "Provider Phone Number must have 9 or 10 numbers (only numbers")
    private Integer providerPhoneNum;

    public Provider(String providerRole, String providerName, Integer providerPhoneNum) {
        this.providerRole = providerRole;
        this.providerName = providerName;
        this.providerPhoneNum = providerPhoneNum;
    }

    public Provider() {
    }

    public String getProviderRole() {
        return providerRole;
    }

    public void setProviderRole(String providerRole) {
        this.providerRole = providerRole;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Integer getProviderPhoneNum() {
        return providerPhoneNum;
    }

    public void setProviderPhoneNum(Integer providerPhoneNum) {
        this.providerPhoneNum = providerPhoneNum;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }
}
