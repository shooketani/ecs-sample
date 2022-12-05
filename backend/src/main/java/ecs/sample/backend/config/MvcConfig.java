package ecs.sample.backend.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("ecs.sample.backend.app.web")
public class MvcConfig implements WebMvcConfigurer {

}
