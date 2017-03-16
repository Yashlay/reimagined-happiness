package com.example;

        import com.example.datalayer.CustomerRepositury;
        import com.example.model.Customer;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.actuate.health.Health;
        import org.springframework.boot.actuate.health.HealthIndicator;
        import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
        import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
        import org.springframework.context.annotation.Bean;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;
        import springfox.documentation.swagger2.annotations.EnableSwagger2;

        import java.util.List;

@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})

@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    HealthIndicator healthIndicator(){
        return ()-> Health.status("I am ").build();
    }
}




