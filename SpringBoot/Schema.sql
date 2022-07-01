DROP TABLE IF EXISTS purchased;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL);
  
  INSERT INTO customers (name) VALUES
    ('Александр'),
    ('Дмитрий'),
    ('Екатерина');

CREATE TABLE IF NOT EXISTS products (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  price INTEGER);

  INSERT INTO products (title, price) VALUES
    ('Монитор', 25000),
    ('Клавиатура', 3500),
    ('Мышь', 1300),
    ('Колонки', 2700),
    ('Жесткий диск', 5000),
    ('Оперативная память', 3400),
    ('Процессор', 12600),
    ('Материнская плата', 3800),
    ('Кофе', 150),
    ('Сэндвич', 300),
    ('Мороженое', 200);

CREATE TABLE IF NOT EXISTS purchased (
  id SERIAL PRIMARY KEY,
  customer_id INTEGER NOT NULL,
  product_id INTEGER NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers (id),
  FOREIGN KEY (product_id) REFERENCES products (id));
  
INSERT INTO purchased (customer_id, product_id) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 9),
    (1, 10),
    (2, 5),
    (2, 6),
    (2, 7),
    (2, 8),
    (2, 9),
    (3, 9),
    (3, 11);