
package cliente.domain;

import java.util.Scanner;

public class clientedomain {
    public static void buscarvuelos() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("aviones");

        System.out.println("Ingrese la ciudad de origen: ");
        String ciudadorigen=scanner.nextLine();

        System.out.println("ciudad de destino");
        String ciudaddestino=scanner.nextLine();

        System.out.println("fecha de salida");
        String fechasalida =scanner.nextLine();


        System.out.println("fecha de regreso");
        String fecharegreso =scanner.nextLine();


        //el sistema debe buscar el vuelo disponible en la base de datos  y arrojar una lista 



       

        cliente.Interface.dbOutCliente.dbbuscarvuelos(ciudadorigen, ciudaddestino, fechasalida, fecharegreso);


    }

    public static void seleccionarVuelo() {
        Scanner scanner = new Scanner(System.in);

        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        // el sistema le permite al usuario seleccionar de una lista de vuelos pŕeviamente buscada
        System.out.println("Porfavor ingresa el id del vuelo que quieres seleccionar");
        Integer vueloconsultado= scanner.nextInt();
        scanner.nextLine();

        System.out.println("Tu vuelo ha sido confirmado");

        
    }
    public static void anadirPasajeros() {
        Scanner scanner =new Scanner (System.in);

        System.out.println("porfavor ingresa los datos del pasajero");
        System.out.println("Ingresa el nombre del pasajero");
        String nombrepasajero= scanner.nextLine();

        System.out.println("Ingresa la edad del pasajero");
        Integer edadpasajero =scanner.nextInt();
        scanner.nextLine();

    
        System.out.println("Ingresa el tipo de documento");
        String tipodeDocumento= scanner.nextLine();


        System.out.println("Ingresa el numero del documento");
        Integer numeroDocumento =scanner.nextInt();
        scanner.nextLine();


        cliente.Interface.dbOutCliente.dbanadirPasajeros(nombrepasajero, edadpasajero, tipodeDocumento, numeroDocumento);

        
  



    }

   
}
