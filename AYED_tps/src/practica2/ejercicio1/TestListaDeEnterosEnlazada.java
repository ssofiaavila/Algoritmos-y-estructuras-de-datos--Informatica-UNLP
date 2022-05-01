package practica2.ejercicio1;

import tp02.ejercicio1.ListaDeEnterosConArreglos;
import tp02.ejercicio1.ListaDeEnterosEnlazada;

public class TestListaDeEnterosEnlazada {
	public static void main(String[]args) {
		
		ListaDeEnterosEnlazada list= new ListaDeEnterosEnlazada();
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
		
		System.out.println("Lista inversa: ");
		list.comenzar();
		int nro=1;
		imprimirListaInversa(list,nro);
		
		
	}

	private static void imprimirListaInversa(ListaDeEnterosEnlazada list,int nro) {
		if (nro<= list.tamanio()) {
			nro=nro+1;
			imprimirListaInversa(list,nro);
			System.out.println(list.elemento(nro-1));				
		}
		
			
		
		
	}
}
