package tecnico.Interface;

import java.sql.*;
import resources.ConexionBD;

public class dbOutTecnico {
    public static void dbRegistrarMantenimiento(Integer id_avion, String fecha, String descripcion, Integer id_empleado) {
        String sql = "INSERT INTO mantenimiento (avion, fecha, descripcion, empleado) VALUES (?, ?, ?, ?)"
        try (
            Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
