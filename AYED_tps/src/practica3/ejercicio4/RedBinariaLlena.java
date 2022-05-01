package practica3.ejercicio4;

import practica3.ejercicio1.ArbolBinario;

public class RedBinariaLlena {
	

	private ArbolBinario<Integer> red= new ArbolBinario<Integer>();
	
	
	public Integer retardoReenvio() {
		return this.calcularRetardoReenvio(this.red);
	}
	
	private Integer calcularRetardoReenvio(ArbolBinario<Integer> ab) {
		int max1=0,max2=0;
		if (!ab.esVacio()) {
			max1+= calcularRetardoReenvio(ab.getHijoDerecho());
			max2+= calcularRetardoReenvio(ab.getHijoIzquierdo());
		}
		return Math.max(max1, max2);
	}
	

}