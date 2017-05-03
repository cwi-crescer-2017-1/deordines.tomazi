-- Lista de Exercício 6

-- Exercício 1
-- Primeiro nome
-- Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT TOP 1 SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1) as PrimeiroNome,
	COUNT(*) as TotalOcorrencias
FROM Cliente
GROUP BY SUBSTRING(Nome, 1, CHARINDEX(' ', Nome) - 1)
ORDER BY TotalOcorrencias DESC

-- Exercício 2
-- Total do Mês
-- Liste o total de pedidos (quantidade e valor) realizados no mês de abril/2017.
SELECT COUNT(*) as Quantidade,
	SUM(ValorPedido) as Valor
FROM Pedido
-- WHERE MONTH(DataPedido) = 4 AND YEAR(DataPedido) = 2017 -- usando as funções MONTH() e YEAR() encontro os mesmos valores do exemplo
WHERE DataPedido BETWEEN CONVERT(DATE, '01/04/2017', 103) AND CONVERT(DATETIME, '30/04/2017 23:59:59', 103); -- deve-se colocar a hora, senão o convert não pega o dia cheio

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

-- Exerício 3
-- Estados x Clientes
-- Identifique qual o estado (coluna UF da tabela Cidade) possuí o maior número de clientes (tabela Cliente), liste também qual o Estado possuí o menor número de clientes.
SELECT cid.UF,
	COUNT(cli.IDCliente) as TotalClientes
FROM Cidade cid
INNER JOIN Cliente cli ON cli.IDCidade = cid.IDCidade
GROUP BY cid.UF
ORDER BY TotalClientes ASC;

-- Exercício 4
-- Novo Produto
-- Crie (insira) um novo registro na tabela de Produto, com as seguintes informações:
-- Nome: Galocha Maragato
-- Preço de custo: 35.67
-- Preço de venda: 77.95
-- Situação: A
BEGIN TRANSACTION
INSERT INTO Produto (Nome, DataCadastro, PrecoCusto, PrecoVenda, Situacao)
VALUES ('Galocha Maragato', GETDATE(), 35.67, 77.95, 'A');
ROLLBACK
SELECT * FROM Produto

-- Exercício 5
-- Produtos não comprados
-- Identifique e liste os produtos que não tiveram nenhum pedido, considere os relacionamentos no modelo de dados, pois não há relacionamento direto entre Produto e Pedido (será preciso relacionar PedidoItem).
-- => Obs.: o produto criado anteriormente deverá ser listado (apenas este)
SELECT prod.*
FROM Produto prod
LEFT JOIN PedidoItem pedItem ON pedItem.IDProduto = prod.IDProduto
WHERE pedItem.IDProduto IS NULL

SELECT *
FROM Produto prod
WHERE NOT EXISTS (SELECT 1
			  FROM PedidoItem pedItem
			  WHERE pedItem.IDProduto = prod.IDProduto)

-- Exercício 6
-- Principais Produtos
-- Liste os 30 produtos que mais geraram lucro em 2016.
SELECT TOP 30 prod.Nome,
	pedItem.PrecoUnitario
FROM PedidoItem pedItem
INNER JOIN Produto prod ON prod.IDProduto = pedItem.IDProduto
INNER JOIN Pedido ped ON ped.IDPedido = pedItem.IDPedido
WHERE ped.DataPedido BETWEEN CONVERT(DATE, '01/01/2016', 103) AND CONVERT(DATE, '31/12/2016 23:59:59', 103)
ORDER BY pedItem.PrecoUnitario DESC;