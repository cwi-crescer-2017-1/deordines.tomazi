-- Lista de Exerc�cios 2
SELECT * FROM Empregado;

-- Exerc�cio 1
SELECT IDEmpregado as ID,
	   NomeEmpregado as Nome,
	   -- DataAdmissao
FROM Empregado
ORDER BY DataAdmissao ASC;

-- Exerc�cio 2
SELECT NomeEmpregado as Nome--, Comissao, salario
FROM Empregado
WHERE Comissao is null
ORDER BY salario ASC;

-- Exerc�cio 3
SELECT IDEmpregado as ID, 
	   NomeEmpregado as Nome,
	   (salario*13) as [Sal�rio Anual],
	   (ISNULL(Comissao, 0)*12) as [Comiss�o Anual],
	   (salario*13) + (ISNULL(Comissao, 0)*12) as [Renda Anual]
FROM Empregado;

-- Exerc�cio 4
SELECT IDEmpregado as ID,
	   NomeEmpregado as Nome,
	   Cargo as Cargo,
	   salario as [Sal�rio Mensal]
FROM Empregado
WHERE (salario*13) < 18500 OR Cargo = 'Atendente';