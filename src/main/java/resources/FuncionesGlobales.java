package resources;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class FuncionesGlobales {
    public static void limpiarPantalla() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void ImprimirTabla(String tabla) {
        String sql = "{CALL ImprimirTabla(?)}";

        try (Connection conn = ConexionBD.getConnection();
            CallableStatement cstmt = conn.prepareCall(sql)) {

            cstmt.setString(1, tabla);

            boolean hasResults = cstmt.execute();

            if (hasResults) {
                try (ResultSet rs = cstmt.getResultSet()) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", metaData.getColumnName(i));
                    }
                    System.out.println();

                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.printf("%-20s", rs.getString(i));
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("No se encontraron resultados para la tabla: " + tabla);
            }
        } catch (SQLException e) {
            System.out.println("Error al imprimir la tabla: " + e.getMessage());
        }
    }
}
