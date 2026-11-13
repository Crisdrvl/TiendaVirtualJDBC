
package com.tiendavirtual.model;

import com.tiendavirtual.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    // REGISTRAR PRODUCTO
    public boolean registrarProducto(Producto producto) {

        String sql = "INSERT INTO productos " +
                "(nombre, descripcion, precio, stock, id_categoria, activo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion == null) return false;

            try (PreparedStatement consulta = conexion.prepareStatement(sql)) {

                consulta.setString(1, producto.getNombre());
                consulta.setString(2, producto.getDescripcion());
                consulta.setDouble(3, producto.getPrecio());
                consulta.setInt(4, producto.getStock());
                consulta.setInt(5, producto.getIdCategoria());
                consulta.setBoolean(6, producto.isActivo());

                return consulta.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error al registrar el producto:");
            e.printStackTrace();
            return false;
        }
    }

    // CONSULTAR TODOS LOS PRODUCTOS
    public List<Producto> listarProductos() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT * FROM productos ORDER BY id_producto";

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion == null) return productos;

            try (PreparedStatement consulta = conexion.prepareStatement(sql);
                 ResultSet resultado = consulta.executeQuery()) {

                while (resultado.next()) {

                    Producto producto = new Producto(
                            resultado.getInt("id_producto"),
                            resultado.getString("nombre"),
                            resultado.getString("descripcion"),
                            resultado.getDouble("precio"),
                            resultado.getInt("stock"),
                            resultado.getInt("id_categoria"),
                            resultado.getBoolean("activo")
                    );

                    productos.add(producto);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los productos:");
            e.printStackTrace();
        }

        return productos;
    }

    // BUSCAR PRODUCTO POR ID
    public Producto buscarProducto(int id) {

        String sql = "SELECT * FROM productos WHERE id_producto = ?";

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion == null) return null;

            try (PreparedStatement consulta = conexion.prepareStatement(sql)) {

                consulta.setInt(1, id);

                try (ResultSet resultado = consulta.executeQuery()) {

                    if (resultado.next()) {

                        return new Producto(
                                resultado.getInt("id_producto"),
                                resultado.getString("nombre"),
                                resultado.getString("descripcion"),
                                resultado.getDouble("precio"),
                                resultado.getInt("stock"),
                                resultado.getInt("id_categoria"),
                                resultado.getBoolean("activo")
                        );
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar el producto:");
            e.printStackTrace();
        }

        return null;
    }

    // ACTUALIZAR PRODUCTO
    public boolean actualizarProducto(Producto producto) {

        String sql = "UPDATE productos SET nombre = ?, descripcion = ?, " +
                "precio = ?, stock = ?, id_categoria = ?, activo = ? " +
                "WHERE id_producto = ?";

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion == null) return false;

            try (PreparedStatement consulta = conexion.prepareStatement(sql)) {

                consulta.setString(1, producto.getNombre());
                consulta.setString(2, producto.getDescripcion());
                consulta.setDouble(3, producto.getPrecio());
                consulta.setInt(4, producto.getStock());
                consulta.setInt(5, producto.getIdCategoria());
                consulta.setBoolean(6, producto.isActivo());
                consulta.setInt(7, producto.getIdProducto());

                return consulta.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto:");
            e.printStackTrace();
            return false;
        }
    }

    // ELIMINAR PRODUCTO (ELIMINACIÓN LÓGICA)
    public boolean eliminarProducto(int id) {

        String sql = "UPDATE productos SET activo = false " +
                "WHERE id_producto = ?";

        try (Connection conexion = DatabaseConnection.conectar()) {

            if (conexion == null) return false;

            try (PreparedStatement consulta = conexion.prepareStatement(sql)) {

                consulta.setInt(1, id);

                return consulta.executeUpdate() > 0;
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto:");
            e.printStackTrace();
            return false;
        }
    }
}
