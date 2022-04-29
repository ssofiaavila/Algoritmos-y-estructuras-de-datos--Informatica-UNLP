package practica3.ejercicio4;
import practica3.ejercicio2.ArbolBinario;
public class RedBinariaLlena {
	private ArbolBinario <Integer> arbol;
	
	
	public int getMax(ArbolBinario<Integer> ab) {
		int max1= ab.getDato();
		int max2= ab.getDato();
		
		if (!ab.esHoja()) {
			max1 += getMax(ab.getHijoIzquierdo());
			max2+= getMax(ab.getHijoDerecho());
		}
		return Math.max(max1, max2);
	}
	
	public int retardoReenvio() {
		return this.getMax(arbol);
	}
}
