package com.company.medications.web.screens.registrationstatus;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.impl.CollectionContainerImpl;
import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.RegistrationStatus;

import javax.inject.Inject;

@UiController("medications_RegistrationStatus.browse")
@UiDescriptor("registration-status-browse.xml")
@LookupComponent("registrationStatusesTable")
@LoadDataBeforeShow
public class RegistrationStatusBrowse extends StandardLookup<RegistrationStatus> {
    @Inject
    private CollectionContainer<RegistrationStatus> registrationStatusesDc;
    @Inject
    private DataManager dataManager;
    @Inject
    private DataGrid<RegistrationStatus> registrationStatusesTable;
    @Inject
    private Dialogs dialogs;


    public void onAddBtnClick() {
        if(registrationStatusesTable.isEditorActive()){
            dialogs.createMessageDialog().withCaption("Внимание").withMessage("Необходимо закончить изменение экземпляра").show();
            return;
        }
        RegistrationStatus registrationStatus = dataManager.create(RegistrationStatus.class);
        registrationStatusesDc.getMutableItems().add(registrationStatus);
        registrationStatusesTable.edit(registrationStatus);
        registrationStatusesTable.addEditorPostCommitListener(editorCloseEvent ->dataManager.commit(editorCloseEvent.getItem()));
        registrationStatusesTable.addEditorCloseListener(editorCloseEvent -> registrationStatusesDc.getMutableItems().remove(registrationStatus));
    }
}