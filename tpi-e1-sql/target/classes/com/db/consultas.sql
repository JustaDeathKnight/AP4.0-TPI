-- Consulta de Resultados de Partidos

SELECT equipo1.nombre_equipo, partido.gol_equipo1, partido.gol_equipo2, equipo2.nombre_equipo FROM partido, (SELECT id_equipo, nombre_equipo FROM equipo) AS equipo1, (SELECT id_equipo, nombre_equipo FROM equipo) AS equipo2 WHERE partido.id_equipo1 = equipo1.id_equipo AND partido.id_equipo2 = equipo2.id_equipo;

-- Consulta de Pronosticos de Partidos

SELECT equipo1.nombre_equipo, pronostico.opcion_equipo1, pronostico.opcion_empate, pronostico.opcion_equipo2, equipo2.nombre_equipo FROM pronostico, (SELECT id_equipo, nombre_equipo FROM equipo) AS equipo1, (SELECT id_equipo, nombre_equipo FROM equipo) AS equipo2 WHERE pronostico.id_equipo1 = equipo1.id_equipo AND pronostico.id_equipo2 = equipo2.id_equipo;


-- Definiendo una vista para resultados de partidos
CREATE VIEW resultados AS 
    SELECT equipo1, partido.gol_equipo1, partido.gol_equipo2, equipo2 
    FROM partido, 
        (SELECT id_equipo, nombre_equipo as equipo1 FROM equipo) AS equipo1,
        (SELECT id_equipo, nombre_equipo as equipo2 FROM equipo) AS equipo2
    WHERE partido.id_equipo1 = equipo1.id_equipo AND partido.id_equipo2 = equipo2.id_equipo;

-- Definiendo una vista para pronosticos de partidos
CREATE VIEW pronosticos AS 
    SELECT equipo1, pronostico.opcion_equipo1, pronostico.opcion_empate, pronostico.opcion_equipo2, equipo2 
    FROM pronostico, 
        (SELECT id_equipo, nombre_equipo as equipo1 FROM equipo) AS equipo1, 
        (SELECT id_equipo, nombre_equipo as equipo2 FROM equipo) AS equipo2 
    WHERE pronostico.id_equipo1 = equipo1.id_equipo AND pronostico.id_equipo2 = equipo2.id_equipo;