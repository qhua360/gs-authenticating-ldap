# Spring Security and LDAP
To run `./mvnw spring-boot:run`

## Testing
In browser, go to "localhost:8080" and login using username "ben" and password "benspassword".

Ben is a developer, so you can then view "localhost:8080/hello" but
he is not a manager, so you can't view "localhost:8080/managers".
Instead you get a 403 error.

