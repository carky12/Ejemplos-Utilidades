package ejemplo.hilos.sincronizar;

public class HilosVarios2 extends Thread {
	
	private Thread hilo;
	
	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	@Override
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
