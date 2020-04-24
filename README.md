# Master Microservices with Spring Boot and Spring Cloud : PART 2 - Microservices with Spring Cloud

## Context

* Learning : <https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/learn/lecture/8005704#overview>
* Resources : [GitHub](https://github.com/in28minutes/spring-microservices/tree/master/03.microservices) et [FAQ](https://github.com/in28minutes/in28minutes-initiatives/blob/master/The-in28Minutes-TroubleshootingGuide-And-FAQ/quick-start.md)

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
* **Spring Cloud Config Server** : `spring-cloud-config-server` as a dependency, annotation `@EnableConfigServer` in main class, `spring.cloud.config.server.git.uri` in configuration file application.properties
* **Any service** : `spring-cloud-starter-config` as a dependency, `spring.application.name` and `spring.cloud.config.uri` in configuration file renamed as bootstrap.properties.
* **Git Repository** : contains configuration files for each service/env : {spring.application.name}[dev|qa|blabla].properties

## Best pratices
TODO conf accessible ici http://localhost:8888/limits-service/[default|dev|qa...]
* **Dependencies**
    * Every service should add Config-Client `spring-cloud-starter-config` as a dependency to be able to connect to the Spring-Cloud config server.
    * While the Config server has `spring-cloud-config-server`
* **Naming** : Give a name to your applications `spring.application.name` to easily identify it
* **Configuration** : prefix your properties with the application name to easily identify them
    * Retrieve them with a class annoted with `@ConfigurationProperties`

## Debugging Problems with...
* [Spring Cloud Config Server](https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ#debugging-problems-with-spring-cloud-config-server)


## Startup


### Reference Documentation
For further reference, please consider the following sections:

* [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/)

### Guides
The following guides illustrate how to use some features concretely:

* TODO see <https://dzone.com/articles/using-spring-config-server>
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
