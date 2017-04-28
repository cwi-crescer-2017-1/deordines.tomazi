-- Exercício 1
SELECT * INTO CidadeAux FROM Cidade;

-- Exercício 2
TRUNCATE TABLE CidadeAux;
INSERT INTO CidadeAux (IDCidade, Nome, UF) SELECT IDCidade, Nome, UF FROM Cidade WHERE UF = 'RS';
-- Boa prática: especificar as colunas que serão inseridas, ao invés de usar o *.

-- Exercício 3
CREATE TABLE Produtos (
	idProduto		int IDENTITY not null,
	nomeCurto		varchar(30) not null,
	nomeDescritivo	varchar(100) not null,
	dataCriacao		date not null,
	localEstoque	varchar(10) not null,
	quantidade		decimal(7,3) not null, -- 7 = quantidade total de números, onde 3 serão após a vírgula. Ex.: 1234,123
	preco			decimal(9,3) not null, -- 9 = quantidade total de números, onde 3 serão após a vírgula. Ex.: 123456,123 
		constraint PK_Produtos primary key (idProduto)
	);

-- Exercício 4
INSERT INTO Produtos(nomeCurto, nomeDescritivo, dataCriacao, localEstoque, quantidade, preco)
	VALUES ('HD WD', 'HD Western Digital SATA 3.5 Blue 7200rpm', GETDATE(), 'Corredor A', 50, 239.99),
			('GTX 1060', 'Placa de Vídeo GeForce GTX 1060 OC 6GB ASUS ROG', GETDATE(), 'Corredor B', 5, 1199.99);

-- Data e hora do BANCO e não do computador do cliente.
SELECT GETDATE();

-- Salvar data específica, convertendo string para data. Funciona somente no SQL Server.
-- Código 103 = dd/mm/aaaa
SELECT CONVERT(DATE, '13/05/2017', 103);

SELECT * FROM Produtos;