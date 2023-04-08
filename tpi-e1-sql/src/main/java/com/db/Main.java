package com.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 *
 * @author Your name
 */
public class Main {
    public static void main(String... param) throws ClassNotFoundException {
        Conexion con = new Conexion();

        con.abrirCon("root", "2717", "tpi_e1");
        Statement st = con.getSt();

        System.out.println(st);

        int val = 2;

        ResultSet rs = null;

        try {
            rs = st.executeQuery("SELECT * FROM resultados");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta");
        }

        try {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al recorrer el resultset");
        }
    }
}