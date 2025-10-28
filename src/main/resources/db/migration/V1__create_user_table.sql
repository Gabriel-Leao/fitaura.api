CREATE TABLE users (
    id            BIGINT       GENERATED    ALWAYS AS IDENTITY       PRIMARY KEY,
    name          VARCHAR(150) NOT NULL,
    email         VARCHAR(200) NOT NULL,
    password      VARCHAR(72)  NOT NULL,
    birthday      DATE         NOT NULL,
    role          VARCHAR(10)  NOT NULL,
    created_at    TIMESTAMP    NOT NULL     DEFAULT CURRENT_TIMESTAMP,
    updated_at    TIMESTAMP    NOT NULL     DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT    UNIQUE_USER_EMAIL         UNIQUE(email),
    CONSTRAINT    CHECK_USER_ROLE           CHECK (role  IN ('USER', 'ADMIN'))
);
