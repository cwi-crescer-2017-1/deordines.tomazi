
-- Maneira r�pida para descobrir a quantidade de linhas da tabela

-- Utilizar a PK
SELECT COUNT(IDEmpregado) FROM Empregado;

-- SELECT * n�o prejudica o desempenho
SELECT COUNT(*) FROM Empregado;
-- E funciona da mesma forma que
SELECT COUNT(1) FROM Empregado;
-- Que � igual a colocar um valor est�tico para retornar um valor simb�lico em cada linha
SELECT 1 FROM Empregado;

-- Retornar todos os cargos, mesmo repetidos
SELECT Cargo FROM Empregado;
-- DISTINCT remove resultados duplicados
SELECT DISTINCT Cargo FROM Empregado;

-- Retornar a quantidade de empregados e cargos sem duplica��o
SELECT COUNT(*) [Total Empregados],
	   COUNT(DISTINCT Cargo) as [Cargos Distintos]
FROM Empregado;

-- ISNULL atribu� um valor espec�fico caso o valor do atributo seja nulo
SELECT IDEmpregado, NomeEmpregado, Salario, Comissao,
       Salario + ISNULL(Comissao, 0) as TotalMensal
FROM Empregado;

-- Retornar uma proje��o de grupo
SELECT IDDepartamento,
	   COUNT(1) as TotalEmpregado
FROM Empregado
GROUP BY IDDepartamento;

SELECT Cargo, IDDepartamento,
       COUNT(*) as [Total Empregado]
FROM Empregado
GROUP BY Cargo, IDDepartamento

-- Ordem de execu��o:
-- WHERE 
-- GROUP BY
-- ORDER BY

-- Retornar n�mero de empregados por cargo, com mais de um empregado por cargo
SELECT Cargo, IDDepartamento,
	   COUNT(*) as TotalEmpregado
FROM Empregado
GROUP BY Cargo, IDDepartamento
HAVING COUNT(*) > 1; -- HAVING = WHERE do GROUP BY

-- HAVING somente deve ser utilizado em fun��es de grupo, para filtros espec�ficos, usar o WHERE.

-- Retornar os anos trabalhados de cada empregado
SELECT NomeEmpregado, DataAdmissao,
	   DATEDIFF(YEAR, DataAdmissao, GETDATE()) AnosTrabalhados
FROM Empregado;

-- Retorna os nomes das cidades com as altera��es pr�-determinadas
SELECT Nome,
	   REPLACE(REPLACE(Nome, '��o', 'cion'), 'sao', 'san') as NomeCidade,
	   UF
FROM Cidade;