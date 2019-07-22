DROP TABLE IF EXISTS cashback_dia;
DROP TABLE IF EXISTS vendas;

CREATE TABLE cashback_dia (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  genero_id INT NOT NULL,
  dia int NOT NULL,
  cashback INT NOT NULL
);

CREATE TABLE venda (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    album_id VARCHAR(250),
    valor_cashback  DECIMAL(6,2)
);


INSERT INTO cashback_dia (genero_id, dia, cashback) VALUES
(1, 1, 25),(1, 2, 7),(1, 3, 6),(1, 4, 2),(1, 5, 10),(1, 6, 15),(1, 7, 20),
(2, 1, 30),(2, 2, 5), (2, 3, 10),(2, 4, 15),(2, 5, 20),(2, 6, 25),(2, 7, 30),
(3, 1, 35),(3, 2, 3), (3, 3, 5), (3, 4, 8), (3, 5, 13),(3, 6, 18),(3, 7, 25),
(4, 1, 40),(4, 2, 10),(4, 3, 15),(4, 4, 15),(4, 5, 15),(4, 6, 20),(4, 7, 40);

