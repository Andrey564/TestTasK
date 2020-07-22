package com.company.medications.web.screens.registrationstatus;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.RegistrationStatus;

import javax.inject.Inject;

@UiController("medications_RegistrationStatus.edit")
@UiDescriptor("registration-status-edit.xml")
@EditedEntityContainer("registrationStatusDc")
@LoadDataBeforeShow
public class RegistrationStatusEdit extends StandardEditor<RegistrationStatus> {
    @Inject
    private FileUploadField file;
    @Inject
    private DataManager dataManager;

    @Override
    protected void commitAndClose(Action.ActionPerformedEvent event) {
        dataManager.commit(getEditedEntity().getFile());
        super.commitAndClose(event);
    }


}