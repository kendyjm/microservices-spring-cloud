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
* **Spring Cloud Config Server** : `spring-cloud-config-server` (config-server) as a dependency, annotation `@EnableConfigServer` in main class, `spring.cloud.config.server.git.uri` in configuration file application.properties
* **Any service** : `spring-cloud-starter-config` (config-client) as a dependency, `spring.application.name` and `spring.cloud.config.uri` in configuration file renamed as bootstrap.properties.
* **Git Repository** : contains configuration files for each service/env : {spring.application.name}[dev|qa|blabla].properties
* **OpenFeign** : Is a declarative REST Client: Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations (see `@FeignClient`)
* **Ribbon** : allows client-side loadbalancing (see `spring-cloud-starter-netflix-ribbon`, `@RibbonClient` and `<serviceName>.ribbon.listOfServers`). [Somes details](https://github.com/Netflix/ribbon/wiki/Working-with-load-balancers#common-rules) about rules available.
* **Eureka** : service registry, useful because it makes client-side load-balancing easier and decouples service providers from consumers without the need for DNS. see `spring-cloud-starter-netflix-eureka-server`, `@EnableEurekaServer`, `eureka.client.register-with-eureka`, `eureka.client.fetch-registry`, [Eureka UI](http://localhost:8761/)

## Best pratices
TODO conf accessible ici http://localhost:8888/limits-service/[default|dev|qa...]
* **Dependencies**
    * Every service should add Config-Client `spring-cloud-starter-config` as a dependency to be able to connect to the Spring-Cloud config server.
    * While the Config server has `spring-cloud-config-server`
* **Naming** : Give a name to your applications `spring.application.name` to easily identify it
* **Configuration** : prefix your properties with the application name to easily identify them
    * Retrieve them with a class annotated with `@ConfigurationProperties`
 
## Spring Cloud Netflix Maintenance Mode

Some dependencies used in this project are in maintenance mode:

* Ribbon

The decision to move most of the Spring Cloud Netflix projects to maintenance mode was
a response to Netflix not continuing maintenance of many of the libraries that Spring provided
support for.

See [this blog entry](https://spring.io/blog/2018/12/12/spring-cloud-greenwich-rc1-available-now#spring-cloud-netflix-projects-entering-maintenance-mode)
for more information on maintenance mode and a list of suggested replacements for those libraries.

## Debugging Problems
* [Activate Spring Boot profile from IntelliJ](https://stackoverflow.com/a/52487280)
* [Share IntelliJ RUN configurations](https://www.jetbrains.com/help/idea/sharing-run-debug-configurations.html#)
* [Spring Cloud Config Server](https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ#debugging-problems-with-spring-cloud-config-server)
* [Feign and Ribbon](https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ#debugging-problems-with-feign-and-ribbon)
* [Naming Server Eureka and Ribbon](https://github.com/in28minutes/in28minutes-initiatives/tree/master/The-in28Minutes-TroubleshootingGuide-And-FAQ#debugging-problems-with-naming-server-eureka-and-ribbon)


## Startup

### Reference Documentation
For further reference, please consider the following sections:

* [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/reference/html/)
* [Bootstrap Application Context](https://cloud.spring.io/spring-cloud-commons/multi/multi__spring_cloud_context_application_context_services.html#_the_bootstrap_application_context)
* [Spring Cloud OpenFeign : Declarative REST Client](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html)
* [Ribbon : Client-side load-balancing](https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html)
* [Eureka : Service Registration and Discovery](https://cloud.spring.io/spring-cloud-netflix/reference/html/#spring-cloud-eureka-server)

### Guides
The following guides illustrate how to use some features concretely:

* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Spring Cloud OpenFeign : Declarative REST Client](https://spring.io/projects/spring-cloud-openfeign)
* [Ribbon : Client-side load-balancing](https://spring.io/guides/gs/client-side-load-balancing/)
* [Eureka : Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)
