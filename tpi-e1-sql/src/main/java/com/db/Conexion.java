package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {

    private Connection conectar;
    private Statement statement;

    public void abrirCon(String user, String pass, String db) throws ClassNotFoundException {
        String sURL = "jdbc:mysql://localhost:3306/" + db;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            conectar = DriverManager.getConnection(sURL, user, pass);
            System.out.println("Conectado establecida exitosamente!\n");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

        try {
            statement = conectar.createStatement();
        } catch (Exception e) {
            System.out.println("Error al crear el statement");
        }
    }

    public void cerrarCon() {
        try {
            conectar.close();
            System.out.println("Conexión cerrada exitosamente!\n");
        } catch (Exception e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConectar() {
        return conectar;
    }

    public void setConectar(Connection conectar) {
        this.conectar = conectar;
    }

    // public void abrirCon(String user, String pass, String db) throws
    // ClassNotFoundException {
    // Connection conectar = null;
    // String sURL = "jdbc:mysql://localhost:3306/" + db;

    // Class.forName("com.mysql.cj.jdbc.Driver");

    // try {
    // conectar = DriverManager.getConnection(sURL, user, pass);
    // System.out.println("Conectado exitosamente!");
    // } catch (Exception e) {
    // System.out.println("Error al conectar a la base de datos: " +
    // e.getMessage());
    // }

    // Statement statement = null;
    // try {
    // statement = conectar.createStatement();
    // } catch (Exception e) {
    // System.out.println("Error al crear el statement");
    // }
    // }

    // public void cerrarCon(Connection con) {
    // try {
    // con.close();
    // System.out.println("Conexión cerrada exitosamente!");
    // } catch (Exception e) {
    // System.out.println("Error al cerrar la conexión: " + e.getMessage());
    // }
    // }

}
