-- Lista de Exerc�cios 3 --

-- Exerc�cio 1
-- Datas
-- Fa�a uma consulta que liste o total de empregados admitidos no ano de 1980. Deve ser projetado nesta consulta: ID, Nome e Idade no momento da admiss�o.
SELECT IDEmpregado as ID,
	NomeEmpregado as Nome,
	YEAR(DataAdmissao) - YEAR(DataNascimento) as [Idade na Admissao]
FROM Empregado
WHERE YEAR(DataADmissao) = 1980;

-- Exerc�cio 2
-- Ranking
-- Qual o cargo (tabela empregado) possui mais empregados ? Deve ser projetado apenas um registro. ** DICA: Pesquise recursos espec�ficos para esta funcionalidade.
SELECT TOP 1 Cargo,
	COUNT(*) as Ranking
FROM Empregado
GROUP BY Cargo
ORDER BY Ranking DESC;

-- Exerc�cio 3
-- Contagem
-- Liste os estados (atributo UF) e o total de cidades existente em cada estado na tabela cidade.
SELECT UF as Estado,
	COUNT(*) as [Total Cidades]
FROM Cidade
GROUP BY UF;

-- Exerc�cio 4
-- Alterando dados
-- Crie um novo departamento, denominado 'Inova��o' com localiza��o em 'S�O LEOPOLDO'.
-- Todos os empregados que foram admitidos no m�s de dezembro (qualquer ano) que n�o ocupam o cargo de 'Atendente' devem ser ter o departamento (IDDepartamento) atualizado para este novo registro (inova��o).
SELECT * FROM Departamento;

INSERT INTO Departamento(IDDepartamento, NomeDepartamento, Localizacao)
VALUES (50, 'Inova��o', 'S�O LEOPOLDO');

UPDATE Empregado
SET IDDepartamento = 50
WHERE MONTH(DataAdmissao) = 12 AND Cargo != 'Atendente';

SELECT * FROM Empregado;