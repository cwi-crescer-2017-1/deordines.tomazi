-- Exercício 1
-- Produtos inativos
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.
SELECT prod.IDProduto, prod.Nome FROM Produto prod
JOIN PedidoItem pedItem ON pedItem.IDPRODUTO = prod.IDPRODUTO
JOIN Pedido ped ON ped.IdPedido = pedItem.IdPedido
HAVING MAX(ped.dataPedido) <= TRUNC(SYSDATE) -120
GROUP BY prod.IDProduto, prod.Nome