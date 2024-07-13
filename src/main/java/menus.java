public class menus {
    public static void main(String[] args) {
        menuAdministrador();
        menuAgente();
        menuCliente();
        menuTecnico();
    }
    public static void menuAdministrador(){
        System.out.println(" ____  _                           _     _                      \r\n" + //
                        "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___                 \r\n" + //
                        "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\                \r\n" + //
                        "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |               \r\n" + //
                        "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   _            \r\n" + //
                        "   / \\   __| |_ __ ___ (_)_ __ (_)___| |_ __ _  __| | ___  _ __ \r\n" + //
                        "  / _ \\ / _` | '_ ` _ \\| | '_ \\| / __| __/ _` |/ _` |/ _ \\| '__|\r\n" + //
                        " / ___ \\ (_| | | | | | | | | | | \\__ \\ || (_| | (_| | (_) | |   \r\n" + //
                        "/_/   \\_\\__,_|_| |_| |_|_|_| |_|_|___/\\__\\__,_|\\__,_|\\___/|_|   ");
        System.out.println(" ");
        System.out.println("2. Registrar Avion ");
        System.out.println("3. Asignar Tripulación");
        System.out.println("4. Consultar Avión ");
        System.out.println("5. Consultar Trayecto ");
        System.out.println("6. Consultar Aeropuerto ");
        System.out.println("7. Actualizar Avión ");
        System.out.println("8. Eliminar Avión ");
        System.out.println("9. Actualizar Trayecto ");
        System.out.println("10. Eliminar Trayecto ");
        System.out.println("11. Actualizar Aeropuerto");
        System.out.println("12. Eliminar Aeropuerto ");
        System.out.println("13. Consultar vuelo ");
        System.out.println("14. Consultar Asignación de Tripulación");
        System.out.println("15. Consultar Escalas de un Trayecto ");
        System.out.println("16. Eliminar Escala");
        System.out.println("17. Registrar Tarifa de Vuelo");
        System.out.println("18. Actualizar Tarifa de Vuelo");
        System.out.println("19. Eliminar Tarifa de Vuelo");
        System.out.println("20. Consultar Tarifa de Vuelo ");
        System.out.println("21. Registrar Tipo de Documento");
        System.out.println("22. Actualizar Tipo de Documento");
        System.out.println("23. Eliminar Tipo de Documento");
        System.out.println("24. Consultar Tipo de Documento");
        System.out.println("25. Salir");
    }
    public static void menuAgente(){
        System.out.println(" ____  _                           _     _       \r\n" + //
                        "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
                        "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
                        "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
                        "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
                        "   / \\   __ _  ___ _ __ | |_ ___                 \r\n" + //
                        "  / _ \\ / _` |/ _ \\ '_ \\| __/ _ \\                \r\n" + //
                        " / ___ \\ (_| |  __/ | | | ||  __/                \r\n" + //
                        "/_/   \\_\\__, |\\___|_| |_|\\__\\___|                \r\n" + //
                        "        |___/             ");
                        System.out.println(" ");
                        System.out.println("1. Crear reserva");
                        System.out.println("2. Consultar CLiente");
                        System.out.println("3. Consultar Reserva");
                        System.out.println("4. Registrar  CLiente");
                        System.out.println("5. Actualizar cliente ");
                        System.out.println("6. ELiminar reserva ");
                        System.out.println("7. Consultar Vuelo");
                        System.out.println("8. Consultar Asignación de Tripulación ");
                        System.out.println("9. Consultar Escalas de un Trayecto");
                        System.out.println("10. Consultar Tarifa de Vuelo");
                        System.out.println("11. Consultar Tipo de Documento");
                        System.out.println("12. Salir");

    }
    public static void menuCliente(){
        System.out.println(" ____  _                           _     _       \r\n" + //
                        "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
                        "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
                        "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
                        "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
                        " / ___| (_) ___ _ __ | |_ ___                    \r\n" + //
                        "| |   | | |/ _ \\ '_ \\| __/ _ \\                   \r\n" + //
                        "| |___| | |  __/ | | | ||  __/                   \r\n" + //
                        " \\____|_|_|\\___|_| |_|\\__\\___|   ");
                        System.out.println(" ");
                        System.out.println("1. Buscar Vuelos");
                        System.out.println("2. Seleccionar Vuelo");
                        System.out.println("3. Añadir Pasajeros");
                        System.out.println("4. Seleccionar Asientos");
                        System.out.println("5. Realizar Pago");
                        System.out.println("6. Consultar Reserva de Vuelo");
                        System.out.println("7. Cancelar Reserva de Vuelo");
                        System.out.println("8. Modificar Reserva de Vuelo");
                        System.out.println("9. Salir");


    }
    public static void menuTecnico(){
        System.out.println(" ____  _                           _     _       \r\n" + //
                        "| __ )(_) ___ _ ____   _____ _ __ (_) __| | ___  \r\n" + //
                        "|  _ \\| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\ \r\n" + //
                        "| |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) |\r\n" + //
                        "|____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/ \r\n" + //
                        "|_   _|__  ___ _ __ (_) ___ ___                  \r\n" + //
                        "  | |/ _ \\/ __| '_ \\| |/ __/ _ \\                 \r\n" + //
                        "  | |  __/ (__| | | | | (_| (_) |                \r\n" + //
                        "  |_|\\___|\\___|_| |_|_|\\___\\___/ ");
                        System.out.println(" ");
                        System.out.println("1. Registrar Revisión");
                        System.out.println("2. Consultar Historial de Revisiones");
                        System.out.println("3. Actualizar Revisión");
                        System.out.println("4. Eliminar Revisión");
                        System.out.println("5. Salir");

    }
    }

