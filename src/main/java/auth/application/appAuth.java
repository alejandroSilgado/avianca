package auth.application;

import java.util.Scanner;
import resources.FuncionesGlobales;

public class appAuth {

    public static void menuInicioSesion() {
        FuncionesGlobales.limpiarPantalla();
        System.out.println(" ___ _   _ ___ ____ ___ ___    ____  _____   ____  _____ ____ ___ ___  _   _ ");
        System.out.println("|_ _| \\ | |_ _/ ___|_ _/ _ \\  |  _ \\| ____| / ___|| ____/ ___|_ _/ _ \\| \\ | |");
        System.out.println(" | ||  \\| || | |    | | | | | | | | |  _|   \\___ \\|  _| \\___ \\| | | | |  \\| |");
        System.out.println(" | || |\\  || | |___ | | |_| | | |_| | |___   ___) | |___ ___) | | |_| | |\\  |");
        System.out.println("|___|_| \\_|___\\____|___\\___/  |____/|_____| |____/|_____|____/___\\___/|_| \\_|");

        auth.domain.domain.sistemaIniciarSesion();
    }

    public static void menuCrearCuenta() {
        FuncionesGlobales.limpiarPantalla();

        System.out.println("  ____ ____  _____    _    ____     ____ _   _ _____ _   _ _____  _    \r\n" + //
                " / ___|  _ \\| ____|  / \\  |  _ \\   / ___| | | | ____| \\ | |_   _|/ \\   \r\n" + //
                "| |   | |_) |  _|   / _ \\ | |_) | | |   | | | |  _| |  \\| | | | / _ \\  \r\n" + //
                "| |___|  _ <| |___ / ___ \\|  _ <  | |___| |_| | |___| |\\  | | |/ ___ \\ \r\n" + //
                " \\____|_| \\_\\_____/_/   \\_\\_| \\_\\  \\____|\\___/|_____|_| \\_| |_/_/   \\_\\");

        auth.domain.domain.sistemaCrearCuenta();
    }

    public static void menuPrincipal() {
        FuncionesGlobales.limpiarPantalla();
        Scanner scanner = new Scanner(System.in);
        System.out.println("  ____ _____ ____ _____ ___  ____       ___     _____    _    _   _  ____    _    \r\n" + //
                " / ___| ____/ ___|_   _/ _ \\|  _ \\     / \\ \\   / /_ _|  / \\  | \\ | |/ ___|  / \\   \r\n" + //
                "| |  _|  _| \\___ \\ | || | | | |_) |   / _ \\ \\ / / | |  / _ \\ |  \\| | |     / _ \\  \r\n" + //
                "| |_| | |___ ___) || || |_| |  _ <   / ___ \\ V /  | | / ___ \\| |\\  | |___ / ___ \\ \r\n" + //
                " \\____|_____|____/ |_| \\___/|_| \\_\\ /_/   \\_\\_/  |___/_/   \\_\\_| \\_|\\____/_/   \\_\\");
        System.out.println("");
        System.out.println("1. Inicar Sesion ");
        System.out.println("2. Crear Cuenta ");
        System.out.println("");

        System.out.println("Ingrese una opcion: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                menuInicioSesion(); // Lógica para registrar un avión
                break;
            case 2:
                menuCrearCuenta();
                return;
            default:
                System.out.println("Opción no válida. Por favor, intente nuevamente.");
                break;
        }
    }
}
