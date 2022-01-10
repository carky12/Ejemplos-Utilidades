package ejemplo.hilos;

public class AppHilos extends Thread {	

	public static void main(String[] args) {
		
		THilo hilo = new THilo(1);		
		hilo.start();
		
		Thread hilo2 = new Thread(new RHilo(2));
		hilo2.start();
		
		for(int i = 0; i<100; i++) {
			System.out.println("Ejecutandose el main " + i); 
		}
		
		

	}

}
