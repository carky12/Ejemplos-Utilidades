package ejemplo.genericos;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Carlos
 * El objetivo de los genericos es:
 * - seguridad del tipado 
 * - evitar casteos innecesarios
 */
public class App {

	public static void main(String[] args) {
		Clase<String> c = new Clase<String>("Hola");		
		c.mostrarTipo();
		
		//Las listas por defecto no son safety type
		List lista = new ArrayList<>();
		
		lista.add("Hola");
		lista.add(25); //Podemos guardar un intenger
		
		//Con los genéricos evitamos esto y añadimos la ventaja de no tener que hacer un casteo al recuperar
		//un elemento de la lista
		List<String> lista2 = new ArrayList<String>();
		
		lista2.add("Hola");
		lista2.add("Bienvenidos");
		//lista2.add(25); no podemos guardar un intenger
		
		//Los arrays por defecto si que son safety type
		String[] array = new String[5];
		
		array[0] = "Hola";
		//array[1] = 23; no podemos guardar un intenger
		

	}

}
