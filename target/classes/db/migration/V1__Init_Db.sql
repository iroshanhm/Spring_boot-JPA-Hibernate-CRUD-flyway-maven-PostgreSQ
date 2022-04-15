
CREATE SEQUENCE IF NOT EXISTS author_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE author
(
--author_id BIGINT NOT NULL,
  id int8 NOT NULL DEFAULT nextval('author_id_seq'),
  author_name TEXT NOT NULL,
  author_description TEXT,
  CONSTRAINT author_pk PRIMARY KEY (id)
);
