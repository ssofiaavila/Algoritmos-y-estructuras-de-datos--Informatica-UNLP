package practica3.ejercicio2;



public class ColaGenerica<T> {
	private ListaEnlazadaGenerica <T> datos = new ListaEnlazadaGenerica <T>(); 
	
	public void encolar(T elemento) { 
		this.datos.agregarFinal(elemento);
	}
	
	public T desencolar() { 
		T elemento = this.datos.elemento(1);
		this.datos.elemento(1);
		return elemento;
		
	}
	public boolean esVacia() { 
		return this.datos.esVacia();
	}
	
	
	public T tope() {
		return this.datos.elemento(this.datos.tamanio());
	}
	 
	
}
