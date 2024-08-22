package dev.yabyab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SwapplesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwapplesServerApplication.class, args);
	}

}
