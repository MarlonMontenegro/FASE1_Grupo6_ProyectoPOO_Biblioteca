CREATE DATABASE IF NOT EXISTS MediatecaDB;
USE MediatecaDB;

-- Tabla para los tipos de material
CREATE TABLE TipoMaterial (
    id_tipo INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

-- Tabla principal de Material
CREATE TABLE Material (
    id_material CHAR(10) PRIMARY KEY, 
    titulo VARCHAR(255) NOT NULL,
    unidades_disponibles INT NOT NULL CHECK (unidades_disponibles >= 0),
    id_tipo INT NOT NULL,
    FOREIGN KEY (id_tipo) REFERENCES TipoMaterial(id_tipo) ON DELETE RESTRICT
);

-- Tabla para libros
CREATE TABLE Libro (
    id_material CHAR(10) PRIMARY KEY,
    autor VARCHAR(255) NOT NULL,
    numero_paginas INT NOT NULL CHECK (numero_paginas > 0),
    editorial VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    anio_publicacion YEAR NOT NULL CHECK (anio_publicacion >= 1800),
    FOREIGN KEY (id_material) REFERENCES Material(id_material) ON DELETE CASCADE
);

-- Tabla para revistas
CREATE TABLE Revista (
    id_material CHAR(10) PRIMARY KEY,
    editorial VARCHAR(255) NOT NULL,
    periodicidad VARCHAR(50) NOT NULL,
    fecha_publicacion DATE NOT NULL,
    FOREIGN KEY (id_material) REFERENCES Material(id_material) ON DELETE CASCADE
);

-- Tabla para CDs de audio
CREATE TABLE CD_Audio (
    id_material CHAR(10) PRIMARY KEY,
    artista VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    duracion INT NOT NULL CHECK (duracion > 0),  -- Almacenado en segundos
    numero_canciones INT NOT NULL CHECK (numero_canciones > 0),
    FOREIGN KEY (id_material) REFERENCES Material(id_material) ON DELETE CASCADE
);

-- Tabla para DVDs
CREATE TABLE DVD (
    id_material CHAR(10) PRIMARY KEY,
    director VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    duracion INT NOT NULL CHECK (duracion > 0),  -- Almacenado en segundos
    FOREIGN KEY (id_material) REFERENCES Material(id_material) ON DELETE CASCADE
);


-- Insertar datos 
INSERT INTO TipoMaterial (nombre) VALUES 
('LIBRO'), 
('REVISTA'), 
('CDA'), 
('DVD');


INSERT INTO Material (id_material, titulo, unidades_disponibles, id_tipo) VALUES 
('LIB00001', 'Cien años de soledad', 5, 1), 
('LIB00002', '1984', 3, 1), 
('REV00001', 'National Geographic - Edición especial', 2, 2), 
('REV00002', 'Science Magazine', 4, 2), 
('CDA00001', 'Thriller - Michael Jackson', 6, 3), 
('CDA00002', 'The Beatles - Abbey Road', 3, 3), 
('DVD00001', 'Interstellar', 7, 4), 
('DVD00002', 'Inception', 5, 4);


INSERT INTO Libro (id_material, autor, numero_paginas, editorial, isbn, anio_publicacion) VALUES 
('LIB00001', 'Gabriel García Márquez', 417, 'Editorial Sudamericana', '978-0307474728', 1967),
('LIB00002', 'George Orwell', 328, 'Secker & Warburg', '978-0451524935', 1949);

INSERT INTO Revista (id_material, editorial, periodicidad, fecha_publicacion) VALUES 
('REV00001', 'National Geographic Society', 'Mensual', '2024-02-01'),
('REV00002', 'American Association for the Advancement of Science', 'Semanal', '2024-03-15');


INSERT INTO CD_Audio (id_material, artista, genero, duracion, numero_canciones) VALUES 
('CDA00001', 'Michael Jackson', 'Pop', 2520, 9),  -- 42 minutos
('CDA00002', 'The Beatles', 'Rock', 2652, 17);   -- 44 minutos

INSERT INTO DVD (id_material, director, genero, duracion) VALUES 
('DVD00001', 'Christopher Nolan', 'Ciencia Ficción', 10140),  -- 169 minutos
('DVD00002', 'Christopher Nolan', 'Acción', 8880);           -- 148 minutos