package practica2.ejercicio3;
import ListasGenericas.tp02.ejercicio2.*;
public class PilaGenerica<T> {
	private ListaEnlazadaGenerica <T> datos= new ListaEnlazadaGenerica <T>();
	
	
	public void apilar(T dato) {
		this.datos.agregarFinal(dato);
	}
	
	public T desapilar() {
		T elemento= this.datos.elemento(this.datos.tamanio());
		this.datos.eliminarEn(this.datos.tamanio());
		return elemento;
	}
	
	public T tope() {
		return this.datos.elemento(this.datos.tamanio());
	}
	
	
	public boolean esVacia() {
		return this.datos.esVacia();
	}
}
