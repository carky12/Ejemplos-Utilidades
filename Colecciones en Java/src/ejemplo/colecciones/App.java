package ejemplo.colecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		//A nivel de rendimiento es mejor poner la capacidad inicial de la lista
		//Si no se establece el número inicial de elementos por defecto es 10
		List<String> lista = new ArrayList<String>(300);
		
		List<Integer> listaInt = new ArrayList<Integer>();
		
		listaInt.add(25);
		listaInt.add(100);
		listaInt.add(1);
		
		//Podemos usar la API Collections para ordenar una lista
		Collections.sort(listaInt);
		//Collections.reverse(listaInt); //ordena la lista en orden inverso en el que se agregaron a la lista 
		
		System.out.println(listaInt);
		
		//Veamos como ordenar una lista de objetos según un criterio, utilizando la interfaz Comparator
		//Ordenamos la lista por nombre. Si queremos comparar por otro campo tendremos que crear otra clase
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		listaPersonas.add(new Persona(1, "Carlos", 40));
		listaPersonas.add(new Persona(2, "Sonia", 30));
		listaPersonas.add(new Persona(3, "Raúl", 20));
		
		Collections.sort(listaPersonas, new NombreComparator());
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona.getNombre());
		}
		
		//Como la clase persona implementa comparable con su método compareTo
		//podemos utilizar el sort de Collections		
		Collections.sort(listaPersonas);
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona.getNombre());
		}
		
		
		
		

	}

}
