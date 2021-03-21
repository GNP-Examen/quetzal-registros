package quetzal.registros;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuetzalRegistrosApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QuetzalRegistrosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(QuetzalRegistrosApplication.class, args);
		LOGGER.info("APP RUNING");
	}

}
