
Proyecto CRUD con Spring Boot, Spring Data JPA, Lombok, Spring Web y MySQL
Este proyecto es un ejemplo de cómo crear un CRUD (create-read-update-delete) para administrar estudiantes utilizando tecnologías de Spring y una base de datos MySQL.


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
