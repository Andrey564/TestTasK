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
);