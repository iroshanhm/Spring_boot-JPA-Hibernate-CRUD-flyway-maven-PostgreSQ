CREATE SEQUENCE IF NOT EXISTS BOOK_AUTHOR_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE BOOK_AUTHOR (
    ID int8 NOT NULL DEFAULT nextval('BOOK_AUTHOR_id_seq'),
    BOOK_ID BIGINT,
    AUTHOR_ID BIGINT,
    PRIMARY KEY (ID),
    FOREIGN KEY (BOOK_ID) REFERENCES book(id),
    FOREIGN KEY (AUTHOR_ID) REFERENCES author(id)
);


CREATE SEQUENCE IF NOT EXISTS BOOK_PUBLISHER_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

CREATE TABLE BOOK_PUBLISHER (
    ID int8 NOT NULL DEFAULT nextval('BOOK_PUBLISHER_id_seq'),
    BOOK_ID BIGINT,
    PUBLISHER_ID BIGINT,
    PRIMARY KEY (ID),
    FOREIGN KEY (BOOK_ID) REFERENCES book(id),
    FOREIGN KEY (PUBLISHER_ID) REFERENCES publisher(id)
);