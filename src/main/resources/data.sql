INSERT INTO clientes (nombre, correo, fecha_registro)
SELECT 'Juan Pérez', 'juan@correo.com', CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM clientes WHERE correo = 'juan@correo.com'
);

INSERT INTO clientes (nombre, correo, fecha_registro)
SELECT 'Ana Gómez', 'ana@correo.com', CURRENT_TIMESTAMP
WHERE NOT EXISTS (
    SELECT 1 FROM clientes WHERE correo = 'ana@correo.com'
);

INSERT INTO productos (nombre, precio, stock, activo)
SELECT 'Laptop Lenovo', 3500000.00, 10, TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'Laptop Lenovo'
);

INSERT INTO productos (nombre, precio, stock, activo)
SELECT 'Mouse Logitech', 120000.00, 25, TRUE
WHERE NOT EXISTS (
    SELECT 1 FROM productos WHERE nombre = 'Mouse Logitech'
);