package ecs.sample.backend.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EntityScan("ecs.sample.backend.app.model.entity")
@EnableJpaRepositories(basePackages="ecs.sample.backend.app.repository")
public class App {
	
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
