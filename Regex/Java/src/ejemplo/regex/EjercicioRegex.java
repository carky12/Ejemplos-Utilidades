package ejemplo.regex;

import java.util.ArrayList;
import java.util.List;

public class EjercicioRegex {

	public static void main(String[] args) {
	
		List<String> valores = new ArrayList<String>();
		
		// Validamos que el número sea entero.
		valores.clear();
		valores.add("46");
		valores.add("s46");
		valores.add("4vr6");
		valores.add("-23");
		valores.add("-vr");
		valores.add("vr");
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es entero: " + ValidarConRegex.validarEntero(valor));
		}
		System.out.println("---------------------------------------------");
		
		// Validamos que el número sea entero y positivo
		valores.clear();
		valores.add("46");
		valores.add("-46");	
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es entero positivo: " + ValidarConRegex.validarEnteroPositivo(valor));
		}		
		System.out.println("---------------------------------------------");
	

		// Validamos que el número sea entero y positivo
		valores.clear();
		valores.add("46");
		valores.add("-46");	
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es entero positivo: " + ValidarConRegex.validarEnteroNegativo(valor));
		}
		System.out.println("---------------------------------------------");
		
		// Validamos que el nif tenga formato válido
		valores.clear();
		valores.add("44468251M");
		valores.add("4468251M");	
		valores.add("44468251a");
		valores.add("444682519");
		valores.add("");

		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es nif válido: " + ValidarConRegex.validarNif(valor));
		}	
		System.out.println("---------------------------------------------");
		
		// Validamos el formato de matricula
		valores.clear();
		valores.add("4444AAA");
		valores.add("444AAA");	
		valores.add("4444AA");
		valores.add("4A444AA");
		valores.add("4444aaa");
		valores.add("444 aaa");
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es una matrícula válida: " + ValidarConRegex.validarMatricula(valor));
		}		
		System.out.println("---------------------------------------------");
		
		// Validamos que un número sea real
		valores.clear();
		valores.add("23");
		valores.add("23.46");	
		valores.add("aaaa");
		valores.add("-23+56A");
		valores.add("-23.46");
		valores.add("-23,46");
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es un número real: " + ValidarConRegex.validarNumeroReal(valor));
		}		
		System.out.println("---------------------------------------------");		
		
		// Validamos que un número sea real
		valores.clear();
		valores.add("carky@gmail.com");
		valores.add("carky.glez_per-10@gmail.com");	
		valores.add("carky.glez_per-10@gmail-10.com");	
		
		for (String valor : valores) {
			System.out.println("Validando si el valor " + valor + " es un email válido: " + ValidarConRegex.validarEmail(valor));
		}		
		System.out.println("---------------------------------------------");				
		
	}
	

}
