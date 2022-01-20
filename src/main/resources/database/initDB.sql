CREATE TABLE IF NOT EXISTS "public".books
(
    id    SERIAL PRIMARY KEY ,
    isbn  VARCHAR(200) NOT NULL ,
    name VARCHAR(200) NOT NULL ,
    author VARCHAR(200)  NOT NULL ,
    pages INT ,
    weight INT ,
    price INT
    );
CREATE SEQUENCE public._id_seq START WITH 3 INCREMENT BY 1;

--    DROP TABLE IF EXISTS "Book";
--    DROP SEQUENCE IF EXISTS books_id_seq