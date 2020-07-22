package com.company.medications.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|countryName")
@Table(name = "MEDICATIONS_COUNTRY_OF_REGISTRATION")
@Entity(name = "medications_CountryOfRegistration")
public class CountryOfRegistration extends StandardEntity {
    private static final long serialVersionUID = 494766304903674530L;

    @NotNull
    @Column(name = "COUNTRY_NAME", nullable = false, length = 250)
    protected String countryName;

    @Column(name = "COUNTRY_NAME_EN", length = 250)
    protected String countryNameEn;

    @NotNull
    @Column(name = "CIPHER", nullable = false, length = 250)
    protected String cipher;

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}