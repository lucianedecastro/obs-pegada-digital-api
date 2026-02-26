package br.org.obspegadadigital.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObsPegadaDigitalApplication {

	public static void main(String[] args) {
		// Inicia o motor do Spring Boot
		SpringApplication.run(ObsPegadaDigitalApplication.class, args);

		System.out.println("🌱 Observatório de Pegada Digital está ONLINE!");
		System.out.println("🔗 Rastreabilidade e Auditoria ativas.");
	}
}
