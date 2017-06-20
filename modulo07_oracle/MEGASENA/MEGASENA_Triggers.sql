/*Exercício 1
Auditoria Loteria
Crie uma estrutura de tabelas e triggers que permita auditar as apostas da megasena.
O objetivo é permitir monitorar eventuais fraudes ou falhas no sistema.
A auditoria deve monitorar tanto as apostas quanto os números de cada aposta.
*/

CREATE TABLE Log_Aud_Apostas (
    IdAudApostas    INTEGER NOT NULL,
    ApostaAntiga    INTEGER,
    ApostaNova      INTEGER,
    Data            DATE DEFAULT SYSDATE,
    Operacao        CHAR(1) NOT NULL,
    CONSTRAINT PK_Log_Aud_Apostas PRIMARY KEY (IdAudApostas)
);  

CREATE TABLE Log_Aud_Numeros (
    IdAudNumeros    INTEGER NOT NULL,
    IdAposta        INTEGER NOT NULL,
    NumeroAntigo    INTEGER NOT NULL,
    NumeroNovo      INTEGER NOT NULL,
    Data            DATE DEFAULT SYSDATE,
    CONSTRAINT PK_Log_Aud_Numeros PRIMARY KEY (IdAudNumeros),
    CONSTRAINT Aposta FOREIGN KEY (IdAposta) REFERENCES Aposta(IdAposta)
);
    
CREATE SEQUENCE sqLog_Aud_Apostas;
CREATE SEQUENCE sqLog_Aud_Numeros;

CREATE OR REPLACE TRIGGER TR_AUD_APOSTA
    AFTER INSERT OR UPDATE OR DELETE ON Aposta
    FOR EACH ROW
DECLARE
    vApostaAntiga   INTEGER;
    vApostaNova     INTEGER;
    vOperacao       CHAR(1);
BEGIN    
    IF INSERTING THEN
        vApostaAntiga := NULL;
        vApostaNova := :new.IdAposta;
        vOperacao := 'I';
    ELSIF UPDATING THEN
        vApostaAntiga := :old.IdAposta;
        vApostaNova := :new.IdAposta;
        vOperacao := 'U';
    ELSE
        vApostaAntiga := :old.IdAposta;
        vApostaNova := NULL;
        vOperacao := 'D';
    END IF;
    
    INSERT INTO Log_Aud_Apostas (IdAudApostas, ApostaAntiga, ApostaNova, Data, Operacao)
        VALUES (sqLog_Aud_Apostas.nextVal, vApostaAntiga, vApostaNova, SYSDATE, vOperacao);
END TR_AUD_APOSTA;

CREATE OR REPLACE TRIGGER TR_AUD_NUMEROS
    AFTER INSERT OR UPDATE OR DELETE ON Numero_Aposta
    FOR EACH ROW
DECLARE
    vAposta         INTEGER;
    vNumeroAntigo   INTEGER;
    vNumeroNovo     INTEGER;
    vOperacao       CHAR(1);
BEGIN    
    IF INSERTING THEN
        vAposta := :new.Aposta;
        vNumeroAntigo := NULL;
        vNumeroNovo := :new.Numero;
        vOperacao := 'I';
    ELSIF UPDATING THEN
        vAposta := :old.Aposta;
        vNumeroAntigo := :old.Numero;
        vNumeroNovo := :new.Numero;
        vOperacao := 'U';
    ELSE
        vAposta := :old.Aposta;
        vNumeroAntigo := :old.Numero;
        vNumeroNovo := NULL;
        vOperacao := 'D';
    END IF;
    
    INSERT INTO Log_Aud_Apostas (IdAudApostas, Aposta, NumeroAntigo, NumeroNovo, Data, Operacao)
        VALUES (sqLog_Aud_Apostas.nextVal, vAposta, vNumeroAntigo, vNumeroNovo, SYSDATE, vOperacao);
END TR_AUD_NUMEROS;