CREATE SEQUENCE IF NOT EXISTS return_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE RETURN_BOOK (
    ID int8 NOT NULL DEFAULT nextval('return_id_seq'),
    lending_id BIGINT,
    return_date timestamp,
    created_by TEXT,
    created_on timestamp,
    updated_by TEXT,
    updated_on timestamp,
    is_remove INT,
    remove_by TEXT,
    remove_on timestamp,
    PRIMARY KEY (ID)
);
