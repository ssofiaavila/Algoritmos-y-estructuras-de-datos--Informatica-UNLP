package practica2.ejercicio1;
import tp02.ejercicio1.*;
public class TestListaDeEnterosEnlazada {
	public static void main(String[]args){
		
		ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
		lista.agregarFinal(45);
		lista.agregarFinal(81);
		lista.agregarFinal(30);
		lista.agregarFinal(7);
		
		lista.comenzar();
		int i;
		for (i=0; i< lista.tamanio();i++)
			System.out.println(lista.proximo());
		
		
	}
}
