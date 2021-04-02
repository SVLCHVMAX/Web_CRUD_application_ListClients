create table CLIENTS
(
    ID          INTEGER identity
        primary key,
    LAST_NAME   VARCHAR(50) not null,
    NAME        VARCHAR(50) not null,
    MIDDLE_NAME VARCHAR(50),
    EMAIL       VARCHAR(50),
    TEL_NUMBER  VARCHAR(50)
);