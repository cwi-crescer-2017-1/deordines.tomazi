CREATE TABLE Pessoa (
  IDPessoa  integer not null,
  Nome      varchar2(30) not null,
    constraint PK_Pessoa primary key (IDPessoa)
);

CREATE SEQUENCE SQPessoa;

INSERT INTO Pessoa (IDPessoa, Nome)
VALUES (SQPessoa.nextval, 'Deordines');

COMMIT;