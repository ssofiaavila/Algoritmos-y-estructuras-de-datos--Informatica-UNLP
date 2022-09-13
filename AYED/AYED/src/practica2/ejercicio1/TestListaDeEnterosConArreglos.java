package practica2.ejercicio1;
import tp02.ejercicio1.*;
public class TestListaDeEnterosConArreglos {
	public static void main(String[]args){
		
		ListaDeEnterosConArreglos lista= new ListaDeEnterosConArreglos();
		lista.agregarFinal(15);
		lista.agregarFinal(1);
		lista.agregarFinal(3);
		lista.agregarFinal(7);
		
		lista.comenzar();
		int i;
		for (i=0; i< lista.tamanio();i++)
			System.out.println(lista.proximo());
		
		
	}
}
