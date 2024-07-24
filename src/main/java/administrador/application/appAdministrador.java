package administrador.application;

import java.util.Scanner;
import administrador.domain.*;
import resources.FuncionesGlobales;

public class appAdministrador {
    public static void menuAdministrador() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            FuncionesGlobales.limpiarPantalla();
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
            System.out.println("1. Registrar Avión ");
            System.out.println("2. Asignar Tripulación");
            System.out.println("3. Consultar Avión ");
            System.out.println("4. Consultar Trayecto ");
            System.out.println("5. Consultar Aeropuerto ");
            System.out.println("6. Actualizar Avión ");
            System.out.println("7. Eliminar Avión ");
            System.out.println("8. Actualizar Trayecto ");
            System.out.println("9. Eliminar Trayecto ");
            System.out.println("10. Actualizar Aeropuerto"); 
            System.out.println("11. Eliminar Aeropuerto ");
            System.out.println("12. Consultar Vuelo ");
            System.out.println("13. Consultar Asignación de Tripulación"); 
            System.out.println("14. Consultar Escalas de un Trayecto ");
            System.out.println("15. Eliminar Escala");
            System.out.println("16. Registrar Tarifa de Vuelo"); 
            System.out.println("17. Actualizar Tarifa de Vuelo");
            System.out.println("18. Eliminar Tarifa de Vuelo");
            System.out.println("19. Consultar Tarifa de Vuelo "); 
            System.out.println("20. Registrar Tipo de Documento");
            System.out.println("21. Actualizar Tipo de Documento");
            System.out.println("22. Eliminar Tipo de Documento");
            System.out.println("23. Consultar Tipo de Documento");
            System.out.println("24. Salir");
            System.out.println(" ");

            System.out.println("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    domain.registrarAvion();             
                    break;
                case 2:
                    domain.asignarTripulacion();
                    break;
                case 3:
                    domain.consultarAvion();
                    break;
                case 4:
                    domain.consultarTrayecto();
                    break;
                case 5:
                    domain.consultarAeropuerto();
                    break;
                case 6:
                    domain.actualizarAvion();
                    break;
                case 7:
                    domain.eliminarAvion();
                    break;
                case 8:
                    domain.actualizarTrayecto();
                    break;
                case 9:
                    domain.eliminarTrayecto();
                    break;
                case 10:
                    domain.actualizarAeropuerto();
                    break;
                case 11:
                    domain.eliminarAeropuerto();
                    break;
                case 12:
                    domain.consultarVuelo();
                    break;
                case 13:
                    domain.consultarAsignacionTripulacion();
                    break;
                case 14:
                    domain.consultarEscalasTrayecto();
                    break;
                case 15:
                    domain.eliminarEscala();
                    break;
                case 16:
                    domain.registrarTarifaVuelo();
                    break;
                case 17:
                    domain.actualizarTarifaVuelo();
                    break;
                case 18:
                    domain.eliminarTarifaVuelo();
                    break;
                case 19:
                    domain.consultarTarifaVuelo();
                    break;
                case 20:
                    domain.registrarTipoDocumento();
                    break;
                case 21:
                    domain.actualizarTipoDocumento();
                    break;
                case 22:
                    domain.eliminarTipoDocumento();
                    break;
                case 23:
                    domain.consultarTipoDocumento();
                    break;
                case 24:
                    System.out.println("Volviendo al menu principal...");
                    auth.application.appAuth.menuPrincipal();
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

            if (continuar) {
                System.out.print("Presione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}
