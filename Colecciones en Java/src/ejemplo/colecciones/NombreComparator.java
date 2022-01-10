package ejemplo.colecciones;

import java.util.Comparator;

public class NombreComparator implements Comparator<Persona>{

	@Override
	public int compare(Persona per1, Persona per2) {
		return (per1.getNombre().compareTo(per2.getNombre()));
	}
	
	

}
