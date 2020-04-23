# Master Microservices with Spring Boot and Spring Cloud : PART 2 - Microservices with Spring Cloud

## Context

* Formation: <https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/8005704#overview>
* Resources de la formation: [GitHub](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices) et [FAQ](https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md)

## Content

* Establishing Communication between Microservices
* Centralized Microservice Configuration with Spring Cloud Config Server
* Using Spring Cloud Bus to exchange messages about Configuration updates
* Simplify communication with other Microservices using Feign REST Client
* Implement client side load balancing with Ribbon
* Implement dynamic scaling using Eureka Naming Server and Ribbon
* Implement API Gateway with Zuul
* Implement Distributed tracing with Spring Cloud Sleuth and Zipkin
* Implement Fault Tolerance with Zipkin

## Keywords 

## Best pratices
TODO see <https://dzone.com/articles/using-spring-config-server> "emember that the variable spring.application.nameset the application name and indicates the name of the file in the GIT repository where the settings were sought."
* **Dependencies**
    * Every service should add Config-Client `spring-cloud-starter-config` as a dependency to be able to connect to the Spring-Cloud config server.
    * While the Config server has `spring-cloud-config-server` as a dependency AND annotation `@EnableConfigServer` in main class
* **Naming** : Give a name to your applications `spring.application.name` to easily identify it
* **Configuration** : prefix your properties with the application name to easily identify them
    * Retrieve them with a class annoted with `@ConfigurationProperties`


## Startup


