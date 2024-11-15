 

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.taxi.eljanoub", "controller", "service", "repository", "mapper", "config"})
@EntityScan("model")
@EnableJpaRepositories("repository")
public class TaxiElJanoubApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaxiElJanoubApplication.class, args);
    }
}