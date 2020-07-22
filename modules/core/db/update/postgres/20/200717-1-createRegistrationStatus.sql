create table MEDICATIONS_REGISTRATION_STATUS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MEDICINAL_PRODUCT_ID uuid not null,
    COUNTRY_ID uuid,
    RU_NUMBER varchar(100),
    RU_DATE timestamp,
    STATUS integer not null,
    INDICATION_FOR_USE text,
    SIDE_EFFECT text,
    FILE_ID uuid,
    --
    primary key (ID)
);