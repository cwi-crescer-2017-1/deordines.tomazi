CREATE TABLE USUARIO (
  ID              NUMBER(12) NOT NULL,
  Email           VARCHAR2(50) NOT NULL,
  Senha           VARCHAR2(50) NOT NULL UNIQUE KEY,
  Nome            VARCHAR2(50) NOT NULL,
  DataNascimento  DATE NOT NULL,
  SEXO 	          CHAR(1) NOT NULL,
    CONSTRAINT PK_USUARIO PRIMARY KEY (ID)
);

CREATE TABLE AMIGOS (
  ID_USUARIO      NUMBER(12) NOT NULL,
  ID_AMIGO        NUMBER(12) NOT NULL,
	CONSTRAINT PK_AMIGOS PRIMARY KEY (ID_USUARIO, ID_AMIGO),
    CONSTRAINT FK_ID_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
    CONSTRAINT FK_ID_AMIGO FOREIGN KEY (ID_AMIGO) REFERENCES USUARIO(ID)
);

CREATE TABLE SOLICITACAO (
  ID_USUARIO      NUMBER(12) NOT NULL,
  ID_AMIGO        NUMBER(12) NOT NULL,
	CONSTRAINT PK_AMIGOS PRIMARY KEY (ID_USUARIO, ID_AMIGO),
    CONSTRAINT FK_ID_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID),
    CONSTRAINT FK_ID_AMIGO FOREIGN KEY (ID_AMIGO) REFERENCES USUARIO(ID)
);

CREATE TABLE PUBLICACAO (




);


[ Usuario ]
Id			pk
Email			varchar2
Senha			varchar2
Nome			varchar2
Data Nascimento		date
Sexo			string

--- / ---

[ Amigos ]
IdUsuario		pk composta
IdAmigo			pk composta

--- / ---

[ Solicitacao ]
IdSolicitante		pk composta
IdSolicitado		pk composta

--- / ---

[ Publicacao ]
Id			pk
Texto			varchar2
DataPublicacao		datetime

--- / ---

[ Curtidas ]
IdPublicacao		fk_publicacao
IdUsuario		fk_usuario

--- / ---

[ Comentarios ]
IdPublicacao		fk_publicacao
IdUsuario		fk_usuario
Comentario		varchar2
Data			date