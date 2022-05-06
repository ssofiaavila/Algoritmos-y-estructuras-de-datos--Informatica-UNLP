package ejercicios_parciales.ejercicio8;

import ListasGenericas.tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class BuscadorDeArbol {
	private ArbolGeneral<Integer> arbol;
	
	public BuscadorDeArbol(ArbolGeneral<Integer> ab){
	this.arbol=ab;
	}
	public Integer buscarMayorEnPostOrden() {
		Integer max=-1;
		this.buscarMayorEnPostOrden(this.arbol,max);
		return max;
	}
	private void buscarMayorEnPostOrden(ArbolGeneral<Integer> abb, Integer max) {
		if (!abb.esVacio()) {
			if (abb.tieneHijos()) {
				tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> hijos= abb.getHijos();
				hijos.comenzar();
				buscarMayorEnPostOrden(hijos.proximo(),max);
				
			
			if (abb.getDato() > max) {
				max= abb.getDato();
			}
			while (!hijos.fin()) {
				
			}
			}
		}
		
	}
}
