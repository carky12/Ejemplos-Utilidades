package com.carky.ejemplo.lambda;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       App app = new App();
       
       app.ordenar();
       app.calcular();
    }
    
    public void calcular() {
//    	Operacion op = new Operacion() {
//			
//			@Override
//			public double calcularPromedio(double n1, double n2) {
//				return (n1+n2)/2;
//			}
//		};
//		
		
		
		Operacion op = (double x, double y) -> (x+y)/2;
		System.out.println(op.calcularPromedio(3, 3));
    }
    
    public void ordenar() {
    	List<String> lista = new ArrayList<>();
    	
    	lista.add("uno");
    	lista.add("dos");
    	lista.add("tres");
    	
    	/*Collections.sort(lista, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {				
				return o1.compareTo(o2);
			}
		});*/
    	
    	Collections.sort(lista, (String p1, String p2) -> p1.compareTo(p2));
    	
    	for (String elemento : lista) {
    		System.out.println(elemento);
			
		}
    	
    }
}
