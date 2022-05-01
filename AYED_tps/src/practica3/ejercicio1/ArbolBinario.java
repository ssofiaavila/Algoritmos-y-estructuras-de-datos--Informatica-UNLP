package practica3.ejercicio1;

import tp02.ejercicio3.ColaGenerica;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {
		int cant=0;
		if (!this.esHoja()) {
			if (this.tieneHijoDerecho()) cant += this.getHijoDerecho().contarHojas();
			if (this.tieneHijoIzquierdo()) cant += this.getHijoIzquierdo().contarHojas();
		}
		return cant;
	}
	

    public ArbolBinario<T> espejo() {
		ArbolBinario<T> nuevo= new ArbolBinario<T>(this.getDato());
		if (!this.esVacio()) {
			if (this.tieneHijoDerecho()) {
				nuevo.agregarHijoDerecho(this.getHijoIzquierdo().espejo());
			}
			if (this.tieneHijoIzquierdo()) {
				nuevo.agregarHijoIzquierdo(this.getHijoDerecho().espejo());
			}
		}
		return nuevo;		
	}


	public void entreNiveles(int n, int m){
		ArbolBinario<T> aux=null;
		ColaGenerica<ArbolBinario<T>> cola= new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel=0;
		while (!cola.esVacia() && nivel<=m) {
			aux= cola.desencolar();
			if (aux != null) {
				if (nivel >= n) {
					System.out.println(aux.getDato());		
				}
				if (aux.tieneHijoDerecho()) cola.encolar(aux.getHijoDerecho());
				if (aux.tieneHijoIzquierdo()) cola.encolar(aux.getHijoIzquierdo());
			}
			else if(!cola.esVacia()) {
				if (nivel <= m) {
					nivel= nivel+1;
					if (nivel > n && nivel < m) {
						System.out.println("");
					}
					cola.encolar(null);
				}
			}
		}
		
		
	}

	

}
