-- Path: TPI\src\db\esquema.sql
CREATE SCHEMA IF NOT EXISTS tpi ;
USE tpi;

CREATE TABLE IF NOT EXISTS equipo (
    id_equipo INT,
    nombre_equipo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_equipo)
);

CREATE TABLE IF NOT EXISTS partido (
    id_partido INT,
    id_equipo1 INT NOT NULL,
    gol_equipo1 INT,
    gol_equipo2 INT,
    id_equipo2 INT NOT NULL,
    PRIMARY KEY (id_partido),
    FOREIGN KEY (id_equipo1) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_equipo2) REFERENCES equipo(id_equipo)
);

CREATE TABLE IF NOT EXISTS pronostico (
    id_pronostico INT,
    id_partido INT NOT NULL,
    id_equipo1 INT NOT NULL,
    opcion_equipo1 INT,
    opcion_empate INT,
    opcion_equipo2 INT,
    id_equipo2 INT NOT NULL,
    PRIMARY KEY (id_pronostico),
    FOREIGN KEY (id_partido) REFERENCES partido(id_partido),
    FOREIGN KEY (id_equipo1) REFERENCES equipo(id_equipo),
    FOREIGN KEY (id_equipo2) REFERENCES equipo(id_equipo)
);

INSERT INTO equipo (id_equipo, nombre_equipo, descripcion) VALUES (1, 'Argentina', 'Argentina'), (2, 'Arabia Saudita', 'Arabia Saudita'), (3, 'Polonia', 'Polonia'), (4, 'Mexico', 'Mexico');

INSERT INTO partido (id_partido, id_equipo1, gol_equipo1, gol_equipo2, id_equipo2) VALUES (1, 1, 1, 2, 2), (2, 3, 0, 0, 4);

INSERT INTO pronostico (id_pronostico, id_partido, id_equipo1, opcion_equipo1, opcion_empate, opcion_equipo2, id_equipo2) VALUES (1, 1, 1, 1, 0, 0, 2), (2, 2, 3, 0, 1, 0, 4);