
select sequence_owner, sequence_name from dba_sequences WHERE sequence_owner = 'MEGASENA';
DROP SEQUENCE MEGASENA.SQLOG_AUD_APOSTAS
DROP SEQUENCE MEGASENA.

SELECT * FROM Aposta
ORDER BY IdAposta DESC

SELECT * FROM Log_Aud_Apostas

insert into Aposta (Idaposta, Idconcurso, Idcidade, Data_Hora, Quantidade_Numeros, Valor)
  values (5000130, 1824, 171, sysdate, 6, 3.5);

insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 14); 
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 15);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 23);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 54);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 27);
insert into Numero_Aposta (idnumero_aposta, idaposta, numero) values (sqnumero_aposta.nextval, 5000130, 46);


commit