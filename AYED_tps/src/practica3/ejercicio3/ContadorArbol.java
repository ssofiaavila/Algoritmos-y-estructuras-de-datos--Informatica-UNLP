package practica3.ejercicio3;

import practica3.ejercicio1.ArbolBinario;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ContadorArbol {
	private ArbolBinario<Integer> ab= new ArbolBinario<Integer>();
	
	
	public ListaGenerica<Integer> numerosParesInOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		numerosParesInOrden(ab,lista);
		return lista;
	}


	private void numerosParesInOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		if (!abb.esVacio()) {
			if (abb.tieneHijoIzquierdo()) numerosParesInOrden(abb.getHijoIzquierdo(), lista);
			if (abb.getDato() % 2 ==0) {
				lista.agregarFinal(abb.getDato());
			}
			if (abb.tieneHijoIzquierdo()) numerosParesInOrden(abb.getHijoIzquierdo(), lista);
		}
		
	}
	
	public ListaGenerica<Integer> numerosParesPostOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		numerosParesPostOrden(ab,lista);
		return lista;
	}


	private void numerosParesPostOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		if (!abb.esVacio()) {
			if (abb.tieneHijoIzquierdo()) numerosParesPostOrden(abb.getHijoIzquierdo(),lista);
			if (abb.tieneHijoIzquierdo()) numerosParesPostOrden(abb.getHijoIzquierdo(), lista);
			if (abb.getDato() %2 == 0) {
				lista.agregarFinal(abb.getDato());
			}
			
		}
		
	}
	
	
	
}
