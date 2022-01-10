package ejemplo.regex;

public class ValidarConRegex {

	/**
	 * Validamos que el entero pueda ser negativo o positivo con -? que sólo pueda
	 * tener números y más de uno con [0-9]+ que empiece y acabe por un número con ^
	 * $
	 */
	public static boolean validarEntero(String numero) {
		return numero.matches("^-?[0-9]+$");
	}

	/**
	 * Validamos que el entero sólo pueda ser positivo comenzando por un número que
	 * sólo pueda tener números y más de uno con [0-9]+ que empiece y acabe por un
	 * número con ^ $
	 */
	public static boolean validarEnteroPositivo(String numero) {
		return numero.matches("^[0-9]+$");
	}

	/**
	 * Validamos que el entero sólo pueda ser negativo comenzando por un número que
	 * sólo pueda tener números y más de uno con [0-9]+ que empiece y acabe por un
	 * número con ^ $
	 */
	public static boolean validarEnteroNegativo(String numero) {
		return numero.matches("^-[0-9]+$");
	}
	
	/**
	 * Validamos un NIF, 8 números y una letra al final
	 */
	public static boolean validarNif(String nif) {
		return nif.matches("^[0-9]{8}[A-Z]$");
	}	

	/**
	 * Validamos el formato de una matrícula
	 */
	public static boolean validarMatricula(String matricula) {
		return matricula.matches("^[0-9]{4}[A-Z]{3}$");
	}
	
	/**
	 * Validamos que un número sea octal. Sólo puede contener 
	 * números entre 0 y 7
	 */
	public static boolean validarOctal(String numero) {
		return numero.matches("^[0-7]+$");
	}
	
	/**
	 * Validamos que un número sea hexadecimal. Sólo puede contener 
	 * números entre 0 y 9 y letras entre A y F
	 */
	public static boolean validarHexadecimal(String numero) {
		return numero.matches("^[0-9A-F]+$");
	}
	
	/**
	 * Validamos que un número sea real.
	 */
	public static boolean validarNumeroReal(String numero) {
		return numero.matches("^-?[0-9]+([.|,]?[0-9]+)?$");
	}
	
	/**
	 * Validamos que un número tenga un número de decimales como máximo
	 * El número máximo de deicmales se le pasa por parámetro y no puede ser cero
	 */
	public static boolean validarDecimalesNumeroReal(String numero, int decimales) {
		if (decimales > 0) {
			return numero.matches("^-?[0-9]+([.|,]?[0-9]{1," + decimales + "})?$");	
		} else {
			return false;
		}		
	}
	
	/**
	 * Validamos que una fecha tenga el formato dd/mm/aaaa
	 */
	public static boolean validarFormatoFecha(String fecha) {
		return fecha.matches("^(0?[1-9]|[12][0-9]|3[01])[/](0?[1-9]|[1][0-2])[/]([19|20]\\d){2}$");
	}
	

	/**
	 * Validamos un nombre incluyendo nombres compuestos
	 */
	public static boolean validarNombreCompuesto(String nombre) {
		return nombre.matches("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
	}
	
	/**
	 * Validamos un email
	 */
	public static boolean validarEmail(String email) {		
		return email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z._-]+\\.[a-zA-Z]+$");
	}
	
	
	
}
