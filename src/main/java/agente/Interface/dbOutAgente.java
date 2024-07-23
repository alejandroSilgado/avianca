package agente.Interface;

import java.sql.*;

import resources.ConexionBD;

public class dbOutAgente {
    // error
    public static void dbCrearReserva(Integer clienteId, Integer trayectoId, String fecha, Float tarifa_precio) {
        String sqlReservaTrayecto = "INSERT INTO reservas_trayectos (id_trayecto) VALUES (?)";
        String sqlDetalle = "INSERT INTO detalles_reservas_trayectos (id_reserva_trayecto, id_cliente) VALUES (?, ?)";
        String sqlTrayecto = "INSERT INTO trayectos (fecha_trayecto, precio_trayecto) VALUES (?, ?)";
        
        try (Connection conn = ConexionBD.getConnection()) {
            conn.setAutoCommit(false);
            
            try (PreparedStatement pstmTrayecto = conn.prepareStatement(sqlTrayecto, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pstmReservaTrayecto = conn.prepareStatement(sqlReservaTrayecto, Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement pstmDetalle = conn.prepareStatement(sqlDetalle)) {
    
                // Si no se proporciona un trayectoId, creamos uno nuevo
                if (trayectoId == null) {
                    pstmTrayecto.setString(1, fecha);
                    pstmTrayecto.setFloat(2, tarifa_precio);
                    pstmTrayecto.executeUpdate();
    
                    try (ResultSet generatedKeys = pstmTrayecto.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            trayectoId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("No se pudo obtener el ID del trayecto creado.");
                        }
                    }
                }
    
                // Insertar en la tabla reservas_trayectos
                pstmReservaTrayecto.setInt(1, trayectoId);
                pstmReservaTrayecto.executeUpdate();
    
                int reservaTrayectoId;
                try (ResultSet generatedKeys = pstmReservaTrayecto.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        reservaTrayectoId = generatedKeys.getInt(1);
                    } else {
                        throw new SQLException("No se pudo obtener el ID de la reserva de trayecto creada.");
                    }
                }
    
                // Insertar en la tabla detalles_reservas_trayectos
                pstmDetalle.setInt(1, reservaTrayectoId);
                pstmDetalle.setInt(2, clienteId);
                pstmDetalle.executeUpdate();
    
                conn.commit();
                System.out.println("Reserva registrada exitosamente.");
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al guardar la Reserva", e);
        }
    }
    // Funcional
    public static void dbconsultarCliente(Integer documento) {
        String sql = "SELECT c.nombre, c.edad, c.email, t.nombre AS tipo_documento " +
                     "FROM clientes AS c " +
                     "JOIN tipos_documentos AS t ON c.id_documento = t.id " +
                     "WHERE c.documento = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
    
            pstm.setInt(1, documento);
    
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    int edad = rs.getInt("edad");
                    String email = rs.getString("email");
                    String tipoDocumento = rs.getString("tipo_documento");
                    System.out.println("________________________________________");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Email: " + email);
                    System.out.println("Tipo de Documento: " + tipoDocumento);
                    System.out.println("________________________________________");

                } else {
                    System.out.println("No se encontró un cliente con el documento proporcionado.");
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error al listar el cliente: " + e.getMessage());
        }
    }
    // error
    public static void dbconsultarReserva(Integer documentoCliente) {
        String sql = "SELECT rt.id AS id_reserva_trayecto, t.fecha_trayecto, t.precio_trayecto, c.nombre, c.documento " +
                     "FROM reservas_trayectos AS rt " +
                     "JOIN trayectos AS t ON rt.id_trayecto = t.id " +
                     "JOIN detalles_reservas_trayectos AS drt ON rt.id = drt.id_reserva_trayecto " +
                     "JOIN clientes AS c ON drt.id_cliente = c.id " +
                     "WHERE c.documento = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
    
            pstm.setInt(1, documentoCliente);
    
            try (ResultSet rs = pstm.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("No se encontraron reservas para el documento proporcionado.");
                    return;
                }
    
                while (rs.next()) {
                    int idReservaTrayecto = rs.getInt("id_reserva_trayecto");
                    Date fechaTrayecto = rs.getDate("fecha_trayecto");
                    float precioTrayecto = rs.getFloat("precio_trayecto");
                    String nombreCliente = rs.getString("nombre");
                    int documentoClienteResultado = rs.getInt("documento");
    
                    System.out.println("________________________________________");
                    System.out.println("ID Reserva Trayecto: " + idReservaTrayecto);
                    System.out.println("Fecha Trayecto: " + fechaTrayecto);
                    System.out.println("Precio Trayecto: " + precioTrayecto);
                    System.out.println("Nombre Cliente: " + nombreCliente);
                    System.out.println("Documento Cliente: " + documentoClienteResultado);
                    System.out.println("________________________________________");
                }
            }
    
        } catch (SQLException e) {
            System.out.println("Error al consultar reservas: " + e.getMessage());
        }
    }
    // error
    public static boolean verificarCliente(String idcliente) {
        String sql = "SELECT COUNT(*) FROM clientes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            
                pstm.setInt(1, Integer.parseInt(idcliente));
            ResultSet resultSet = pstm.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // error
    public static void dbregistrarCliente(String nombre, Integer edad, String email, String contraseña, Integer id_documento, String documento) {
        String sql = "INSERT INTO clientes (nombre, edad, email, contraseña, id_documento, documento) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombre);
            pstmt.setInt(2, edad);
            pstmt.setString(3, email);
            pstmt.setString(4, contraseña);
            pstmt.setInt(5, id_documento);
            pstmt.setString(6, documento);
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente registrado exitosamente!");
            } else {
                System.out.println("No se pudo registrar el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar el cliente: " + e.getMessage());
        }
    }
    // error
    public static void dbActualizarCliente(String idcliente, String nombre, Integer edad, String email, String contraseña, Integer tipo_documento, String numeroDocumento) {
        StringBuilder queryBuilder = new StringBuilder("UPDATE clientes SET ");
        
        if (nombre != null && !nombre.isEmpty()) queryBuilder.append("nombre = ?, ");
        if (edad != null) queryBuilder.append("edad = ?, ");
        if (email != null && !email.isEmpty()) queryBuilder.append("email = ?, ");
        if (contraseña != null && !contraseña.isEmpty()) queryBuilder.append("contraseña = ?, ");
        if (tipo_documento != null) queryBuilder.append("id_documento = ?, ");
        if (numeroDocumento != null && !numeroDocumento.isEmpty()) queryBuilder.append("documento = ?, ");
    
        int lastCommaIndex = queryBuilder.lastIndexOf(", ");
        if (lastCommaIndex != -1) {
            queryBuilder.delete(lastCommaIndex, lastCommaIndex + 2);
        }
    
        queryBuilder.append(" WHERE id = ?");
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryBuilder.toString())) {
    
            int paramIndex = 1;
            
            if (nombre != null && !nombre.isEmpty()) pstmt.setString(paramIndex++, nombre);
            if (edad != null) pstmt.setInt(paramIndex++, edad);
            if (email != null && !email.isEmpty()) pstmt.setString(paramIndex++, email);
            if (contraseña != null && !contraseña.isEmpty()) pstmt.setString(paramIndex++, contraseña);
            if (tipo_documento != null) pstmt.setInt(paramIndex++, tipo_documento);
            if (numeroDocumento != null && !numeroDocumento.isEmpty()) pstmt.setString(paramIndex++, numeroDocumento);
    
            pstmt.setInt(paramIndex, Integer.parseInt(idcliente));
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cliente actualizado exitosamente!");
            } else {
                System.out.println("No se pudo actualizar el cliente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cliente: " + e.getMessage());
        }
    }
    
    public static void dbeliminarReserva(Integer id_reserva) {
        String sql = "DELETE FROM detalles_reservas_trayectos WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_reserva);
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
                System.out.println("Reserva eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna reserva con el ID proporcionado.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void dbconsultarVuelo(String numeroConexion) {
        String sql = "SELECT cv.*, a.matricula, ae.nombre AS nombre_aerolinea, "
        + "ap.nombre AS nombre_aeropuerto, c.nombre as nombre_ciudad, p.nombre as nombre_pais "
        + "FROM conexiones_vuelos AS cv "
        + "JOIN aviones AS a ON cv.id_avion = a.id "
        + "JOIN aerolineas AS ae ON a.id_aerolinea = ae.id "
        + "JOIN aeropuertos AS ap ON cv.id_aeropuerto = ap.id "
        + "JOIN ciudades AS c ON ap.id_ciudad = c.id "
        + "JOIN paises AS p ON c.id_pais = p.id "
        + "WHERE cv.numero_conexion = ?";

    try (Connection conn = ConexionBD.getConnection();
    PreparedStatement pstm = conn.prepareStatement(sql)) {
    
    pstm.setString(1, numeroConexion);
    
    try (ResultSet rs = pstm.executeQuery()) {
        if (rs.next()) {
            int id = rs.getInt("id");
            String numeroConexionResult = rs.getString("numero_conexion");
            int idTrayecto = rs.getInt("id_trayecto");
            String matriculaAvion = rs.getString("matricula");
            String nombreAerolinea = rs.getString("nombre_aerolinea");
            String nombreAeropuerto = rs.getString("nombre_aeropuerto");
            String ciudadAeropuerto = rs.getString("nombre_ciudad");
            String paisAeropuerto = rs.getString("nombre_pais");

            System.out.println("________________________________________");
            System.out.println("ID: " + id);
            System.out.println("Número de Conexión: " + numeroConexionResult);
            System.out.println("ID Trayecto: " + idTrayecto);
            System.out.println("Matrícula Avión: " + matriculaAvion);
            System.out.println("Nombre Aerolínea: " + nombreAerolinea);
            System.out.println("Nombre Aeropuerto: " + nombreAeropuerto);
            System.out.println("Ciudad Aeropuerto: " + ciudadAeropuerto);
            System.out.println("País Aeropuerto: " + paisAeropuerto);
            System.out.println("________________________________________");
        } else {
            System.out.println("No se encontró el vuelo con el número de conexión: " + numeroConexion);
        }
    }
        } catch (SQLException e) {
        System.out.println("Error al consultar vuelo: " + e.getMessage());
        }
    }
    
    public static void dbconsultarAsignacionTripulacion(Integer idTrayecto) {

        String sql = "SELECT e.nombre AS nombre_empleado, e.email, r.nombre AS rol "
                   + "FROM tripulaciones t "
                   + "JOIN empleados e ON t.id_empleado = e.id "
                   + "JOIN roles_tripulacion r ON e.id_rol = r.id "
                   + "WHERE t.id_trayectos = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
             
            pstm.setInt(1, idTrayecto);
            
            try (ResultSet rs = pstm.executeQuery()) {
                System.out.println("Tripulación asignada al trayecto " + idTrayecto + ":");
                while (rs.next()) {
                    String nombreEmpleado = rs.getString("nombre_empleado");
                    String email = rs.getString("email");
                    String rol = rs.getString("rol");

                    System.out.println("________________________________________");
                    System.out.println("Nombre: " + nombreEmpleado);
                    System.out.println("Email: " + email);
                    System.out.println("Rol: " + rol);
                    System.out.println("________________________________________");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar la asignación de tripulación: " + e.getMessage());
        }
    }
   
    public static void dbconsultarEscalasTrayecto(Integer idTrayecto) {
        String sql = "SELECT c.numero_conexion, a.nombre AS nombre_aeropuerto, ci.nombre AS nombre_ciudad, p.nombre AS nombre_pais "
        + "FROM conexiones_vuelos c "
        + "JOIN aeropuertos a ON c.id_aeropuerto = a.id "
        + "JOIN ciudades ci ON a.id_ciudad = ci.id "
        + "JOIN paises p ON ci.id_pais = p.id "
        + "WHERE c.id_trayecto = ?";

    try (Connection conn = ConexionBD.getConnection();
    PreparedStatement pstm = conn.prepareStatement(sql)) {
    
    pstm.setInt(1, idTrayecto);
    
    try (ResultSet rs = pstm.executeQuery()) {
        System.out.println("Escalas para el trayecto " + idTrayecto + ":");
            while (rs.next()) {
            String numeroConexion = rs.getString("numero_conexion");
            String nombreAeropuerto = rs.getString("nombre_aeropuerto");
            String nombreCiudad = rs.getString("nombre_ciudad");
            String nombrePais = rs.getString("nombre_pais");

            System.out.println("________________________________________");
            System.out.println("Número de Conexión: " + numeroConexion);
            System.out.println("Aeropuerto: " + nombreAeropuerto);
            System.out.println("Ciudad: " + nombreCiudad);
            System.out.println("País: " + nombrePais);
            System.out.println("________________________________________");
        }
    }
        } catch (SQLException e) {
        System.out.println("Error al consultar las escalas del trayecto: " + e.getMessage());
        }
    }
    
     public static void dbconsultarTarifaVuelo(Integer idTarifa) {
    String sql = "SELECT t.fecha_trayecto, t.precio_trayecto, tv.descripcion, tv.valor, cv.numero_conexion "
               + "FROM tarifas_vuelos tv "
               + "JOIN detalles_reservas_trayectos drt ON tv.id = drt.id_tarifa "
               + "JOIN reservas_trayectos rt ON drt.id_reserva_trayecto = rt.id "
               + "JOIN trayectos t ON rt.id_trayecto = t.id "
               + "JOIN conexiones_vuelos cv ON t.id = cv.id_trayecto "
               + "WHERE tv.id = ?";
    
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstm = conn.prepareStatement(sql)) {
        
        pstm.setInt(1, idTarifa);
        
        try (ResultSet rs = pstm.executeQuery()) {
            System.out.println("Tarifas para la tarifa con ID " + idTarifa + ":");
            while (rs.next()) {
                Date fechaTrayecto = rs.getDate("fecha_trayecto");
                float precioTrayecto = rs.getFloat("precio_trayecto");
                String descripcionTarifa = rs.getString("descripcion");
                float valorTarifa = rs.getFloat("valor");
                String numeroConexion = rs.getString("numero_conexion");
                
                System.out.println("________________________________________");
                System.out.println("Fecha del Trayecto: " + fechaTrayecto);
                System.out.println("Precio del Trayecto: " + precioTrayecto);
                System.out.println("Descripción de la Tarifa: " + descripcionTarifa);
                System.out.println("Valor de la Tarifa: " + valorTarifa);
                System.out.println("Número de Conexión: " + numeroConexion);
                System.out.println("________________________________________");
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al consultar la tarifa del vuelo: " + e.getMessage());
    }
}

    public static void dbconsultarDocumento(Integer idTipoDocumento) {
        String sql = "SELECT nombre, descripcion "
                   + "FROM tipos_documentos "
                   + "WHERE id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
             
            pstm.setInt(1, idTipoDocumento);
            
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");

                    System.out.println("________________________________________");
                    System.out.println("Nombre del Tipo de Documento: " + nombre);
                    System.out.println("Descripción: " + descripcion);
                    System.out.println("________________________________________");
                    return;
                } else {
                    System.out.println("No se encontró información para el tipo de documento con ID: " + idTipoDocumento);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar el tipo de documento: " + e.getMessage());
        }
    }
}