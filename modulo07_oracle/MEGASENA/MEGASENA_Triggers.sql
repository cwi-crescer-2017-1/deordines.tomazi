/*Exercício 1
Auditoria Loteria
Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena.
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema.
A auditoria deve monitorar tanto as apostas quanto os números de cada aposta.
*/

CREATE TABLE Log_Aud_Apostas (
    IdAudApostas   INTEGER NOT NULL,
    Aposta         INTEGER NOT NULL,
    --NumeroAposta   INTEGER NOT NULL,
    Data           DATE DEFAULT SYSDATE,
    Operacao       CHAR(1) NOT NULL,
    CONSTRAINT PK_Log_Aud_Apostas PRIMARY KEY (IdAudApostas)--,
    --CONSTRAINT FK_Aposta FOREIGN KEY (Aposta) REFERENCES Aposta(IdAposta),
    --CONSTRAINT FK_NumeroAposta FOREIGN KEY (NumeroAposta) REFERENCES Numero_Aposta(IdNumero_Aposta)
);  

CREATE TABLE Log_Aud_Numeros (
    IdAudNumeros  INTEGER NOT NULL,
    Aposta        INTEGER NOT NULL,
    Numero        INTEGER NOT NULL,
    CONSTRAINT PK_Log_Aud_Numeros PRIMARY KEY (IdAudNumeros),
    CONSTRAINT FK_Numero FOREIGN KEY (Numero) REFERENCES Numero_Aposta(IdNumero_Aposta)
);
    
CREATE SEQUENCE sqLog_Aud_Apostas;
CREATE SEQUENCE sqLog_Aud_Numeros;

CREATE OR REPLACE TRIGGER TR_AUD_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON APOSTA
DECLARE
    vOperacao   CHAR(1);
    vIdAposta   INTEGER NOT NULL;
BEGIN
    vIdAposta := :new.IdAposta;
    
    IF INSERTING THEN
        vOperacao := 'I';
    END IF;
    
    INSERT INTO Log_Aud_Apostas (iddAudApostas, aposta, data)
    VALUES (sqLog_Aud_Apostas.nextVal, vIdAposta, sysdate);
END TR_AUD_APOSTA;
    
/*
CREATE OR REPLACE TRIGGER TR_AUD1_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Aposta
    FOR EACH ROW
DECLARE
    v_operacao      CHAR(1);
    v_idAposta      INTEGER;
    v_numeroAposta  INTEGER;
BEGIN      
    SELECT MAX(IdAposta)
    INTO v_idAposta
    FROM Aposta;
    
    IF INSERTING THEN        
        v_operacao := 'I';
    END IF;
    
    SELECT IdNumero_Aposta
    INTO v_NumeroAposta
    FROM Numero_Aposta
    WHERE IdAposta = v_Aposta;
    
    INSERT INTO Log_Aud_Apostas (idAudApostas, aposta, numeroAposta, data, operacao)
    VALUES (Log_Aud_Apostas.nextVal, v_Aposta, v_NumeroAposta, sysdate, v_operacao);
End TR_AUD1_APOSTA;
*/