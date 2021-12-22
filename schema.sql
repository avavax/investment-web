CREATE TABLE country (
    id SERIAL PRIMARY KEY,
    name VARCHAR(32)
);

INSERT INTO country (name) VALUES ('Россия');
INSERT INTO country (name) VALUES ('США');
INSERT INTO country (name) VALUES ('Германия');
INSERT INTO country (name) VALUES ('Китай');
INSERT INTO country (name) VALUES ('Япония');

CREATE TABLE sector (
     id SERIAL PRIMARY KEY,
     title VARCHAR(32)
);

INSERT INTO sector (title) VALUES ('Нефтегаз');
INSERT INTO sector (title) VALUES ('Финансы');
INSERT INTO sector (title) VALUES ('IT');
INSERT INTO sector (title) VALUES ('Металлургия');
INSERT INTO sector (title) VALUES ('Добыча');
INSERT INTO sector (title) VALUES ('Строительство');
INSERT INTO sector (title) VALUES ('Ритейл');
INSERT INTO sector (title) VALUES ('Сельское хозяйство');
INSERT INTO sector (title) VALUES ('Машиностроение');

CREATE TABLE user (
  id SERIAL PRIMARY KEY,
  name VARCHAR(64),
  email VARCHAR(32),
  password VARCHAR(64),
  role VARCHAR(8),
  visible SMALLINT DEFAULT 1
);

INSERT INTO account (name, email, password, role)
    VALUES ('Илья Петров', 'admin@admin.com', '$2a$10$r2M6s4M2vCeldFtPxMNF5evwgGEpVXnppVdmek.U2mzLSAbD1PM3u', 'ADMIN');
INSERT INTO account (name, email, password, role)
    VALUES ('Марсель Сидиков', 'marsel@marsel.com', '$2a$10$kK0RT2I1h3iMps7nCvHgGetvrP./aweEdXyUJR.GLUl61RSwsfH.i', 'USER');
INSERT INTO account (name, email, password, role)
    VALUES ('Джон Богл', 'user@user.com', '$2a$10$kK0RT2I1h3iMps7nCvHgGetvrP./aweEdXyUJR.GLUl61RSwsfH.i', 'USER');

CREATE TABLE stock (
    id SERIAL PRIMARY KEY,
    country_id INTEGER,
    sector_id INTEGER,
    user_id INTEGER,
    symbol VARCHAR(8),
    company VARCHAR(64),
    count INTEGER,
    price NUMERIC(8, 2),
    FOREIGN KEY (country_id) REFERENCES country (id),
    FOREIGN KEY (sector_id) REFERENCES sector (id),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (1, 1, 1, 'GAZP', 'Газпром', 100, 330.2);
INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (1, 2, 1, 'SBERP', 'Сбербанк-преф', 220, 250.4);
INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (1, 5, 1, 'GMKN', 'Норильский никель', 2, 22300);

INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (2, 9, 2, 'TSLA', 'Tesla Motors', 3, 69370);
INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (1, 7, 2, 'MGNT', 'Магнит', 30, 5861);
INSERT INTO stock (country_id, sector_id, user_id, symbol, company, count, price)
    VALUES (4, 3, 2, 'BABA', 'Alibaba Group', 25, 8400);

CREATE TABLE bond (
      id SERIAL PRIMARY KEY,
      country_id INTEGER,
      user_id INTEGER,
      symbol VARCHAR(32),
      title VARCHAR(32),
      company VARCHAR(64),
      count INTEGER,
      price NUMERIC(8, 2),
      cupon NUMERIC(4, 2),
      yield NUMERIC(8, 2),
      maturity DATE,
      FOREIGN KEY (country_id) REFERENCES country (id),
      FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO bond (country_id, user_id, symbol, title, company, count, price, cupon, yield, maturity)
    VALUES (1, 1, 'SU26235RMFS0', 'ОФЗ-26235', 'Минфин РФ', 60, 84.2, 5.9, 8.6, '2031-03-12');
INSERT INTO bond (country_id, user_id, symbol, title, company, count, price, cupon, yield, maturity)
    VALUES (1, 1, 'SU26230RMFS1', 'ОФЗ-26230', 'Минфин РФ', 130, 94.8, 7.7, 8.43, '2019-05-06');

INSERT INTO bond (country_id, user_id, symbol, title, company, count, price, cupon, yield, maturity)
    VALUES (1, 2, 'SU26230RMFS1', 'ОФЗ-26230', 'Минфин РФ', 200, 94.8, 7.7, 8.43, '2019-05-06');

INSERT INTO bond (country_id, user_id, symbol, title, company, count, price, cupon, yield, maturity)
    VALUES (1, 3, 'SU26235RMFS0', 'ОФЗ-26235', 'Минфин РФ', 300, 84.2, 5.9, 8.6, '2031-03-12');
INSERT INTO bond (country_id, user_id, symbol, title, company, count, price, cupon, yield, maturity)
    VALUES (1, 3, 'SU26230RMFS1', 'ОФЗ-26230', 'Минфин РФ', 250, 94.8, 7.7, 8.43, '2019-05-06');


