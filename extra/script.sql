drop schema teste;

CREATE SCHEMA teste;
USE teste;

CREATE TABLE teste.endereco (
  id int auto_increment NOT NULL,
  cep varchar(9) NOT NULL,
  cidade varchar(55) NOT NULL,
  uf varchar(2) NOT NULL,
  CONSTRAINT endereco_pk PRIMARY KEY (id)
)

CREATE TABLE teste.fabricantes (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	cnpj varchar(14) NOT NULL,
	id_endereco int NOT NULL,
	CONSTRAINT fabricantes_pk PRIMARY KEY (id),
	CONSTRAINT id_endereco foreign key (id_endereco) references teste.endereco(ID)
);

CREATE TABLE teste.produtos (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	id_fabricante int NOT NULL,
	valor DECIMAL NOT NULL,
	peso DECIMAL NOT NULL,
	data_cadastro DATE NOT NULL,
	CONSTRAINT produtos_pk PRIMARY KEY (id),
	CONSTRAINT id_fabricante foreign key (id_fabricante) references teste.fabricantes(ID)
);

INSERT INTO teste.endereco (cep, cidade, uf)
VALUES('88101420', 'São José', 'SC');

INSERT INTO teste.endereco (cep, cidade, uf)
VALUES('88125000', 'São Pedro de Alcântara', 'SC');

INSERT INTO teste.fabricantes (nome, cnpj, id_endereco)
VALUES('Ouro', '11222333000022', 1);

INSERT INTO teste.fabricantes (nome, cnpj, id_endereco)
VALUES('Pelé', '10222333000022', 1);

INSERT INTO teste.fabricantes (nome, cnpj, id_endereco)
VALUES('Havaianas', '55222333000022', 2);

INSERT INTO teste.fabricantes (nome, cnpj, id_endereco)
VALUES('Rider', '88222333000022', 2);

INSERT INTO teste.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 1, 12.5, 0.5, sysdate());

INSERT INTO teste.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 10.0, 0.5, sysdate());

INSERT INTO teste.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela de tira', 3, 80.5, 0.2, sysdate());

INSERT INTO teste.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela pesada', 4, 70.2, 0.3, sysdate());

select * from fabricantes f;
select * from produtos p;
select * from endereco e;