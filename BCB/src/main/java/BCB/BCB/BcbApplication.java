package BCB.BCB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("BCB.BCB")
@EnableJpaRepositories(basePackages = "BCB.BCB")
public class BcbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcbApplication.class, args);
	}

}