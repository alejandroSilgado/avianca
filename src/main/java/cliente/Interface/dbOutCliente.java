package cliente.Interface;

import java.sql.*;
import resources.ConexionBD;


public class dbOutCliente{
    public static void dbbuscarvuelos(String ciudadorigen, String ciudaddestino, String fechasalida, String fecharegreso) {
        String sql = "SELECT " +
                "cv.id AS idConexion, " +
                "cv.numero_conexion, " +
                "a.nombre AS nombreAeropuerto, " +
                "c.nombre AS nombreCiudad, " +
                "p.nombre AS nombrePais, " +
                "t.fecha_trayecto, " +
                "t.precio_trayecto " +
                "FROM " +
                "conexiones_vuelos cv " +
                "JOIN aeropuertos a ON cv.id_aeropuerto = a.id " +
                "JOIN ciudades c ON c.id = a.id_ciudad " +
                "JOIN paises p ON p.id = c.id_pais " +
                "JOIN trayectos t ON t.id = cv.id_trayecto " +
                "WHERE c.nombre = ? AND p.nombre = ? AND t.fecha_trayecto >= ?";

        if (fecharegreso != null && !fecharegreso.isEmpty()) {
            sql += " AND t.fecha_trayecto <= ?";
        }

        try (
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            System.out.println("Conexión a la base de datos establecida.");

            pstmt.setString(1, ciudadorigen);
            pstmt.setString(2, ciudaddestino);
            pstmt.setString(3, fechasalida);

            if (fecharegreso != null && !fecharegreso.isEmpty()) {
                pstmt.setString(4, fecharegreso);
            }

            System.out.println("Ejecutando consulta SQL: " + pstmt);

            ResultSet rs = pstmt.executeQuery();

            // Procesar el resultado del ResultSet
            boolean hayResultados = false;
            while (rs.next()) {
                hayResultados = true;
                int idConexion = rs.getInt("idConexion");
                String numeroConexion = rs.getString("numero_conexion");
                String nombreAeropuerto = rs.getString("nombreAeropuerto");
                String nombreCiudad = rs.getString("nombreCiudad");
                String nombrePais = rs.getString("nombrePais");
                String fechaTrayecto = rs.getString("fecha_trayecto");
                float precioTrayecto = rs.getFloat("precio_trayecto");

                // Aquí puedes imprimir los datos o almacenarlos en una lista para devolverlos
                System.out.println("ID Conexión: " + idConexion);
                System.out.println("Número Conexión: " + numeroConexion);
                System.out.println("Aeropuerto: " + nombreAeropuerto);
                System.out.println("Ciudad: " + nombreCiudad);
                System.out.println("País: " + nombrePais);
                System.out.println("Fecha Trayecto: " + fechaTrayecto);
                System.out.println("Precio Trayecto: " + precioTrayecto);
                System.out.println("-------------");
            }

            if (!hayResultados) {
                System.out.println("No se encontraron vuelos que coincidan con los criterios de búsqueda.");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL:");
            e.printStackTrace();
        }
    }

    public static void dbseleccionarVuelo(int idVueloSeleccionado) {
        String sqlVueloSeleccionado = "SELECT " +
                "cv.id AS idConexion, " +
                "cv.numero_conexion, " +
                "a.nombre AS nombreAeropuerto, " +
                "c.nombre AS nombreCiudad, " +
                "p.nombre AS nombrePais, " +
                "t.fecha_trayecto, " +
                "t.precio_trayecto " +
                "FROM " +
                "conexiones_vuelos cv " +
                "JOIN aeropuertos a ON cv.id_aeropuerto = a.id " +
                "JOIN ciudades c ON c.id = a.id_ciudad " +
                "JOIN paises p ON p.id = c.id_pais " +
                "JOIN trayectos t ON t.id = cv.id_trayecto " +
                "WHERE cv.id = ?";

        try (
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmtVueloSeleccionado = conn.prepareStatement(sqlVueloSeleccionado)
        ) {

            pstmtVueloSeleccionado.setInt(1, idVueloSeleccionado);
            ResultSet rsVueloSeleccionado = pstmtVueloSeleccionado.executeQuery();

            if (rsVueloSeleccionado.next()) {

                int idConexion = rsVueloSeleccionado.getInt("idConexion");
                String numeroConexion = rsVueloSeleccionado.getString("numero_conexion");
                String nombreAeropuerto = rsVueloSeleccionado.getString("nombreAeropuerto");
                String nombreCiudad = rsVueloSeleccionado.getString("nombreCiudad");
                String nombrePais = rsVueloSeleccionado.getString("nombrePais");
                String fechaTrayecto = rsVueloSeleccionado.getString("fecha_trayecto");
                float precioTrayecto = rsVueloSeleccionado.getFloat("precio_trayecto");

                // Mostrar los detalles del vuelo seleccionado
                System.out.println("-----------------------------------------------------");
                System.out.println("ID Conexión: " + idConexion);
                System.out.println("Número Conexión: " + numeroConexion);
                System.out.println("Aeropuerto: " + nombreAeropuerto);
                System.out.println("Ciudad: " + nombreCiudad);
                System.out.println("País: " + nombrePais);
                System.out.println("Fecha Trayecto: " + fechaTrayecto);
                System.out.println("Precio Trayecto: " + precioTrayecto);
                System.out.println("-----------------------------------------------------");

            } else {
                System.out.println("No se encontró un vuelo con el ID proporcionado.");
            }

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta SQL:");
            e.printStackTrace();
        }
    }

    public static void dbAñadirPasajeros(String nombrepasajero, Integer edad, Integer tipo_documentom, String numerodocumneto) {
        String query = "INSERT INTO clientes (nombre, edad, documento, id_documento) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nombrepasajero);
            pstmt.setInt(2, edad);
            pstmt.setString(3, numerodocumneto);
            pstmt.setInt(4, tipo_documentom);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("El pasajero se creo correctamente.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Integer clienteExiste(int documento) {
        String query = "SELECT id FROM clientes WHERE documento = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setInt(1, documento);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");  // Retorna el id del cliente si existe
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al verificar la existencia del cliente.");
        }
        return null;  // Retorna null si el cliente no existe
    }
    
    public static void guardarSeleccionAsiento(String asientoId, int idCliente) {
        String query = "INSERT INTO seleccion_asientos (asiento, id_cliente) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, asientoId);
            pstmt.setInt(2, idCliente);
            pstmt.executeUpdate();
            System.out.println("Asiento " + asientoId + " guardado en la base de datos con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al guardar la selección del asiento.");
        }
    }
    
    public static void realizarPago(String asientoId, int idCliente) {

    }
    public static void dbconsultarReserva(Integer identificador) {
        String query = "SELECT drt.id_reserva_trayecto, drt.id_cliente, c.nombre " +
                       "FROM detalles_reservas_trayectos drt " +
                       "JOIN clientes c ON drt.id_cliente = c.id " +
                       "WHERE drt.id_reserva_trayecto = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
             
            pstmt.setInt(1, identificador);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Aquí puedes imprimir los detalles de la reserva
                    System.out.println("-----------------------------------------------");
                    System.out.println("ID Reserva Trayecto: " + rs.getInt("id_reserva_trayecto"));
                    System.out.println("ID Cliente: " + rs.getInt("id_cliente"));
                    System.out.println("Nombre Cliente: " + rs.getString("nombre"));
                    System.out.println("-----------------------------------------------");

                    // Agrega más campos según sea necesario
                } else {
                    System.out.println("No se encontró ninguna reserva con el identificador proporcionado.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar la reserva.");
        }
    }

}
    


