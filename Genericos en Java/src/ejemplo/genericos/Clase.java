package ejemplo.genericos;


/**
 * @author Carlos
 * Convención de nombres para los tipos de parámetros
 * E - Elemento
 * K - Key
 * N - Number
 * T - Tipo
 * V - Value
 * S, U, V, etc - Más tipos...
 * 
 */
public class Clase<T> {
	
	private T objeto;

	public Clase(T objeto) {		
		this.objeto = objeto;
	}
	
	public void mostrarTipo() {
		System.out.println("T es un objeto de tipo: " + objeto.getClass());
	}
	
	

}
