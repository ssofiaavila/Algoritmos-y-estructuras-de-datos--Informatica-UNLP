package ejercicios_parciales.ejercicio4;
/*4) Devolver el camino a la hoja más lejana, si hubiese más de un camino de igual longitud maxima, devovler el primero que encontremos*/

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RecorridoLargo {
	private ArbolGeneral<Integer> arbol;
	
	public RecorridoLargo(ArbolGeneral<Integer> ab) {
		this.arbol=ab;
	}
	
	public ListaGenerica<Integer> caminoMasLargo(){
		ListaGenerica<Integer> camino= new ListaEnlazadaGenerica<Integer>();
		ListaGenerica<Integer> actual= new ListaEnlazadaGenerica<Integer>();
		this.caminoMasLargo(this.arbol,camino,actual);
		return camino;
	}

	private void caminoMasLargo(ArbolGeneral<Integer> ab, ListaGenerica<Integer> camino,
			ListaGenerica<Integer> actual) {
		if (!ab.esVacio()) {
			if (ab.esHoja()) {
			actual.agregarFinal(ab.getDato());
			if (actual.tamanio() > camino.tamanio() ) {
				this.clonar(camino,actual);
			}
			}
			else {
				ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					caminoMasLargo(hijos.proximo(),camino,actual);
					actual.eliminarEn(actual.tamanio());
				}
			}
				
			
		}
		
		
	}
	
	private void clonar(ListaGenerica<Integer> camino, ListaGenerica<Integer> actual) {
		while (!camino.esVacia()) {
			camino.eliminarEn(camino.tamanio());
		}
		actual.comenzar();
		while (!actual.fin()) {
			camino.agregarFinal(actual.proximo());
		}
		
	}
}
