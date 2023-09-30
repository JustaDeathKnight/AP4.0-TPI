package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author Your name
 */
public class DB_test {
    public static void main(String... param) throws ClassNotFoundException {
        Conexion con = new Conexion();

        con.abrirCon("root", "2717", "tpi_e1");
        Statement st = con.getStatement();

        ResultSet rs = null;

        // Consulta a la base de datos desde una Vista creada para obtener los
        // resultados del partido
        try {
            rs = st.executeQuery("SELECT * FROM resultados");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        try {

            System.out.println("Resultados:");
            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " " +
                                rs.getInt(2) + " " +
                                rs.getInt(3) + " " +
                                rs.getString(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recorrer el resultset");
        }

        // Consulta a la base de datos desde una Vista creada para obtener los
        // pronosticos del partido
        try {
            rs = st.executeQuery("SELECT * FROM pronosticos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        try {
            System.out.println("Pronosticos:");
            while (rs.next()) {
                System.out.println(
                        rs.getString(1) + " " +
                                rs.getInt(2) + " " +
                                rs.getInt(3) + " " +
                                rs.getInt(4) + " " +
                                rs.getString(5));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recorrer el resultset");
        }

        con.cerrarCon();

    }
}