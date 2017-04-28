-- Criar tabela
CREATE TABLE Pais (
	IDPais	int	not null,
	Nome	varchar(50) not null,
	Sigla	varchar(3),
	constraint PK_Pais primary key(IDPais) -- chave primária
	)

-- Inserir dados
INSERT INTO Pais (IDPais, Nome, Sigla)
	VALUES (1, 'Brazil', 'BRA');

INSERT INTO Pais (IDPais, Nome, Sigla)
	VALUES (2, 'Alemanha', 'ALE');

INSERT INTO Pais (IDPais, Nome, Sigla)
	VALUES (0, 'Argentina', 'ARG');

-- Deletar apenas uma linha conforme a chave primária
DELETE FROM Pais where IDpais = 0;

-- Selecionar apenas uma linha conforme a chave primária
SELECT * FROM Pais where IDpais = 1;

-- Alterar estrutura da tabela para incluir um novo atributo
ALTER TABLE Pais add DDI varchar(5);

-- Selecionar dados da tabela
SELECT * FROM Pais;

-- Eliminar uma tabela completamente
DROP TABLE Pais;

-- Primary Key: apenas uma chave por tabela
-- Unique: mais de uma chave por tabela

-- Criar tabela com IDENTITY (auto incremento)
CREATE TABLE Pais (
	IDPais	int IDENTITY not null,
	Nome	varchar(50) not null,
	Sigla	varchar(3)
	)

INSERT INTO Pais (Nome, Sigla)
	VALUES ('Brazil', 'BRA');

INSERT INTO Pais (Nome, Sigla)
	VALUES ('Alemanha', 'ALE');

INSERT INTO Pais (Nome, Sigla)
	VALUES ('Argentina', 'ARG');

SELECT * FROM Pais;

-- Alterar para adicionar a chave primária
ALTER TABLE Pais ADD CONSTRAINT PK_Pais PRIMARY KEY (IDPais);

/* char, varchar VS nchar, nvarchar
nchar, nationalvarchar: útil para aplicações globais, ocupam o dobro de armazenamento
Ex.: símbolos japoneses ou chineses que ocupam duas casas (2 bytes) */

DROP TABLE Pais;

-- Criar tabela com PK e UK, Primary Key e Unique Key
CREATE TABLE Pais (
	IDPais	int IDENTITY not null,
	Nome	varchar(50) not null,
	Sigla	varchar(3),
		constraint PK_Pais primary key (IDPais),
		constraint UK_Pais_Nome unique (Nome)
	)
	
INSERT INTO Pais (Nome, Sigla)
	VALUES ('Brasil', 'BRA'),
		('Argentina', 'ARG');

-- Deve dar erro, pois já existe um país com o nome Brasil
INSERT INTO Pais (Nome, Sigla)
	VALUES ('Brasil', 'BRA');

DROP TABLE Pais;

-- Criar tabela com PK, UK e Check
CREATE TABLE Pais (
	IDPais	int IDENTITY not null,
	Nome	varchar(50) not null,
	Sigla	varchar(3),
	Situacao char(1),
		constraint PK_Pais primary key (IDPais),
		constraint UK_Pais_Nome unique (Nome),
		constraint CC_Pais_Situacao check (Situacao in ('A', 'I'))
	)

INSERT INTO Pais (Nome, Sigla, Situacao) VALUES ('Brasil', 'BRA', 'A');
INSERT INTO Pais (Nome, SIgla, Situacao) VALUES ('Peru', 'PER', 'I');
INSERT INTO Pais (Nome, Sigla, Situacao) VALUES ('Colômbia', 'COL', 'A');

SELECT * FROM Pais WHERE Situacao = 'A';
SELECT * FROM Pais WHERE Situacao = 'I';

DROP TABLE Pais;