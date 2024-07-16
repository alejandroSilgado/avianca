package administrador.domain;


import java.sql.SQLException;
import java.util.Scanner;
import administrador.Interface.*;;

public class domain {

    public static void registrarAvion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese la capacidad del avión: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la fecha de fabricacion del avión: ");
        String fecha = scanner.nextLine();

        // Imprimir aerolíneas
        resources.FuncionesGlobales.ImprimirTabla("estados");
        System.out.println("Ingrese ID del estado del avión: ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        // Imprimir aerolíneas
        resources.FuncionesGlobales.ImprimirTabla("aerolineas");

        System.out.println("Ingrese ID de la aerolínea: ");
        int aerolinea = scanner.nextInt();
        scanner.nextLine();

        // Imprimir modelos de avión
        resources.FuncionesGlobales.ImprimirTabla("modelos");

        System.out.println("Ingrese ID del modelo del avion: ");
        int modelo = scanner.nextInt();
        scanner.nextLine();

        try {
            dbOutAdministrador.agregarAvion(matricula, capacidad, fecha, estado, aerolinea, modelo);
        } catch (SQLException e) {
            System.out.println("Error al agregar avión: " + e.getMessage());
        }
    }

    public static void asignarTripulacion() {
        Scanner scanner = new Scanner(System.in);

        // Imprimir trayectos
        resources.FuncionesGlobales.ImprimirTabla("trayectos");

        System.out.println("Seleccione el ID de un trayecto: ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        // Imprimir empleados
        resources.FuncionesGlobales.ImprimirTabla("empleados");

        System.out.println("Ingrese el ID del empleado a asignar para el trayecto: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        dbOutAdministrador.dbAgregarTripulacion(idEmpleado, idTrayecto);
    }

    public static void consultarAvion() {
        Scanner scanner = new Scanner(System.in);

        // Imprimir aviones
        resources.FuncionesGlobales.ImprimirTabla("aviones");

        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

    }
}
