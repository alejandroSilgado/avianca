package tecnico.domain;

import java.util.Scanner;

public class domain {
    public static void registrarRevision() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa los datos del avión");
        String datosAvion=scanner.nextLine();
        System.out.println("Ingresa la fecha");
        String fechaAvion=scanner.nextLine();
        System.out.println("Ingresa los datos de la descripcion");
        String descripcion =scanner.nextLine();

        // imprimir empleado
        System.out.println("Ingresa el ID empleados responsables");
        String responsable = scanner.nextLine();

    }
    public static void HistorialdeRevisiones(){
        System.out.println("Ingresa la matricula del avion");
        String matricula=sc.nextLine();
        System.out.println("");

        
    }
}
