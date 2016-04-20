/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Zilderlan
 * Created: 10/04/2016
 */


CREATE TABLE Usuario(	
/*	id SERIAL NOT NULL UNIQUE,*/
	nome VARCHAR(50) NOT NULL,
	apelido VARCHAR(30) NOT NULL UNIQUE,
	email VARCHAR(30) /*UNIQUE*/ NOT NULL, 
	dataNascimento DATE NOT NULL,
	cidade VARCHAR(30) NOT NULL,
	estado VARCHAR(30) NOT NULL,
	tipo VARCHAR(15) DEFAULT 'Usuario',
	administrador BOOLEAN DEFAULT 'FALSE',
	senha VARCHAR(32) NOT NULL,
	imagem VARCHAR(300),
	PRIMARY KEY (email)
);


CREATE TABLE Livro(
	id SERIAL NOT NULL UNIQUE,/* O PRIMARY KEY poderia ser o ISBN ele é único terá que mudar em todas as outras tabelas que fazem referencia a esta!*/
	idUsuario INTEGER NOT NULL,
	titulo VARCHAR(30) NOT NULL,
	ano INTEGER NOT NULL,
	editora VARCHAR(30) NOT NULL,
	fotoCapa BLOB NOT NULL,
	fotoCapaC VARCHAR(50),
	autores TEXT NOT NULL,
	tema VARCHAR(25) NOT NULL, 
	isbn INTEGER NOT NULL,
	dataDeCadastro DATE NOT NULL,
	PRIMARY KEY (id),	
	FOREIGN KEY (idUsuario) REFERENCES Usuario (id)ON DELETE CASCADE,
);

CREATE TABLE ComentarioLivro(
    id SERIAL NOT NULL,
    usuario VARCHAR(60) NOT NULL UNIQUE,
    comentario VARCHAR(250) NOT NULL,
    comData DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario) REFERENCES Usuario (email)ON DELETE CASCADE,
);

﻿ CREATE TABLE solicitacaoAmizade(
    solicitacaoEnviada VARCHAR(50) NOT NULL,
    solicitacaoRecebida VARCHAR(50) NOT NULL,
    visualizado BOOLEAN DEFAULT 'FALSE',
-- 		pendente BOOLEAN DEFAULT FALSE,
-- 		resposta BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (solicitacaoEnviada, solicitacaoRecebida),
    FOREIGN KEY (solicitacaoEnviada) REFERENCES usuario (email) ON DELETE CASCADE,
		FOREIGN KEY (solicitacaoRecebida) REFERENCES usuario (email) ON DELETE CASCADE
);

﻿CREATE TABLE Amizade(
--     id SERIAL UNIQUE NOT NULL,
		solicitacaoEnviada VARCHAR(60) NOT NULL,
		solicitacaoRecebida VARCHAR(60) NOT NULL,
		PRIMARY KEY (solicitacaoEnviada,solicitacaoRecebida),
		FOREIGN KEY (solicitacaoEnviada) REFERENCES Usuario (email) ON DELETE CASCADE,
		FOREIGN KEY (solicitacaoRecebida) REFERENCES Usuario (email) ON DELETE CASCADE
);


CREATE TABLE Grupo(
	id INTEGER NOT NULL,
        foto VARCHAR(300), 
	nome VARCHAR(25) NOT NULL UNIQUE,
	descricao VARCHAR(200) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE ParticipaGrupo(
    idGrupo INTEGER NOT NULL,
    idUsuario VARCHAR(60) NOT NULL,
    PRIMARY KEY(idGrupo, idUsuario),
    FOREIGN KEY (idGrupo) REFERENCES Grupo (id) ON DELETE CASCADE,
    FOREIGN KEY (idUsuario) REFERENCES Usuario (email) ON DELETE CASCADE 
);

CREATE TABLE ComentarioGrupo (
	idComentario SERIAL NOT NULL,
	idUsuario VARCHAR(60) NOT NULL,
	nameUsuario VARCHAR(60) NOT NULL,
	idGrupo INTEGER NOT NULL,
        comentario TEXT,
        dataComment DATE NOT NULL,
        imagem VARCHAR(400),
	PRIMARY KEY (idUsuario, idGrupo, idComentario),
	FOREIGN KEY (idUsuario) REFERENCES Usuario(email),
	FOREIGN KEY (nameUsuario) REFERENCES Usuario(nome),
	FOREIGN KEY (idGrupo) REFERENCES Grupo(id)
);

