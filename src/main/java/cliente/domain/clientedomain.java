
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

    
   
}
