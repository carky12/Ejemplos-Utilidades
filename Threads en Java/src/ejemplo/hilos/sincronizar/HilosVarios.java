package ejemplo.hilos.sincronizar;

public class HilosVarios extends Thread {	
	
	@Override
	public void run() {
		
		for (int i = 0; i < 15; i++) {
			System.out.println("Ejecutando hilo " + getName());
			try {
				sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
