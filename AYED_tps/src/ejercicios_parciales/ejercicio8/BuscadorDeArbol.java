package ejercicios_parciales.ejercicio8;

import ListasGenericas.tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class BuscadorDeArbol {
	private ArbolGeneral<Integer> arbol;
	
	public BuscadorDeArbol(ArbolGeneral<Integer> ab){
	this.arbol=ab;
	}
	public ArbolGeneral<Integer> getArbol(){
		return this.arbol;
	}
	
	
	public Integer buscarMayorEnPostOrden() {
		int max=-1; 		
		return this.buscarMayorEnPostOrden(arbol,max);
	}
	private Integer buscarMayorEnPostOrden(ArbolGeneral<Integer> ab, int max) {
		int aux;
		if (!arbol.esVacio()) { //es vacio si no tiene dato y tampoco hijos
			if (arbol.tieneHijos()) {
				tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos(); 
				hijos.comenzar();  
				while (!hijos.fin()) { 
					aux= buscarMayorEnPostOrden(hijos.proximo(),max);
					if (aux > max) max= aux;
				}
			}
			if (ab.getDato() > max ) {
				return ab.getDato();
			}
			
		}
		return max;
	}	
	
}
