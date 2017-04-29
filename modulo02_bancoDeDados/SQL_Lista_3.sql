-- Lista de Exercícios 3 --

-- Exercício 1
-- Datas
-- Faça uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admissão.
SELECT IDEmpregado as ID,
	NomeEmpregado as Nome,
	YEAR(DataAdmissao) - YEAR(DataNascimento) as [Idade na Admissao]
FROM Empregado
WHERE YEAR(DataADmissao) = 1980;

-- Exercício 2
-- Ranking
-- Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** DICA: Pesquise recursos específicos para esta funcionalidade.
SELECT TOP 1 Cargo,
	COUNT(*) as Ranking
FROM Empregado
GROUP BY Cargo
ORDER BY Ranking DESC;

-- Exercício 3
-- Contagem
-- Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
SELECT UF as Estado,
	COUNT(*) as [Total Cidades]
FROM Cidade
GROUP BY UF;

-- Exercício 4
-- Alterando dados
-- Crie um novo departamento, denominado 'Inovação' com localização em 'SÃO LEOPOLDO'.
-- Todos os empregados que foram admitidos no mês de dezembro (qualquer ano) que não ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inovação).
SELECT * FROM Departamento;

INSERT INTO Departamento(IDDepartamento, NomeDepartamento, Localizacao)
VALUES (50, 'Inovação', 'SÃO LEOPOLDO');

UPDATE Empregado
SET IDDepartamento = 50
WHERE MONTH(DataAdmissao) = 12 AND Cargo != 'Atendente';

SELECT * FROM Empregado;