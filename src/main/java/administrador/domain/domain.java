package administrador.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class domain {

    public void registrarAvion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese la capacidad del avión: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la fecha de fabricacion del avión: ");
        String fecha = scanner.nextLine();

        // Imprimir estados
        System.out.println("Ingrese ID del estado del avión: ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        // Imprimir aerolíneas
        System.out.println("Ingrese ID de la aerolínea: ");
        int aerolinea = scanner.nextInt();
        scanner.nextLine();

        // Imprimir modelos de avión
        System.out.println("Ingrese ID del modelo del avion: ");
        int modelo = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO planes (matricula, capacidad, fecha, estado, aerolinea, modelo) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        } catch (SQLException e) {
            System.out.println("Error al agregar avión: " + e.getMessage());
        }
    }

    public void asignarTripulacion() {
        Scanner scanner = new Scanner(System.in);
        // imprimir trayectos
        System.out.println("Seleccione el ID de un trayecto ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        // imprimir empleados disponibles
        System.out.println("Ingrese el ID los empleados a asingar para el trayecto: ");
        int idEmpleados = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO tripcrews (idTrayecto, idEmpleados) " +
                "VALUES (?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idTrayecto);
            pstmt.setInt(2, idEmpleados);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tripulacion agregada correctamente.");
            } else {
                System.out.println("No se pudo agregar a la Tripulacion.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar a la Tripulacion: " + e.getMessage());
        }

    }

    public void consultarAvion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(CONNECTION_URL)) {
            String sql = "SELECT * FROM Plane WHERE matricula = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, matricula);
                ResultSet rs = pstmt.executeQuery();
                System.out.println("Partidos disponibles:");
                System.out.println("ID\tEquipo Local\tEquipo Visitante\tFecha\t\tHora\t\tEstadio");
                System.out.println("------------------------------------------------------------------------------");
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String equipoLocal = rs.getString("equipoLocal");
                    String equipoVisitante = rs.getString("equipoVisitante");
                    String fecha = rs.getString("fecha");
                    String hora = rs.getString("hora");
                    String estadio = rs.getString("estadio");

                    System.out.printf("%d\t%s\t%s\t%s\t%s\t%s%n", id, equipoLocal, equipoVisitante, fecha, hora,
                            estadio);
                }
            }

        }
    }
    
}
