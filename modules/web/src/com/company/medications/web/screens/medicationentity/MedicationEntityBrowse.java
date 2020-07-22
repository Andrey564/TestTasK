package com.company.medications.web.screens.medicationentity;

import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.MedicationEntity;

@UiController("medications_MedicationEntity.browse")
@UiDescriptor("medication-entity-browse.xml")
@LookupComponent("medicationEntitiesTable")
@LoadDataBeforeShow
public class MedicationEntityBrowse extends StandardLookup<MedicationEntity> {
}