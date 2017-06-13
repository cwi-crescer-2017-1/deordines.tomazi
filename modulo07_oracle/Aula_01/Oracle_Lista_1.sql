-- Exercício 1
-- Produtos inativos
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
CREATE OR REPLACE VIEW vw_Produtos_Sem_Compra AS
SELECT prod.IdProduto, prod.Nome FROM Produto prod
JOIN PedidoItem pedItem ON pedItem.IDPRODUTO = prod.IDPRODUTO
JOIN Pedido ped ON ped.IDPEDIDO = pedItem.IDPEDIDO
HAVING MAX (ped.DATAPEDIDO) <= TRUNC(SYSDATE) - 120
GROUP BY prod.IdProduto, prod.Nome

-- Selecionar as infomações da tabela
SELECT * FROM user_tables;

-- Atualizar estatísticas
-- Para consultas lentas, o comando abaixo pode ser a solução.
EXEC dbms_stats.gather_schema_stats(USER);

-- Selecionar o usuário que está conectado
SELECT USER FROM DUAL;

-- Exercício 2
-- Alterando status
-- Altere o status dos produtos (campo situacao) que não tiveram nenhum pedido nos últimos quatro meses. Definir o valor I para o campo situacao.
UPDATE Produto
SET Situacao = 'I'
WHERE IDProduto IN (SELECT IDProduto FROM vw_Produtos_Sem_Compra);
-- ou
UPDATE Produto
SET Situacao = 'I'
WHERE EXISTS (SELECT IDProduto
              FROM vw_Produtos_Sem_Compra vw
              WHERE Produto.IDProduto = vw.IDProduto);

-- Exercício 3
-- Parametro
-- Faça uma consulta que receba um parâmetro sendo o IDProduto e liste a quantidade de itens na tabela PedidoItem com este IDProduto foram vendidos no último ano (desde janeiro/2017).
SELECT SUM(pedItem.Quantidade) qtds
FROM PedidoItem pedItem
JOIN Pedido ped ON ped.IDPedido = pedItem.IDPedido
WHERE pedItem.IDProduto = :parametro
AND ped.DataPedido >= trunc(sysdate, 'yyyy');