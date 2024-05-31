# microservices_springboot_JWTtoken_SpringSecurity
Microservices with Spring Boot — Authentication with JWT and Spring Security
JWT token based authentication flow:
    Get the JWT based token from the authentication endpoint, eg /login.
    Extract token from the authentication result.
    Set the HTTP header as Authorization and value as Bearer jwt_token.
    Then send a request to access the protected resources.
    If the requested resource is protected, Spring Security will use our custom Filter to validate the JWT token, and build an Authentication object and set it in Spring Security specific SecurityContextHolder to complete the authentication progress.
    If the JWT token is valid it will return the requested resource to client.

Steps:

(1) Create a Eureka server (eureka-server)

(2) Create a gateway using spring-boot microservice.gateway will act as proxy server.

(3) Create one microservice with Eureka client dependency and register them in Eureka server. (admin-service: responsible for admin CRUD)

(4) Create another microservice responsible for login (login-service)

(5) Test the application with various API endpoints at specific microservices.

(6) Now add Spring security dependency in the gateway and check how it is affecting our application.

(7) Make the changes and test the application. Yes, we are done !!!!


===> first start the Eureka server , then register all the services in Eureka.
===> Run the Login-service/login POST API give username and password (I have given username:superadmin password:superadmin)
===> This request gives the JWT token as a response.
===> Now We have added spring security. So if you want to run any admin URl then you should give generated token in header, key:Authorization and value:generatedJWTtoken
===> if you give generated token in header Authorization then only you can access the API endpoints of admin, else you get the error
