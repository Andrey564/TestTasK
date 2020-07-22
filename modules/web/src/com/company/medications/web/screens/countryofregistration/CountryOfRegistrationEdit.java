package com.company.medications.web.screens.countryofregistration;

import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.CountryOfRegistration;

@UiController("medications_CountryOfRegistration.edit")
@UiDescriptor("country-of-registration-edit.xml")
@EditedEntityContainer("countryOfRegistrationDc")
@LoadDataBeforeShow
public class CountryOfRegistrationEdit extends StandardEditor<CountryOfRegistration> {
}