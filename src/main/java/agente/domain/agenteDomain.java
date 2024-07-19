package agente.domain;

import java.util.Scanner;

public class agenteDomain {
    public static void main(String[] args) {
        consultarReserva();
    }
    public static void crearReserva() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("clientes");
        System.out.println("Ingrese el ID del cliente: ");
        Integer id_cliente = scanner.nextInt();
        scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        System.out.println("Ingrese el ID del trayecto : ");
        Integer id_trayecto = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la fecha del trayecto: ");
        String fecha = scanner.nextLine();

        System.out.println("Ingrese el ID de : ");
        Integer tarifa = scanner.nextInt();
        scanner.nextLine();

        agente.Interface.dbOutAgente.dbCrearReserva(id_cliente, id_trayecto, fecha, tarifa);

    }
    public static void consultarCliente() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el documento del cliente: ");
        Integer id_documento = scanner.nextInt();
        scanner.nextLine();
    
        agente.Interface.dbOutAgente.dbconsultarCliente(id_documento);
    
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
    
    
    public static void consultarReserva() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el documento del cliente: ");
        Integer id_documento = scanner.nextInt();
        scanner.nextLine();
    
        agente.Interface.dbOutAgente.dbconsultarReserva(id_documento);
    
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
    }
    public static void registrarCliente() {
        
    }
    public static void actualizarCliente() {
        
    }
    public static void eliminarReserva() {
        
    }
    public static void consultarVuelo() {
        
    }
    public static void consultarAsignacionTripulacion() {
        
    }
    public static void consultarEscalasTrayecto() {
        
    }
    public static void consultarTarifaVuelo() {
        
    }
    public static void consultarDocumento() {
        
    }

}
