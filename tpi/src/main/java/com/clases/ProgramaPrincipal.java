package com.clases;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProgramaPrincipal {
    public static void main(String[] args) throws NumberFormatException, IOException {
        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
        ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();

        Partido unPartido;

        Equipo unEquipo1;
        Equipo unEquipo2;

        // Ruta Archivos
        Path archivoPartidos = Paths.get("tpi/src/archivos/resultados.txt");
        Path archivoPronosticos = Paths.get("tpi/src/archivos/pronosticos.txt");

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
                unPronostico.setResultado(ResultadoEnum.GANADOR_EQUIPO1);
            else if (lineas[2].equals("1"))
                unPronostico.setResultado(ResultadoEnum.EMPATE);
            else if (lineas[3].equals("1"))
                unPronostico.setResultado(ResultadoEnum.GANADOR_EQUIPO2);
            listaPronosticos.add(unPronostico);
        }

        // Mostrar Partidos
        for (int i = 0; i < listaPartidos.size(); i++) {
            // Por consola
            System.out.println(
                    listaPartidos.get(i).getEquipo1().getNombre() +
                            " " +
                            listaPartidos.get(i).getGolesEquipo1() +
                            " " +
                            listaPartidos.get(i).getEquipo2().getNombre() +
                            " " +
                            listaPartidos.get(i).getGolesEquipo2());

            // Por ventana
            JOptionPane.showMessageDialog(
                    null,
                    "Partido: " + (i + 1) + "\n" +
                            listaPartidos.get(i).getEquipo1().getNombre() +
                            " " +
                            listaPartidos.get(i).getGolesEquipo1() +
                            " " +
                            listaPartidos.get(i).getEquipo2().getNombre() +
                            " " +
                            listaPartidos.get(i).getGolesEquipo2());
        }

        // Mostrar Pronosticos
        for (int i = 0; i < listaPronosticos.size(); i++) {
            // Por consola
            System.out.println(
                    listaPronosticos.get(i).getEquipo1().getNombre() +
                            " " +
                            listaPronosticos.get(i).getGanaEquipo1() +
                            " " +
                            listaPronosticos.get(i).getEmpate() +
                            " " +
                            listaPronosticos.get(i).getGanaEquipo2() +
                            " " +
                            listaPronosticos.get(i).getEquipo2().getNombre());

            // Por ventana
            JOptionPane.showMessageDialog(
                    null,
                    listaPronosticos.get(i).getEquipo1().getNombre() +
                            " " +
                            listaPronosticos.get(i).getGanaEquipo1() +
                            " " +
                            listaPronosticos.get(i).getEmpate() +
                            " " +
                            listaPronosticos.get(i).getGanaEquipo2() +
                            " " +
                            listaPronosticos.get(i).getEquipo2().getNombre());
        }

        // Mostrar Resultados/Puntos/TEST
        int puntos = 0;
        for (int i = 0; i < listaPartidos.size(); i++) {
            for (int j = 0; j < listaPronosticos.size(); j++) {
                if (listaPartidos.get(i).getEquipo1().getNombre()
                        .equals(listaPronosticos.get(j).getEquipo1().getNombre())
                        && listaPartidos.get(i).getEquipo2().getNombre()
                                .equals(listaPronosticos.get(j).getEquipo2().getNombre())) {

                    // Por consola
                    System.out.println("Partido: " + listaPartidos.get(i).getEquipo1().getNombre() + " vs "
                            + listaPartidos.get(i).getEquipo2().getNombre());

                    // def pronostico
                    // String pronostico;
                    // if (listaPronosticos.get(j).getGanaEquipo1() == 1)
                    // pronostico = "Gana: " + listaPronosticos.get(j).getEquipo1().getNombre();
                    // else if (listaPronosticos.get(j).getEmpate() == 1)
                    // pronostico = "Empate";
                    // else if (listaPronosticos.get(j).getGanaEquipo2() == 1)
                    // pronostico = "Gana: " + listaPronosticos.get(j).getEquipo2().getNombre();
                    // else
                    // pronostico = "No se pronostico";

                    System.out.println("Pronostico: " + listaPronosticos.get(j).pronostico());

                    System.out.println(
                            "Resultado: " + listaPartidos.get(i).getGolesEquipo1() + " "
                                    + listaPartidos.get(i).getGolesEquipo2());
                    System.out.println(
                            "Puntos: " + listaPronosticos.get(j).calcularPuntos(listaPartidos.get(i).getGolesEquipo1(),
                                    listaPartidos.get(i).getGolesEquipo2()));
                    puntos += listaPronosticos.get(j).calcularPuntos(listaPartidos.get(i).getGolesEquipo1(),
                            listaPartidos.get(i).getGolesEquipo2());

                    // Por ventana
                    JOptionPane.showMessageDialog(
                            null,
                            "Partido: " + listaPartidos.get(i).getEquipo1().getNombre() + " vs "
                                    + listaPartidos.get(i).getEquipo2().getNombre() + " \nPronostico: "
                                    + listaPronosticos.get(j).pronostico() +
                                    "\nResultado: " + listaPartidos.get(i).getGolesEquipo1() + " "
                                    + listaPartidos.get(i).getGolesEquipo2()
                                    + "\nPuntos: "
                                    + listaPronosticos.get(j).calcularPuntos(listaPartidos.get(i).getGolesEquipo1(),
                                            listaPartidos.get(i).getGolesEquipo2()));

                }
            }
        }

        // Mostrar Puntos Totales
        System.out.println("Puntos totales en esta Ronda: " + puntos);
        JOptionPane.showMessageDialog(null, "Puntos totales en esta Ronda: " + puntos);
    }
}
