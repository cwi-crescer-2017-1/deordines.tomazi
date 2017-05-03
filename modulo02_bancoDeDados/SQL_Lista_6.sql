-- Lista de Exerc�cio 6

-- Exerc�cio 1
-- Primeiro nome
-- Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT TOP 1 SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) as PrimeiroNome,
	COUNT(*) as TotalOcorrencias
FROM Cliente
GROUP BY SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1)
ORDER BY TotalOcorrencias DESC

-- Exerc�cio 2
-- Total do M�s
-- Liste o total de pedidos (quantidade e valor) realizados no m�s de abril/2017.
SELECT COUNT(*) as Quantidade,
	SUM(ValorPedido) as Valor
FROM Pedido
-- WHERE MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017 -- usando as fun��es MONTH() e YEAR() encontro os mesmos valores do exemplo
WHERE DataPedido BETWEEN CONVERT(DATE, '01/04/2017', 103) AND CONVERT(DATETIME, '30/04/2017 23:59:59', 103); -- deve-se colocar a hora, sen�o o convert n�o pega o dia cheio

/* Testes testes e testes
SELECT * FROM Pedido
WHERE MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017;

SELECT * FROM Pedido
WHERE DataPedido BETWEEN CONVERT(DATE, '01/04/2017', 103) AND CONVERT(DATE, '30/04/2017', 103);

SELECT * INTO resultado1 FROM Pedido
WHERE MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017;

SELECT * INTO resultado2 FROM Pedido
WHERE DataPedido BETWEEN CONVERT(DATE, '01/04/2017', 103) AND CONVERT(DATE, '30/04/2017', 103);

SELECT r1.*
FROM resultado1 r1
LEFT JOIN resultado2 r2 ON r2.IDPedido = r1.IDPedido
WHERE r2.IDPedido IS NULL;

SELECT * FROM Pedido
WHERE DAY(DataPedido) = 30 AND MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017;
*/

-- Exer�cio 3
-- Estados x Clientes
-- Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), liste tamb�m qual o Estado possu� o menor n�mero de clientes.
SELECT cid.UF,
	COUNT(cli.IDCliente) as TotalClientes
FROM Cidade cid
INNER JOIN Cliente cli ON cli.IDCidade = cid.IDCidade
GROUP BY cid.UF
ORDER BY TotalClientes ASC;

-- Exerc�cio 4
-- Novo Produto
-- Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
-- Nome: Galocha Maragato
-- Pre�o de custo: 35.67
-- Pre�o de venda: 77.95
-- Situa��o: A
BEGIN TRANSACTION
INSERT INTO Produto (Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES ('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A');
ROLLBACK
SELECT * FROM Produto

-- Exerc�cio 5
-- Produtos n�o comprados
-- Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
-- => Obs.: o produto criado anteriormente dever� ser listado (apenas este)
SELECT prod.*
FROM Produto prod
LEFT JOIN PedidoItem pedItem ON pedItem.IDProduto = prod.IDProduto
WHERE pedItem.IDProduto IS NULL

SELECT *
FROM Produto prod
WHERE NOT EXISTS (SELECT 1
			  FROM PedidoItem pedItem
			  WHERE pedItem.IDProduto = prod.IDProduto)

-- Exerc�cio 6
-- Principais Produtos
-- Liste os 30 produtos que mais geraram lucro em 2016.
SELECT TOP 30 prod.Nome,
	pedItem.PrecoUnitario
FROM PedidoItem pedItem
INNER JOIN Produto prod ON prod.IDProduto = pedItem.IDProduto
INNER JOIN Pedido ped ON ped.IDPedido = pedItem.IDPedido
WHERE ped.DataPedido BETWEEN CONVERT(DATE, '01/01/2016', 103) AND CONVERT(DATE, '31/12/2016 23:59:59', 103)
ORDER BY pedItem.PrecoUnitario DESC;