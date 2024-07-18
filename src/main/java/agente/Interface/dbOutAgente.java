package agente.Interface;

import java.sql.*;

import resources.ConexionBD;

public class dbOutAgente {
    public static void dbCrearReserva(Integer clienteId, Integer trayectoId, String fecha, Integer tarifaId) {
        String sqlReserva = "INSERT INTO trayectos (fecha_trayecto, precio_trayecto ) VALUES (?)";
        String sqlDetalle = "INSERT INTO detalles_reservas_trayectos (id_reserva_trayecto, id_cliente) VALUES (?, ?)";
        try {
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstm = conn.prepareStatement(sqlDetalle);
            PreparedStatement pstms = conn.prepareStatement(sqlReserva);

            pstm.setInt(1, clienteId);
            pstm.setInt(2, trayectoId);
        
            pstms.setString(1,fecha);
            pstms.setInt(2, tarifaId);

            System.out.println("Reserva registrada exitosamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la Reserva", e);
        }
    }

    public static void dbconsultarCliente() {
        
    }
    public static void dbconsultarReserva() {
        
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
