package ejemplo.hilos.sincronizar;

public class SincorinzandoHilos {

	public static void main(String[] args) {
		HilosVarios hilo1 = new HilosVarios();		
		hilo1.start();
		try {
			hilo1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HilosVarios hilo2 = new HilosVarios();		
		hilo2.start();
		try {
			hilo2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Finalización del programa");

	}

}
