DROP TABLE conta;
DROP TABLE pessoa;

CREATE TABLE pessoa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(64) NOT NULL,
  cpf CHAR(11) UNIQUE NOT NULL,
  idade INTEGER,
  cidade VARCHAR(64)
);

CREATE TABLE conta (
  id SERIAL PRIMARY KEY,
  pessoa INTEGER NOT NULL REFERENCES PESSOA(ID) ON UPDATE CASCADE ON DELETE CASCADE,
  numero INTEGER UNIQUE NOT NULL,
  banco VARCHAR(64),
  saldo NUMERIC(16,2)
);

INSERT INTO pessoa (nome, cpf, idade, cidade) VALUES
	('Solidus Snake', '62691733025', 37, 'Nova Iorque'),
	('Paul Schrader', '43720607003', 73, 'Verê'),
	('Bill Hader', '22190772095', 40, 'Belo Horizonte'),
	('Michael Myers', '85317105021', 23, 'Dois Vizinhos'),
	('Jessica Chastain', '80599496088', 42, 'San Franscisco'),
	('Regina King', '44724358025', 48, 'Los Angeles'),
	('Caroline Polachek', '01980411018', 34, 'Anor Londo');

INSERT INTO conta (pessoa, numero, banco, saldo) VALUES
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '1', 'NuBank', 1.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '2', 'NuBank', 2.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '3', 'NuBank', 3.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '4', 'NuBank', 4.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '5', 'NuBank', 5.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '6', 'NuBank', 6.00),
	((SELECT id FROM pessoa WHERE cpf = '01980411018'), '7', 'NuBank', 7.00);

INSERT INTO conta (pessoa, numero, banco, saldo) VALUES
	((SELECT id FROM pessoa WHERE cpf = '62691733025'), '999999', 'Fox', 1997.00),
	((SELECT id FROM pessoa WHERE cpf = '62691733025'), '666666', 'Xof', 20.08);
