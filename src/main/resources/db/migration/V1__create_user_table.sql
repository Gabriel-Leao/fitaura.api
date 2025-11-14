CREATE TABLE users (
    id            BIGINT       GENERATED    ALWAYS AS IDENTITY       PRIMARY KEY,
    name          VARCHAR(150) NOT NULL,
    email         VARCHAR(200) NOT NULL,
    password      VARCHAR(72)  NOT NULL,
    birthday      DATE         NOT NULL,
    role          VARCHAR(10)  NOT NULL,
    street        VARCHAR(200) NOT NULL,
    number        VARCHAR(20)  NOT NULL,
    neighborhood  VARCHAR(120) NOT NULL,
    city          VARCHAR(120) NOT NULL,
    uf            VARCHAR(2)   NOT NULL,
    zip_code      VARCHAR(20)  NOT NULL,
    complement    VARCHAR(150) NOT NULL,
    created_at    TIMESTAMP    NOT NULL     DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL     DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT    UNIQUE_USER_EMAIL         UNIQUE(email),
    CONSTRAINT    CHECK_USER_ROLE           CHECK (role  IN ('USER', 'ADMIN')),
    CONSTRAINT CHECK_UF CHECK (uf IN (
      'AC','AL','AP','AM','BA','CE','DF','ES','GO','MA','MT','MS','MG',
      'PA','PB','PR','PE','PI','RJ','RN','RS','RO','RR','SC','SP','SE','TO'
    ))
);
