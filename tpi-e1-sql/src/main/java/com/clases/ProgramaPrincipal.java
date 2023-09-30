package com.clases;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.db.Conexion;
import com.funciones.Mostrar;

public class ProgramaPrincipal {
    public static void main(String[] args)
            throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
        ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
        ArrayList<Pronostico> listaPronosticos = new ArrayList<Pronostico>();

        Partido unPartido;

        Equipo unEquipo1;
        Equipo unEquipo2;

        // Acceso a Base de Datos
        Conexion conexion = new Conexion();
        conexion.abrirCon("root", "2717", "tpi_e1");
        Statement statement = conexion.getStatement();

        ResultSet resultado = null;

        try {
            resultado = statement.executeQuery("SELECT * FROM resultados");
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta en Vista Resultados");
        }

        // Query a Vista Resultados para obtener los resultados de los partidos
        while (resultado.next()) {
            unPartido = new Partido();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();

            unEquipo1.setNombre(resultado.getString("equipo1"));
            unEquipo2.setNombre(resultado.getString("equipo2"));

            unPartido.setEquipo1(unEquipo1);
            unPartido.setEquipo2(unEquipo2);
            unPartido.setGolesEquipo1(resultado.getInt("goles_equipo1"));
            unPartido.setGolesEquipo2(resultado.getInt("goles_equipo2"));

            listaPartidos.add(unPartido);
        }

        try {
            resultado = statement.executeQuery("SELECT * FROM pronosticos");
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta en Vista Pronosticos");
        }

        // Query a Vista Pronosticos para obtener los pronosticos de los partidos
        while (resultado.next()) {
            Pronostico unPronostico = new Pronostico();
            unEquipo1 = new Equipo();
            unEquipo2 = new Equipo();

            unEquipo1.setNombre(resultado.getString("equipo1"));
            unEquipo2.setNombre(resultado.getString("equipo2"));

            for (int i = 0; i < listaPartidos.size(); i++) {
                if (listaPartidos.get(i).getEquipo1().getNombre().equals(unEquipo1.getNombre()) &&
                        listaPartidos.get(i).getEquipo2().getNombre().equals(unEquipo2.getNombre())) {
                    unPronostico.setPartido(listaPartidos.get(i));
                    break;
                }
            }

            unPronostico.setEquipo1(unEquipo1);
            unPronostico.setEquipo2(unEquipo2);

            if (resultado.getString("opcion_equipo1").equals("1"))
                unPronostico.setResultado(ResultadoEnum.GANA_EQUIPO1);
            else if (resultado.getString("opcion_empate").equals("1"))
                unPronostico.setResultado(ResultadoEnum.EMPATE);
            else if (resultado.getString("opcion_equipo2").equals("1"))
                unPronostico.setResultado(ResultadoEnum.GANA_EQUIPO2);

            listaPronosticos.add(unPronostico);
        }

        Mostrar.partido(listaPartidos);
        Mostrar.pronostico(listaPronosticos);

        // Calcular Puntos y Mostrar Resultado
        Mostrar.resultado(listaPartidos, listaPronosticos);

    }
}