
package tecnico.domain;

import java.util.Scanner;

public class tecnicodomain {
    public static void main(String[] args) {
        registrarRevision();
    }
    public static void registrarRevision() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("aviones");
        System.out.println("ingresa el id del avión");
        Integer datosAvion=scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa la fecha");
        String fechaAvion=scanner.nextLine();
        System.out.println("Ingresa los datos de la descripcion");
        String descripcion =scanner.nextLine();

        // imprimir empleado
        resources.FuncionesGlobales.ImprimirTabla("empleados");
        System.out.println("Ingresa el ID empleados responsable de la revisiòn");
        Integer responsable=scanner.nextInt();
        scanner.nextLine();        
        
        tecnico.Interface.dbOutTecnico.dbRegistrarMantenimiento(datosAvion, fechaAvion, descripcion, responsable);
    }
    public static void historialdeRevisiones(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la matricula del avion");
        String matricula=scanner.nextLine();
        // el sistema debe buscar y mostrar el historial de revisiones 
        System.out.println("");

    }
    public static void actualizarRevision(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("ingresa el identificador de la revision");
        String datosAvion=scanner.nextLine();
        // el sistema debe mostrar la informacion actual de la revision
        System.out.println("Ingresa porfavor los Nuevos detalles de la revisiòn");
        String fechaAvion=scanner.nextLine();
       
        // imprimir empleado
        System.out.println("Ingresa el ID del empleado responsable de la revisiòn");
        String responsable = scanner.nextLine();
    }

    public static void Eliminarrevision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingresa porfavor  el identificador de la revision");
        int identificador= scanner.nextInt();
        scanner.nextLine();

        // el sistema valida la existencia de la revision
        
        System.out.println("El sistema elimino de manera exitosa la revisiòn");

        


       
    }


}
