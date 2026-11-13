
package com.tiendavirtual.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/TiendaVirtual";

    private static final String USER = "postgres";

    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(
                    URL, USER, PASSWORD
            );

            System.out.println("¡Conexión exitosa con PostgreSQL!");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con PostgreSQL:");
            e.printStackTrace();
            return null;
        }
    }
}
