# Proyecto Mediateca - Experiencia de Aprendizaje 2

Este repositorio contiene la solución completa a los desafíos planteados en la **Experiencia de Aprendizaje 2** del módulo de desarrollo de software. El proyecto se centra en la gestión de materiales disponibles en una mediateca utilizando UML, bases de datos en MySQL, y una aplicación Java con interfaces gráficas.

## Tabla de contenidos

- [Resumen del desafío](#resumen-del-desafío)
- [Tecnologías utilizadas](#tecnologías-utilizadas)
- [Desafío 1 - Análisis y base de datos](#desafío-1---análisis-y-base-de-datos)
- [Desafío 2 - Desarrollo del sistema](#desafío-2---desarrollo-del-sistema)
- [Ejecución del proyecto](#ejecución-del-proyecto)
- [Autores](#autores)

---

## Resumen del desafío

### 📌 Desafío 2

- Desarrollo de una aplicación en **Java con Swing** que implemente la funcionalidad para gestionar materiales.
- Uso de **Programación Orientada a Objetos (POO)** aplicando herencia y clases abstractas.
- **Persistencia de datos** mediante archivos o base de datos.
- Conexión con MySQL y uso de tablas (`JTable`) para visualización.

---

## Tecnologías utilizadas

- Lenguaje: **Java**
- GUI: **Swing (Java)**
- Base de datos: **MySQL**
- Modelo de datos: **UML, Diagrama ER**
- IDE: **IntelliJ IDEA**

---

## Desafío 1 - Análisis y base de datos

- Diagrama de casos de uso en UML
- Modelo entidad-relación (ER)
- Script SQL de creación de tablas
- Convenciones para código de materiales:
  - LIBxxxxx → Libros
  - REVxxxxx → Revistas
  - CDAxxxxx → CDs de audio
  - DVDxxxxx → DVDs

---

## Desafío 2 - Desarrollo del sistema

### Funcionalidades:

- Agregar material
- Modificar material
- Listar materiales disponibles (usando `JTable`)
- Eliminar material
- Buscar material
- Salir

### Materiales gestionados:

- **Libros**: título, autor, páginas, editorial, ISBN, año, unidades
- **Revistas**: título, editorial, periodicidad, fecha publicación, unidades
- **CDs de audio**: título, artista, género, duración, canciones, unidades
- **DVDs**: título, director, duración, género

### Principios aplicados:

- Herencia
- Clases abstractas
- Validación de entradas
- Almacenamiento en archivos o conexión a base de datos

---

## Ejecución del proyecto

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tuusuario/proyecto-mediateca.git
   ```

## Autores

Proyecto realizado por:

- [Andrea Paola Montenegro Paz](https://github.com/andreapaola-m)
- [Marlon Eduardo Montenegro Paz](https://github.com/marlonmontenegro)
- [Bryan Benjamín Henríquez Salmerón](https://github.com/bryanhenriquez)
- [Mateo Alejandro Ledesma Mendoza](https://github.com/mateoledesma)
