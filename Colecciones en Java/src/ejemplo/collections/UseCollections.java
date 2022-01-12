package ejemplo.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ejemplo.model.CollectionsClients;

public class UseCollections {
	
	public static void main(String[] args) {
		
		CollectionsClients c1 = new CollectionsClients("Carlos", "0001", 1500);
		CollectionsClients c2 = new CollectionsClients("Sonia", "0002", 3500);
		CollectionsClients c3 = new CollectionsClients("Raul", "0003", 2500);
		CollectionsClients c4 = new CollectionsClients("Raul", "0003", 2500);
		
		/* SET:  
		 * - No permiten duplicados
		 * - Uso sencillo de add
		 * - No tienen acceso aleatorio
		 * - Poco eficientes ordenando
		 * - Los iterators s�lo modifican hacia adelante
		 * - Tipos: 
		 *   - TreeSet: ordenado pero poco eficiente
		 *   - LinkedHashSet: ordenaci�n por entrada, eficiente al acceder, no eficiente al agregar
		 *   - HashSet: r�pida, no duplicados, no ordenaci�n, no acceso aleatorio
		 *   - EnumSet: para tipos enumerados
		 */
		
		/*
		 * HASHSET: es de r�pido acceso, no permite duplicados (utiliza los m�todos equals y hashCode del objeto contenido en la lista), 
		 * no permite ordenar los elementos, no tiene acceso aleatorio y no se puede borrar elementos de la lista mientras estamos recorriendolo
		 * con un bucle for (se podr�a borrar si iteramos los elementos de la lista con un iterador
		 */
		System.out.println("Ejemplo con HASHSET:");

		Set<CollectionsClients> listaHashSet = new HashSet<>();		
		
		listaHashSet.add(c2);
		listaHashSet.add(c3);
		listaHashSet.add(c4);
		listaHashSet.add(c1);
		
		for (CollectionsClients cliente : listaHashSet) {
			System.out.println("Cliente " + cliente.getNombre() + " con cuenta " + cliente.getCuenta());
		}
		
		//Recorremos la lista con un Iterador
		Iterator<CollectionsClients> iterador = listaHashSet.iterator();		
		while(iterador.hasNext()) {
			String nombre = iterador.next().getNombre();
			//System.out.println("El nombre es " + nombre);
		}	
		
		/*
		 * TREESET: igual que el hashset pero permite ordenar los elementos aunque no de forma eficiente. Por
		 * defecto se ordenan alfab�ticamente
		 */
		System.out.println("");
		System.out.println("Ejemplo con TREESET:");
		
		Set<String> ordenaPersonas = new TreeSet<String>();
		
		ordenaPersonas.add("Sonia");
		ordenaPersonas.add("Carlos");
		ordenaPersonas.add("Raul");
		ordenaPersonas.add("Laura");
		ordenaPersonas.add("Diego");
		
		for (String persona : ordenaPersonas) {
			System.out.println(persona);
		}		
		
		/* LIST:
		 * ---- 
		 * - No hay restricci�n con agregar y eliminar elementos
		 * - Permiten ordenar (.sort())
		 * - Tienen acceso aleatorio
		 * - ListIterator modifica en cualquier direcci�n (no s�lo hacia adelante)
		 * - Tipos: 
		 *   - ArrayList: poco eficientes en la eliminaci�n de elementos. Al eliminar un elemento se desplazan todos los posteriores
		 *   - LinkedList: almacena los elementos en nodos que no tienen por que estar adyacentes. Los nodos guardan el dato y 
		 *     un enlace al elemento posterior y anterior). Si se elimina un elemento s�lo hay que actualizar los enlaces del nodo. Son
		 *     listas m�s eficientes. 
		 */
		
		/*
		 * LINKEDLIST: muy eficiente para la eliminaci�n y modificaci�n de elementos. Soportan listIterator para iterar los elementos
		 */
		System.out.println("");
		System.out.println("Ejemplo con LINKEDLIST:");
		
		List<CollectionsClients> listaLinkedList = new LinkedList<CollectionsClients>();
		
		listaLinkedList.add(c1);
		listaLinkedList.add(c2);
		listaLinkedList.add(c3);
		listaLinkedList.add(c4);
		
		for (CollectionsClients cliente : listaLinkedList) {
			System.out.println("Cliente " + cliente.getNombre() + " con cuenta " + cliente.getCuenta());
		}
	
		/* MAPS:
		 * ---- 
		 * - Asocian clave-valor
		 * - No se pueden repetir las claves
		 * - Tienen acceso aleatorio
		 * - ListIterator modifica en cualquier direcci�n (no s�lo hacia adelante)
		 * - Tipos: 
		 *   - HashMap: muy eficiente en lectura y escritura pero no permite ordenaci�n
		 *   - LinkedHashMap: ordenado por inserci�n, perimte ordenar por uso, eficiente lectura y poca eficiente de escritura
		 *   - HashTable: obsoleto
		 *   - TreeMap: ordenado por clave y poco eficiente en sus operaciones
		 */
		
	}

}
