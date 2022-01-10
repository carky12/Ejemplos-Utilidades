package ejemplo.primeraweb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ejemplo.demoweb.EjemploDemoWeb;
import ejemplo.demoweb.modelo.Usuario;
import ejemplo.demoweb.repository.IUsuarioRepository;

@SpringBootTest(classes = EjemploDemoWeb.class)
public class PrimeraWebApplicationTests {

	@Autowired
	private IUsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void crearUsuarioTests() {
		Usuario user = new Usuario(2, "admin", encoder.encode("1234"));
		
		Usuario userInsertado = repo.save(user);
		
		assertTrue(userInsertado.getPass().equalsIgnoreCase(user.getPass()));
	}

}
