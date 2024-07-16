package auth.domain;

import java.util.Scanner;

public class domain {
    public static void sistemaIniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        auth.Interface.dbOutAuth.dbIngresoUsuario(email, password);
    }

    public static void sistemaCrearCuenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del usuario: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el email del usuario: ");
        String email = scanner.nextLine();

        System.out.println("Ingrese la contraseña del usuario: ");
        String contraseña = scanner.nextLine();

        auth.Interface.dbOutAuth.dbcrearUsuario(nombre, apellido, email, contraseña);

        System.out.println("Usuario creado exitosamente.");
    }

}
