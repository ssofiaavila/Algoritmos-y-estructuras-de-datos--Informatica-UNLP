package ejercicios_parciales.ejercicio1;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Caminos {
	
	
	public ListaGenerica<ListaGenerica<Character>> caminosPares(ArbolGeneral<Character>abb){
		ListaGenerica<ListaGenerica<Character>> listaDeListas= new ListaEnlazadaGenerica<ListaGenerica<Character>>();
		ListaGenerica<Character> actual= new ListaEnlazadaGenerica<Character>();
		this.caminosPares(abb,listaDeListas,actual);
		return listaDeListas;
		
	}

	private void caminosPares(ArbolGeneral<Character> abb, ListaGenerica<ListaGenerica<Character>> listaDeListas,
			ListaGenerica<Character> actual) {
		if (!abb.esVacio()) {
			actual.agregarFinal(abb.getDato());
			if (abb.esHoja() && actual.tamanio()%2 ==0) {
				listaDeListas.agregarFinal(actual);
			}
			ListaGenerica<ArbolGeneral<Character>> hijos= abb.getHijos();
			hijos.comenzar();
			while (!hijos.fin()) {
				this.caminosPares(hijos.proximo(), listaDeListas, actual);
			}
			actual.eliminarEn(actual.tamanio());
		}
	}
	
	
}
