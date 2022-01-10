package ejemplo.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ejemplo.demoweb.modelo.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Usuario findByNombre(String nombre);

}
