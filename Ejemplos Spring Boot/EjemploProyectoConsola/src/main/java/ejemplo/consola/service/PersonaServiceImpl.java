package ejemplo.consola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ejemplo.consola.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService{
	
	@Autowired
	@Qualifier("persona2")
	private IPersonaRepo repo;

	@Override
	public void agregar(String nombre) {		
		repo.agregar(nombre);		
	}	
	

}
