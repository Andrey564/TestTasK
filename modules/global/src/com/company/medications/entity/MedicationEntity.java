package com.company.medications.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamePattern("%s|medicationName")
@Table(name = "MEDICATIONS_MEDICATION_ENTITY")
@Entity(name = "medications_MedicationEntity")
public class MedicationEntity extends StandardEntity {
    private static final long serialVersionUID = -8060493581516105205L;

    @NotNull
    @Column(name = "MEDICATION_NAME", nullable = false, length = 250)
    protected String medicationName;

    @Column(name = "FORM_RELEASE", length = 1000)
    protected String formRelease;

    @NotNull
    @Column(name = "CIPHER", nullable = false, length = 50)
    protected String cipher;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IBD")
    protected Date ibd;

    public Date getIbd() {
        return ibd;
    }

    public void setIbd(Date ibd) {
        this.ibd = ibd;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }

    public String getFormRelease() {
        return formRelease;
    }

    public void setFormRelease(String formRelease) {
        this.formRelease = formRelease;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
}