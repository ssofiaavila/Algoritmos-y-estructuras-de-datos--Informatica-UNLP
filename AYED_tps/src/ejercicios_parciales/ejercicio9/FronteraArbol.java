package ejercicios_parciales.ejercicio9;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class FronteraArbol {
	private ArbolGeneral<Integer> arbol;
	
	public FronteraArbol(ArbolGeneral<Integer> arbol) {
		this.arbol=arbol;
	}
	
	public ListaEnlazadaGenerica<Integer> fronteraDeArbol(){
		ListaEnlazadaGenerica<Integer> nodosFrontera= new ListaEnlazadaGenerica<Integer>();
		if (arbol != null && !arbol.esVacio()) this.fronteraDeArbol(this.getArbol(),nodosFrontera);
		return nodosFrontera;
	}

	private void fronteraDeArbol(ArbolGeneral<Integer> arbol, ListaEnlazadaGenerica<Integer> nodosFrontera) {
		if (arbol.esHoja()) {
			nodosFrontera.agregarFinal(arbol.getDato());
		}
		else {
			ListaGenerica<ArbolGeneral<Integer>> hijos= arbol.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				fronteraDeArbol(hijos.proximo(),nodosFrontera);
			}
		}
		
	}

	private ArbolGeneral<Integer> getArbol() {
		return this.arbol;
	}
	
}
