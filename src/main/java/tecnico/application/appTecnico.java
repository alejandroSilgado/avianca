package tecnico.application;

import java.util.Scanner;

import resources.FuncionesGlobales;

public class appTecnico {
    public static void menuTecnico() {
        FuncionesGlobales.limpiarPantalla();

        Scanner scanner = new Scanner(System.in);

        System.out.println(" ____  _                           _     _       \r\n" + //
        "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
        "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
        "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
        "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
        "|_   _|__  ___ _ __ (_) ___ ___                  \r\n" + //
        "  | |/ _ \\/ __| '_ \\| |/ __/ _ \\                 \r\n" + //
        "  | |  __/ (__| | | | | (_| (_) |                \r\n" + //
        "  |_|\\___|\\___|_| |_|_|\\___\\___/ ");
        System.out.println(" ");
        System.out.println("1. Registrar Revisión");
        System.out.println("2. Consultar Historial de Revisiones");
        System.out.println("3. Actualizar Revisión");
        System.out.println("4. Eliminar Revisión");
        System.out.println("5. Salir");

        System.out.println("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                tecnico.domain.tecnicodomain.registrarRevision();
                return;
            case 2:
                tecnico.domain.tecnicodomain.historialdeRevisiones();
                return;
            case 3:
                tecnico.domain.tecnicodomain.actualizarRevision();
                return;
            case 4:
                tecnico.domain.tecnicodomain.Eliminarrevision();
                return;
            case 5:
                System.out.println("Saliendo...");
                return;
            default:
                break;
        }
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();    
    }
}
