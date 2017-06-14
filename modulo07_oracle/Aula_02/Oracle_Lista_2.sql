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