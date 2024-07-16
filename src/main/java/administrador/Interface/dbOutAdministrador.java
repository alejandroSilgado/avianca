package administrador.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import resources.ConexionBD;

public class dbOutAdministrador {

    public static void agregarAvion(String matricula, int capacidad, String fecha, int estado, int aerolinea,
            int modelo) throws SQLException {
        String sql = "INSERT INTO aviones (matricula, capacidad, fecha_fabricacion, id_estado, id_aerolinea, id_modelo) "
                +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setInt(2, capacidad);
            pstmt.setString(3, fecha);
            pstmt.setInt(4, estado);
            pstmt.setInt(5, aerolinea);
            pstmt.setInt(6, modelo);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Avión agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el avión.");
            }
        }
    }

    public static void dbAgregarTripulacion (Integer id_empleado, Integer id_trayecto) {
        String sql = "INSERT INTO tripulaciones (id_trayectos, id_empleado) " +
                "VALUES (?, ?)";

        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_empleado);
                ps.setInt(2, id_trayecto);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tripulacion agregada correctamente.");
            } else {
                System.out.println("No se pudo agregar a la Tripulacion.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar a la Tripulacion: " + e.getMessage());
        }

    }
}