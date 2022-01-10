package ejemplo.consola.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("persona1")
public class PersonaRepoImpl implements IPersonaRepo{

	private static Logger LOG = LoggerFactory.getLogger(PersonaRepoImpl.class);
	
	@Override
	public void agregar(String nombre) {
		LOG.info("Se agregó la persona con nombre " + nombre);		
	}
	

}
