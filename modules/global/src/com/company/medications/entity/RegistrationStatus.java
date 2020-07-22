package com.company.medications.entity;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "MEDICATIONS_REGISTRATION_STATUS")
@Entity(name = "medications_RegistrationStatus")
public class RegistrationStatus extends StandardEntity {
    private static final long serialVersionUID = -1698105740535096265L;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEDICINAL_PRODUCT_ID")
    protected @NotNull MedicationEntity medicinalProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected CountryOfRegistration country;

    @Column(name = "RU_NUMBER", length = 100)
    protected String ruNumber;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RU_DATE")
    protected Date ruDate;

    @Column(name = "STATUS", nullable = false)
    protected @NotNull Integer status;

    @Lob
    @Column(name = "INDICATION_FOR_USE")
    protected String indicationForUse;

    @Lob
    @Column(name = "SIDE_EFFECT")
    protected String sideEffect;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE_ID")
    protected FileDescriptor file;

    public FileDescriptor getFile() {
        return file;
    }

    public void setFile(FileDescriptor file) {
        this.file = file;
    }

    public void setStatus(StatusEnum status) {
        this.status = status == null ? null : status.getId();
    }

    public StatusEnum getStatus() {
        return status == null ? null : StatusEnum.fromId(status);
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getIndicationForUse() {
        return indicationForUse;
    }

    public void setIndicationForUse(String indicationForUse) {
        this.indicationForUse = indicationForUse;
    }

    public Date getRuDate() {
        return ruDate;
    }

    public void setRuDate(Date ruDate) {
        this.ruDate = ruDate;
    }

    public String getRuNumber() {
        return ruNumber;
    }

    public void setRuNumber(String ruNumber) {
        this.ruNumber = ruNumber;
    }

    public CountryOfRegistration getCountry() {
        return country;
    }

    public void setCountry(CountryOfRegistration country) {
        this.country = country;
    }

    public MedicationEntity getMedicinalProduct() {
        return medicinalProduct;
    }

    public void setMedicinalProduct(MedicationEntity medicinalProduct) {
        this.medicinalProduct = medicinalProduct;
    }
}