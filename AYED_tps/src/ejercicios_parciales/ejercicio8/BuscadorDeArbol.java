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
		int max= -1;
		return buscarMayorEnPostOrden(this.arbol,max);
	}
	private int buscarMayorEnPostOrden(ArbolGeneral<Integer> ab, int max) {
		tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> hijos;
		int aux=-1;
		if (!ab.esVacio()) {
			if (ab.tieneHijos()) {
				hijos= ab.getHijos();
				hijos.comenzar();
				max= buscarMayorEnPostOrden(hijos.proximo(),max);
			}
			if (ab.getDato() > max) {
				aux=ab.getDato();
			}
			if (ab.tieneHijos()) {
				hijos=ab.getHijos();
				while (!hijos.fin()){
					max=buscarMayorEnPostOrden(hijos.proximo(),max);
				}
				
				
			}
		if (aux> max) return aux;
		
		}
		return max;
	}
	
}
