package cliente.application;

import java.util.Scanner;

import cliente.domain.clientedomain;
import resources.FuncionesGlobales;

public class appCliente {
    public static void menuCliente() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            FuncionesGlobales.limpiarPantalla();
            System.out.println(" ____  _                           _     _       \r\n" + //
                            "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
                            "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
                            "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
                            "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
                            " / ___| (_) ___ _ __ | |_ ___                    \r\n" + //
                            "| |   | | |/ _ \\ '_ \\| __/ _ \\                   \r\n" + //
                            "| |___| | |  __/ | | | ||  __/                   \r\n" + //
                            " \\____|_|_|\\___|_| |_|\\__\\___|   ");
            System.out.println(" ");
            System.out.println("1. Buscar Vuelos");
            System.out.println("2. Seleccionar Vuelo");
            System.out.println("3. Añadir Pasajeros");
            System.out.println("4. Seleccionar Asientos");
            System.out.println("5. Realizar Pago");
            System.out.println("6. Consultar Reserva de Vuelo");
            System.out.println("7. Cancelar Reserva de Vuelo");
            System.out.println("8. Modificar Reserva de Vuelo");
            System.out.println("9. Salir");
            
            System.out.println("Ingrese una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    clientedomain.buscarvuelos();
                    break;
                case 2:
                    clientedomain.seleccionarVuelo();
                    break;
                case 3:
                    clientedomain.anadirPasajeros();
                    break;
                case 4:
                    clientedomain.seleccionarAsientos();
                    break;
                case 5:
                    clientedomain.realizarPago();
                    break;
                case 6:
                    clientedomain.consultarreserva();
                   break;
                case 7:
                    clientedomain.cancelarreserva();
                  break;
                case 8:
                  clientedomain.modificarReserva();
                  break;
                case 9:
                    System.out.println("Volviendo al menu....");
                    auth.application.appAuth.menuPrincipal();
                    salir = true;
                    break; 
                default:
                  System.out.println("Opción no válida. Por favor, intente de nuevo.");
                  break;
            }

            if (!salir) {
                System.out.print("Presione Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
