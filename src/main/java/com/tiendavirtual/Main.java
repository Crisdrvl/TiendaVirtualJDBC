
package com.tiendavirtual;

import com.tiendavirtual.config.DatabaseConnection;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion != null) {
                System.out.println("Prueba de conexión completada correctamente.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }

        } catch (Exception e) {
            System.out.println("Error durante la prueba:");
            e.printStackTrace();
        }
    }
}
