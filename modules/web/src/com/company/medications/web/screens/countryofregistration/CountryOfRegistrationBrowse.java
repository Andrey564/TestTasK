package com.company.medications.web.screens.countryofregistration;

import com.haulmont.cuba.gui.screen.*;
import com.company.medications.entity.CountryOfRegistration;

@UiController("medications_CountryOfRegistration.browse")
@UiDescriptor("country-of-registration-browse.xml")
@LookupComponent("countryOfRegistrationsTable")
@LoadDataBeforeShow
public class CountryOfRegistrationBrowse extends StandardLookup<CountryOfRegistration> {
}