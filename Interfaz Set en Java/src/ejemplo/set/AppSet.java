package ejemplo.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AppSet {

	public static void main(String[] args) {
		//HashSet no agrega duplicados aunque no se preocupa del orden
		Set<String> lista = new HashSet<String>();
		lista.add("Carlos");
		lista.add("Carlos");
		lista.add("Sonia");
		lista.add("Raul");
		lista.add("Raul1");
		lista.add("Sonia");
		
		for (String cadena : lista) {
			System.out.println(cadena);			
		}
		
		System.out.println("***********************");
		
		//Si en lugar de tipos primitivos utilizamos objetos, aunque los parámetros del objeto
		//sean iguales, son objetos diferentes
		//Necesitamos sobreescribir 2 métodos hashCode y equals
		Set<Persona> lista1 = new HashSet<Persona>();
		
		lista1.add(new Persona(1, "Carlos", 40));
		lista1.add(new Persona(1, "Raul", 8));
		lista1.add(new Persona(1, "Sonia", 38));
		lista1.add(new Persona(1, "Carlos", 40));

		for (Persona persona : lista1) {
			System.out.println(persona.getNombre());
		}
		
		System.out.println("**** TREESET *******");
		
		//La implementación TREESET no admite duplicados y ordena alfabéticamente
		Set<String> lista2 = new TreeSet<String>();
		
		lista2.add("Carlos");
		lista2.add("Sonia");
		lista2.add("Raúl");
		lista2.add("Raúl");
		
		for (String string : lista2) {
			System.out.println(string);
			
		}
		
		System.out.println("***********************");
		
		Set<Persona> lista3 = new TreeSet<Persona>();
		
		lista3.add(new Persona(1, "Carlos", 25));
		lista3.add(new Persona(2, "Sonia", 26));
		lista3.add(new Persona(3, "Raul", 27));
		lista3.add(new Persona(3, "Raul", 27));
		lista3.add(new Persona(5, "Laura", 28));
		lista3.add(new Persona(6, "Diego", 29));
		lista3.add(new Persona(7, "Diego", 39));
		
		for (Persona per : lista3) {
			System.out.println(per.getId() + "-" + per.getNombre() + "-" + per.getEdad());
			
		}
		
		System.out.println("**** LINKEDHASHSET *******");
		
		//La implementación LINKEDHASHSET no admite duplicados y ordena los elementos por orden de agregado a la lista
		Set<String> lista4 = new LinkedHashSet<String>();
				
		lista4.add("Raúl");
		lista4.add("Carlos");
		lista4.add("Sonia");		
		lista4.add("Raúl");
				
		for (String string : lista4) {
			System.out.println(string);			
		}
	}
	
	/*
	 * RESUMEN DE IMPLEMENTACIÓN SET
	 *                    HASHSET    TREESET     LINKEDHASHSET
	 * VALORES UNICOS     SI         SI          SI
	 * ORDEN              ALEATORIO  ALFABETICO  AGREGADO A LA LISTA
	 * 
	 * Para realizar un orden sobre un campo concreto de un objeto implementar el métido compareTo en el objeto
	 * Para forzar que no admita objetos duplicados según los campos del objeto sobreescribir los métidos hashcode y equals
	 */
	
	

}
