CREATE TABLE tipos_documentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    descripcion VARCHAR(255)
);

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    edad INT,
    email VARCHAR(50),
    contraseña VARCHAR(20),
    documento VARCHAR(20),
    id_documento INT,
    FOREIGN KEY (id_documento) REFERENCES tipos_documentos(id)
);

CREATE TABLE tarifas_vuelos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(20),
    detalles TEXT,
    valor FLOAT
);

CREATE TABLE trayectos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_trayecto DATE,
    precio_trayecto FLOAT
);

CREATE TABLE reservas_trayectos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    id_trayecto INT,
    FOREIGN KEY (id_trayecto) REFERENCES trayectos(id)
);

CREATE TABLE detalles_reservas_trayectos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_reserva_trayecto INT,
    id_cliente INT,
    id_tarifa INT,
    FOREIGN KEY (id_reserva_trayecto) REFERENCES reservas_trayectos(id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id),
    FOREIGN KEY (id_tarifa) REFERENCES tarifas_vuelos(id)
);

CREATE TABLE paises (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50)
);

CREATE TABLE ciudades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    id_pais INT,
    FOREIGN KEY (id_pais) REFERENCES paises(id)
);

CREATE TABLE aeropuertos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    id_ciudad INT,
    FOREIGN KEY (id_ciudad) REFERENCES ciudades(id)
);

CREATE TABLE aerolineas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);

CREATE TABLE roles_tripulacion (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(10)
);

CREATE TABLE empleados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    email VARCHAR(50),
    contraseña VARCHAR(20),
    id_rol INT,
    fecha_ingreso DATE,
    id_aerolinea INT,
    id_aeropuerto INT,
    FOREIGN KEY (id_rol) REFERENCES roles_tripulacion(id),
    FOREIGN KEY (id_aerolinea) REFERENCES aerolineas(id),
    FOREIGN KEY (id_aeropuerto) REFERENCES aeropuertos(id)
);

CREATE TABLE puertas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_puerta VARCHAR(10),
    id_aeropuerto INT,
    FOREIGN KEY (id_aeropuerto) REFERENCES aeropuertos(id)
);

CREATE TABLE estados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30)
);

CREATE TABLE fabricantes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40)
);

CREATE TABLE modelos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    id_fabricante INT,
    FOREIGN KEY (id_fabricante) REFERENCES fabricantes(id)
);

CREATE TABLE aviones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    matricula VARCHAR(30),
    capacidad INT,
    fecha_fabricacion DATE,
    id_estado INT,
    id_aerolinea INT,
    id_modelo INT,
    FOREIGN KEY (id_estado) REFERENCES estados(id),
    FOREIGN KEY (id_aerolinea) REFERENCES aerolineas(id),
    FOREIGN KEY (id_modelo) REFERENCES modelos(id)
);

CREATE TABLE conexiones_vuelos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    numero_conexion VARCHAR(20),
    id_trayecto INT,
    id_avion INT,
    id_aeropuerto INT,
    FOREIGN KEY (id_trayecto) REFERENCES trayectos(id),
    FOREIGN KEY (id_avion) REFERENCES aviones(id),
    FOREIGN KEY (id_aeropuerto) REFERENCES aeropuertos(id)
);

CREATE TABLE detalles_revision (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descripcion TEXT,
    id_empleado INT,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id)
);

CREATE TABLE revisiones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha_revision DATE,
    id_avion INT,
    FOREIGN KEY (id_avion) REFERENCES aviones(id)
);

CREATE TABLE revision_empleados (
    id_empleado INT,
    id_revision INT,
    PRIMARY KEY (id_empleado, id_revision),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id),
    FOREIGN KEY (id_revision) REFERENCES revisiones(id)
);

CREATE TABLE tripulaciones (
    id_empleado INT,
    id_trayectos INT,
    PRIMARY KEY (id_empleado, id_trayectos),
    FOREIGN KEY (id_empleado) REFERENCES empleados(id),
    FOREIGN KEY (id_trayectos) REFERENCES trayectos(id)
);

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(40),
    apellido VARCHAR(40),
    email VARCHAR(30),
    contraseña VARCHAR(40),
    id_rol INT,
    FOREIGN KEY (id_rol) REFERENCES roles_tripulacion(id)
);

CREATE TABLE seleccion_asientos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    asiento VARCHAR(5),
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);

CREATE TABLE escalas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_trayecto INT,
    id_aeropuerto INT,
    fecha DATE,
    FOREIGN KEY (id_trayecto) REFERENCES trayectos(id),
    FOREIGN KEY (id_aeropuerto) REFERENCES aeropuertos(id)
);