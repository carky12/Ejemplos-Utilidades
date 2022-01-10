package ejemplo.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ejemplo.demoweb.modelo.Persona;

public interface IPersonaRepository extends JpaRepository<Persona, Integer>{
	

}
