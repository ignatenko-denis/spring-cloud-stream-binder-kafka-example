CREATE TABLE IF NOT EXISTS client
(
    id            BIGSERIAL PRIMARY KEY NOT NULL,
    name          VARCHAR(255)          NOT NULL,
    credit_rating INTEGER               NOT NULL
);