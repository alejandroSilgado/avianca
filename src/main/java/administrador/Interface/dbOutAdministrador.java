package administrador.Interface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import resources.ConexionBD;

public class dbOutAdministrador {

    public static void agregarAvion(String matricula, int capacidad, String fecha, int estado, int aerolinea,
            int modelo) throws SQLException {
        String sql = "INSERT INTO aviones (matricula, capacidad, fecha_fabricacion, id_estado, id_aerolinea, id_modelo) "
                +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, matricula);
            pstmt.setInt(2, capacidad);
            pstmt.setString(3, fecha);
            pstmt.setInt(4, estado);
            pstmt.setInt(5, aerolinea);
            pstmt.setInt(6, modelo);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Avión agregado correctamente.");
            } else {
                System.out.println("No se pudo agregar el avión.");
            }
        }
    }

    public static void dbAgregarTripulacion (Integer id_empleado, Integer id_trayecto) {
        String sql = "INSERT INTO tripulaciones (id_trayectos, id_empleado) " +
                "VALUES (?, ?)";

        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id_empleado);
                ps.setInt(2, id_trayecto);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tripulacion agregada correctamente.");
            } else {
                System.out.println("No se pudo agregar a la Tripulacion.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar a la Tripulacion: " + e.getMessage());
        }

    }

    public static void dbConsultarAvion(String matricula) {
        String sql = "SELECT a.matricula, a.capacidad, a.fecha_fabricacion, e.nombre AS estado, al.nombre AS aerolinea, m.nombre AS modelo, f.nombre AS fabricante " +
                     "FROM aviones a " +
                     "JOIN estados e ON a.id_estado = e.id " +
                     "JOIN aerolineas al ON a.id_aerolinea = al.id " +
                     "JOIN modelos m ON a.id_modelo = m.id " +
                     "JOIN fabricantes f ON m.id_fabricante = f.id " +
                     "WHERE a.matricula = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, matricula);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String capacidad = rs.getString("capacidad");
                    String fechaFabricacion = rs.getString("fecha_fabricacion");
                    String estado = rs.getString("estado");
                    String aerolinea = rs.getString("aerolinea");
                    String modelo = rs.getString("modelo");
                    String fabricante = rs.getString("fabricante");

                    System.out.println("-----------------------------------------");
                    System.out.println("Matrícula: " + matricula);
                    System.out.println("Capacidad: " + capacidad);
                    System.out.println("Fecha de Fabricación: " + fechaFabricacion);
                    System.out.println("Estado: " + estado);
                    System.out.println("Aerolínea: " + aerolinea);
                    System.out.println("Modelo: " + modelo);
                    System.out.println("Fabricante: " + fabricante);
                    System.out.println("-----------------------------------------");

                } else {
                    System.out.println("No se encontró un avión con la matrícula: " + matricula);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el avión", e);
        }
    }

    public static void dbConsultarTrayecto(Integer id_trayecto) {
        String sql = "SELECT t.id, t.fecha_trayecto, t.precio_trayecto, " +
                     "ao.nombre AS aeropuerto_origen, ad.nombre AS aeropuerto_destino, " +
                     "co.nombre AS ciudad_origen, cd.nombre AS ciudad_destino " +
                     "FROM trayectos t " +
                     "JOIN conexiones_vuelos cv ON t.id = cv.id_trayecto " +
                     "JOIN aeropuertos ao ON cv.id_aeropuerto = ao.id " +
                     "JOIN aeropuertos ad ON cv.id_aeropuerto = ad.id " +
                     "JOIN ciudades co ON ao.id_ciudad = co.id " +
                     "JOIN ciudades cd ON ad.id_ciudad = cd.id " +
                     "WHERE t.id = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id_trayecto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String fechaTrayecto = rs.getString("fecha_trayecto");
                    float precioTrayecto = rs.getFloat("precio_trayecto");
                    String ciudadOrigen = rs.getString("ciudad_origen");
                    String ciudadDestino = rs.getString("ciudad_destino");
                    String aeropuertoOrigen = rs.getString("aeropuerto_origen");
                    String aeropuertoDestino = rs.getString("aeropuerto_destino");

                    System.out.println("-----------------------------------------");
                    System.out.println("Detalles del Trayecto:");
                    System.out.println("ID: " + id_trayecto);
                    System.out.println("Fecha del Trayecto: " + fechaTrayecto);
                    System.out.println("Precio del Trayecto: " + precioTrayecto);
                    System.out.println("Ciudad de Origen: " + ciudadOrigen);
                    System.out.println("Ciudad de Destino: " + ciudadDestino);
                    System.out.println("Aeropuerto de Origen: " + aeropuertoOrigen);
                    System.out.println("Aeropuerto de Destino: " + aeropuertoDestino);
                    System.out.println("-----------------------------------------");

                } else {
                    System.out.println("No se encontró un trayecto con el ID: " + id_trayecto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el trayecto", e);
        }
    }

    public static void dbConsultarAreopuerto(String nombreAeropuerto) {
        String sql = "SELECT a.id, a.nombre, c.nombre AS ciudad, p.nombre AS pais " +
                     "FROM aeropuertos a " +
                     "JOIN ciudades c ON a.id_ciudad = c.id " +
                     "JOIN paises p ON c.id_pais = p.id " +
                     "WHERE a.nombre = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombreAeropuerto);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String ciudad = rs.getString("ciudad");
                    String pais = rs.getString("pais");
    
                    System.out.println("-----------------------------------------");
                    System.out.println("ID: " + id);
                    System.out.println("Nombre: " + nombreAeropuerto);
                    System.out.println("Ciudad: " + ciudad);
                    System.out.println("País: " + pais);
                    System.out.println("-----------------------------------------");
                } else {
                    System.out.println("No se encontró un aeropuerto con el nombre: " + nombreAeropuerto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el aeropuerto", e);
        }
    }
    
    public static void dbActualizarAvion(Integer id_avion, String nuevaMatricula, Integer nuevaCapacidad, String nuevaFechaFabricacion, Integer nuevoIdEstado, Integer nuevoIdAerolinea, Integer nuevoIdModelo) {
        String sql = "UPDATE aviones SET matricula = ?, capacidad = ?, fecha_fabricacion = ?, id_estado = ?, id_aerolinea = ?, id_modelo = ? WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nuevaMatricula);
            pstmt.setInt(2, nuevaCapacidad);
            pstmt.setDate(3, java.sql.Date.valueOf(nuevaFechaFabricacion));
            pstmt.setInt(4, nuevoIdEstado);
            pstmt.setInt(5, nuevoIdAerolinea);
            pstmt.setInt(6, nuevoIdModelo);
            pstmt.setInt(7, id_avion);
    
            int filasActualizadas = pstmt.executeUpdate();
    
            if (filasActualizadas > 0) {
                System.out.println("El avión con ID " + id_avion + " fue actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un avión con el ID " + id_avion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el avión", e);
        }
    }
    
    public static void dbEliminarAvion(Integer id_avion) {
        String sql = "DELETE FROM aviones WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id_avion);
    
            int filasEliminadas = pstmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                System.out.println("El avión con ID " + id_avion + " fue eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un avión con el ID " + id_avion);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el avión", e);
        }
    }
    
    public static void dbAsignarAvion(Integer id_avion, Integer id_trayecto, Integer id_aeropuerto) {
        String sql = "INSERT INTO conexiones_vuelos (numero_conexion, id_trayecto, id_avion, id_aeropuerto) VALUES (?, ?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            String numeroConexion = "CONN" + (System.currentTimeMillis() % 1000000000); // Generar un valor corto y único
            if (numeroConexion.length() > 20) {
                numeroConexion = numeroConexion.substring(0, 20); 
            }
    
            pstmt.setString(1, numeroConexion);  // El número de conexión
            pstmt.setInt(2, id_trayecto);        // ID del trayecto
            pstmt.setInt(3, id_avion);           // ID del avión
            pstmt.setInt(4, id_aeropuerto);      // ID del aeropuerto
    
            int filasInsertadas = pstmt.executeUpdate();
    
            if (filasInsertadas > 0) {
                System.out.println("El avión con ID " + id_avion + " fue asignado exitosamente al trayecto con ID " + id_trayecto + ".");
            } else {
                System.out.println("No se pudo asignar el avión con ID " + id_avion + " al trayecto con ID " + id_trayecto + ".");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al asignar el avión al trayecto", e);
        }
    }
    
    public static void dbActualizarTrayecto(Integer id_trayecto, String nuevaFechaTrayecto, Float nuevoPrecioTrayecto) {
        String sql = "UPDATE trayectos SET fecha_trayecto = ?, precio_trayecto = ? WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setDate(1, java.sql.Date.valueOf(nuevaFechaTrayecto));
            pstmt.setFloat(2, nuevoPrecioTrayecto);
            pstmt.setInt(3, id_trayecto);
    
            int filasActualizadas = pstmt.executeUpdate();
    
            if (filasActualizadas > 0) {
                System.out.println("El trayecto con ID " + id_trayecto + " fue actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un trayecto con el ID " + id_trayecto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el trayecto", e);
        }
    }
    
    public static void dbEliminarTrayecto(Integer id_trayecto) {
        String sql = "DELETE FROM trayectos WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id_trayecto);
    
            int filasEliminadas = pstmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                System.out.println("El trayecto con ID " + id_trayecto + " fue eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un trayecto con el ID " + id_trayecto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el trayecto", e);
        }
    }

    public static void dbActualizarAeropuerto(Integer id_aeropuerto, String nuevoNombre, Integer nuevoIdCiudad) {
        String sql = "UPDATE aeropuertos SET nombre = ?, id_ciudad = ? WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nuevoNombre);
            pstmt.setInt(2, nuevoIdCiudad);
            pstmt.setInt(3, id_aeropuerto);
    
            int filasActualizadas = pstmt.executeUpdate();
    
            if (filasActualizadas > 0) {
                System.out.println("El aeropuerto con ID " + id_aeropuerto + " fue actualizado exitosamente.");
            } else {
                System.out.println("No se encontró un aeropuerto con el ID " + id_aeropuerto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el aeropuerto", e);
        }
    }
    
    public static void dbEliminarAeropuerto(Integer idAeropuerto) {
        String sql = "DELETE FROM aeropuertos WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idAeropuerto);
    
            int filasEliminadas = pstmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                System.out.println("El aeropuerto con ID " + idAeropuerto + " fue eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un aeropuerto con el ID " + idAeropuerto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el aeropuerto", e);
        }
    }

    public static void dbConsultarVuelo(String numeroConexion) {
        String sql = "SELECT * FROM conexiones_vuelos WHERE numero_conexion = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, numeroConexion);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("--------------------------------------");
                    System.out.println("ID de Conexión: " + rs.getInt("id"));
                    System.out.println("Número de Conexión: " + rs.getString("numero_conexion"));
                    System.out.println("ID de Trayecto: " + rs.getInt("id_trayecto"));
                    System.out.println("ID de Avión: " + rs.getInt("id_avion"));
                    System.out.println("ID de Aeropuerto: " + rs.getInt("id_aeropuerto"));
                    System.out.println("--------------------------------------");

                } else {
                    System.out.println("No se encontró un vuelo con el número de conexión " + numeroConexion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el vuelo", e);
        }
    }

    public static void dbConsultarAsignacionTripulacion(Integer idTrayecto) {
        String sql = "SELECT e.nombre AS nombre_empleado, t.fecha_trayecto as fecha " +
                     "FROM tripulaciones tr " +
                     "JOIN empleados e ON tr.id_empleado = e.id " +
                     "JOIN trayectos t ON tr.id_trayectos = t.id " +
                     "WHERE t.id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idTrayecto);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean encontrado = false;
                while (rs.next()) {
                    System.out.println("--------------------------------------");
                    System.out.println("Nombre del Empleado: " + rs.getString("nombre_empleado"));
                    System.out.println("Fecha del Trayecto: " + rs.getString("fecha"));
                    encontrado = true;
                    System.out.println("--------------------------------------");

                }
                if (!encontrado) {
                    System.out.println("No se encontró asignación de tripulación para el trayecto con ID " + idTrayecto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar la asignación de tripulación", e);
        }
    }
    
    public static void dbConsultarEscalasTrayecto(Integer idTrayecto) {
        String sql = "SELECT e.id AS id_escala, a.nombre AS nombre_aeropuerto, e.fecha " +
                     "FROM escalas e " +
                     "JOIN aeropuertos a ON e.id_aeropuerto = a.id " +
                     "WHERE e.id_trayecto = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idTrayecto);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean encontrado = false;
                while (rs.next()) {
                    System.out.println("ID de Escala: " + rs.getInt("id_escala"));
                    System.out.println("Nombre de Aeropuerto: " + rs.getString("nombre_aeropuerto"));
                    System.out.println("Fecha de Escala: " + rs.getDate("fecha"));
                    System.out.println("-----------------------------");
                    encontrado = true;
                }
                if (!encontrado) {
                    System.out.println("No se encontraron escalas para el trayecto con ID " + idTrayecto);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar las escalas del trayecto", e);
        }
    }
    
    public static void dbRegistrarTarifaVuelo(String descripcion, String detalles, Float valor) {
        String sql = "INSERT INTO tarifas_vuelos (descripcion, detalles, valor) VALUES (?, ?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, descripcion);
            pstmt.setString(2, detalles);
            pstmt.setFloat(3, valor);
    
            int filasInsertadas = pstmt.executeUpdate();
    
            if (filasInsertadas > 0) {
                System.out.println("La tarifa de vuelo fue registrada exitosamente.");
            } else {
                System.out.println("No se pudo registrar la tarifa de vuelo.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar la tarifa de vuelo", e);
        }
    }
    
    public static void dbEliminarEscala(Integer idEscala) {
        String sql = "DELETE FROM escalas WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idEscala);
    
            int filasEliminadas = pstmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                System.out.println("La escala con ID " + idEscala + " fue eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una escala con el ID " + idEscala);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la escala", e);
        }
    }
    
    public static void dbActualizarTarifaVuelo(Integer idTarifa, String nuevaDescripcion, String nuevosDetalles, Float nuevoValor) {
        String sql = "UPDATE tarifas_vuelos SET descripcion = ?, detalles = ?, valor = ? WHERE id = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setString(1, nuevaDescripcion);
            pstmt.setString(2, nuevosDetalles);
            pstmt.setFloat(3, nuevoValor);
            pstmt.setInt(4, idTarifa);
        
            int filasActualizadas = pstmt.executeUpdate();
        
            if (filasActualizadas > 0) {
                System.out.println("La tarifa con ID " + idTarifa + " fue actualizada exitosamente.");
            } else {
                System.out.println("No se encontró una tarifa con el ID " + idTarifa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la tarifa de vuelo", e);
        }
    }

    public static void dbEliminarTarifaVuelo(Integer idTarifa) {
        String sql = "DELETE FROM tarifas_vuelos WHERE id = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, idTarifa);
        
            int filasEliminadas = pstmt.executeUpdate();
        
            if (filasEliminadas > 0) {
                System.out.println("La tarifa con ID " + idTarifa + " fue eliminada exitosamente.");
            } else {
                System.out.println("No se encontró una tarifa con el ID " + idTarifa);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la tarifa de vuelo", e);
        }
    }
    
    public static void dbConsultarTarifaVuelo(Integer idTarifa) {
        String sql = "SELECT descripcion, detalles, valor FROM tarifas_vuelos WHERE id = ?";
        
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
            pstmt.setInt(1, idTarifa);
        
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Descripción: " + rs.getString("descripcion"));
                    System.out.println("Detalles: " + rs.getString("detalles"));
                    System.out.println("Valor: " + rs.getFloat("valor"));
                } else {
                    System.out.println("No se encontró una tarifa con el ID " + idTarifa);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar la tarifa de vuelo", e);
        }
    }
    
    public static void dbRegistrarTipoDocumento(String nombre, String descripcion) {
        String sql = "INSERT INTO tipos_documentos (nombre, descripcion) VALUES (?, ?)";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
    
            int filasInsertadas = pstmt.executeUpdate();
    
            if (filasInsertadas > 0) {
                System.out.println("Tipo de documento registrado exitosamente.");
            } else {
                System.out.println("No se pudo registrar el tipo de documento.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar el tipo de documento", e);
        }
    }
    
    public static void dbActualizarTipoDocumento(Integer idTipoDocumento, String nombre, String descripcion) {
        String sql = "UPDATE tipos_documentos SET nombre = ?, descripcion = ? WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, nombre);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, idTipoDocumento);
    
            int filasActualizadas = pstmt.executeUpdate();
    
            if (filasActualizadas > 0) {
                System.out.println("Tipo de documento actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el tipo de documento.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el tipo de documento", e);
        }
    }
    
    public static void dbEliminarTipoDocumento(Integer idTipoDocumento) {
        String sql = "DELETE FROM tipos_documentos WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idTipoDocumento);
    
            int filasEliminadas = pstmt.executeUpdate();
    
            if (filasEliminadas > 0) {
                System.out.println("Tipo de documento eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el tipo de documento.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el tipo de documento", e);
        }
    }
    
    public static void dbConsultarTipoDocumento(Integer idTipoDocumento) {
        String sql = "SELECT * FROM tipos_documentos WHERE id = ?";
    
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, idTipoDocumento);
    
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("-----------------------------");
                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Nombre: " + rs.getString("nombre"));
                    System.out.println("Descripción: " + rs.getString("descripcion"));
                    System.out.println("-----------------------------");
                } else {
                    System.out.println("No se encontró el tipo de documento con ID " + idTipoDocumento);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar el tipo de documento", e);
        }
    }
    
}