package agente.Interface;

import java.sql.*;
import java.util.Scanner;

import resources.ConexionBD;

public class dbOutAgente {
    public static void dbCrearReserva(Integer clienteId, Integer trayectoId, String fecha, Integer tarifa_precio) {
        String sqlReserva = "INSERT INTO trayectos (fecha_trayecto, precio_trayecto ) VALUES (?)";
        String sqlDetalle = "INSERT INTO detalles_reservas_trayectos (id_reserva_trayecto, id_cliente) VALUES (?, ?)";
        try {
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sqlDetalle);
            PreparedStatement pstms = conn.prepareStatement(sqlReserva);

            pstm.setInt(1, clienteId);
            pstm.setInt(2, trayectoId);
        
            pstms.setString(1,fecha);
            pstms.setInt(2, tarifa_precio);

            System.out.println("Reserva registrada exitosamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la Reserva", e);
        }
    }

    public static void dbconsultarCliente(Integer documento) {
        String sql = "SELECT c.nombre, c.edad, c.email, t.nombre AS tipo_documento " +
                     "FROM clientes AS c " +
                     "JOIN tipos_documentos AS t ON c.id_documento = t.id " +
                     "WHERE c.documento = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
    
            pstm.setInt(1, documento);
    
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    String email = rs.getString("email");
                    String tipoDocumento = rs.getString("tipo_documento");
                    System.out.println("________________________________________");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Email: " + email);
                    System.out.println("Tipo de Documento: " + tipoDocumento);
                    System.out.println("________________________________________");

                } else {
                    System.out.println("No se encontró un cliente con el documento proporcionado.");
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error al listar el cliente: " + e.getMessage());
        }
    }
     
    public static void dbconsultarReserva(Integer documentoCliente) {
        String sql = "SELECT * FROM reservas_trayectos AS rt "
            + "JOIN detalles_reservas_trayectos AS drt ON rt.id = drt.id_reserva_trayecto "
            + "JOIN clientes AS c ON drt.id_cliente = c.id "
            + "WHERE c.documento = ?";

            try (Connection conn = ConexionBD.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sql)) {
       
           pstm.setInt(1, documentoCliente);
       
           try (ResultSet rs = pstm.executeQuery()) {
               while (rs.next()) {
                   int idReserva = rs.getInt("id");
                   Date fechaReserva = rs.getDate("fecha");
                   float precioTrayecto = rs.getFloat("precio_trayecto");
                   String nombreCliente = rs.getString("nombre");
       
                   System.out.println("________________________________________");
                   System.out.println("ID Reserva: " + idReserva);
                   System.out.println("Fecha Reserva: " + fechaReserva);
                   System.out.println("Precio Trayecto: " + precioTrayecto);
                   System.out.println("Nombre Cliente: " + nombreCliente);
                   System.out.println("________________________________________");
               }
       
               if (!rs.isBeforeFirst()) {
                   System.out.println("No se encontraron reservas para el documento proporcionado.");
               }
           }
       
       } catch (SQLException e) {
           System.out.println("Error al consultar reservas: " + e.getMessage());
       }
    }
    
    public static boolean verificarCliente(String idcliente) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            
                pstm.setInt(1, Integer.parseInt(idcliente));
            ResultSet resultSet = pstm.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void dbregistrarCliente(String nombre, Integer edad, String email, String contraseña, Integer tipo_documento, String numeroDocumento) {
        String sql = "INSERT INTO clientes (nombre, edad, email, contraseña, tipo_documento, numero_documento) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, email);
            pstmt.setString(4, contraseña);
            pstmt.setInt(5, tipo_documento);
            pstmt.setString(6, numeroDocumento);
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente registrado exitosamente!");
            } else {
                System.out.println("No se pudo registrar el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }
    }
    
    public static void dbActualizarCliente(String idcliente, String nombre, Integer edad, String email, String contraseña, Integer tipo_documento, String numeroDocumento) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE clientes SET ");
        boolean first = true;
    
        if (nombre != null && !nombre.isEmpty()) {
            queryBuilder.append("nombre = ?, ");
            first = false;
        }
        if (edad != null) {
            queryBuilder.append(first ? "" : "edad = ?, ");
            first = false;
        }
        if (email != null && !email.isEmpty()) {
            queryBuilder.append(first ? "" : "email = ?, ");
            first = false;
        }
        if (contraseña != null && !contraseña.isEmpty()) {
            queryBuilder.append(first ? "" : "contraseña = ?, ");
            first = false;
        }
        if (tipo_documento != null) {
            queryBuilder.append(first ? "" : "id_documento = ?, ");
            first = false;
        }
        if (numeroDocumento != null && !numeroDocumento.isEmpty()) {
            queryBuilder.append(first ? "" : "documento = ?, ");
        }
    
        int lastCommaIndex = queryBuilder.lastIndexOf(", ");
        if (lastCommaIndex != -1) {
            queryBuilder.delete(lastCommaIndex, lastCommaIndex + 2);
        }
    
        queryBuilder.append(" WHERE id = ?");
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {
    
            int paramIndex = 1;
    
            if (nombre != null && !nombre.isEmpty()) {
                pstmt.setString(paramIndex++, nombre);
            }
            if (edad != null) {
                pstmt.setInt(paramIndex++, edad);
            }
            if (email != null && !email.isEmpty()) {
                pstmt.setString(paramIndex++, email);
            }
            if (contraseña != null && !contraseña.isEmpty()) {
                pstmt.setString(paramIndex++, contraseña);
            }
            if (tipo_documento != null) {
                pstmt.setInt(paramIndex++, tipo_documento);
            }
            if (numeroDocumento != null && !numeroDocumento.isEmpty()) {
                pstmt.setString(paramIndex++, numeroDocumento);
            }
    
            pstmt.setInt(paramIndex, Integer.parseInt(idcliente));
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente actualizado exitosamente!");
            } else {
                System.out.println("No se pudo actualizar el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }
    
    public static void dbeliminarReserva(Integer id_reserva) {
        String sql = "DELETE FROM reservas WHERE id_reserva = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_reserva);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Reserva eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna reserva con el ID proporcionado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void dbconsultarVuelo(String numeroConexion) {
        String sql = "SELECT cv.*, a.matricula, ae.nombre AS nombre_aerolinea, "
        + "ap.nombre AS nombre_aeropuerto, c.nombre as nombre_ciudad, p.nombre as nombre_pais "
        + "FROM conexiones_vuelos AS cv "
        + "JOIN aviones AS a ON cv.id_avion = a.id "
        + "JOIN aerolineas AS ae ON a.id_aerolinea = ae.id "
        + "JOIN aeropuertos AS ap ON cv.id_aeropuerto = ap.id "
        + "JOIN ciudades AS c ON ap.id_ciudad = c.id "
        + "JOIN paises AS p ON c.id_pais = p.id "
        + "WHERE cv.numero_conexion = ?";

    try (Connection conn = ConexionBD.getConnection();
    PreparedStatement pstm = conn.prepareStatement(sql)) {
    
    pstm.setString(1, numeroConexion);
    
    try (ResultSet rs = pstm.executeQuery()) {
        if (rs.next()) {
            int id = rs.getInt("id");
            String numeroConexionResult = rs.getString("numero_conexion");
            int idTrayecto = rs.getInt("id_trayecto");
            String matriculaAvion = rs.getString("matricula");
            String nombreAerolinea = rs.getString("nombre_aerolinea");
            String nombreAeropuerto = rs.getString("nombre_aeropuerto");
            String ciudadAeropuerto = rs.getString("nombre_ciudad");
            String paisAeropuerto = rs.getString("nombre_pais");

            System.out.println("________________________________________");
            System.out.println("ID: " + id);
            System.out.println("Número de Conexión: " + numeroConexionResult);
            System.out.println("ID Trayecto: " + idTrayecto);
            System.out.println("Matrícula Avión: " + matriculaAvion);
            System.out.println("Nombre Aerolínea: " + nombreAerolinea);
            System.out.println("Nombre Aeropuerto: " + nombreAeropuerto);
            System.out.println("Ciudad Aeropuerto: " + ciudadAeropuerto);
            System.out.println("País Aeropuerto: " + paisAeropuerto);
            System.out.println("________________________________________");
        } else {
            System.out.println("No se encontró el vuelo con el número de conexión: " + numeroConexion);
        }
    }
        } catch (SQLException e) {
        System.out.println("Error al consultar vuelo: " + e.getMessage());
        }
    }
    
    public static void dbconsultarAsignacionTripulacion(Integer idTrayecto) {

        String sql = "SELECT e.nombre AS nombre_empleado, e.email, r.nombre AS rol "
                   + "FROM tripulaciones t "
                   + "JOIN empleados e ON t.id_empleado = e.id "
                   + "JOIN roles_tripulacion r ON e.id_rol = r.id "
                   + "WHERE t.id_trayectos = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
             
            pstm.setInt(1, idTrayecto);
            
            try (ResultSet rs = pstm.executeQuery()) {
                System.out.println("Tripulación asignada al trayecto " + idTrayecto + ":");
                while (rs.next()) {
                    String nombreEmpleado = rs.getString("nombre_empleado");
                    String email = rs.getString("email");
                    String rol = rs.getString("rol");

                    System.out.println("________________________________________");
                    System.out.println("Nombre: " + nombreEmpleado);
                    System.out.println("Email: " + email);
                    System.out.println("Rol: " + rol);
                    System.out.println("________________________________________");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la asignación de tripulación: " + e.getMessage());
        }
    }
    public static void dbconsultarEscalasTrayecto() {
        
    }
    public static void dbconsultarTarifaVuelo() {
        
    }
    public static void dbconsultarDocumento() {
        
    }
}

