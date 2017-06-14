-- Exerc�cio 1
-- Cidades Duplicadas
-- Atualmente a tabela de Cidade tem registros duplicados (nome e UF). Fa�a um c�digo (PL/SQL) que liste quais s�o as cidades duplicadas. Ap�s isso liste todos os clientes que est�o relacionados com estas cidades
DECLARE
    CURSOR ListaClientes IS
        SELECT cli.IDCIdade, cli.Nome, cid.Nome as NomeCidade
        FROM Cliente cli
        JOIN Cidade cid ON cid.IDCidade = cli.IDCidade;
    
    CURSOR ListaDeCidadesRepetidas IS
        SELECT Nome, UF, COUNT(*)
        FROM Cidade
        GROUP BY Nome, UF
        HAVING COUNT(*) > 1
        ORDER BY Nome;
BEGIN
    FOR cidade IN ListaDeCidadesRepetidas LOOP
        FOR cliente IN ListaClientes LOOP
            IF (cidade.Nome = cliente.NomeCidade) THEN
                DBMS_OUTPUT.PUT_LINE(cliente.nome);
            END IF;
        END LOOP;
    END LOOP;
END;

-- Exerc�cio 2
-- Atualizando Valor do Pedido
-- Fa�a uma rotina que permita atualizar o valor do pedido a partir dos seus itens. Esta rotina deve receber por parametro o IDPedido e ent�o verificar o valor total de seus itens (quantidade x valor unit�rio).
DECLARE
    vValorAtualizado    Pedido.ValorPedido%TYPE;
    vId                 Pedido.IdPedido%TYPE;

    --CURSOR Pedido (Id2 in NUMBER) IS
        --SELECT ValorPedido
        --FROM Pedido
        --WHERE IdPedido = Id2;
        
    CURSOR PedidoItem (Id in NUMBER) IS
        SELECT pedItem.Quantidade, pedItem.PrecoUnitario
        FROM PedidoItem pedItem
        WHERE pedItem.IdPedido = Id;
BEGIN
    vId := :Id;
    vValorAtualizado := 0;

    --FOR item2 IN Pedido(vId) LOOP
        --DBMS_OUTPUT.PUT_LINE(item2.ValorPedido);
    --END LOOP;
    
    FOR item IN PedidoItem(vId) LOOP
        vValorAtualizado := vValorAtualizado + (item.Quantidade * item.PrecoUnitario);
        DBMS_OUTPUT.PUT_LINE(vValorAtualizado);
    END LOOP;
    
    UPDATE Pedido
    SET ValorPedido = vValorAtualizado
    WHERE IdPedido = vId;
END;

-- Exerc�cio 3
-- Atualiza��o de Clientes
-- Crie uma rotina que atualize todos os clientes que n�o realizaram nenhum pedido nos �ltimos 6 meses (considere apenas o m�s, dia 01 do 6� m�s anterior). Definir o atributo Situacao para I.
DECLARE
-- TODO Ver Com o Nunes
    CURSOR ListaClientes IS
        SELECT ped.IdCliente, ped.DataPedido
        FROM Pedido ped
        JOIN Cliente cli ON cli.IdCliente = ped.IdCliente
        WHERE ped.DataPedido > add_months(TRUNC(SYSDATE, 'MM'), -5)
        ORDER BY ped.DataPedido;
BEGIN
    FOR cliente IN ListaClientes LOOP
        UPDATE Cliente
        SET Situacao = 'I';
    END LOOP;
END;