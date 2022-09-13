package practica2;
import tp02.ejercicio1.*;
public class ejercicio1_2 {
	public static void main (String []args) {
		
		ListaDeEnterosConArreglos lista= new ListaDeEnterosConArreglos();
		lista.agregarFinal(45);
		lista.agregarFinal(50);
		lista.agregarFinal(16);
		lista.agregarFinal(90);
		
		lista.comenzar();
		while (!lista.fin()) {
			System.out.println(lista.proximo());
		}
		
		
	}
}
