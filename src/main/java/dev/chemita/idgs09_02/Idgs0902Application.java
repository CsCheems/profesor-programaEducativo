package dev.chemita.idgs09_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "dev.chemita.idgs09_02.clients")
public class Idgs0902Application {

	public static void main(String[] args) {
		SpringApplication.run(Idgs0902Application.class, args);
	}

}
