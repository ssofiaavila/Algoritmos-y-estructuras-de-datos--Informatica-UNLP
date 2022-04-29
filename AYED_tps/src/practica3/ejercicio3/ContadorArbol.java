package practica3.ejercicio3;
import practica3.ejercicio2.*;
import ListaDeEnteros.ListaDeEnteros;
import ListaDeEnteros.ListaDeEnterosEnlazada;
public class ContadorArbol {
	private ArbolBinario<Integer> abb;
	
	public ContadorArbol(ArbolBinario<Integer> abb) {
		super();
		this.abb=abb;
	}
	public ArbolBinario<Integer> getArbol(){
		return this.abb;
	}
	public void setArbol(ArbolBinario<Integer>abb) {
		this.abb=abb;
	}
	
	private void numerosParesInOrden(ArbolBinario<Integer> ab, ListaDeEnteros lista) {
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo()) this.numerosParesInOrden(ab.getHijoIzquierdo(), lista);
			if (ab.getDato()%2 ==0) {
				lista.agregarFinal(ab.getDato());
			}
			if (ab.tieneHijoDerecho()) this.numerosParesInOrden(ab.getHijoDerecho(), lista);
		}
	}
	
	public ListaDeEnteros numerosParesInOrden() {
		ListaDeEnterosEnlazada lista=new ListaDeEnterosEnlazada();
		lista.comenzar();
		this.numerosParesInOrden(abb, lista);
		return lista;
	}
		
	


	private void numerosParesPostOrden(ArbolBinario<Integer> ab, ListaDeEnteros lista) {
		if (!ab.esVacio()) {
			if (ab.tieneHijoIzquierdo())  this.numerosParesInOrden(ab.getHijoIzquierdo(), lista);
			if (ab.tieneHijoDerecho()) this.numerosParesInOrden(ab.getHijoDerecho(), lista);
			if (ab.getDato()%2 ==0) {
				lista.agregarFinal(ab.getDato());
			}
		}
	}
	public ListaDeEnteros numerosParesPostOrden() {
		ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
		lista.comenzar();
		this.numerosParesPostOrden(abb, lista);
		return lista;
	}
	
}
