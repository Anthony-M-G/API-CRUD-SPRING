Proyecto CRUD con Spring Boot, Spring Data JPA, Lombok, Spring Web y MySQL
Este proyecto es un ejemplo de cómo crear un CRUD (create-read-update-delete) para administrar estudiantes utilizando tecnologías de Spring y una base de datos MySQL.

Requisitos previos
Antes de comenzar, asegúrate de tener instalado lo siguiente:

JDK 8+: Asegúrate de tener Java Development Kit instalado en tu máquina.
MySQL: Instala y configura MySQL en tu entorno local.
IDE favorito: Utiliza tu IDE preferido (por ejemplo, Eclipse, IntelliJ IDEA) para desarrollar el proyecto.
Creación del proyecto
Ve a Spring Initializr.
Selecciona las siguientes opciones:
Maven Project
Java
Última versión de Spring Boot
Completa los siguientes metadatos:
Group: com.crud
Artifact: msstudent
Name: msstudent
Packaging: Mantén la opción predeterminada (JAR).
Agrega las siguientes dependencias:
Web
JPA
MySQL
Lombok
Haz clic en Generate para descargar un archivo ZIP con la estructura básica del proyecto.
Descomprime el archivo ZIP y ábrelo en tu IDE.
Estructura del proyecto
La estructura de directorios debería verse así:

├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── crud
│       │           └── msstudent
│       │               └── MsstudentApplication.java
│       └── resources
│           ├── static
│           ├── templates
│           └── application.properties
└── pom.xml

Implementación del CRUD
Crea una entidad Student con las propiedades firstName, lastName y email.
Crea una interfaz StudentRepository que extienda JpaRepository<Student, Long>.
Implementa un controlador REST con los siguientes endpoints:
GET /students: Obtiene todos los estudiantes.
GET /students/{id}: Obtiene un estudiante por su ID.
POST /students: Crea un nuevo estudiante.
PUT /students/{id}: Actualiza los datos de un estudiante existente.
DELETE /students/{id}: Elimina un estudiante por su ID.

Pruebas con PostMan
