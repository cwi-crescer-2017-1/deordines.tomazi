-- Lista Exerc�cio 4
SELECT * FROM Licitacao

-- Exerc�cio 1
-- Datas
-- Liste todos os projetos que tiveram atrasos no in�cio da obra, exibir tamb�m o tempo previsto (em meses), e o tempo realizado (em meses) para a conclus�o da obra.
SELECT Identificador,
	Projeto,
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Prev) as [Tempo Previsto],
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) as [Tempo Realizado]
FROM Licitacao
WHERE Data_Inicio_Real > Data_Inicio_Prev;

-- Exerc�cio 2
-- Ranking
-- Liste as TOP 10 empresas que tiveram maior faturamento, deve ser projetado tamb�m o valor m�dio por profissional.
SELECT TOP 10 Empresa_Licitante as Empresa,
	SUM(Valor_Realizado) as [Total Faturamento R$],
	SUM(Valor_Realizado) / SUM(Profissionais) as [Valor M�dio Por Profissional R$]
FROM Licitacao
GROUP BY Empresa_Licitante
ORDER BY [Total Faturamento R$] DESC;

-- Exerc�cio 3
-- TOP Cidades
-- Liste as TOP 10 cidades com maior arreca��o de impostos.
SELECT TOP 10 Municipio,
	SUM(Imposto_Municipal) as [Arrecada��o]
FROM Licitacao
GROUP BY Municipio
ORDER BY [Arrecada��o] DESC;

-- Exerc�cio 4
-- Finais de semana
-- Liste todos os projetos que tiveram a data de in�cio (real) ocorrendo em finais de semana (s�bado ou domingo).
SELECT Projeto,
	DATENAME(WEEKDAY, Data_Inicio_Real) as [Dia da Semana]
FROM Licitacao
WHERE DATEPART(WEEKDAY, Data_Inicio_Real) = 1 OR
	DATEPART(WEEKDAY, Data_Inicio_Real) = 7;

-- Exerc�cio 5
-- Empresas com sorte
-- Liste todas as empresas que tiveram (ou ter�o) um faturamento (valor previsto) superior a 50% do seu faturamento no ano anterior.
SELECT Empresa_Licitante as Empresa,
	SUM(Valor_Realizado) as [Total Faturamento Atual],
	SUM(Faturamento_1Ano_Anterior) as [Faturamento Ano Anterior],
	SUM(Faturamento_1Ano_Anterior) * 0.5 as [50% Ano Anterior]
FROM Licitacao
GROUP BY Empresa_Licitante
HAVING SUM(Valor_Realizado) > SUM(Faturamento_1Ano_Anterior) * 0.5;

-- Exerc�cio 6
-- Custo real
-- Liste os projetos exibindo o custo real do projeto. Caso o projeto seja de esfera federal deve ser descontado o imposto federal, e assim respectivamente para as esferas estaduais e municipais.
SELECT Projeto,
	Valor_Realizado as [Total Projeto],
	CASE Esfera
		WHEN 'Federal' THEN Valor_Realizado - Imposto_Federal
		WHEN 'Estadual' THEN Valor_Realizado - Imposto_Estadual
		WHEN 'Municipal' THEN Valor_Realizado - Imposto_Municipal
	END AS [Total Projeto Sem Imposto]
FROM Licitacao;

-- Exerc�cio 7
-- Investiga��o
-- O projeto 17255 foi suspenso, o motivo foi o elevado custo para o or�amento anual do munic�pio. A partir de uma investiga��o mais detalhada foi visto que esse motivo n�o era a verdadeira raz�o. Explique por que este motivo n�o � v�lido apresentando uma consulta com dados.
SELECT Identificador, Projeto, Situacao, Esfera, Municipio, Valor_Realizado, Imposto_Federal, Imposto_Estadual, Imposto_Municipal, Data_Inicio_Real, Data_Fim_Prev, Data_Fim_Real,
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Prev) as [Tempo Previsto (em meses)],
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) as [Tempo Total (em meses)]
FROM Licitacao
WHERE Identificador = 17255;

SELECT Identificador, Projeto, Situacao, Esfera, Municipio, Valor_Realizado, Imposto_Federal, Imposto_Estadual, Imposto_Municipal,
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Prev) as [Previs�o (em meses)],
	DATEDIFF(MONTH, Data_Inicio_Real, Data_Fim_Real) as [Conclus�o (em meses)]
FROM Licitacao
WHERE Projeto = 'Escola T�cnica Bento Gon�alves';

/* Em compara��o entre os projetos executados no mesmo local, podemos ver que h� diverg�ncias entre os impostos pagos.
Entretanto, como o projeto � de esfera estadual e levando em considera��o o c�lculo feito no Exerc�cio 6, devemos dar aten��o ao valor do imposto estadual. Vide tabela abaixo:

			federal		estadual	municipal
normal 		408000		133280		119680
suspensa	476160		399052.8	73728
		_________________________________________
diferen�a	-68.160		-265.772,8	45.952

No imposto estadual, o projeto suspenso paga R$265.772,80 a mais em rela��o ao projeto que est� com situa��o normal.
Para exemplificar melhor, usaremos uma regra de 3:

1360000 - 100
133280  -  x
x = 9.8% do valor � imposto no projeto com situa��o normal

1536000	  - 100
399052.8  - x
x = 25.98% do valor � imposto no projeto com situa��o suspensa

Logo, podemos perceber que o projeto suspenso paga 16.18% a mais de imposto que o outro projeto realizado no mesmo local e com o mesmo tipo de taxa. */