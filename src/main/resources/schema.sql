DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS producto;

CREATE TABLE cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    correo VARCHAR(150),
    fecha_registro TIMESTAMP
);

CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DOUBLE,
    fecha_creacion TIMESTAMP
);