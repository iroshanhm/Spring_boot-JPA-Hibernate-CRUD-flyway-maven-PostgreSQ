
CREATE SEQUENCE IF NOT EXISTS book_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE book
(
--book_id BIGINT NOT NULL,
    id int8 NOT NULL DEFAULT nextval('book_id_seq'),
    book_isbn int8 NOT NULL,
    book_name TEXT NOT NULL,
    book_description TEXT,
    CONSTRAINT book_pk PRIMARY KEY (id)
);
