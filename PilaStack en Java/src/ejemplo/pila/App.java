package ejemplo.pila;

import java.util.Stack;

public class App {

	public static void main(String[] args) throws InterruptedException {
		//Una pila puede albergar elementos duplicados, lo importante es el orden de entrada
		
		Stack<String> pila = new Stack<String>();
		
		pila.push("1-Carlos");
		pila.push("2-Sonia");
		pila.push("3-Raul");
		
		for (String string : pila) {
			System.out.println(string);
		}
		
		//Para obtener el último elemento de la pila
		System.out.println("Ultimo elemento " + pila.peek());
		
		//Para buscar un elemento en la pila (cuenta desde el final de la pila al principio)
		System.out.println(pila.search("1-Carlos"));
		
		
		System.out.println("LIFO");
		//Se eliminan en orden descendente de entrada en la pila
		while (!pila.isEmpty()) {
			System.out.println("Elemento " +  pila.pop());
			Thread.sleep(1000);
			
		}
		
		System.out.println("*************************");
		
		Stack<Persona> pila2 = new Stack<Persona>();
		
		pila2.push(new Persona(1, "Carlos", 25));
		pila2.push(new Persona(2, "Sonia", 26));
		pila2.push(new Persona(3, "Raul", 30));
		pila2.push(new Persona(3, "Raul", 30));
		
		for (Persona per : pila2) {
			System.out.println(per);
		}
		
		//Para obtener el último elemento de la pila
		System.out.println("Ultimo elemento " + pila2.peek());
		
		//Para buscar un elemento en la pila (cuenta desde el final de la pila al principio)
		System.out.println(pila2.search(new Persona(1, "Carlos", 25)));
		
		
		System.out.println("LIFO");
		//Se eliminan en orden descendente de entrada en la pila
		while (!pila2.isEmpty()) {
			System.out.println("Elemento " +  pila2.pop());
			Thread.sleep(1000);
			
		}
		
		
		
	}

}
