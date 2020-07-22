package com.company.medications.service;


import com.google.gson.Gson;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.company.medications.entity.MedicationEntity;
import com.haulmont.cuba.core.entity.KeyValueEntity;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service(RestControllerService.NAME)
public class RestControllerServiceBean implements RestControllerService {
    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    @Inject
    private DataManager dataManager;


    
    public MedicationEntity createEntity(String[] object) throws ParseException {
        Date ibd;
        try{
            ibd = DATE_FORMAT.parse(object[3]);
        }catch (Exception e){ibd=null;}
        MedicationEntity entity = dataManager.create(MedicationEntity.class);
        entity.setMedicationName(object[0]);
        entity.setFormRelease(object[1]);
        entity.setCipher(object[2]);
        entity.setIbd(ibd);
        dataManager.commit(entity);
        return entity;
    }
    public Object[] getListEntity(){
        int i=0;
        List<KeyValueEntity> kvs = dataManager.loadValues("select e.id, e.medicationName, e.formRelease from medications_MedicationEntity e")
                .properties("id", "name", "frel")
                .list();
        Object[] out = new Object[kvs.size()];
        for(KeyValueEntity e:kvs){
            String it = "{\"id\":\""+e.getValue("id")+"\",\"name\":\""+e.getValue("name")+"\",\"frel\":\""+e.getValue("frel")+"\"}";
            Object obj = new Gson().fromJson(it, Object.class);
            out[i]= obj;
            i++;
        }
        return out;
    }
}