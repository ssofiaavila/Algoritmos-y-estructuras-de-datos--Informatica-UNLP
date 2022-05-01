package practica2.ejercicio1;
import tp02.ejercicio1.*;
public class TestListaDeEnterosConArreglos {
	public static void main(String[]args) {
		
		ListaDeEnterosConArreglos list= new ListaDeEnterosConArreglos();
		list.agregarFinal(4);
		list.agregarFinal(10);
		list.agregarFinal(55);
		list.agregarFinal(8);
		list.comenzar();
		int size= list.tamanio();
		int i=1;
		while (!list.fin() && (i <= size)) {
			System.out.println(list.elemento(i));
			i++;
		}
		
	}
}
