package ejercicios_parciales.ejercicio7;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ejercicio7 {
	
	public ListaEnlazadaGenerica<Integer> obtenerCamino(ArbolGeneral<Integer> ab){
		ListaEnlazadaGenerica<Integer> camino= new ListaEnlazadaGenerica<Integer>();
		recorrer(ab,camino);
		return camino;
	}
	
	private void recorrer(ArbolGeneral<Integer>ab, ListaEnlazadaGenerica<Integer> camino) {
		if (!ab.esVacio()) {
			camino.agregarFinal(ab.getDato());
			if (ab.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos= ab.getHijos();
				recorrer(hijos.elemento(ab.getDato()),camino);
			}			
		}
	}
}
