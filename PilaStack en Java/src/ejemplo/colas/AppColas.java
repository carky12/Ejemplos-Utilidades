package ejemplo.colas;

import java.util.PriorityQueue;
import java.util.Queue;

public class AppColas {

	public static void main(String[] args) throws InterruptedException {
		
		Queue<String> cola = new PriorityQueue<String>();
		
		cola.offer("1-Carlos");
		cola.offer("2-Sonia");
		cola.offer("3-Raul");
		
		for (String string : cola) {
			System.out.println(string);
		}
		
		//Para un objeto necesitamos indicarle a la cola la prioridad del campo para ello podemos implementar en nuestra clase Persona la interfaz comparable
		
		System.out.println("FIFO");
		//En un for no se puede borrar elementos
		while (!cola.isEmpty()) {
			System.out.println("Elemento " + cola.poll());
			Thread.sleep(1000);
		}
		
		
		

	}

}
