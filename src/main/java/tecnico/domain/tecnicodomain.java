
package tecnico.domain;

import java.util.Scanner;

public class tecnicodomain {
    public static void registrarRevision() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("aviones");
        System.out.println("ingresa el id del avión");
        Integer datosAvion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa la fecha");
        String fechaAvion = scanner.nextLine();
        System.out.println("Ingresa la descripcion de la reparacion: ");
        String descripcion = scanner.nextLine();

        // imprimir empleado
        resources.FuncionesGlobales.ImprimirTabla("empleados");
        System.out.println("Ingresa el ID empleados responsable de la revisiòn");
        Integer responsable = scanner.nextInt();
        scanner.nextLine();

        tecnico.Interface.dbOutTecnico.dbRegistrarMantenimiento(datosAvion, fechaAvion, descripcion, responsable);
    }

    public static void historialdeRevisiones() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("aviones");
        System.out.println("Ingresa la matricula del avion");
        String matricula = scanner.nextLine();

        tecnico.Interface.dbOutTecnico.dbConsultarRevisiones(matricula);
    }

    public static void actualizarRevision(){
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("revisiones");
        System.out.println("ingresa el ID de la revision: ");
        Integer id_revision=scanner.nextInt();
        scanner.nextLine();

        // el sistema debe mostrar la informacion actual de la revision
        System.out.println("Ingresa la nueva fecha de la revisiòn");
        String fechaAvion=scanner.nextLine();

        System.out.println("Ingresa la nueva descripcion de la revisiòn");
        String descripcion=scanner.nextLine();
        // imprimir empleado
        resources.FuncionesGlobales.ImprimirTabla("empleados");

        System.out.println("Ingresa el ID del empleado responsable de la revisiòn");
        Integer responsable = scanner.nextInt();
        scanner.nextLine();

        tecnico.Interface.dbOutTecnico.dbActualizarRevision(id_revision, fechaAvion, descripcion, responsable);
    }

    public static void Eliminarrevision() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingresa porfavor  el identificador de la revision");
        int identificador = scanner.nextInt();
        scanner.nextLine();

        tecnico.Interface.dbOutTecnico.dbEliminarRevision(identificador);

    }

}
