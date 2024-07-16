package agente.application;

import java.util.Scanner;

import resources.FuncionesGlobales;

public class appAgente {
    public static void menuAgente() {
        Scanner scanner = new Scanner(System.in);
        FuncionesGlobales.limpiarPantalla();

            System.out.println(" ____  _                           _     _       \r\n" + //
                            "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
                            "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
                            "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
                            "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
                            "   / \\   __ _  ___ _ __ | |_ ___                 \r\n" + //
                            "  / _ \\ / _` |/ _ \\ '_ \\| __/ _ \\                \r\n" + //
                            " / ___ \\ (_| |  __/ | | | ||  __/                \r\n" + //
                            "/_/   \\_\\__, |\\___|_| |_|\\__\\___|                \r\n" + //
                            "        |___/             ");
                            System.out.println(" ");
                            System.out.println("1. Crear reserva");
                            System.out.println("2. Consultar CLiente");
                            System.out.println("3. Consultar Reserva");
                            System.out.println("4. Registrar  CLiente");
                            System.out.println("5. Actualizar cliente ");
                            System.out.println("6. ELiminar reserva ");
                            System.out.println("7. Consultar Vuelo");
                            System.out.println("8. Consultar Asignación de Tripulación ");
                            System.out.println("9. Consultar Escalas de un Trayecto");
                            System.out.println("10. Consultar Tarifa de Vuelo");
                            System.out.println("11. Consultar Tipo de Documento");
                            System.out.println("12. Salir");
    
        }

        System.out.println("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                
                break;
            case 2:
                break;

            case 3:
                break;

            case 4:
                break;

            case 5:
                break;

            default:
                break;
        }
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();    
    }
}

