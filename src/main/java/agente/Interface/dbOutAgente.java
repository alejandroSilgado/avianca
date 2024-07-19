package agente.Interface;

import java.sql.*;

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
    
    public static void dbregistrarCliente() {
        
    }
    public static void dbactualizarCliente() {
        
    }
    public static void dbeliminarReserva() {
        
    }
    public static void dbconsultarVuelo() {
        
    }
    public static void dbconsultarAsignacionTripulacion() {
        
    }
    public static void dbconsultarEscalasTrayecto() {
        
    }
    public static void dbconsultarTarifaVuelo() {
        
    }
    public static void dbconsultarDocumento() {
        
    }
}
