-- Exercício 1
-- Cidades Duplicadas
-- Atualmente a tabela de Cidade tem registros duplicados (nome e UF). Faça um código (PL/SQL) que liste quais são as cidades duplicadas. Após isso liste todos os clientes que estão relacionados com estas cidades
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

-- Exercício 2
-- Atualizando Valor do Pedido
-- Faça uma rotina que permita atualizar o valor do pedido a partir dos seus itens. Esta rotina deve receber por parametro o IDPedido e então verificar o valor total de seus itens (quantidade x valor unitário).
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

-- Exercício 3
-- Atualização de Clientes
-- Crie uma rotina que atualize todos os clientes que não realizaram nenhum pedido nos últimos 6 meses (considere apenas o mês, dia 01 do 6º mês anterior). Definir o atributo Situacao para I.
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