package tecnico.domain;

import java.util.Scanner;

public class domain {
    public static void ingresaDeatalles() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese la capacidad del avión: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();
        
    }
}
