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
	FOREIGN KEY (idUsuario) REFERENCES Usuario (id)
);

CREATE TABLE ComentarioLivro(
    id SERIAL NOT NULL,
    usuario VARCHAR(60) NOT NULL UNIQUE,
    comentario VARCHAR(250) NOT NULL,
    comData DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (usuario) REFERENCES Usuario (email)
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
    id SERIAL UNIQUE NOT NULL,
		solicitacaoEnviada VARCHAR(60) UNIQUE NOT NULL,
		solicitacaoRecebida VARCHAR(60) UNIQUE NOT NULL,
		PRIMARY KEY (solicitacaoEnviada,solicitacaoRecebida),
		FOREIGN KEY (solicitacaoEnviada) REFERENCES Usuario (email) ON DELETE CASCADE,
		FOREIGN KEY (solicitacaoRecebida) REFERENCES Usuario (email) ON DELETE CASCADE
);


CREATE TABLE Grupo(
	id SERIAL NOT NULL UNIQUE,
	idUsuario VARCHAR(60) NOT NULL,
	nome VARCHAR(25) NOT NULL UNIQUE,
	descricao VARCHAR(200) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (idUsuario) REFERENCES Usuario (email) ON DELETE CASCADE
	/* Não é bom colocar ON DELETE CASCADE nestes que referencias outra tabela não? (Ele é usado em conjunto com ON DELETE ou ON UPDATE. Isso significa que os dados criança é excluído ou atualizado quando os dados pai é excluído ou atualizado.) nas outras tabelas também.*/
);

