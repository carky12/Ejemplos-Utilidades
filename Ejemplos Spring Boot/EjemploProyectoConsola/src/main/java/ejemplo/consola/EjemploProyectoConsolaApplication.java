package ejemplo.consola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ejemplo.consola.service.IPersonaService;

@SpringBootApplication
public class EjemploProyectoConsolaApplication implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(EjemploProyectoConsolaApplication.class);
	
	@Autowired	
	private IPersonaService service;
	
	public static void main(String[] args) {
		SpringApplication.run(EjemploProyectoConsolaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {		
		//System.out.println("hola desde el proyecto de consola!");
		LOG.info("Hola desde el proyecto de consola!");
		LOG.warn("Mensaje de advertencia!");
		service.agregar("Carlos");
	}

	
	
}
