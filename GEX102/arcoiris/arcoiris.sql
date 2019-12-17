CREATE DATABASE arcoiris DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE arcoiris;

CREATE TABLE users(
  iduser INTEGER AUTO_INCREMENT PRIMARY KEY,
  email varchar (50) NOT NULL,
  senha varchar(8) NOT NULL,
  nome VARCHAR(50) NOT NULL,
);

CREATE TABLE produto (
  idprod INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50)NOT NULL,
  fabricante VARCHAR(50) NOT NULL,
  tipo INTEGER,
  procedencia VARCHAR(50) NOT NULL,
  preco DOUBLE NOT NULL,
  precov DOUBLE NOT NULL,
  disponivel INTEGER NOT NULL,
  imagem VARCHAR(50),
  idusuario INTEGER,
  FOREIGN KEY (idusuario) REFERENCES users(iduser)
);

CREATE TABLE cliente (
  idcliente INTEGER AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(50),
  emailcliente VARCHAR(50),
  telefone INTEGER
);
