-- Exercício 1
Select * INTO CidadeAux From Cidade;

-- Exercício 2
TRUNCATE TABLE CidadeAux;
INSERT INTO CidadeAux SELECT * FROM Cidade WHERE UF = 'RS';

-- Exercício 3
CREATE TABLE Produtos (
	idProduto		int IDENTITY not null,
	nomeCurto		varchar(30) not null,
	nomeDescritivo	varchar(100) not null,
	dataCriacao		date not null,
	localEstoque	varchar(10) not null,
	quantidade		int not null,
	preco			real not null,
		constraint PK_Produtos primary key (idProduto);
	)

-- Exercício 4
INSERT INTO Produtos(nomeCurto, nomeDescritivo, dataCriacao, localEstoque, quantidade, preco)
	VALUES ('HD WD', 'HD Western Digital SATA 3.5 Blue 7200rpm', GETDATE(), 'Corredor A', '50', '239.99'),
			('GTX 1060', 'Placa de Vídeo GeForce GTX 1060 OC 6GB ASUS ROG', GETDATE(), 'Corredor B', '5', '1199.99');

SELECT * FROM Produtos;