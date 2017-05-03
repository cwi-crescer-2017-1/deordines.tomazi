
-- Maneira rápida para descobrir a quantidade de linhas da tabela

-- Utilizar a PK
SELECT COUNT(IDEmpregado) FROM Empregado;

-- SELECT * não prejudica o desempenho
SELECT COUNT(*) FROM Empregado;
-- E funciona da mesma forma que
SELECT COUNT(1) FROM Empregado;
-- Que é igual a colocar um valor estático para retornar um valor simbólico em cada linha
SELECT 1 FROM Empregado;

-- Retornar todos os cargos, mesmo repetidos
SELECT Cargo FROM Empregado;
-- DISTINCT remove resultados duplicados
SELECT DISTINCT Cargo FROM Empregado;

-- Retornar a quantidade de empregados e cargos sem duplicação
SELECT COUNT(*) [Total Empregados],
	   COUNT(DISTINCT Cargo) as [Cargos Distintos]
FROM Empregado;

-- ISNULL atribuí um valor específico caso o valor do atributo seja nulo
SELECT IDEmpregado, NomeEmpregado, Salario, Comissao,
       Salario + ISNULL(Comissao, 0) as TotalMensal
FROM Empregado;

-- Retornar uma projeção de grupo
SELECT IDDepartamento,
	   COUNT(1) as TotalEmpregado
FROM Empregado
GROUP BY IDDepartamento;

SELECT Cargo, IDDepartamento,
       COUNT(*) as [Total Empregado]
FROM Empregado
GROUP BY Cargo, IDDepartamento

-- Ordem de execução:
-- WHERE 
-- GROUP BY
-- ORDER BY

-- Retornar número de empregados por cargo, com mais de um empregado por cargo
SELECT Cargo, IDDepartamento,
	   COUNT(*) as TotalEmpregado
FROM Empregado
GROUP BY Cargo, IDDepartamento
HAVING COUNT(*) > 1; -- HAVING = WHERE do GROUP BY

-- HAVING somente deve ser utilizado em funções de grupo, para filtros específicos, usar o WHERE.

-- Retornar os anos trabalhados de cada empregado
SELECT NomeEmpregado, DataAdmissao,
	   DATEDIFF(YEAR, DataAdmissao, GETDATE()) AnosTrabalhados
FROM Empregado;

-- Retorna os nomes das cidades com as alterações pré-determinadas
SELECT Nome,
	   REPLACE(REPLACE(Nome, 'ção', 'cion'), 'sao', 'san') as NomeCidade,
	   UF
FROM Cidade;