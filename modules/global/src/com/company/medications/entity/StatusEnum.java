package com.company.medications.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum StatusEnum implements EnumClass<Integer> {

    REGISTRATION(10),
    RE_REGISTRATION(20);

    private Integer id;

    StatusEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static StatusEnum fromId(Integer id) {
        for (StatusEnum at : StatusEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}