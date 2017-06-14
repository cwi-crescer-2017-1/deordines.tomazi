-- Exercício 1
-- Cidades Duplicadas
-- A partir do conhecimento de procedures/functions e packages obtidos (rapidamente) crie uma package que permita eliminar cidades duplicadas.
-- Para essa tarefa respeite as seguintes regras:
-- -> identifique as cidades duplicadas;
-- -> identifique os clientes que estão relacionados com ela;
-- -> altere no cliente (idcidade) para manter apenas a cidade duplicada de menor ID;
-- -> certificando-se que não há mais clientes utilizando cidades duplicadas elimine-as.
-- Utilize uma codificação que possibilite o uso de teste unitário.

create or replace PACKAGE pck_cidade AS
    PROCEDURE IdentificarCidadesDuplicadas;
    FUNCTION BuscarCidadeComMenorId(pNome VARCHAR2, pUF VARCHAR2) return INTEGER;
END

create or replace PACKAGE BODY pck_cidade AS
    vNovoId Cidade.IdCidade%TYPE;

    FUNCTION BuscarCidadeComMenorId(pNome VARCHAR2, pUF VARCHAR2) return INTEGER AS
        vId Cidade.IdCidade%TYPE;
        BEGIN
            SELECT MIN(IdCidade) as MenorID
            INTO vId
            FROM Cidade
            WHERE Cidade.Nome = pNome
            AND Cidade.UF = pUF;
        RETURN vId;
    END BuscarCidadeComMenorId;

    PROCEDURE IdentificarCidadesDuplicadas AS
        CURSOR ListaDeCidadesRepetidas IS
            SELECT Nome, UF, COUNT(*)
            FROM Cidade
            GROUP BY Nome, UF
            HAVING COUNT(*) > 1
            ORDER BY Nome;

        CURSOR ListaClientes (pNome IN VARCHAR2, pUF IN VARCHAR2) IS
            SELECT cli.IdCliente, cli.Nome as NomeCliente, cid.Nome as NomeCidade, cid.UF
            FROM Cliente cli
            JOIN Cidade cid ON cid.IdCidade = cli.IdCidade
            WHERE cid.Nome = pNome
            AND cid.UF = pUF;
        BEGIN
            FOR cidade IN ListaDeCidadesRepetidas LOOP
                DBMS_OUTPUT.PUT_LINE(cidade.Nome);
                vNovoId := pck_cidade.BuscarCidadeComMenorId(cidade.Nome, cidade.UF);
                FOR cliente IN ListaClientes(cidade.Nome, cidade.UF) LOOP
                    UPDATE cliente
                    SET IdCidade = vNovoId
                    WHERE IdCidade != vNovoId;
                END LOOP;
            END LOOP;
    END IdentificarCidadesDuplicadas;
END pck_cidade;