-- Exerc�cio 1
-- Cidades Duplicadas
-- Atualmente a tabela de Cidade tem registros duplicados (nome e UF). Fa�a um c�digo (PL/SQL) que liste quais s�o as cidades duplicadas. Ap�s isso liste todos os clientes que est�o relacionados com estas cidades
DECLARE
  CURSOR ListaClientes IS
    SELECT cli.IDCIdade, cli.Nome
    FROM Cliente cli
    JOIN Cidade cid ON cid.IDCidade = cli.IDCidade;
  CURSOR ListaCidades IS
    SELECT IDCidade, Nome, UF, COUNT(*)
    FROM Cidade
    GROUP BY IDCIdade, Nome, UF
    HAVING COUNT(*) > 1
    ORDER BY Nome;
BEGIN
  FOR cidade IN ListaCidades LOOP
    DBMS_OUTPUT.PUT_LINE(cidade.nome);
  END LOOP;
  
  --FOR cliente IN ListaClientes LOOP
    FOR cidade IN ListaCidades LOOP
      --IF (cliente.IDCidade = cidade.IDCidade) THEN 
        DBMS_OUTPUT.PUT_LINE(cidade.Nome);
      --END IF;
    END LOOP;
  --END LOOP;
END;