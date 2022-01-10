package ejemplo.hilos.concurrente;

import java.awt.Component;

public class PelotaThread implements Runnable {

	private Pelota pelota;
	private Component panel;
	
	public PelotaThread(Pelota pelota, Component panel) {
		this.pelota = pelota;
		this.panel = panel;
	}
	
	
	@Override
	public void run() {
		
		//for (int i = 0; i < 3000; i++) {
		
		//while(!Thread.interrupted()) {
		
		while (!Thread.currentThread().isInterrupted()) {
			
			pelota.mover(panel.getBounds());
			panel.paint(panel.getGraphics());
			
			/*try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}		
	}	

}
