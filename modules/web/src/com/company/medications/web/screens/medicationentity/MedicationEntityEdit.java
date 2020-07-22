package com.company.medications.web.screens.medicationentity;

import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.MedicationEntity;

@UiController("medications_MedicationEntity.edit")
@UiDescriptor("medication-entity-edit.xml")
@EditedEntityContainer("medicationEntityDc")
@LoadDataBeforeShow
public class MedicationEntityEdit extends StandardEditor<MedicationEntity> {
}