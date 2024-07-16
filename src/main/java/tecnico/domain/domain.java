package tecnico.domain;

import java.util.Scanner;

public class domain {

    public static void registrarRevision() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("aviones");

        System.out.println("Matricula del avión: ");
        String datosAvion=scanner.nextLine();

        System.out.println("Ingresa la fecha");
        String fechaAvion=scanner.nextLine();

        System.out.println("Ingresa los datos de la descripcion");
        String descripcion =scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("empleados");

        System.out.println("Ingresa el ID empleados responsables");
        Integer empleado = scanner.nextInt();
        scanner.nextLine(); 

        tecnico.Interface.dbOutTecnico.dbRegistrarMantenimiento(datosAvion, fechaAvion, descripcion, empleado);


    }
    public static void HistorialdeRevisiones(){
        System.out.println("Ingresa la matricula del avion");
        String matricula=sc.nextLine();
        System.out.println("");

        
    }
}
