package cliente.Interface;

import java.sql.*;
import resources.ConexionBD;


public class dbOutCliente{
    public static void dbbuscarvuelos(String ciudadorigen, String ciudaddestino, String fechasalida, String fecharegreso) {
        String sql = "SELECT " +
                "cv.*, " +
                "a.*, " +
                "p.*, " +
                "c.*, " +
                "t.* " +
                "FROM " +
                "conexiones_vuelos cv " +
                "JOIN aeropuertos a ON cv.id_aeropuerto = a.id " +
                "JOIN ciudades c ON c.id = a.id_ciudad " +
                "JOIN paises p ON p.id = c.id_pais " +
                "JOIN trayectos t ON t.id = cv.id_trayecto " +
                "WHERE c.nombre = ? AND p.nombre = ? AND t.fecha_trayecto >= ?";

        try (
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, ciudadorigen);
            pstmt.setString(2, ciudaddestino);
            pstmt.setString(3, fechasalida);

            ResultSet rs = pstmt.executeQuery();

            // Aquí puedes procesar el resultado del ResultSet
            while (rs.next()) {
                // Ejemplo de cómo obtener datos de la consulta
                int idConexion = rs.getInt("cv.id");
                String numeroConexion = rs.getString("cv.numero_conexion");
                // Obtener más datos según sea necesario
                // Por ejemplo:
                // int idAeropuerto = rs.getInt("a.id");
                // String nombreAeropuerto = rs.getString("a.nombre");
                // y así sucesivamente para las otras tablas involucradas
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente según tus requerimientos
        }
    }

}


