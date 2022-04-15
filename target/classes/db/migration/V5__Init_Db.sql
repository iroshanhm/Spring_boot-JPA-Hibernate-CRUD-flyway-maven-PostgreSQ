CREATE SEQUENCE IF NOT EXISTS lending_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE LENDING (
    ID int8 NOT NULL DEFAULT nextval('lending_id_seq'),
--    book_ISBN BIGINT,
    member_id BIGINT,
    lending_date timestamp,
    created_by TEXT,
    created_on timestamp,
    updated_by TEXT,
    updated_on timestamp,
    is_remove INT,
    remove_by TEXT,
    remove_on timestamp,
    PRIMARY KEY (ID)
);



CREATE SEQUENCE IF NOT EXISTS lending_book_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE LENDING_BOOK (
    ID int8 NOT NULL DEFAULT nextval('lending_book_id_seq'),
    lending_id BIGINT,
--    book_id BIGINT,
    book_ISBN BIGINT,
    book_tag BIGINT,
    PRIMARY KEY (ID)
);
