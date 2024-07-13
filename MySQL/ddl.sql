CREATE DATABASE avianca;
USE DATABASE avianca;

CREATE TABLE documents_types (
    id INT PRIMARY KEY,
    name VARCHAR(40),
);

CREATE TABLE customers (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(30),
    age INT,
    email VARCHAR(50),
    password VARCHAR(20),
    id_document INT,

    FOREIGN KEY (id_document) REFERENCES documents(id)
);
CREATE TABLE flights_fares (
    id INT PRIMARY KEY,
    description VARCHAR(20),
    details TEXT,
    value DOUBLE(7,3)
);
CREATE TABLE trips (
    id INT PRIMARY KEY,
    trip_date DATE,
    price_trip DOUBLE
);
CREATE TABLE trip_booking (
    id INT PRIMARY KEY,
    date DATE,
    idtrips INT
    
    FOREIGN KEY idtrips REFERENCES trips(id);
);
CREATE TABLE trip_booking_details (
    id INT PRIMARY KEY auto_increment,
    id_tripbooking INT,
    id_customers VARCHAR(20),
    id_fares INT,

    FOREIGN KEY (id_tripbooking) REFERENCES trip_booking(id),
    FOREIGN KEY (id_customers) REFERENCES customers(id),
    FOREIGN KEY (id_fares) REFERENCES flights_fares(id)
);

CREATE TABLE countries (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50)
);
CREATE TABLE cities (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50),
    idcountry INT,
    FOREIGN KEY (idcountry) REFERENCES countries(id)
);

CREATE TABLE airports (
    id VARCHAR(5) PRIMARY KEY,
    name VARCHAR(50),
    idcity INT,
    FOREIGN KEY (idcity) REFERENCES cities(id)
);
CREATE TABLE airlines (
    id INT PRIMARY KEY,
    name VARCHAR(30)
);
CREATE TABLE tripulationroles (
    id INT PRIMARY KEY,
    name VARCHAR(10)
);
CREATE TABLE employees (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(30),
    email VARCHAR(50),
    password VARCHAR(20),
    idrol INT,
    ingresdate DATE,
    idairline INT,
    idairport INT, 
    FOREIGN KEY (idrol) REFERENCES tripulationroles(id),
    FOREIGN KEY (idairline) REFERENCES airlines(id),
    FOREIGN KEY (idairport) REFERENCES airports(id)
);
CREATE TABLE gates (
    id INT PRIMARY KEY,
    gatenumber VARCHAR(10),
    idairport INT,
    FOREIGN KEY (idairport) REFERENCES airports(id)
);
CREATE TABLE statuses (
    id INT PRIMARY KEY,
    name VARCHAR(30)
);
CREATE TABLE manufacturers (
    id INT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE models (
    id INT PRIMARY KEY,
    name VARCHAR(30),
    manufactured INT,
    FOREIGN KEY (manufactured) REFERENCES manufacturers(id)
);
CREATE TABLE planes (
    id INT PRIMARY KEY,
    plates VARCHAR(30),
    capacity INT,
    fabrication_date DATE,
    id_status INT,
    idairline INT,
    id_model INT,
    FOREIGN KEY (id_status) REFERENCES statuses(id),
    FOREIGN KEY (idairline) REFERENCES airlines(id),
    FOREIGN KEY (id_model) REFERENCES models(id)
);

CREATE TABLE flight_connections (
    id INT PRIMARY KEY,
    connection_number VARCHAR(20),
    id_trip INT,
    id_plane INT,
    id_airport INT,
    FOREIGN KEY (id_trip) REFERENCES trips(id),
    FOREIGN KEY (id_plane) REFERENCES planes(id),
    FOREIGN KEY (id_airport) REFERENCES airports(id)
);
CREATE TABLE revision_details (
    id INT PRIMARY KEY,
    description TEXT,
    id_employee INT,
    
    FOREIGN KEY (id_employee) REFERENCES employees(id)
);

CREATE TABLE revisions (
    id INT PRIMARY KEY,
    revision_date DATE,
    id_plane INT,
    FOREIGN KEY (id_plane) REFERENCES planes(id)
);

CREATE TABLE revemployee (
    idemployee INT,
    idrevision INT,
    PRIMARY KEY (idemployee, idrevision),
    FOREIGN KEY (idemployee) REFERENCES employees(id),
    FOREIGN KEY (idrevision) REFERENCES revisions(id)
);

CREATE TABLE tripcrews (
    idemployees INT,
    idconection INT,
    PRIMARY KEY (idemployees, idconection),
    FOREIGN KEY (idemployees) REFERENCES employees(id),
    FOREIGN KEY (idconection) REFERENCES flight_connections(id)
);









