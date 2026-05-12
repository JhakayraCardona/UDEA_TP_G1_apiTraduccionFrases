--Ejecutar primero
DROP DATABASE TraduccionFrases WITH (FORCE);
--Ejecutar segundo
CREATE DATABASE TraduccionFrases; 

--Para las siguientes instrucciones, se debe cambiar la conexión

-- Crear tabla FRASE
CREATE TABLE Frase(
	Id SERIAL PRIMARY KEY,
	Texto VARCHAR(255) NOT NULL
	);

-- Crear indice para FRASE	ordenado por texto
CREATE UNIQUE INDEX ixFrase
	ON Frase(Texto);

-- Crear tabla IDIOMA
CREATE TABLE Idioma(
	Id SERIAL PRIMARY KEY,
	Idioma VARCHAR(100) NOT NULL
	);

-- Crear indice para FRASE	ordenado por texto
CREATE UNIQUE INDEX ixIdioma
	ON Idioma(Idioma);

-- Crear tabla TRADUCCION
CREATE TABLE Traduccion(
	IdFrase int NOT NULL, 
	CONSTRAINT fkTraduccion_Frase FOREIGN KEY (IdFrase) REFERENCES Frase(Id),
	IdIdioma int NOT NULL, 
	CONSTRAINT fkTraduccion_Idioma FOREIGN KEY (IdIdioma) REFERENCES Idioma(Id),
	CONSTRAINT pkTraduccion PRIMARY KEY (IdFrase, IdIdioma),
	Texto VARCHAR(255) NOT NULL,
	Audio bytea NULL
);

-- Crear indice para FRASE	ordenado por texto
CREATE INDEX ixTraduccion
	ON Traduccion(Texto);
