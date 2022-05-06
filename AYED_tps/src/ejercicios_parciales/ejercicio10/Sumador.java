package ejercicios_parciales.ejercicio10;

import practica3.ejercicio1.ArbolBinario;

public class Sumador {
	private ArbolBinario<Integer> abb;
	
	public Sumador(ArbolBinario<Integer> abb) {
		this.abb=abb;
	}
	
	public int sumarElementos() {
		
		return	this.sumarElementos(abb);
	}

	private int sumarElementos(ArbolBinario<Integer> abb) {
		if (!abb.esVacio()) {
			if (abb.tieneHijoDerecho() && abb.tieneHijoIzquierdo()) return abb.getDato() + sumarElementos(abb.getHijoDerecho()) + sumarElementos(abb.getHijoIzquierdo());
			else
				return abb.getDato();
		}
		return 0;
	}
}
