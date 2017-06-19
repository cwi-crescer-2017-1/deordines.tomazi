create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
    FUNCTION retornarIdUltimoConcurso RETURN Concurso.IdConcurso%TYPE AS
        vIdUltimoConcurso Concurso.IdConcurso%TYPE;
        BEGIN
            SELECT MAX(IdConcurso)
            INTO vIdUltimoConcurso
            FROM Concurso;
        RETURN vIdUltimoConcurso;
    END retornarIdUltimoConcurso;
    
    FUNCTION retornarValorUltimoConcurso RETURN Aposta.Valor%TYPE AS
        vValorUltimoConcurso Aposta.Valor%TYPE;
        BEGIN
            SELECT SUM(Valor)
            INTO vValorUltimoConcurso
            FROM Aposta
            WHERE IdConcurso = PCK_MEGASENA.retornarIdUltimoConcurso;
        RETURN vValorUltimoConcurso;
    END retornarValorUltimoConcurso;
    
    FUNCTION retonarUltimoNumeroIdConcurso RETURN INTEGER AS
        vUltimoNumeroIdConcurso INTEGER;
        BEGIN
            SELECT SUBSTR(PCK_MEGASENA.retornarIdUltimoConcurso, -1)
            INTO vUltimoNumeroIdConcurso
            FROM Concurso;
        RETURN vUltimoNumeroIdConcurso;
    END retonarUltimoNumeroIdConcurso;
      
    FUNCTION retornarAcumulou RETURN Concurso.Acumulou%TYPE AS
        vAcumulou Concurso.Acumulou%TYPE;
        BEGIN
            SELECT Acumulou
            INTO vAcumulou
            FROM Concurso
            WHERE IdConcurso = PCK_MEGASENA.retornarIdUltimoConcurso;
        RETURN vAcumulou;
    END retornarAcumulou;
    
    PROCEDURE geraProximoConcurso AS
        vIdUltimoConcurso Concurso.IdConcurso%TYPE;
        vValorUltimoConcurso Aposta.Valor%TYPE;
        vAcumulou Concurso.Acumulou%TYPE;
        vDataConcurso Concurso.Data_Sorteio%TYPE;
        vValorUltimoNumero INTEGER;
        
        BEGIN
            vIdUltimoConcurso := PCK_MEGASENA.retornarIdUltimoConcurso + 1;
            vValorUltimoConcurso := PCK_MEGASENA.retornarValorUltimoConcurso;
            vAcumulou := PCK_MEGASENA.retornarAcumulou;
            vDataConcurso := SYSDATE;
            vValorUltimoNumero := retonarUltimoNumeroIdConcurso + 1;
            
            IF (vValorUltimoNumero = 0 OR vValorUltimoNumero = 5) THEN
                vValorUltimoConcurso := vValorUltimoConcurso + (vValorUltimoConcurso * 0.453);
            END IF;
            
            PCK_MEGASENA.salvaConcurso(vIdUltimoConcurso, vDataConcurso, vValorUltimoConcurso);
            
    END geraProximoConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
    FUNCTION retornarPremioQuadra RETURN Aposta.Valor%TYPE AS
        vValorPremioQuadra Aposta.Valor%TYPE;
        BEGIN
            SELECT COUNT(IdAposta)
            INTO vValorPremioQuadra
            FROM Aposta_Premiada
            WHERE Acertos = 4;
        RETURN vValorPremioQuadra;
    END retornarPremioQuadra;
        
    FUNCTION retornarPremioQuina RETURN Aposta.Valor%TYPE AS
        vValorPremioQuina Aposta.Valor%TYPE;
        BEGIN
            SELECT COUNT(IdAposta)
            INTO vValorPremioQuina
            FROM Aposta_Premiada
            WHERE Acertos = 5;
        RETURN vValorPremioQuina;
    END retornarPremioQuina;
    
    FUNCTION retornarPremioSena RETURN Aposta.Valor%TYPE AS
        vValorPremioSena Aposta.Valor%TYPE;
        BEGIN
            SELECT COUNT(IdAposta)
            INTO vValorPremioSena
            FROM Aposta_Premiada
            WHERE Acertos = 6;
        RETURN vValorPremioSena;
    END retornarPremioSena;
            
    PROCEDURE atualizaAcertadores (pConcurso IN INTEGER) AS
        vPrimeiraDezena NUMBER;
        vSegundaDezena NUMBER;
        vTerceiraDezena NUMBER;
        vQuartaDezena NUMBER;
        vQuintaDezena NUMBER;
        vSextaDezena NUMBER;
        vNumero NUMBER;
        vQuantidadeAcertos NUMBER;
        vIdApostaPremiada INTEGER;
        
        CURSOR listaApostas IS
            SELECT IdAposta
            FROM Aposta
            WHERE IdConcurso = pConcurso;
            
        CURSOR listaNumerosApostados(pIdAposta IN INTEGER) IS
            SELECT numApo.Numero FROM Aposta apo
            JOIN Numero_Aposta numApo ON numApo.IdAposta = apo.IdAposta
            WHERE apo.IdAposta = pIdAposta;
        
        BEGIN
        FOR aposta IN listaApostas LOOP
            vQuantidadeAcertos := 0;
            FOR numeroApostado IN listaNumerosApostados(aposta.IdAposta) LOOP
                vNumero := numeroApostado.Numero;
                
                CASE vNumero
                    WHEN vPrimeiraDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                    WHEN vSegundaDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                    WHEN vTerceiraDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                    WHEN vQuartaDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                    WHEN vQuintaDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                    WHEN vSextaDezena THEN vQuantidadeAcertos := vQuantidadeAcertos + 1;
                END CASE;
            END LOOP;
            
            IF (vQuantidadeAcertos >= 4) THEN
                vIdApostaPremiada := vIdApostaPremiada + 1;
                CASE vQuantidadeAcertos
                    WHEN 4 THEN
                        INSERT INTO Aposta_Premiada(IdAposta_Premiada, IdAposta, Acertos, Valor)
                        VALUES (vIdApostaPremiada, aposta.IdAposta, vQuantidadeAcertos, PCK_MEGASENA.retornarPremioQuadra);
                    WHEN 5 THEN
                        INSERT INTO Aposta_Premiada(IdAposta_Premiada, IdAposta, Acertos, Valor)
                        VALUES (vIdApostaPremiada, aposta.IdAposta, vQuantidadeAcertos, PCK_MEGASENA.retornarPremioQuina);
                    WHEN 6 THEN
                        UPDATE Concurso
                        SET Acumulou = 1
                        WHERE IdConcurso = pConcurso;
                        
                        INSERT INTO Aposta_Premiada(IdAposta_Premiada, IdAposta, Acertos, Valor)
                        VALUES (vIdApostaPremiada, aposta.IdAposta, vQuantidadeAcertos, PCK_MEGASENA.retornarPremioSena);
                END CASE;
            END IF;
        END LOOP;
    END atualizaAcertadores;

begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;