DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS products (
  id SERIAL PRIMARY KEY,
  title VARCHAR(50) NOT NULL,
  price INTEGER);

  INSERT INTO products (title, price) VALUES
    ('Ноутбук', 32000),
    ('Смартфон', 35000),
    ('Планшет', 22000),
    ('Системный блок', 48000),
    ('Монитор', 25000),
    ('Клавиатура', 3500),
    ('Мышь', 1300),
    ('Колонки', 2700),
    ('Наушники', 1800),
    ('Микрофон', 1300),
    ('Жесткий диск', 5000),
    ('Оперативная память', 3400),
    ('Процессор', 12600),
    ('Материнская плата', 3800),
    ('Кофе', 150),
    ('Чай', 120),
    ('Сэндвич', 300),
    ('Хотдог', 250),
    ('Торт', 650),
    ('Мороженое', 200);