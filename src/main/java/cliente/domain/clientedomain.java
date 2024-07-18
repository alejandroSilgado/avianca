
package cliente.domain;

import java.util.Scanner;

public class clientedomain {
    public static void buscarvuelos() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("aviones");

        System.out.println("Ingrese la ciudad de origen: ");
        String ciudadorigen = scanner.nextLine();

        System.out.println("ciudad de destino");
        String ciudaddestino = scanner.nextLine();

        System.out.println("fecha de salida");
        String fechasalida = scanner.nextLine();

        System.out.println("fecha de regreso");
        String fecharegreso = scanner.nextLine();

        // el sistema debe buscar el vuelo disponible en la base de datos y arrojar una
        // lista

        cliente.Interface.dbOutCliente.dbbuscarvuelos(ciudadorigen, ciudaddestino, fechasalida, fecharegreso);

    }

    public static void seleccionarVuelo() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        // el sistema le permite al usuario seleccionar de una lista de vuelos
        // pŕeviamente buscada
        System.out.println("Porfavor ingresa el id del vuelo que quieres seleccionar");
        Integer vueloconsultado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Tu vuelo ha sido confirmado");

    }

    public static void anadirPasajeros() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("porfavor ingresa los datos del pasajero");
        System.out.println("Ingresa el nombre del pasajero");
        String nombrepasajero = scanner.nextLine();

        System.out.println("Ingresa la edad del pasajero");
        Integer edadpasajero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa el tipo de documento");
        String tipodeDocumento = scanner.nextLine();

        System.out.println("Ingresa el numero del documento");
        Integer numeroDocumento = scanner.nextInt();
        scanner.nextLine();

        cliente.Interface.dbOutCliente.dbanadirPasajeros(nombrepasajero, edadpasajero, tipodeDocumento,
                numeroDocumento);

    }

    public static void selecciionarAsientos() {
        Scanner scanner = new Scanner(System.in);

        // El sistema me muestra los asientos disponibles

        System.out.println("Ingresa el id del asiento");
        Integer idasiento = scanner.nextInt();
        scanner.nextLine();

        // el sistema debe permitir guardar los asientos disponibles

    }

    public static void realizarPago() {
        Scanner scanner = new Scanner(System.in);

        // Ojo precondición-para poder ejecutarse el sistema debe haber selecionado los
        // asientos

        System.out.println("Ingresa el metodo de pago");
        String metododePago = scanner.nextLine();

        System.out.println("Ingresa la informaciòn de la tarjeta de credito o debito");
        String informacion = scanner.nextLine();

        cliente.Interface.dbOutCliente.dbrealizarPago(metododePago, informacion);
        // el sistema debe guardar la reserva en la base de datos
    }

    public static void consultarreserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el identificador de la reserva");
        String identificador = scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");
    }

    public static void cancelarreserva() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");

        System.out.println("Ingresa el identificador de la reserva");
        String identificador = scanner.nextLine();

        System.out.println("Ingresa tu correo electronico");
        String correo = scanner.nextLine();

        System.out.println("Porfavor confirma si quieres cancelar esta reserva ");
        String identificadorconfirma = scanner.nextLine();

        System.out.println("Se le enviara un correo donde confirmamos su cancelaciòn");

        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");
    }

    public static void modificarReserva() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");

        System.out.println("Ingresa el identificador de la reserva");
        String identificador = scanner.nextLine();

        // el sistema debe mostrar los detalles de la reserva

        System.out.println("Ingresa la nueva fecha de la reserva");
        String fecha = scanner.nextLine();

        System.out.println("Ingresa los pasajeros ");
        String pasajeros = scanner.nextLine();

        System.out.println("Ingresa los asientos");
        String asientos = scanner.nextLine();

        System.out.println("Se le enviara un correo donde confirmamos su cancelaciòn");

        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");
    }

}
