package ejemplo.hilos.sincronizar.banco;

public class EjecutarTransferencias implements Runnable {

	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMaxima;
	
	public EjecutarTransferencias(Banco banco, int cuentaOrigen, double cantidadMaxima) {
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMaxima = cantidadMaxima;		
	}
	
	@Override
	public void run() {
		
		try {
			
			//bucle infinito para realizar infinitas transferencias
			while (true) {
				
				int cuentaDestino = (int) (100 * Math.random());
				double cantidad = (double) cantidadMaxima * Math.random();
				
				banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);				
			
				Thread.sleep((int) (Math.random() * 10));			
			}	
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
