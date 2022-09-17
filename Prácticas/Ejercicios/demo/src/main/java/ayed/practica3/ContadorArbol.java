package ayed.practica3;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;



public class ContadorArbol {
	private ArbolBinario<Integer> ab;
	
	public ContadorArbol(ArbolBinario<Integer>abb) {
		this.ab=abb;
	}
	
	public ListaGenerica<Integer> numerosParesInOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.numerosParesInOrden(this.ab,lista);
		return lista;
	}

	private void numerosParesInOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		
		if (abb.tieneHijoIzquierdo()) {
			this.numerosParesInOrden(abb.getHijoIzquierdo(), lista);
		}
		if ((abb.getDato() % 2) == 0) {
			lista.agregarFinal(abb.getDato());
		}
		if (abb.tieneHijoDerecho()) {
			this.numerosParesInOrden(abb.getHijoDerecho(),lista);
		}
		
	}
	
	public ListaGenerica<Integer> numerosParesPostOrden(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.numerosParesPostOrden(this.ab,lista);
		return lista;
	}

	private void numerosParesPostOrden(ArbolBinario<Integer> abb, ListaGenerica<Integer> lista) {
		if (abb.tieneHijoDerecho()) {
			this.numerosParesPostOrden(abb.getHijoDerecho(),lista);
		}
		if (abb.tieneHijoIzquierdo()) {
			this.numerosParesPostOrden(abb.getHijoIzquierdo(), lista);
		}
		if ((abb.getDato() % 2) == 0) {
			lista.agregarFinal(abb.getDato());
		}
	}
	
}