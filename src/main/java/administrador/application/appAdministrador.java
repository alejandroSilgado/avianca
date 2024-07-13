package administrador.application;

import java.util.Scanner;

public class appAdministrador {
    public static void main(String[] args) {
        menuAdministrador();
    }
    public static void menuAdministrador() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ____  _                           _     _                      \r\n" + //
                "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___                 \r\n" + //
                "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\                \r\n" + //
                "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |               \r\n" + //
                "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   _            \r\n" + //
                "   / \\   __| |_ __ ___ (_)_ __ (_)___| |_ __ _  __| | ___  _ __ \r\n" + //
                "  / _ \\ / _` | '_ ` _ \\| | '_ \\| / __| __/ _` |/ _` |/ _ \\| '__|\r\n" + //
                " / ___ \\ (_| | | | | | | | | | | \\__ \\ || (_| | (_| | (_) | |   \r\n" + //
                "/_/   \\_\\__,_|_| |_| |_|_|_| |_|_|___/\\__\\__,_|\\__,_|\\___/|_|   ");
        System.out.println(" ");
        System.out.println("2. Registrar Avion ");
        System.out.println("3. Asignar Tripulación");
        System.out.println("4. Consultar Avión ");
        System.out.println("5. Consultar Trayecto ");
        System.out.println("6. Consultar Aeropuerto ");
        System.out.println("7. Actualizar Avión ");
        System.out.println("8. Eliminar Avión ");
        System.out.println("9. Actualizar Trayecto ");
        System.out.println("10. Eliminar Trayecto ");
        System.out.println("11. Actualizar Aeropuerto");
        System.out.println("12. Eliminar Aeropuerto ");
        System.out.println("13. Consultar vuelo ");
        System.out.println("14. Consultar Asignación de Tripulación");
        System.out.println("15. Consultar Escalas de un Trayecto ");
        System.out.println("16. Eliminar Escala");
        System.out.println("17. Registrar Tarifa de Vuelo");
        System.out.println("18. Actualizar Tarifa de Vuelo");
        System.out.println("19. Eliminar Tarifa de Vuelo");
        System.out.println("20. Consultar Tarifa de Vuelo ");
        System.out.println("21. Registrar Tipo de Documento");
        System.out.println("22. Actualizar Tipo de Documento");
        System.out.println("23. Eliminar Tipo de Documento");
        System.out.println("24. Consultar Tipo de Documento");
        System.out.println("25. Salir");
        System.out.println(" ");

        System.out.println("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 2:
                // Registrar Avion
                System.out.println("Registrar Avion");
                // Lógica para registrar un avión
                break;
            case 3:
                // Asignar Tripulación
                System.out.println("Asignar Tripulación");
                // Lógica para asignar tripulación
                break;
            case 4:
                // Consultar Avión
                System.out.println("Consultar Avión");
                // Lógica para consultar un avión
                break;
            case 5:
                // Consultar Trayecto
                System.out.println("Consultar Trayecto");
                // Lógica para consultar un trayecto
                break;
            case 6:
                // Consultar Aeropuerto
                System.out.println("Consultar Aeropuerto");
                // Lógica para consultar un aeropuerto
                break;
            case 7:
                // Actualizar Avión
                System.out.println("Actualizar Avión");
                // Lógica para actualizar un avión
                break;
            case 8:
                // Eliminar Avión
                System.out.println("Eliminar Avión");
                // Lógica para eliminar un avión
                break;
            case 9:
                // Actualizar Trayecto
                System.out.println("Actualizar Trayecto");
                // Lógica para actualizar un trayecto
                break;
            case 10:
                // Eliminar Trayecto
                System.out.println("Eliminar Trayecto");
                // Lógica para eliminar un trayecto
                break;
            case 11:
                // Actualizar Aeropuerto
                System.out.println("Actualizar Aeropuerto");
                // Lógica para actualizar un aeropuerto
                break;
            case 12:
                // Eliminar Aeropuerto
                System.out.println("Eliminar Aeropuerto");
                // Lógica para eliminar un aeropuerto
                break;
            case 13:
                // Consultar Vuelo
                System.out.println("Consultar Vuelo");
                // Lógica para consultar un vuelo
                break;
            case 14:
                // Consultar Asignación de Tripulación
                System.out.println("Consultar Asignación de Tripulación");
                // Lógica para consultar la asignación de tripulación
                break;
            case 15:
                // Consultar Escalas de un Trayecto
                System.out.println("Consultar Escalas de un Trayecto");
                // Lógica para consultar escalas de un trayecto
                break;
            case 16:
                // Eliminar Escala
                System.out.println("Eliminar Escala");
                // Lógica para eliminar una escala
                break;
            case 17:
                // Registrar Tarifa de Vuelo
                System.out.println("Registrar Tarifa de Vuelo");
                // Lógica para registrar una tarifa de vuelo
                break;
            case 18:
                // Actualizar Tarifa de Vuelo
                System.out.println("Actualizar Tarifa de Vuelo");
                // Lógica para actualizar una tarifa de vuelo
                break;
            case 19:
                // Eliminar Tarifa de Vuelo
                System.out.println("Eliminar Tarifa de Vuelo");
                // Lógica para eliminar una tarifa de vuelo
                break;
            case 20:
                // Consultar Tarifa de Vuelo
                System.out.println("Consultar Tarifa de Vuelo");
                // Lógica para consultar una tarifa de vuelo
                break;
            case 21:
                // Registrar Tipo de Documento
                System.out.println("Registrar Tipo de Documento");
                // Lógica para registrar un tipo de documento
                break;
            case 22:
                // Actualizar Tipo de Documento
                System.out.println("Actualizar Tipo de Documento");
                // Lógica para actualizar un tipo de documento
                break;
            case 23:
                // Eliminar Tipo de Documento
                System.out.println("Eliminar Tipo de Documento");
                // Lógica para eliminar un tipo de documento
                break;
            case 24:
                // Consultar Tipo de Documento
                System.out.println("Consultar Tipo de Documento");
                // Lógica para consultar un tipo de documento
                break;
            case 25:
                // Salir
                System.out.println("Saliendo...");
                // Lógica para salir del menú
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();    
    }
}
