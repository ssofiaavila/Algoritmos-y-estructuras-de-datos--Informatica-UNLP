package practica3.ejercicio5;
import practica3.ejercicio2.*;


public class ProfundidadDeArbolBinario {
	ArbolBinario<Integer> ab;
	
	public int sumaElementosProfundidad(int nivel) {
		ColaGenerica<ArbolBinario<Integer>> cola= new ColaGenerica<ArbolBinario<Integer>>();
		ArbolBinario<Integer>aux;
		int n=0,suma=0;
		cola.encolar(this.getArbol());
		cola.encolar(null);
		while (!cola.esVacia() && n<= nivel) {
			ab= cola.desencolar();
			if (ab !=null) {
				if (n== nivel) suma+= ab.getDato();
				if (ab.tieneHijoDerecho()) cola.encolar(ab.getHijoDerecho());
				if (ab.tieneHijoIzquierdo()) cola.encolar(ab.getHijoIzquierdo());
			}
			else if(!cola.esVacia()) {
				cola.encolar(null);
				n++;
			}
		}
		return suma;
	}
	
	public ArbolBinario<Integer> getArbol(){
		return this.ab;
	}
}
