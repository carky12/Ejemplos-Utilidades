package ejemplo.hilos.sincronizar.banco;

public class BancoSinSincronizar {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		
		for (int i = 0; i < 100; i++) {
			Runnable r = new EjecutarTransferencias(banco, i, 2000);
			Thread hilo = new Thread(r);
			hilo.start();			
		}

	}

}
