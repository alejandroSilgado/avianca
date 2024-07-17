
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

       

        cliente.Interface.dbOutCliente.dbbuscarvuelos(ciudadorigen, ciudaddestino, fechasalida, fecharegreso);


    }
   
}
