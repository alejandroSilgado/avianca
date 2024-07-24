package administrador.domain;


import java.sql.SQLException;
import java.util.Scanner;
import administrador.Interface.*;

public class domain {
    public static void main(String[] args) {
        actualizarTipoDocumento();
    }
    public static void registrarAvion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        System.out.println("Ingrese la capacidad del avión: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la fecha de fabricacion del avión: ");
        String fecha = scanner.nextLine();

        // Imprimir aerolíneas
        resources.FuncionesGlobales.ImprimirTabla("estados");
        System.out.println("Ingrese ID del estado del avión: ");
        int estado = scanner.nextInt();
        scanner.nextLine();

        // Imprimir aerolíneas
        resources.FuncionesGlobales.ImprimirTabla("aerolineas");

        System.out.println("Ingrese ID de la aerolínea: ");
        int aerolinea = scanner.nextInt();
        scanner.nextLine();

        // Imprimir modelos de avión
        resources.FuncionesGlobales.ImprimirTabla("modelos");

        System.out.println("Ingrese ID del modelo del avion: ");
        int modelo = scanner.nextInt();
        scanner.nextLine();

        try {
            dbOutAdministrador.agregarAvion(matricula, capacidad, fecha, estado, aerolinea, modelo);
        } catch (SQLException e) {
            System.out.println("Error al agregar avión: " + e.getMessage());
        }
    }

    public static void asignarTripulacion() {
        Scanner scanner = new Scanner(System.in);

        // Imprimir trayectos
        resources.FuncionesGlobales.ImprimirTabla("trayectos");

        System.out.println("Seleccione el ID de un trayecto: ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        // Imprimir empleados
        resources.FuncionesGlobales.ImprimirTabla("empleados");

        System.out.println("Ingrese el ID del empleado a asignar para el trayecto: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        dbOutAdministrador.dbAgregarTripulacion(idEmpleado, idTrayecto);
    }

    public static void consultarAvion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la matricula del avion: ");
        String matricula = scanner.nextLine();

        administrador.Interface.dbOutAdministrador.dbConsultarAvion(matricula);
    }
    
    public static void consultarTrayecto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del trayecto: ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        administrador.Interface.dbOutAdministrador.dbConsultarTrayecto(idTrayecto);
    }

    public static void consultarAeropuerto() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el nombre del aeropuerto: ");
        String nombreAeropuerto = scanner.nextLine();
    
        administrador.Interface.dbOutAdministrador.dbConsultarAreopuerto(nombreAeropuerto);
    }

    public static void actualizarAvion() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("aviones");
        System.out.println("Ingrese el ID del avión a actualizar: ");
        Integer id_avion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    
        System.out.println("Ingrese la nueva matrícula del avión: ");
        String nuevaMatricula = scanner.nextLine();
    
        System.out.println("Ingrese la nueva capacidad del avión: ");
        Integer nuevaCapacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    
        System.out.println("Ingrese la nueva fecha de fabricación (YYYY-MM-DD): ");
        String nuevaFechaFabricacion = scanner.nextLine();

        resources.FuncionesGlobales.ImprimirTabla("estados");
        System.out.println("Ingrese el nuevo ID del estado del avión: ");
        Integer nuevoIdEstado = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        resources.FuncionesGlobales.ImprimirTabla("aerolineas");
        System.out.println("Ingrese el nuevo ID de la aerolínea del avión: ");
        Integer nuevoIdAerolinea = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        resources.FuncionesGlobales.ImprimirTabla("modelos");
        System.out.println("Ingrese el nuevo ID del modelo del avión: ");
        Integer nuevoIdModelo = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    
        administrador.Interface.dbOutAdministrador.dbActualizarAvion(id_avion, nuevaMatricula, nuevaCapacidad, nuevaFechaFabricacion, nuevoIdEstado, nuevoIdAerolinea, nuevoIdModelo);
    }
    
    public static void eliminarAvion() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del avión a eliminar: ");
        Integer id_avion = scanner.nextInt();
    
        administrador.Interface.dbOutAdministrador.dbEliminarAvion(id_avion);
    }
    
    public static void asignarAvion() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("aviones");
        System.out.println("Ingrese el ID del avión a asignar: ");
        Integer id_avion = scanner.nextInt();
        scanner.nextLine(); 
        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        System.out.println("Ingrese el ID del trayecto al que se va a asignar el avión: ");
        Integer id_trayecto = scanner.nextInt();
        scanner.nextLine(); 
        resources.FuncionesGlobales.ImprimirTabla("aeropuertos");
        System.out.println("Ingrese el ID del aeropuerto al que se va a asignar el avión: ");
        Integer id_aeropuerto = scanner.nextInt();
        scanner.nextLine(); 
    
        administrador.Interface.dbOutAdministrador.dbAsignarAvion(id_avion, id_trayecto, id_aeropuerto);
    }
    
    public static void actualizarTrayecto() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        System.out.println("Ingrese el ID del trayecto a actualizar: ");
        Integer idTrayecto = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
    
        System.out.println("Ingrese la nueva fecha del trayecto (YYYY-MM-DD): ");
        String nuevaFechaTrayecto = scanner.nextLine();
    
        System.out.println("Ingrese el nuevo precio del trayecto: ");
        Float nuevoPrecioTrayecto = scanner.nextFloat();
    
        administrador.Interface.dbOutAdministrador.dbActualizarTrayecto(idTrayecto, nuevaFechaTrayecto, nuevoPrecioTrayecto);
    }

    public static void eliminarTrayecto() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("trayectos");

        System.out.println("Ingrese el ID del trayecto a eliminar: ");
        Integer idTrayecto = scanner.nextInt();
    
        administrador.Interface.dbOutAdministrador.dbEliminarTrayecto(idTrayecto);
    }

    public static void actualizarAeropuerto() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("aeropuertos");

        System.out.println("Ingrese el ID del aeropuerto a actualizar: ");
        Integer idAeropuerto = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.println("Ingrese el nuevo nombre del aeropuerto: ");
        String nuevoNombre = scanner.nextLine();
        resources.FuncionesGlobales.ImprimirTabla("ciudades");

        System.out.println("Ingrese el ID de la ciudad para el nuevo aeropuerto: ");
        Integer nuevoIdCiudad = scanner.nextInt();
    
        administrador.Interface.dbOutAdministrador.dbActualizarAeropuerto(idAeropuerto, nuevoNombre, nuevoIdCiudad);
    }
    
    public static void eliminarAeropuerto() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del aeropuerto a eliminar: ");
        Integer idAeropuerto = scanner.nextInt();
    
        administrador.Interface.dbOutAdministrador.dbEliminarAeropuerto(idAeropuerto);
    }

    public static void consultarVuelo() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el número de conexión del vuelo: ");
        String numeroConexion = scanner.nextLine();
    
        administrador.Interface.dbOutAdministrador.dbConsultarVuelo(numeroConexion);
    }
    
    public static void consultarAsignacionTripulacion() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del trayecto para consultar la asignación de tripulación: ");
        Integer idTrayecto = scanner.nextInt();
    
        administrador.Interface.dbOutAdministrador.dbConsultarAsignacionTripulacion(idTrayecto);
    }
    
    public static void consultarEscalasTrayecto() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("trayectos");
        System.out.println("Ingrese el ID del trayecto: ");
        Integer idTrayecto = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
    
        administrador.Interface.dbOutAdministrador.dbConsultarEscalasTrayecto(idTrayecto);
    }

    public static void eliminarEscala() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("escalas");
        System.out.println("Ingrese el ID de la escala a eliminar: ");
        Integer idEscala = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
    
        administrador.Interface.dbOutAdministrador.dbEliminarEscala(idEscala);
    }

    public static void registrarTarifaVuelo() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese la descripción de la tarifa: ");
        String descripcion = scanner.nextLine();
    
        System.out.println("Ingrese los detalles de la tarifa: ");
        String detalles = scanner.nextLine();
    
        System.out.println("Ingrese el valor de la tarifa: ");
        Float valor = scanner.nextFloat();
        scanner.nextLine();  // Consumir el salto de línea
    
        administrador.Interface.dbOutAdministrador.dbRegistrarTarifaVuelo(descripcion, detalles, valor);
    }
    
    public static void actualizarTarifaVuelo() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tarifas_vuelos");
        System.out.println("Ingrese el ID de la tarifa a actualizar: ");
        Integer idTarifa = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        System.out.println("Ingrese la nueva descripción de la tarifa: ");
        String descripcion = scanner.nextLine();
        
        System.out.println("Ingrese los nuevos detalles de la tarifa: ");
        String detalles = scanner.nextLine();
        
        System.out.println("Ingrese el nuevo valor de la tarifa: ");
        Float valor = scanner.nextFloat();
        scanner.nextLine();  // Consumir el salto de línea
        
        administrador.Interface.dbOutAdministrador.dbActualizarTarifaVuelo(idTarifa, descripcion, detalles, valor);
    }
    
    public static void eliminarTarifaVuelo() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tarifas_vuelos");
        System.out.println("Ingrese el ID de la tarifa a eliminar: ");
        Integer idTarifa = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        administrador.Interface.dbOutAdministrador.dbEliminarTarifaVuelo(idTarifa);
    }
    
    public static void consultarTarifaVuelo() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tarifas_vuelos");
        System.out.println("Ingrese el ID de la tarifa a consultar: ");
        Integer idTarifa = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        administrador.Interface.dbOutAdministrador.dbConsultarTarifaVuelo(idTarifa);
    }
    
    public static void registrarTipoDocumento() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del tipo de documento: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la descripción del tipo de documento: ");
        String descripcion = scanner.nextLine();
        
        administrador.Interface.dbOutAdministrador.dbRegistrarTipoDocumento(nombre, descripcion);
    }
    
    public static void actualizarTipoDocumento() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");

        System.out.println("Ingrese el ID del tipo de documento a actualizar: ");
        Integer idTipoDocumento = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        System.out.println("Ingrese el nuevo nombre del tipo de documento: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la nueva descripción del tipo de documento: ");
        String descripcion = scanner.nextLine();
        
        administrador.Interface.dbOutAdministrador.dbActualizarTipoDocumento(idTipoDocumento, nombre, descripcion);
    }
    
    public static void eliminarTipoDocumento() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");

        System.out.println("Ingrese el ID del tipo de documento a eliminar: ");
        Integer idTipoDocumento = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        administrador.Interface.dbOutAdministrador.dbEliminarTipoDocumento(idTipoDocumento);
    }
    
    public static void consultarTipoDocumento() {
        Scanner scanner = new Scanner(System.in);
        resources.FuncionesGlobales.ImprimirTabla("tipos_documentos");

        System.out.println("Ingrese el ID del tipo de documento a consultar: ");
        Integer idTipoDocumento = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        
        administrador.Interface.dbOutAdministrador.dbConsultarTipoDocumento(idTipoDocumento);
    }

}
