-- begin MEDICATIONS_MEDICATION_ENTITY
create table MEDICATIONS_MEDICATION_ENTITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    MEDICATION_NAME varchar(250) not null,
    FORM_RELEASE varchar(1000),
    CIPHER varchar(50) not null,
    IBD timestamp,
    --
    primary key (ID)
)^
-- end MEDICATIONS_MEDICATION_ENTITY
-- begin MEDICATIONS_COUNTRY_OF_REGISTRATION
create table MEDICATIONS_COUNTRY_OF_REGISTRATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COUNTRY_NAME varchar(250) not null,
    COUNTRY_NAME_EN varchar(250),
    CIPHER varchar(250) not null,
    --
    primary key (ID)
)^
-- end MEDICATIONS_COUNTRY_OF_REGISTRATION
-- begin MEDICATIONS_REGISTRATION_STATUS
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
)^
-- end MEDICATIONS_REGISTRATION_STATUS
