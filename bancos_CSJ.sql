-- =============================================
-- SISTEMA BANCARIO COMPLETO - TODO EN UNO
-- =============================================

-- ====================
-- 1. ELIMINAR TABLAS EXISTENTES (OPCIONAL)
-- ====================
DROP TABLE IF EXISTS abonos CASCADE;
DROP TABLE IF EXISTS movimientos CASCADE;
DROP TABLE IF EXISTS tarjetas CASCADE;
DROP TABLE IF EXISTS prestamos CASCADE;
DROP TABLE IF EXISTS cuentas CASCADE;
DROP TABLE IF EXISTS empleados CASCADE;
DROP TABLE IF EXISTS clientes CASCADE;
DROP TABLE IF EXISTS tipo_tarjeta CASCADE;
DROP TABLE IF EXISTS tipo_cuenta CASCADE;
DROP TABLE IF EXISTS rol CASCADE;

-- ====================
-- 2. CREAR TABLAS
-- ====================

-- TABLA ROL
CREATE TABLE rol (
    rol_id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL UNIQUE,
    sueldo_base DECIMAL(10,2) NOT NULL CHECK (sueldo_base > 0)
);

-- TABLA CLIENTES
CREATE TABLE clientes (
    cliente_id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    direccion TEXT NOT NULL,
    curp VARCHAR(18) UNIQUE NOT NULL,
    fecha_nac DATE NOT NULL CHECK (fecha_nac <= CURRENT_DATE - INTERVAL '18 years'),
    telefono VARCHAR(15),
    email VARCHAR(100),
    fecha_registro DATE DEFAULT CURRENT_DATE,
    activo BOOLEAN DEFAULT TRUE
);

-- TABLA TIPO_CUENTA
CREATE TABLE tipo_cuenta (
    tipo_id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL UNIQUE,
    saldo_min DECIMAL(12,2) NOT NULL DEFAULT 0,
    saldo_max DECIMAL(12,2),
    comision_mensual DECIMAL(8,2) DEFAULT 0,
    limite_retiro_diario DECIMAL(10,2)
);

-- TABLA TIPO_TARJETA
CREATE TABLE tipo_tarjeta (
    tipo_id SERIAL PRIMARY KEY,
    descripcion VARCHAR(255) NOT NULL UNIQUE,
    limite_credito DECIMAL(12,2),
    comision_anual DECIMAL(8,2) DEFAULT 0
);

-- TABLA CUENTAS
CREATE TABLE cuentas (
    cuenta_id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    num_cuenta VARCHAR(20) UNIQUE NOT NULL,
    tipo_cuenta_id INTEGER NOT NULL,
    saldo DECIMAL(15,2) NOT NULL DEFAULT 0,
    fecha_apertura DATE DEFAULT CURRENT_DATE,
    estado VARCHAR(20) DEFAULT 'ACTIVA' CHECK (estado IN ('ACTIVA', 'SUSPENDIDA', 'CANCELADA')),
    saldo_promedio DECIMAL(15,2) DEFAULT 0
);

-- TABLA TARJETAS
CREATE TABLE tarjetas (
    tarjeta_id SERIAL PRIMARY KEY,
    cuenta_id INTEGER NOT NULL,
    num_tarjeta VARCHAR(16) UNIQUE NOT NULL,
    cvv VARCHAR(3) NOT NULL,
    expira VARCHAR(7) NOT NULL,
    tipo_tarjeta_id INTEGER NOT NULL,
    nivel VARCHAR(50) NOT NULL CHECK (nivel IN ('CLASICA', 'ORO', 'PLATINUM', 'BLACK')),
    fecha_emision DATE DEFAULT CURRENT_DATE,
    fecha_vencimiento DATE NOT NULL,
    estado VARCHAR(20) DEFAULT 'ACTIVA' CHECK (estado IN ('ACTIVA', 'BLOQUEADA', 'CANCELADA')),
    limite_credito DECIMAL(12,2) NOT NULL,
    saldo_actual DECIMAL(12,2) DEFAULT 0
);

-- TABLA PRESTAMOS
CREATE TABLE prestamos (
    prestamo_id SERIAL PRIMARY KEY,
    cliente_id INTEGER NOT NULL,
    monto DECIMAL(12,2) NOT NULL CHECK (monto > 0),
    tasa_interes DECIMAL(5,2) NOT NULL,
    fecha_contratacion DATE DEFAULT CURRENT_DATE,
    fecha_limite DATE NOT NULL,
    plazo_meses INTEGER NOT NULL CHECK (plazo_meses BETWEEN 1 AND 360),
    estado VARCHAR(20) DEFAULT 'VIGENTE' CHECK (estado IN ('VIGENTE', 'PAGADO', 'VENCIDO', 'CASTIGADO')),
    saldo_pendiente DECIMAL(12,2) NOT NULL,
    proximo_pago DATE
);

-- TABLA ABONOS
CREATE TABLE abonos (
    abono_id SERIAL PRIMARY KEY,
    prestamo_id INTEGER NOT NULL,
    fecha DATE DEFAULT CURRENT_DATE,
    monto DECIMAL(10,2) NOT NULL CHECK (monto > 0),
    tipo_abono VARCHAR(20) DEFAULT 'NORMAL' CHECK (tipo_abono IN ('NORMAL', 'EXTRAORDINARIO')),
    descripcion TEXT
);

-- TABLA MOVIMIENTOS
CREATE TABLE movimientos (
    mov_id SERIAL PRIMARY KEY,
    cuenta_id INTEGER NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_operacion VARCHAR(50) NOT NULL CHECK (tipo_operacion IN ('RETIRO', 'DEPOSITO', 'TRANSFERENCIA', 'PAGO_SERVICIO', 'COMPRA_TARJETA')),
    monto DECIMAL(12,2) NOT NULL CHECK (monto > 0),
    saldo_anterior DECIMAL(15,2) NOT NULL,
    saldo_posterior DECIMAL(15,2) NOT NULL,
    descripcion TEXT,
    referencia VARCHAR(100)
);

-- TABLA EMPLEADOS
CREATE TABLE empleados (
    emp_id SERIAL PRIMARY KEY,
    rol_id INTEGER NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    fecha_nac DATE NOT NULL,
    fecha_contratacion DATE DEFAULT CURRENT_DATE,
    salario DECIMAL(10,2) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15),
    activo BOOLEAN DEFAULT TRUE
);

-- ====================
-- 3. CONSTRAINTS DE LLAVES FORÁNEAS
-- ====================

ALTER TABLE prestamos ADD CONSTRAINT fk_prestamo_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id);
ALTER TABLE cuentas ADD CONSTRAINT fk_cuentas_cliente_id FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id);
ALTER TABLE cuentas ADD CONSTRAINT fk_cuentas_tipo_id FOREIGN KEY (tipo_cuenta_id) REFERENCES tipo_cuenta(tipo_id);
ALTER TABLE tarjetas ADD CONSTRAINT fk_tarjetas_tipo_t FOREIGN KEY (tipo_tarjeta_id) REFERENCES tipo_tarjeta(tipo_id);
ALTER TABLE tarjetas ADD CONSTRAINT fk_tarjetas_cuenta_id FOREIGN KEY (cuenta_id) REFERENCES cuentas(cuenta_id);
ALTER TABLE empleados ADD CONSTRAINT fk_empleados_rol_id FOREIGN KEY (rol_id) REFERENCES rol(rol_id);
ALTER TABLE abonos ADD CONSTRAINT fk_abonos_prestamo_id FOREIGN KEY (prestamo_id) REFERENCES prestamos(prestamo_id);
ALTER TABLE movimientos ADD CONSTRAINT fk_movimiento_cuenta_id FOREIGN KEY (cuenta_id) REFERENCES cuentas(cuenta_id);

-- ====================
-- 4. INSERTAR DATOS MAESTROS
-- ====================

-- ROLES
INSERT INTO rol (descripcion, sueldo_base) VALUES 
('Cajero Bancario', 15000),
('Asesor Financiero', 25000),
('Gerente de Sucursal', 40000),
('Analista de Créditos', 30000),
('Ejecutivo de Cuenta', 35000);

-- TIPOS DE CUENTA
INSERT INTO tipo_cuenta (descripcion, saldo_min, saldo_max) VALUES
('DEBITO', 1500, 100000),
('CREDITO', 3000, 300000),
('AHORRO', 50, 100000),
('INVERSION', 1500, 1000000);

-- TIPOS DE TARJETA
INSERT INTO tipo_tarjeta (descripcion) VALUES
('VIRTUAL'),
('FISICA');

-- CLIENTES
INSERT INTO clientes (nombre, apellidos, direccion, curp, fecha_nac, telefono, email) VALUES 
('Juan', 'Pérez', 'Calle Principal 123', 'JUPX850101HDFRLL02', '1985-01-01', '555-100-0001', 'juan.perez@email.com'),
('Ana', 'López', 'Av. Revolución 456', 'ALMX900215MDFRLL03', '1990-02-08', '555-100-0002', 'ana.lopez@email.com'),
('Carlos', 'Sánchez', 'Boulevard Norte 789', 'CAXS870517HDFPLL04', '1987-05-17', '555-100-0003', 'carlos.sanchez@email.com'),
('Laura', 'Gómez', 'Calle Sur 321', 'LAXG920718MDFLLL05', '1992-07-06', '555-100-0004', 'laura.gomez@email.com'),
('Roberto', 'Ruiz', 'Callejón del Sol 111', 'RORX750319HDFLLL06', '1975-03-04', '555-100-0005', 'roberto.ruiz@email.com'),
('Verónica', 'Díaz', 'Paseo del Bosque 234', 'VEDX810812MDFLLL07', '1981-08-12', '555-100-0006', 'veronica.diaz@email.com'),
('Fernando', 'Morales', 'Avenida Siempre Viva 102', 'FEMX880928HDFLLL08', '1988-09-11', '555-100-0007', 'fernando.morales@email.com'),
('Sofía', 'Martínez', 'Circuito del Lago 456', 'SOMX950112MDFLLL09', '1995-01-12', '555-100-0008', 'sofia.martinez@email.com'),
('Miguel', 'Torres', 'Plaza Central 567', 'MITX910905HDFLLL10', '1991-09-05', '555-100-0009', 'miguel.torres@email.com'),
('Gloria', 'García', 'Alameda 789', 'GLGX770604MDFLLL11', '1977-06-04', '555-100-0010', 'gloria.garcia@email.com'),
('Daniel', 'Hernández', 'Calle Flores 987', 'DAHX940817HDFLLL12', '1994-08-11', '555-100-0011', 'daniel.hernandez@email.com'),
('Isabel', 'Castillo', 'Paseo de la Reforma 888', 'ISCX850710MDFLLL13', '1985-09-10', '555-100-0012', 'isabel.castillo@email.com'),
('Luis', 'Delgado', 'Camino Real 123', 'LUXX700615HDFLLN14', '1970-06-03', '555-100-0013', 'luis.delgado@email.com'),
('Alejandra', 'Paredes', 'Carretera Nacional 456', 'ALPX780823MDFLLL15', '1978-08-08', '555-100-0014', 'alejandra.paredes@email.com'),
('Pedro', 'Zamora', 'Autopista del Sol 101', 'PEZX900123XDFLLL16', '1990-01-10', '555-100-0015', 'pedro.zamora@email.com');

-- CUENTAS
INSERT INTO cuentas (cliente_id, num_cuenta, tipo_cuenta_id, saldo) VALUES 
(1, '100001', 1, 15000),
(2, '100002', 2, 8000),
(3, '100003', 1, 50000),
(4, '100004', 4, 100000),
(5, '100005', 3, 25000),
(6, '100006', 1, 12000),
(7, '100007', 3, 60000),
(8, '100008', 2, 35000),
(9, '100009', 1, 9500),
(10, '100010', 3, 5000),
(11, '100011', 4, 75000),
(12, '100012', 2, 25000),
(13, '100013', 4, 110000),
(14, '100014', 1, 9000),
(15, '100015', 3, 30000);

-- TARJETAS
INSERT INTO tarjetas (cuenta_id, num_tarjeta, cvv, expira, tipo_tarjeta_id, nivel, fecha_vencimiento, limite_credito) VALUES 
(1, '400000000001', '123', '01/2026', 1, 'CLASICA', '2026-01-31', 20000),
(2, '400000000002', '456', '12/2025', 2, 'CLASICA', '2025-12-31', 20000),
(3, '400000000003', '789', '05/2027', 1, 'ORO', '2027-05-31', 50000),
(4, '400000000004', '147', '11/2024', 2, 'PLATINUM', '2024-11-30', 100000),
(5, '400000000005', '258', '06/2026', 1, 'CLASICA', '2026-06-30', 20000),
(6, '400000000006', '369', '07/2027', 2, 'ORO', '2027-07-31', 50000),
(7, '400000000007', '741', '06/2025', 1, 'PLATINUM', '2025-06-30', 100000),
(8, '400000000008', '852', '05/2027', 2, 'CLASICA', '2027-05-31', 20000),
(9, '400000000009', '963', '04/2024', 1, 'ORO', '2024-04-30', 50000),
(10, '400000000010', '159', '03/2026', 2, 'CLASICA', '2026-03-31', 20000),
(11, '400000000011', '753', '02/2025', 1, 'PLATINUM', '2025-02-28', 100000),
(12, '400000000012', '951', '01/2027', 2, 'ORO', '2027-01-31', 50000),
(13, '400000000013', '258', '12/2024', 1, 'BLACK', '2024-12-31', 250000),
(14, '400000000014', '369', '11/2026', 2, 'CLASICA', '2026-11-30', 20000),
(15, '400000000015', '753', '10/2025', 1, 'ORO', '2025-10-31', 50000);

-- PRÉSTAMOS
INSERT INTO prestamos (cliente_id, monto, tasa_interes, fecha_contratacion, fecha_limite, plazo_meses, saldo_pendiente) VALUES 
(1, 50000, 5.0, '2021-03-15', '2026-03-15', 60, 50000),
(2, 80000, 7.0, '2022-04-12', '2027-04-12', 60, 80000),
(3, 30000, 9.0, '2020-05-20', '2025-05-20', 60, 30000),
(4, 100000, 11.0, '2019-06-17', '2024-06-17', 60, 100000),
(5, 45000, 7.0, '2021-07-11', '2026-07-11', 60, 45000),
(6, 75000, 9.0, '2020-08-19', '2025-08-19', 60, 75000),
(7, 60000, 11.0, '2019-09-23', '2024-09-23', 60, 60000),
(8, 20000, 5.0, '2021-10-10', '2026-10-10', 60, 20000),
(9, 10000, 7.0, '2020-11-01', '2025-11-01', 60, 10000),
(10, 95000, 9.0, '2018-12-15', '2023-12-15', 60, 95000),
(11, 85000, 11.0, '2022-01-05', '2027-01-05', 60, 85000),
(12, 70000, 5.0, '2019-02-22', '2024-02-22', 60, 70000),
(13, 120000, 7.0, '2020-03-14', '2025-03-14', 60, 120000),
(14, 40000, 9.0, '2021-04-30', '2026-04-30', 60, 40000),
(15, 5000, 11.0, '2020-05-18', '2025-05-18', 60, 5000);

-- ABONOS
INSERT INTO abonos (prestamo_id, fecha, monto) VALUES 
(7, '2020-09-15', 5000),
(7, '2021-01-10', 7500),
(7, '2021-05-05', 3200),
(7, '2022-02-17', 2800),
(10, '2019-01-05', 9500),
(10, '2019-06-25', 6700),
(10, '2020-04-15', 12000),
(5, '2021-08-20', 4000),
(5, '2021-12-10', 5000),
(5, '2022-05-30', 3000),
(5, '2022-11-25', 4500),
(2, '2022-05-12', 8000),
(2, '2023-03-05', 6500),
(2, '2023-09-01', 9000),
(2, '2024-02-19', 3000),
(13, '2020-05-17', 9500),
(13, '2021-08-20', 13000),
(13, '2023-03-11', 5000),
(1, '2021-04-15', 5000),
(1, '2022-01-22', 3000),
(1, '2022-07-19', 7000),
(12, '2020-05-11', 9000),
(12, '2021-06-30', 11000),
(9, '2021-02-20', 5000),
(9, '2022-03-11', 3200),
(6, '2020-11-10', 7500),
(6, '2021-09-21', 6000),
(15, '2020-06-10', 2000),
(15, '2021-05-18', 1500),
(3, '2020-08-25', 7000),
(4, '2019-10-17', 9000),
(8, '2021-12-19', 2000),
(11, '2022-02-02', 8500);

-- MOVIMIENTOS
INSERT INTO movimientos (cuenta_id, fecha, tipo_operacion, monto, saldo_anterior, saldo_posterior, descripcion) VALUES 
(3, '2021-01-10', 'RETIRO', 1500, 50000, 48500, 'Retiro en cajero'),
(3, '2021-04-25', 'DEPOSITO', 3000, 48500, 51500, 'Depósito en ventanilla'),
(3, '2021-08-19', 'TRANSFERENCIA', 2500, 51500, 49000, 'Transferencia a tercero'),
(3, '2022-02-14', 'RETIRO', 1700, 49000, 47300, 'Retiro en cajero'),
(3, '2022-12-05', 'DEPOSITO', 2100, 47300, 49400, 'Depósito nómina'),
(5, '2021-03-15', 'DEPOSITO', 4000, 25000, 29000, 'Depósito efectivo'),
(5, '2021-09-07', 'RETIRO', 1200, 29000, 27800, 'Retiro cajero automático'),
(5, '2022-04-30', 'TRANSFERENCIA', 5000, 27800, 22800, 'Pago de servicio'),
(7, '2020-06-11', 'DEPOSITO', 6000, 60000, 66000, 'Depósito inicial'),
(7, '2020-12-18', 'RETIRO', 2500, 66000, 63500, 'Retiro para gastos'),
(7, '2021-05-03', 'TRANSFERENCIA', 3200, 63500, 60300, 'Transferencia familiar'),
(7, '2022-08-25', 'DEPOSITO', 7000, 60300, 67300, 'Depósito ahorro'),
(9, '2020-02-10', 'TRANSFERENCIA', 9500, 9500, 0, 'Pago de tarjeta'),
(9, '2020-07-20', 'DEPOSITO', 3000, 0, 3000, 'Abono a cuenta'),
(9, '2021-02-19', 'RETIRO', 1800, 3000, 1200, 'Retiro efectivo'),
(9, '2022-11-03', 'DEPOSITO', 2700, 1200, 3900, 'Depósito ocasional'),
(10, '2021-09-25', 'RETIRO', 3000, 5000, 2000, 'Retiro para compras'),
(10, '2021-11-02', 'TRANSFERENCIA', 1500, 2000, 500, 'Transferencia programada'),
(10, '2022-03-15', 'DEPOSITO', 4000, 500, 4500, 'Depósito de reembolso'),
(6, '2021-07-07', 'RETIRO', 1200, 12000, 10800, 'Retiro semanal'),
(6, '2022-05-20', 'DEPOSITO', 5000, 10800, 15800, 'Depósito extraordinario'),
(6, '2022-09-09', 'TRANSFERENCIA', 3300, 15800, 12500, 'Pago de préstamo'),
(2, '2020-08-12', 'DEPOSITO', 1000, 8000, 9000, 'Depósito inicial');

-- ====================
-- 5. CONSULTAS DEL MANUAL SQL
-- ====================

-- CONSULTA 1: SELECT BÁSICO
SELECT '=== CONSULTA 1: TODOS LOS CLIENTES ===' AS titulo;
SELECT * FROM clientes LIMIT 5;

-- CONSULTA 2: SELECT CON COLUMNAS ESPECÍFICAS
SELECT '=== CONSULTA 2: CLIENTES CON SALDO ALTO ===' AS titulo;
SELECT 
    c.nombre,
    c.apellidos,
    ct.saldo
FROM clientes c
JOIN cuentas ct ON c.cliente_id = ct.cliente_id
WHERE ct.saldo > 10000
ORDER BY ct.saldo DESC
LIMIT 5;

-- CONSULTA 3: WHERE CON OPERADORES
SELECT '=== CONSULTA 3: CUENTAS CON SALDO ENTRE 5000 Y 20000 ===' AS titulo;
SELECT 
    c.nombre,
    c.apellidos,
    ct.saldo
FROM clientes c
JOIN cuentas ct ON c.cliente_id = ct.cliente_id
WHERE ct.saldo BETWEEN 5000 AND 20000
ORDER BY ct.saldo DESC
LIMIT 5;

-- CONSULTA 4: FUNCIONES DE AGREGACIÓN
SELECT '=== CONSULTA 4: ESTADÍSTICAS DE CUENTAS ===' AS titulo;
SELECT 
    COUNT(*) AS total_cuentas,
    AVG(saldo) AS saldo_promedio,
    MAX(saldo) AS saldo_maximo,
    MIN(saldo) AS saldo_minimo,
    SUM(saldo) AS saldo_total
FROM cuentas;

-- CONSULTA 5: GROUP BY
SELECT '=== CONSULTA 5: SALDO PROMEDIO POR TIPO DE CUENTA ===' AS titulo;
SELECT 
    tc.descripcion AS tipo_cuenta,
    COUNT(*) AS cantidad_cuentas,
    AVG(c.saldo) AS saldo_promedio,
    SUM(c.saldo) AS saldo_total
FROM cuentas c
JOIN tipo_cuenta tc ON c.tipo_cuenta_id = tc.tipo_id
GROUP BY tc.descripcion
ORDER BY saldo_total DESC;

-- CONSULTA 6: HAVING
SELECT '=== CONSULTA 6: TIPOS DE CUENTA CON SALDO PROMEDIO > 20000 ===' AS titulo;
SELECT 
    tc.descripcion AS tipo_cuenta,
    AVG(c.saldo) AS saldo_promedio
FROM cuentas c
JOIN tipo_cuenta tc ON c.tipo_cuenta_id = tc.tipo_id
GROUP BY tc.descripcion
HAVING AVG(c.saldo) > 20000;

-- CONSULTA 7: JOINS MÚLTIPLES
SELECT '=== CONSULTA 7: INFORMACIÓN COMPLETA DE CLIENTES ===' AS titulo;
SELECT 
    cl.nombre || ' ' || cl.apellidos AS cliente_completo,
    c.num_cuenta,
    tc.descripcion AS tipo_cuenta,
    c.saldo,
    t.num_tarjeta,
    tt.descripcion AS tipo_tarjeta,
    p.monto AS prestamo,
    p.tasa_interes
FROM clientes cl
LEFT JOIN cuentas c ON cl.cliente_id = c.cliente_id
LEFT JOIN tipo_cuenta tc ON c.tipo_cuenta_id = tc.tipo_id
LEFT JOIN tarjetas t ON c.cuenta_id = t.cuenta_id
LEFT JOIN tipo_tarjeta tt ON t.tipo_tarjeta_id = tt.tipo_id
LEFT JOIN prestamos p ON cl.cliente_id = p.cliente_id
ORDER BY cl.apellidos, cl.nombre
LIMIT 10;

-- CONSULTA 8: SUBCONSULTA
SELECT '=== CONSULTA 8: CLIENTES CON SALDO MAYOR AL PROMEDIO ===' AS titulo;
SELECT 
    nombre,
    apellidos,
    saldo
FROM (
    SELECT 
        cl.nombre,
        cl.apellidos,
        c.saldo
    FROM clientes cl
    JOIN cuentas c ON cl.cliente_id = c.cliente_id
) AS clientes_con_saldo
WHERE saldo > (SELECT AVG(saldo) FROM cuentas)
ORDER BY saldo DESC
LIMIT 5;

-- CONSULTA 9: RESUMEN EJECUTIVO
SELECT '=== CONSULTA 9: RESUMEN EJECUTIVO ===' AS titulo;
SELECT 
    'Total clientes: ' || (SELECT COUNT(*) FROM clientes) AS metricas,
    'Total cuentas: ' || (SELECT COUNT(*) FROM cuentas) AS metricas,
    'Saldo total: $' || (SELECT TO_CHAR(SUM(saldo), '999,999,999.99') FROM cuentas) AS metricas,
    'Préstamos activos: ' || (SELECT COUNT(*) FROM prestamos) AS metricas,
    'Tarjetas emitidas: ' || (SELECT COUNT(*) FROM tarjetas) AS metricas;

-- CONSULTA 10: MOVIMIENTOS RECIENTES
SELECT '=== CONSULTA 10: ÚLTIMOS MOVIMIENTOS ===' AS titulo;
SELECT 
    c.num_cuenta,
    cl.nombre || ' ' || cl.apellidos AS cliente,
    m.fecha,
    m.tipo_operacion,
    m.monto,
    m.descripcion
FROM movimientos m
JOIN cuentas c ON m.cuenta_id = c.cuenta_id
JOIN clientes cl ON c.cliente_id = cl.cliente_id
ORDER BY m.fecha DESC
LIMIT 10;

-- ====================
-- 6. CONSULTAS AVANZADAS DE ANÁLISIS
-- ====================

-- ANÁLISIS 1: CLIENTES CON MÁS PRODUCTOS
SELECT '=== ANÁLISIS 1: CLIENTES CON MÁS PRODUCTOS ===' AS titulo;
SELECT 
    c.nombre || ' ' || c.apellidos AS cliente,
    COUNT(DISTINCT ct.cuenta_id) AS cuentas,
    COUNT(DISTINCT t.tarjeta_id) AS tarjetas,
    COUNT(DISTINCT p.prestamo_id) AS prestamos,
    (COUNT(DISTINCT ct.cuenta_id) + COUNT(DISTINCT t.tarjeta_id) + COUNT(DISTINCT p.prestamo_id)) AS total_productos
FROM clientes c
LEFT JOIN cuentas ct ON c.cliente_id = ct.cliente_id
LEFT JOIN tarjetas t ON ct.cuenta_id = t.cuenta_id
LEFT JOIN prestamos p ON c.cliente_id = p.cliente_id
GROUP BY c.cliente_id, c.nombre, c.apellidos
ORDER BY total_productos DESC
LIMIT 10;

-- ANÁLISIS 2: PRÉSTAMOS POR VENCER
SELECT '=== ANÁLISIS 2: PRÉSTAMOS POR VENCER (PRÓXIMOS 30 DÍAS) ===' AS titulo;
SELECT 
    p.prestamo_id,
    c.nombre || ' ' || c.apellidos AS cliente,
    p.monto,
    p.saldo_pendiente,
    p.fecha_limite,
    p.tasa_interes
FROM prestamos p
JOIN clientes c ON p.cliente_id = c.cliente_id
WHERE p.fecha_limite BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '30 days'
ORDER BY p.fecha_limite;

-- ANÁLISIS 3: MOVIMIENTOS POR DÍA DE LA SEMANA
SELECT '=== ANÁLISIS 3: MOVIMIENTOS POR DÍA DE LA SEMANA ===' AS titulo;
SELECT 
    EXTRACT(DOW FROM fecha) AS dia_semana,
    CASE EXTRACT(DOW FROM fecha)
        WHEN 0 THEN 'Domingo'
        WHEN 1 THEN 'Lunes'
        WHEN 2 THEN 'Martes'
        WHEN 3 THEN 'Miércoles'
        WHEN 4 THEN 'Jueves'
        WHEN 5 THEN 'Viernes'
        WHEN 6 THEN 'Sábado'
    END AS nombre_dia,
    COUNT(*) AS total_movimientos,
    SUM(monto) AS monto_total
FROM movimientos
GROUP BY dia_semana
ORDER BY dia_semana;

-- ANÁLISIS 4: CLIENTES POR RANGO DE EDAD
SELECT '=== ANÁLISIS 4: CLIENTES POR RANGO DE EDAD ===' AS titulo;
SELECT 
    CASE 
        WHEN EXTRACT(YEAR FROM AGE(fecha_nac)) BETWEEN 18 AND 25 THEN '18-25'
        WHEN EXTRACT(YEAR FROM AGE(fecha_nac)) BETWEEN 26 AND 35 THEN '26-35'
        WHEN EXTRACT(YEAR FROM AGE(fecha_nac)) BETWEEN 36 AND 45 THEN '36-45'
        WHEN EXTRACT(YEAR FROM AGE(fecha_nac)) BETWEEN 46 AND 55 THEN '46-55'
        ELSE '56+'
    END AS rango_edad,
    COUNT(*) AS cantidad_clientes,
    ROUND(AVG(ct.saldo), 2) AS saldo_promedio
FROM clientes c
LEFT JOIN cuentas ct ON c.cliente_id = ct.cliente_id
GROUP BY rango_edad
ORDER BY rango_edad;

-- ANÁLISIS 5: TARJETAS PRÓXIMAS A VENCER
SELECT '=== ANÁLISIS 5: TARJETAS PRÓXIMAS A VENCER ===' AS titulo;
SELECT 
    t.num_tarjeta,
    c.num_cuenta,
    cl.nombre || ' ' || cl.apellidos AS cliente,
    t.expira,
    t.fecha_vencimiento
FROM tarjetas t
JOIN cuentas c ON t.cuenta_id = c.cuenta_id
JOIN clientes cl ON c.cliente_id = cl.cliente_id
WHERE t.fecha_vencimiento BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '90 days'
ORDER BY t.fecha_vencimiento;

-- ====================
-- 7. RESUMEN FINAL
-- ====================
SELECT '=== SISTEMA BANCARIO COMPLETO CREADO Y CONSULTADO ===' AS mensaje_final;
SELECT '=== RESUMEN FINAL ===' AS titulo;
SELECT 
    'Clientes: ' || COUNT(*) AS resumen FROM clientes
UNION ALL SELECT 'Cuentas: ' || COUNT(*) FROM cuentas
UNION ALL SELECT 'Tarjetas: ' || COUNT(*) FROM tarjetas
UNION ALL SELECT 'Préstamos: ' || COUNT(*) FROM prestamos
UNION ALL SELECT 'Movimientos: ' || COUNT(*) FROM movimientos
UNION ALL SELECT 'Abonos: ' || COUNT(*) FROM abonos;
