# Spring Security and LDAP
To run `./mvnw spring-boot:run`

## Testing
In browser, go to "localhost:8080" and login using username "ben" and password "benspassword".

Ben is a developer, so you can then view "localhost:8080/hello" but
he is not a manager, so you can't view "localhost:8080/managers".
Instead you get a 403 error.

## Springfox Swagger and Swagger UI
Swagger is implemented using Springfox via this tutorial: https://www.tutorialspoint.com/spring_boot/spring_boot_enabling_swagger2.htm.

### Change from version 2.9.2 to 3.0.0
To view Swagger UI, go to localhost:8080/swagger-ui/index.html NOT localhost:8080/swagger-ui.html.

