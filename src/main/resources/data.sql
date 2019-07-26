DROP TABLE IF EXISTS cashback;
DROP TABLE IF EXISTS venda;
DROP TABLE IF EXISTS item_venda;

CREATE TABLE cashback (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  cd_genero INT NOT NULL,
  cd_dia int NOT NULL,
  vl_percentual DECIMAL NOT NULL
);

CREATE TABLE venda (
   id INT AUTO_INCREMENT  PRIMARY KEY,
   dt_venda DATETIME
);

CREATE TABLE item_venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venda INT,
    id_cashback INT,
    FOREIGN KEY (id_cashback) REFERENCES cashback(id),
    foreign key (id_venda) references venda(id),
    vl_cashback DECIMAL not null,
    vl_unitario DECIMAL not null,
    cd_album VARCHAR2(250)
);

INSERT INTO cashback (cd_genero, cd_dia, vl_percentual) VALUES
(1, 1, 25),(1, 2, 7),(1, 3, 6),(1, 4, 2),(1, 5, 10),(1, 6, 15),(1, 7, 20),
(2, 1, 30),(2, 2, 5), (2, 3, 10),(2, 4, 15),(2, 5, 20),(2, 6, 25),(2, 7, 30),
(3, 1, 35),(3, 2, 3), (3, 3, 5), (3, 4, 8), (3, 5, 13),(3, 6, 18),(3, 7, 25),
(4, 1, 40),(4, 2, 10),(4, 3, 15),(4, 4, 15),(4, 5, 15),(4, 6, 20),(4, 7, 40);

