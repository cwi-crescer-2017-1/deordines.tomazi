-- Lista de Exercícios 2
SELECT * FROM Empregado;

-- Exercício 1
SELECT IDEmpregado as ID,
	   NomeEmpregado as Nome,
	   -- DataAdmissao
FROM Empregado
ORDER BY DataAdmissao ASC;

-- Exercício 2
SELECT NomeEmpregado as Nome--, Comissao, salario
FROM Empregado
WHERE Comissao is null
ORDER BY salario ASC;

-- Exercício 3
SELECT IDEmpregado as ID, 
	   NomeEmpregado as Nome,
	   (salario*13) as [Salário Anual],
	   (ISNULL(Comissao, 0)*12) as [Comissão Anual],
	   (salario*13) + (ISNULL(Comissao, 0)*12) as [Renda Anual]
FROM Empregado;

-- Exercício 4
SELECT IDEmpregado as ID,
	   NomeEmpregado as Nome,
	   Cargo as Cargo,
	   salario as [Salário Mensal]
FROM Empregado
WHERE (salario*13) < 18500 OR Cargo = 'Atendente';