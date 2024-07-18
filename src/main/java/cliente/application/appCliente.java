package cliente.application;

import java.util.Scanner;

import resources.FuncionesGlobales;

public class appCliente {
    public static void menuCliente() {
        Scanner scanner = new Scanner(System.in);
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
                cliente.domain.clientedomain.buscarvuelos();
                break;
            case 2:
            cliente.domain.clientedomain.seleccionarVuelo();
                break;

            case 3:
            cliente.domain.clientedomain.anadirPasajeros();
                break;

            case 4:
            cliente.domain.clientedomain.selecciionarAsientos();
                break;

            case 5:
            cliente.domain.clientedomain.realizarPago();
                break;
            case 6:
            cliente.domain.clientedomain.consultarreserva();
               break;
            case 7:
            cliente.domain.clientedomain.cancelarreserva();
              break;
            case 8:
            cliente.domain.clientedomain.modificarReserva();
              break;
            case 9:
              break; 
            default:
              break;
        }
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();    
    }
}
