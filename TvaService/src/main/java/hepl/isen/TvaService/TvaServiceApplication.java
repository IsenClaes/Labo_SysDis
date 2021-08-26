package hepl.isen.TvaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TvaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TvaServiceApplication.class, args);
	}

}
