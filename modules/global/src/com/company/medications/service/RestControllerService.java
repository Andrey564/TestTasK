package com.company.medications.service;

import com.company.medications.entity.MedicationEntity;
import com.google.gson.JsonObject;

import java.text.ParseException;
import java.util.List;

public interface RestControllerService {
    String NAME = "medications_RestControllerService";

    /**
     * @param object
     * массив значений для создания сущности
     * @return
     * возвращает созданную сущность
     */
    MedicationEntity createEntity(String[] object) throws ParseException;

    /**
     * @return
     * Получить список всех сущностей
     */
    Object[] getListEntity();

}