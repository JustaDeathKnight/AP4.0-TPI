package com.clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.funciones.Mostrar;

public class ProgramaPrincipal {
    public static void main(String[] args) throws NumberFormatException, IOException {
        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
        ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();

        Partido unPartido;

        Equipo unEquipo1;
        Equipo unEquipo2;

        // Ruta Archivos
        Path archivoPartidos = Paths.get("tpi-etapa1/src/assets/resultados.txt");
        Path archivoPronosticos = Paths.get("tpi-etapa1/src/assets/pronosticos.txt");

        // Lectura Archivo Partidos
        for (String linea : Files.readAllLines(archivoPartidos)) {
            String lineas[] = linea.split(",");

            unPartido = new Partido();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();

            unEquipo1.setNombre(lineas[0]);
            unEquipo2.setNombre(lineas[3]);

            unPartido.setEquipo1(unEquipo1);
            unPartido.setEquipo2(unEquipo2);
            unPartido.setGolesEquipo1(Integer.parseInt(lineas[1]));
            ;
            unPartido.setGolesEquipo2(Integer.parseInt(lineas[2]));

            listaPartidos.add(unPartido);
        }

        // Lectura Archivo Pronosticos
        for (String linea : Files.readAllLines(archivoPronosticos)) {
            String lineas[] = linea.split(",");

            Pronostico unPronostico = new Pronostico();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();

            unEquipo1.setNombre(lineas[0]);
            unEquipo2.setNombre(lineas[4]);

            for (int i = 0; i < listaPartidos.size(); i++) {
                if (listaPartidos.get(i).getEquipo1().getNombre().equals(unEquipo1.getNombre()) &&
                        listaPartidos.get(i).getEquipo2().getNombre().equals(unEquipo2.getNombre())) {
                    unPronostico.setPartido(listaPartidos.get(i));
                    break;
                }
            }

            unPronostico.setEquipo1(unEquipo1);
            unPronostico.setEquipo2(unEquipo2);
            if (lineas[1].equals("1"))
                unPronostico.setResultado(ResultadoEnum.GANA_EQUIPO1);
            else if (lineas[2].equals("1"))
                unPronostico.setResultado(ResultadoEnum.EMPATE);
            else if (lineas[3].equals("1"))
                unPronostico.setResultado(ResultadoEnum.GANA_EQUIPO2);
            listaPronosticos.add(unPronostico);
        }

        Mostrar.partido(listaPartidos);
        Mostrar.pronostico(listaPronosticos);

        // Calcular Puntos y Mostrar Resultado
        Mostrar.resultado(listaPartidos, listaPronosticos);

    }
}