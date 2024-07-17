package agente.application;

import java.util.Scanner;
import resources.FuncionesGlobales;

public class appAgente {
    public static void menuAgente() {
        Scanner scanner = new Scanner(System.in);
        FuncionesGlobales.limpiarPantalla();

        System.out.println(" ____  _                           _     _       ");
        System.out.println("| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  ");
        System.out.println("|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ ");
        System.out.println("| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |");
        System.out.println("|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ ");
        System.out.println("   / \\   __ _  ___ _ __ | |_ ___                 ");
        System.out.println("  / _ \\ / _` |/ _ \\ '_ \\| __/ _ \\                ");
        System.out.println(" / ___ \\ (_| |  __/ | | | ||  __/                ");
        System.out.println("/_/   \\_\\__, |\\___|_| |_|\\__\\___|                ");
        System.out.println("        |___/                                    ");
        System.out.println(" ");
        System.out.println("1. Crear reserva");
        System.out.println("2. Consultar Cliente");
        System.out.println("3. Consultar Reserva");
        System.out.println("4. Registrar Cliente");
        System.out.println("5. Actualizar Cliente");
        System.out.println("6. Eliminar Reserva");
        System.out.println("7. Consultar Vuelo");
        System.out.println("8. Consultar Asignación de Tripulación");
        System.out.println("9. Consultar Escalas de un Trayecto");
        System.out.println("10. Consultar Tarifa de Vuelo");
        System.out.println("11. Consultar Tipo de Documento");
        System.out.println("12. Salir");

        System.out.println("Ingrese una opción: ");
        Integer opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agente.domain.agenteDomain.crearReserva();
                return;
            case 2:
                agente.domain.agenteDomain.consultarCliente();
                return;
            case 3:
                agente.domain.agenteDomain.consultarReserva();
                return;
            case 4:
                agente.domain.agenteDomain.registrarCliente();
                return;
            case 5:
                agente.domain.agenteDomain.actualizarCliente();
                return;
            case 6:
                agente.domain.agenteDomain.eliminarReserva();
                return;
            case 7:
                agente.domain.agenteDomain.consultarVuelo();
                return;
            case 8:
                agente.domain.agenteDomain.consultarAsignacionTripulacion();
                return;
            case 9:
                agente.domain.agenteDomain.consultarEscalasTrayecto();
                return;
            case 10:
                agente.domain.agenteDomain.consultarTarifaVuelo();
                return;
            case 11:
                agente.domain.agenteDomain.consultarDocumento();
                return;
            case 12:
                System.out.println("Saliendo...");
                return;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
                break;
        }
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
}
