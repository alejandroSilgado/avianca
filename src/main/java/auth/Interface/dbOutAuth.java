package auth.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import administrador.application.appAdministrador;
import agente.application.appAgente;
import cliente.application.appCliente;
import tecnico.application.appTecnico;
import resources.ConexionBD;

public class dbOutAuth {

    public static void dbIngresoUsuario(String email, String password) {
        String sql = "SELECT id_rol FROM usuarios WHERE email = ? AND contraseña = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int rol = rs.getInt("id_rol");
                switch (rol) {
                    case 1:
                        appAdministrador.menuAdministrador();
                        break;
                    case 2:
                        appAgente.menuAgente();
                        break;
                    case 3:
                        appCliente.menuCliente();
                        break;
                    case 4:
                        appTecnico.menuTecnico();
                        break;
                    default:
                        System.out.println("Rol no reconocido.");
                }
            } else {
                System.out.println("Credenciales incorrectas.");
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }

    public static void dbcrearUsuario(String nombre, String apellido, String email, String contraseña) {
        String sql = "INSERT INTO usuarios (nombre, apellido, email, contraseña, id_rol) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, email);
            pstmt.setString(4, contraseña);
            pstmt.setInt(5, 3); // Asignar el rol de cliente, asumiendo que es el rol por defecto para nuevos usuarios
    
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario insertado correctamente en la base de datos.");
            } else {
                System.out.println("No se pudo insertar el usuario en la base de datos.");
            }
    
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }
    
}
