create or replace package pck_megasena is

  -- Author  : ANDRENUNES
  -- Purpose : Manipulação na base de dados da Loteria mais conhecida do Brasil
  
  -- Variáveis Globais - definidas em procedimento específico
  gPremio_sena          number(12,2) := 0;
  gPremio_quina         number(12,2) := 0;
  gPremio_quadra        number(12,2) := 0;
  gAcumulado_proximo_05 number(12,2) := 0;
  gAcumulado_final_ano  number(12,2) := 0;
  
  -- Public type declarations
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number);
  function buscaPercentual(pIdentificador in varchar2) return number;
  
  FUNCTION retornarIdUltimoConcurso RETURN Concurso.IdConcurso%TYPE;
  FUNCTION retornarValorUltimoConcurso RETURN Aposta.Valor%TYPE;
  FUNCTION retonarUltimoNumeroIdConcurso RETURN INTEGER;
  FUNCTION retornarAcumulou RETURN Concurso.Acumulou%TYPE;
  PROCEDURE geraProximoConcurso;
  
  FUNCTION retornarPremioQuadra RETURN Aposta.Valor%TYPE;
  FUNCTION retornarPremioQuina RETURN Aposta.Valor%TYPE;
  FUNCTION retornarPremioSena RETURN Aposta.Valor%TYPE;
  PROCEDURE atualizaAcertadores (pConcurso IN INTEGER);
  
end pck_megasena;