package com.springboot.SpringBootProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/*
 @SpringBootApplication annotation is a combination of three annotations :
 	@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration

 a) @EnableAutoConfiguration : to enable Spring Boot's auto-configuration feature.
 Auto configuration will auto configure features like embedded tomcat server and we have already 
 seen we are not writing any code to connect to database which is automatically configured internally 
 with help of @EnableAutoConfiguration
 
 EnableAutoConfiguration does auto configuration depends on dependency file we added in pom.xml
 eg : In out project we added spring-boot-starter-data-jpa and mysql-connector-java dependencies
 so instead of we writing hibernate code to connect to database internally spring boot is taking care to connect
 to database
 
 Not only this it is doing lot of other things
 
 In order for Spring to do auto configuration we need to add @SpringBootApplication
 spring initialzr is taking care of adding this annotation while creating so we dont add this specifically
 We dont need to add EnableAutoConfiguration annotation seperately beacuse @SpringBootApplication internally contains this.
 
 
 Let say we dont want Spring Boot to auto configure database for us we can exclude that by using 
 
 @EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 
 b) @Configuration to enable Java-based configuration
  Let say we want to do our own configuartion we can create class and annoatate with @Configuration
  create a method with @Bean and write the code.
  
  @Bean is used to inject to inject the dependency;
  
 
 c) @ComponentScan annotation is used to specify the packages to look for Component classes.
	we can pass the package names to this annotation
	Spring boot create the beans only for classes that configured inside this packages. 
 
*/
// when project is created we will see only @SpringBootApplication
// @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ComponentScan(value= {"com.springboot.SpringBootProject"} )
//multiple packages
//@ComponentScan({"com.my.package.first","com.my.package.second"})

//@EnableEurekaClient
public class SpringBootProjectApplication {
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		/*
		 * create AnnotationConfigApplicationContext object
		 * and immedaitely all the beans inside out project will be created 
		 * it is going to recognize beans with help of brlow annoations
		 * @Controller,@Service,@Repository,@Component
		 * 
		 */
	}

}
