
CREATE SEQUENCE IF NOT EXISTS publisher_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE publisher
(
--book_id BIGINT NOT NULL,
    id int8 NOT NULL DEFAULT nextval('publisher_id_seq'),
    publisher_name TEXT NOT NULL,
    publisher_description TEXT,
    CONSTRAINT publisher_pk PRIMARY KEY (id)
);
