package agente.domain;

import java.util.Scanner;

public class agenteDomain {

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

        System.out.println("Ingrese la tarifa : ");
        Float tarifa = scanner.nextFloat();
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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese la contraseña: ");
        String contraseña = scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");
        System.out.print("Ingrese el ID del tipo  documento: ");
        int tipo_documento = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el número de documento: ");
        String numeroDocumento = scanner.nextLine();

        agente.Interface.dbOutAgente.dbregistrarCliente(nombre, edad, email, contraseña, tipo_documento,
                numeroDocumento);

    }

    public static void actualizarCliente() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("clientes");
        System.out.print("Ingrese el ID del cliente a actualizar: ");
        String idcliente = scanner.nextLine();

        // Verificar si el cliente existe en la base de datos
        boolean existeCliente = agente.Interface.dbOutAgente.verificarCliente(idcliente);
        if (!existeCliente) {
            System.out.println("El cliente con ID " + idcliente + " no existe.");
            return;
        }

        // Solicitar nuevos datos del cliente
        System.out.print("Ingrese el nuevo nombre (deje en blanco para no modificar): ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la nueva edad (deje en blanco para no modificar): ");
        String edadStr = scanner.nextLine();
        Integer edad = null;
        if (!edadStr.isEmpty()) {
            edad = Integer.parseInt(edadStr);
        }

        System.out.print("Ingrese el nuevo email (deje en blanco para no modificar): ");
        String email = scanner.nextLine();

        System.out.print("Ingrese la nueva contraseña (deje en blanco para no modificar): ");
        String contraseña = scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");
        System.out.print("Ingrese el nuevo ID del tipo documento (deje en blanco para no modificar): ");
        String tipoDocumentoStr = scanner.nextLine();
        Integer tipo_documento = null;
        if (!tipoDocumentoStr.isEmpty()) {
            tipo_documento = Integer.parseInt(tipoDocumentoStr);
        }

        System.out.print("Ingrese el nuevo número de documento (deje en blanco para no modificar): ");
        String numeroDocumento = scanner.nextLine();

        // Actualizar el cliente en la base de datos
        agente.Interface.dbOutAgente.dbActualizarCliente(idcliente, nombre, edad, email, contraseña, tipo_documento,
                numeroDocumento);
    }

    public static void eliminarReserva() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");
        System.out.print("Ingrese el ID de la reserva a eliminar: ");
        Integer idReserva = scanner.nextInt();
        scanner.nextLine();

        agente.Interface.dbOutAgente.dbeliminarReserva(idReserva);
    }

    public static void consultarVuelo() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numero de conexion del vuelo: ");
        String numeroConexion = scanner.nextLine();

        agente.Interface.dbOutAgente.dbconsultarVuelo(numeroConexion);
    }

    public static void consultarAsignacionTripulacion() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        System.out.println("Ingrese el identificador del trayecto:");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        agente.Interface.dbOutAgente.dbconsultarAsignacionTripulacion(idTrayecto);

    }

    public static void consultarEscalasTrayecto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el identificador del trayecto:");
        int idTrayecto = scanner.nextInt();

        agente.Interface.dbOutAgente.dbconsultarEscalasTrayecto(idTrayecto);
    }

    public static void consultarTarifaVuelo() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("conexiones_vuelos");
        System.out.println("Ingrese el identificador del vuelo:");
        int idVuelo = scanner.nextInt();

        agente.Interface.dbOutAgente.dbconsultarTarifaVuelo(idVuelo);
    }

    public static void consultarDocumento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el identificador del tipo de documento:");
        int idTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        agente.Interface.dbOutAgente.dbconsultarDocumento(idTipoDocumento);
    }
}
