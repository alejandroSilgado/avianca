-- Insertar en la tabla tipos_documentos
INSERT INTO tipos_documentos (nombre, descripcion) VALUES
('Pasaporte','Documento de viaje internacional'),
('Cédula', 'Documento de identidad nacional'),
('Licencia de Conducir','Permiso para conducir vehículos');

-- Insertar en la tabla roles_tripulacion
INSERT INTO roles_tripulacion (nombre) VALUES
('Admin'),
('Agente'),
('Cliente'),
('Técnico');

-- Insertar en la tabla clientes
INSERT INTO clientes (nombre, edad, email, contraseña, documento, id_documento)
VALUES ('Juan Pérez', 30, 'juan.perez@email.com', 'mipassword123', '123456789', 1);

INSERT INTO clientes (nombre, edad, email, contraseña, documento, id_documento)
VALUES ('María Gómez', 25, 'maria.gomez@email.com', 'micontraseña123', '987654321', 2);

INSERT INTO clientes (nombre, edad, email, contraseña, documento, id_documento)
VALUES ('Pedro López', 40, 'pedro.lopez@email.com', 'mipass2024', '000000000', 3);

-- Insertar en la tabla tarifas_vuelos
INSERT INTO tarifas_vuelos (descripcion, detalles, valor) VALUES
('Económica', 'Tarifa económica sin equipaje', 150.50),
('Ejecutiva', 'Tarifa ejecutiva con equipaje', 300.75),
('Primera Clase', 'Tarifa primera clase todo incluido', 750.25);

-- Insertar en la tabla trayectos
INSERT INTO trayectos (fecha_trayecto, precio_trayecto) VALUES
('2024-07-20', 200.00),
('2024-07-21', 250.00),
('2024-07-22', 300.00);

-- Insertar en la tabla paises
INSERT INTO paises (nombre) VALUES
('Colombia'),
('Estados Unidos'),
('España');

-- Insertar en la tabla ciudades
INSERT INTO ciudades (nombre, id_pais) VALUES
('Bogotá', 1),
('Nueva York', 2),
('Madrid', 3);

-- Insertar en la tabla aeropuertos
INSERT INTO aeropuertos (nombre, id_ciudad) VALUES
('El Dorado', 1),
('JFK', 2),
('Barajas', 3);

-- Insertar en la tabla aerolineas
INSERT INTO aerolineas (nombre) VALUES
('Avianca'),
('American Airlines'),
('Iberia');

-- Insertar en la tabla empleados
INSERT INTO empleados (nombre, email, contraseña, id_rol, fecha_ingreso, id_aerolinea, id_aeropuerto) VALUES
('Pedro Gómez', 'pedro.gomez@example.com', 'password123', 2, '2022-01-01', 1, 1),
('María López', 'maria.lopez@example.com', 'password456', 2, '2023-02-01', 2, 2),
('Carlos Ramírez', 'carlos.ramirez@example.com', 'password789', 4, '2024-03-01', 3, 3),
('Ana Martínez', 'ana.martinez@example.com', 'password101', 3, '2023-05-15', 1, 2),
('Juan Rodríguez', 'juan.rodriguez@example.com', 'password202', 4, '2022-11-30', 2, 1);

-- Insertar en la tabla puertas
INSERT INTO puertas (numero_puerta, id_aeropuerto) VALUES
('P01', 1),
('P02', 2),
('P03', 3);

-- Insertar en la tabla estados
INSERT INTO estados (nombre) VALUES
('Activo'),
('Inactivo'),
('En Mantenimiento');

-- Insertar en la tabla fabricantes
INSERT INTO fabricantes (nombre) VALUES
('Boeing'),
('Airbus'),
('Embraer');

-- Insertar en la tabla modelos
INSERT INTO modelos (nombre, id_fabricante) VALUES
('737', 1),
('A320', 2),
('E190', 3);

-- Insertar en la tabla aviones
INSERT INTO aviones (matricula, capacidad, fecha_fabricacion, id_estado, id_aerolinea, id_modelo) VALUES
('ABC123', 180, '2010-05-20', 1, 1, 1),
('DEF456', 220, '2012-07-15', 1, 2, 2),
('GHI789', 100, '2015-11-30', 1, 3, 3);

-- Insertar en la tabla conexiones_vuelos
INSERT INTO conexiones_vuelos (numero_conexion, id_trayecto, id_avion, id_aeropuerto) VALUES
('CX001', 1, 2, 1),
('CX002', 2, 3, 2),
('CX003', 3, 4, 3);

-- Insertar en la tabla reservas_trayectos
INSERT INTO reservas_trayectos (fecha, id_trayecto) VALUES
('2024-07-15', 1),
('2024-07-16', 2),
('2024-07-17', 3);

-- Insertar en la tabla detalles_reservas_trayectos
INSERT INTO detalles_reservas_trayectos (id_reserva_trayecto, id_cliente, id_tarifa) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- Insertar en la tabla detalles_revision
INSERT INTO detalles_revision (descripcion, id_empleado) VALUES
('Revisión de motores', 1),
('Revisión de sistemas eléctricos', 2),
('Revisión de estructura',3);

-- Insertar en la tabla revisiones
INSERT INTO revisiones (fecha_revision, id_avion) VALUES
('2024-07-10', 2),
('2024-07-11', 3),
('2024-07-12', 4);

-- Insertar en la tabla revision_empleados
INSERT INTO revision_empleados (id_empleado, id_revision) VALUES
(1, 2),
(2, 3),
(3, 4);

-- Insertar en la tabla tripulaciones
INSERT INTO tripulaciones (id_empleado, id_trayectos) VALUES
(1, 1),
(2, 2),
(3, 3);

-- Insertar en la tabla usuarios
INSERT INTO usuarios (nombre, apellido, email, contraseña, id_rol) VALUES
('Admin', 'Admin', 'admin@example.com', 'admin123', 1),
('Agente', 'Agente', 'agente@example.com', 'agente123', 2),
('Cliente', 'Cliente', 'cliente@example.com', 'cliente123', 3),
('Tecnico', 'Tecnico', 'tecnico@example.com', 'tecnico123', 4);

-- Inserta una escala para un trayecto con ID 1 en el aeropuerto con ID 2
INSERT INTO escalas (id_trayecto, id_aeropuerto, fecha)VALUES
(1, 1, '2024-07-20'),
(2, 2, '2024-07-21'),
(3, 3, '2024-07-22'),
(1, 2, '2024-07-23');
