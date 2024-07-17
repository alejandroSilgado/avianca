package tecnico.Interface;

import java.sql.*;
import resources.ConexionBD;

public class dbOutTecnico {
    public static void dbRegistrarMantenimiento(Integer id_avion, String fecha, String descripcion, Integer id_empleado) {
        String sql = "INSERT INTO revisiones (fecha_revision, id_avion) VALUES (?, ?)";
        String sqlDetalle = "INSERT INTO detalles_revision (descripcion, id_empleado) VALUES (?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {
            // INSERCION EN LA TABLA REVISION 
            pstmt.setString(1, fecha);
            pstmt.setInt(2, id_avion);
            // INSERCION EN LA TABLA DETALLES REVISION 
            pstmtDetalle.setString(1, descripcion);
            pstmtDetalle.setInt(2, id_empleado);

            System.out.println("Revision registrada exitosamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la revisión", e);
        }
    }

    public static void dbConsultarRevisiones(String matricula) {
        String sql = "SELECT r.fecha_revision, dr.descripcion, e.nombre AS nombre_empleado " +
                     "FROM revisiones r " +
                     "JOIN aviones a ON r.id_avion = a.id " +
                     "JOIN detalles_revision dr ON dr.id_empleado = r.id_avion " +
                     "JOIN empleados e ON dr.id_empleado = e.id " +
                     "WHERE a.matricula = ? " +
                     "ORDER BY r.fecha_revision DESC";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("Historial de Revisiones del Avión con Matrícula: " + matricula);
            System.out.println("------------------------------------------------");

            while (rs.next()) {
                String fechaRevision = rs.getDate("fecha_revision").toString();
                String descripcion = rs.getString("descripcion");
                String nombreEmpleado = rs.getString("nombre_empleado");

                System.out.println("Fecha: " + fechaRevision);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Empleado Responsable: " + nombreEmpleado);
                System.out.println("------------------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el historial de revisiones: " + e.getMessage());
        }
    }

    public static void dbActualizarRevision(Integer id_revision, String nueva_fecha, String nueva_descripcion, Integer nuevo_id_empleado) {
        String sqlRevision = "UPDATE revisiones SET fecha_revision = ? WHERE id = ?";
        String sqlDetalle = "UPDATE detalles_revision SET descripcion = ?, id_empleado = ? WHERE id_revision = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmtRevision = conn.prepareStatement(sqlRevision);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {

            // Actualizar la tabla de revisiones
            pstmtRevision.setString(1, nueva_fecha);
            pstmtRevision.setInt(2, id_revision);
            pstmtRevision.executeUpdate();

            // Actualizar la tabla de detalles de revisión
            pstmtDetalle.setString(1, nueva_descripcion);
            pstmtDetalle.setInt(2, nuevo_id_empleado);
            pstmtDetalle.setInt(3, id_revision);
            pstmtDetalle.executeUpdate();

            System.out.println("Revisión actualizada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al actualizar la revisión: " + e.getMessage());
        }
    }
    
    public static void dbEliminarRevision(Integer id_revision) {
        String sqlRevision = "DELETE FROM revisiones WHERE id = ?";
        String sqlDetalle = "DELETE FROM detalles_revision WHERE id_revision = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmtRevision = conn.prepareStatement(sqlRevision);
             PreparedStatement pstmtDetalle = conn.prepareStatement(sqlDetalle)) {

            // Eliminar los detalles de revisión primero para mantener la integridad referencial
            pstmtDetalle.setInt(1, id_revision);
            pstmtDetalle.executeUpdate();

            // Luego eliminar la revisión
            pstmtRevision.setInt(1, id_revision);
            pstmtRevision.executeUpdate();

            System.out.println("Revisión eliminada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar la revisión: " + e.getMessage());
        }
    }

}



