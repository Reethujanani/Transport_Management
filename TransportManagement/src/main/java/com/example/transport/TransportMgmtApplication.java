package com.example.transport;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransportMgmtApplication {
	private static final Logger LOGGER= (Logger) LoggerFactory.getLogger(TransportMgmtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransportMgmtApplication.class, args);
		LOGGER.info("Welcome to transport management");
	}

}
