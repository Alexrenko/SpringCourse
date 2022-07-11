DROP TABLE IF EXISTS students_books;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS books;

CREATE TABLE students (
id bigserial NOT NULL,
name varchar(100) NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO students (name) VALUES ('Bob'), ('John'), ('Michael');

CREATE TABLE books (
id bigserial NOT NULL,
title varchar(100) NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO books (title) VALUES ('Harry Potter'), ('Lord Of The Ring');

CREATE TABLE students_books (
student_id bigint NOT NULL,
book_id bigint NOT NULL,
PRIMARY KEY (student_id, book_id),
FOREIGN KEY (student_id) REFERENCES students (id),
FOREIGN KEY (book_id) REFERENCES books (id)
);
