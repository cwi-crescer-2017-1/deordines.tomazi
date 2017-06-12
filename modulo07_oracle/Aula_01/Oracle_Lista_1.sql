-- Exercício 1
-- Produtos inativos
-- Liste os produtos (id e nome) que não tiveram nenhuma compra nos últimos quatro meses.

SELECT prod.IDProduto, prod.Nome FROM Produto prod
JOIN PedidoItem pedItem ON pedItem.IDPRODUTO = prod.IDPRODUTO
WHERE pedItem.IDPEDIDO not in (SELECT IdPedido FROM Pedido
    WHERE DataPedido BETWEEN '12/02/2017' AND '12/06/2017');






SELECT ped.IdPedido, ped.DataPedido FROM Pedido ped
WHERE EXTRACT(month FROM ped.DataPedido) = 1;

SELECT ped.IDPedido, ped.DataPedido FROM Pedido ped
(WHERE 
WHERE ped.DataPedido BETWEEN '12/02/2017' AND '12/06/2017';

