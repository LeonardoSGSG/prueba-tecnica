# Proyecto: Gestión de Empleados y Oficinas

Este proyecto es una API desarrollada en Spring Boot para la gestión de empleados y oficinas. Incluye endpoints para crear, actualizar, eliminar y consultar empleados y oficinas, además de documentación API generada con Swagger y pruebas unitarias implementadas con JUnit y Mockito.

---

## ✅ **Requisitos Previos**

- Java JDK 17 o superior
- Apache Maven
- IDE recomendado: IntelliJ IDEA o Eclipse

---

## ✅ **Instrucciones para Ejecutar el Proyecto**

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/usuario/prueba-tecnica.git
   cd prueba-tecnica
   ```

2. Compilar el proyecto:

   ```bash
   mvn clean install
   ```

3. Ejecutar el proyecto:

   ```bash
   mvn spring-boot:run
   ```

4. Acceso a la API:

   - Base URL: `http://localhost:5173`

---

## ✅ **Ver la Documentación de la API (Swagger)**

1. Asegúrate de que el proyecto esté en ejecución.

2. Accede a la documentación generada por Swagger en la siguiente URL:

   ```
   http://localhost:8080/swagger-ui/index.html
   ```

3. En caso de problemas al acceder a la documentación, verifica:
   - Las dependencias de Swagger en `pom.xml`.
   - La configuración de `SwaggerConfig.java`.
   - El contexto del servidor en `application.properties`.

---

## ✅ **Ejecutar las Pruebas Unitarias**

1. Asegúrate de haber compilado el proyecto:

   ```bash
   mvn clean install
   ```

2. Ejecuta todas las pruebas:

   ```bash
   mvn test
   ```

3. Los resultados se mostrarán en la consola.

4. Las pruebas cubren:
   - Servicios (`OfficeServiceTest.java`)
   - Controladores (`OfficeControllerTest.java`)

---
