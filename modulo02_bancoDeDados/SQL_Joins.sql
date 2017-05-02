-- Retornar informações de uma tabela que se relaciona com outra, através do INNER JOIN
SELECT Associado.IDAssociado,
	Associado.Nome,
	Associado.IDCidade,
	Cidade.Nome as [Nome Cidade]
FROM Associado
INNER JOIN Cidade ON Cidade.IDCidade = Associado.IDCidade;

-- Dar apelidos para as tabelas para facilitar a leitura (funciona somente na consulta utilizada)
SELECT a.IDAssociado,
	a.Nome,
	a.IDCidade,
	c.Nome as [Nome Cidade]
FROM Associado a
INNER JOIN Cidade c ON a.IDCidade = c.IDCidade;

-- Adicionar associado com IDCidade = null
SET DATEFORMAT ymd;
SELECT * FROM Associado;
INSERT INTO Associado(IDAssociado, Nome, DataNascimento, Sexo)
VALUES (3, 'Carlos', CAST('1980-05-15 00:00:00.000' as DATETIME), 'M');

-- Retornar o associado relacionado com cidade, trazendo também os não relacionados
SELECT a.IDAssociado,
	a.Nome,
	a.IDCidade,
	c.Nome as [Nome Cidade]
FROM Associado a
LEFT JOIN Cidade c ON a.IDCidade = c.IDCidade;

-- Relacionar a tabela com ela mesma (auto-relacionamento). Apelidar a tabela será obrigatório.
-- INNER JOIN retorna 14 resultados; LEFT JOIN 15. KING, o presidente, tem IDGerente nulo.
SELECT emp.IDEmpregado,
	emp.NomeEmpregado,
	emp.IDGerente,
	gerente.NomeEmpregado as [Nome Gerente]
FROM Empregado emp
LEFT JOIN Empregado gerente ON emp.IDGerente = gerente.IDEmpregado;

-- EXISTS retorna true ou false.
-- Query abaixo retornará as cidades que possuem associados.
SELECT IDCidade, Nome
FROM Cidade e
WHERE EXISTS (SELECT 1
			  FROM Associado a
			  WHERE a.IDCidade = e.IDCidade);

-- Retornar a quantidade de associados em cada cidade
SELECT e.IDCidade,
	e.Nome,
	COUNT(a.IDAssociado) TotalAssociados
FROM Cidade e
LEFT JOIN Associado a ON a.IDCidade = e.IDCidade
GROUP BY e.IDCIdade, e.Nome;

-- IN verifica todos os valores, mesmo se houver duplicação
SELECT IDCidade, Nome
FROM Cidade e
WHERE IDCidade IN (SELECT IDCidade
				   FROM Associado);

-- Igualdade funciona, porém retorna apenas um único valor.
SELECT IDCidade, Nome
FROM Cidade e
WHERE IDCidade = (SELECT MIN(IDCidade)
				  FROM Cidade
				  WHERE UF = 'SP')

-- Retonar a união dos resultados de duas tabelas em uma
-- UNION = Pega o resultado da consulta e armazena em cache, ordena tudo, remove os duplicados e projeta.
-- UNION ALL = Pega o resultado e projeta. (+ rápido)
SELECT Nome
FROM Associado
UNION ALL
SELECT NomeEmpregado
FROM Empregado;