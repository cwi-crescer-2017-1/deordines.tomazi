-- Lista de Exercícios 5

-- Exercício 1
-- Múltiplos acessos
-- Liste o nome do empregado, o nome do gerente e o departamento de cada um.
SELECT * FROM Empregado;
SELECT e.NomeEmpregado,
	depE.NomeDepartamento as [Departamento Empregado],
	gerente.NomeEmpregado as [Nome Gerente],
	depG.NomeDepartamento as [Departamento Gerente]
FROM Empregado e
LEFT JOIN Departamento depE ON e.IDDepartamento = depE.IDDepartamento
LEFT JOIN Empregado gerente ON e.IDGerente = gerente.IDEmpregado
LEFT JOIN Departamento depG ON gerente.IDDepartamento = depG.IDDepartamento;

-- Exercício 2
-- Maior Salário
-- Liste o departamento (id e nome) com o empregado de maior salário.
SELECT * FROM
Empregado
ORDER BY Salario DESC;

SELECT IDDepartamento, NomeDepartamento
FROM Departamento
WHERE IDDepartamento IN (SELECT TOP 1 IDDepartamento
						 FROM Empregado
						 WHERE IDDepartamento IS NOT NULL
						 ORDER BY Salario DESC);

-- Exercício 3
-- Reajuste salarial
-- Aplique uma alteração salarial em todos os empregados que o departamento fique na localidade de SAO PAULO, este reajuste deve ser de 17,3%.
-- Por segurança faça uma cópia da tabela Empregado antes de iniciar esta tarefa.
SELECT *
INTO EmpregadoBackup
FROM Empregado;

SELECT NomeEmpregado
FROM Empregado
WHERE IDDepartamento IN (SELECT IDDepartamento
						 FROM Departamento
						 WHERE Localizacao = 'SAO PAULO');

BEGIN TRANSACTION
UPDATE Empregado
SET Salario = Salario + (Salario * 0.173)
FROM Empregado
WHERE IDDepartamento IN (SELECT IDDEpartamento
						 FROM Departamento
						 WHERE Localizacao = 'SAO PAULO');

ROLLBACK

SELECT * FROM Empregado
WHERE IDDepartamento IN (SELECT IDDEpartamento
						 FROM Departamento
						 WHERE Localizacao = 'SAO PAULO');

-- Exercício 4
-- Cidades duplicadas
-- Liste todas as cidades duplicadas (nome e UF iguais).
SELECT DISTINCT c.Nome, c.UF
FROM Cidade c
WHERE EXISTS (SELECT 1
			  FROM Cidade c2
			  WHERE c.Nome = c2.Nome AND c.UF = c2.UF AND c.IDCidade != c2.IDCidade);

-- Exercício 5
-- Definindo Cidades
-- Faça uma alteraçao nas cidades que tenham nome+UF duplicados, adicione no final do nome um asterisco. Mas atenção! apenas a cidade com maior ID deve ser alterada.
ALTER TABLE Cidade
ALTER COLUMN UF VARCHAR(3);

BEGIN TRANSACTION
UPDATE c
SET c.Nome = c.Nome + '*', c.UF = c.UF + '*'
FROM Cidade c
INNER JOIN Cidade c2 ON c.Nome = c2.Nome AND c.UF = c2.UF AND c.IDCidade != c2.IDCidade
WHERE c2.IDCidade < c.IDCidade; -- wtf corrigir
ROLLBACK

SELECT * FROM Cidade;