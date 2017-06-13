-- Exerc�cio 1
-- Produtos inativos
-- Liste os produtos (id e nome) que n�o tiveram nenhuma compra nos �ltimos quatro meses.
CREATE OR REPLACE VIEW vw_Produtos_Sem_Compra AS
SELECT prod.IdProduto, prod.Nome FROM Produto prod
JOIN PedidoItem pedItem ON pedItem.IDPRODUTO = prod.IDPRODUTO
JOIN Pedido ped ON ped.IDPEDIDO = pedItem.IDPEDIDO
HAVING MAX (ped.DATAPEDIDO) <= TRUNC(SYSDATE) - 120
GROUP BY prod.IdProduto, prod.Nome

-- Selecionar as infoma��es da tabela
SELECT * FROM user_tables;

-- Atualizar estat�sticas
-- Para consultas lentas, o comando abaixo pode ser a solu��o.
EXEC dbms_stats.gather_schema_stats(USER);

-- Selecionar o usu�rio que est� conectado
SELECT USER FROM DUAL;

-- Exerc�cio 2
-- Alterando status
-- Altere o status dos produtos (campo situacao) que n�o tiveram nenhum pedido nos �ltimos quatro meses. Definir o valor I para o campo situacao.
UPDATE Produto
SET Situacao = 'I'
WHERE IDProduto IN (SELECT IDProduto FROM vw_Produtos_Sem_Compra);
-- ou
UPDATE Produto
SET Situacao = 'I'
WHERE EXISTS (SELECT IDProduto
              FROM vw_Produtos_Sem_Compra vw
              WHERE Produto.IDProduto = vw.IDProduto);

-- Exerc�cio 3
-- Parametro
-- Fa�a uma consulta que receba um par�metro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no �ltimo ano (desde janeiro/2017).
SELECT SUM(pedItem.Quantidade) qtds
FROM PedidoItem pedItem
JOIN Pedido ped ON ped.IDPedido = pedItem.IDPedido
WHERE pedItem.IDProduto = :parametro
AND ped.DataPedido >= trunc(sysdate, 'yyyy');