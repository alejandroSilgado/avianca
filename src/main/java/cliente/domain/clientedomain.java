
package cliente.domain;

import java.util.Scanner;

public class clientedomain {
    public static void main(String[] args) {
        consultarreserva();
    }

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

        cliente.Interface.dbOutCliente.dbbuscarvuelos(ciudadorigen, ciudaddestino, fechasalida, fecharegreso);

    }

    public static void seleccionarVuelo() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("conexiones_vuelos");
        // el sistema le permite al usuario seleccionar de una lista de vuelos
        // pŕeviamente buscada
        System.out.println("Ingresa el id del vuelo que quieres seleccionar: ");
        Integer vueloconsultado = scanner.nextInt();
        scanner.nextLine();

        cliente.Interface.dbOutCliente.dbseleccionarVuelo(vueloconsultado);

    }

    public static void anadirPasajeros() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("porfavor ingresa los datos del pasajero");
        System.out.println("Ingresa el nombre del pasajero: ");
        String nombrepasajero = scanner.nextLine();

        System.out.println("Ingresa la edad del pasajero");
        Integer edadpasajero = scanner.nextInt();
        scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");
        System.out.println("Ingresa el tipo de documento");
        Integer tipodeDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingresa el numero del documento");
        String numeroDocumento = scanner.nextLine();

        cliente.Interface.dbOutCliente.dbAñadirPasajeros(nombrepasajero, edadpasajero, tipodeDocumento,
                numeroDocumento);

    }
    
    public static void seleccionarAsientos() {
        String[] asientos = {"1A", "1B", "1C", "1D", "2A", "2B", "2C", "2D"};
        boolean[] asientosSeleccionados = new boolean[asientos.length];
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el documento del cliente: ");
        int documento = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea
    
        Integer idCliente = cliente.Interface.dbOutCliente.clienteExiste(documento);
        
        if (idCliente == null) {
            System.out.println("Cliente no encontrado. No se puede proceder con la selección de asientos.");
            scanner.close();
            return;
        }
    
        while (true) {
            System.out.print("Asientos disponibles: ");
            for (int i = 0; i < asientos.length; i++) {
                if (!asientosSeleccionados[i]) {
                    System.out.print(asientos[i] + " ");
                }
            }
            System.out.println();
    
            System.out.println("Ingresa el ID del asiento o 'salir' para terminar:");
            String idAsiento = scanner.nextLine();
    
            if (idAsiento.equalsIgnoreCase("salir")) {
                break;
            }
    
            int indiceAsiento = -1;
            for (int i = 0; i < asientos.length; i++) {
                if (asientos[i].equals(idAsiento)) {
                    indiceAsiento = i;
                    break;
                }
            }
    
            if (indiceAsiento == -1) {
                System.out.println("ID de asiento no válido. Intente nuevamente.");
                continue;
            }
    
            if (asientosSeleccionados[indiceAsiento]) {
                System.out.println("Asiento ya seleccionado. Intente nuevamente.");
            } else {
                asientosSeleccionados[indiceAsiento] = true;
                System.out.println("Asiento " + asientos[indiceAsiento] + " seleccionado con éxito.");

                cliente.Interface.dbOutCliente.guardarSeleccionAsiento(asientos[indiceAsiento], idCliente);
                break;
            }
        }
    
        scanner.close();
    }
    
    public static void realizarPago() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el metodo de pago");
        String metododePago = scanner.nextLine();

        System.out.println("Ingresa la informaciòn de la tarjeta de credito o debito");
        String informacion = scanner.nextLine();

        System.out.println("Ingresa el CVC de la tarjeta");
        String CVC = scanner.nextLine();
        
        System.out.println("Pago realizado con exito");
    }

    public static void consultarreserva() {
        Scanner scanner = new Scanner(System.in);
        // toca poner un id deñ 1 al 5 
        System.out.println("Ingresa el ID de la reserva");
        Integer identificador = scanner.nextInt();
        scanner.nextLine();

        cliente.Interface.dbOutCliente.dbconsultarReserva(identificador);
    }

    public static void cancelarreserva() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("detalles_reservas_trayectos");

        System.out.println("Ingresa el identificador de la reserva");
        String identificador = scanner.nextLine();

        System.out.println("Porfavor confirma si quieres cancelar esta reserva ");
        String identificadorconfirma = scanner.nextLine();


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

    }

}
