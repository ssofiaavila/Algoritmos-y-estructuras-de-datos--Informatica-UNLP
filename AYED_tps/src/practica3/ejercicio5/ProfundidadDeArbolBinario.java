package practica3.ejercicio5;

import practica3.ejercicio1.ArbolBinario;
import tp02.ejercicio3.ColaGenerica;

public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> abb= new ArbolBinario<Integer>();
	
	
	int sumaElementosProfundidad(int p) {
		ArbolBinario<Integer> aux;
		ColaGenerica<ArbolBinario<Integer>> cola= new ColaGenerica<ArbolBinario<Integer>>();
		int actual=0;
		int total=0;
		cola.encolar(abb);
		cola.encolar(null);
		while ((!cola.esVacia()) && (actual <= p)) {
			aux= cola.desencolar();
			if (aux!= null) {
				if (actual== p) total+= aux.getDato();
				if (aux.tieneHijoDerecho()) cola.encolar(aux.getHijoDerecho());
				if (aux.tieneHijoIzquierdo()) cola.encolar(aux.getHijoIzquierdo());
			}
			else
				if (!cola.esVacia()) {
					cola.encolar(null);
					actual++;
				}
		}
		return total;
	}
}
