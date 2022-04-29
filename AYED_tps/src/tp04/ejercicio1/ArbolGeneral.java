package tp04.ejercicio1;

import practica2.ejercicio3.ColaGenerica;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		if (hijos==null)
			this.hijos = new ListaEnlazadaGenerica<ArbolGeneral<T>>();
		else
			this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}
	
	public boolean tieneHijos() {
		return !this.hijos.esVacia();
	}
	
	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}

	

	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo)) 
				hijos.eliminar(hijo);
		}
	}
	
	public ListaEnlazadaGenerica<T> preOrden() {
		return null;
	}
	
	
	public Integer altura() {
		int altura= -1;
		if (this.esHoja())	return 0;
		else {
			if (this.tieneHijos()) {
				ListaGenerica<ArbolGeneral<T>> hijos= this.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					altura= Math.max(altura, hijos.proximo().altura());
				}
			}
		}
		return altura;
			
	}

	public Integer nivel(T dato) {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.encolar(this);
		cola.encolar(null);
		int nivel=0;
		while (!cola.esVacia()) {
			aux= cola.desencolar();
			if (aux !=null) {
				if (aux.getDato() ==dato) {
					return nivel;
				}
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos= aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			else 
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
				}
		}
		return nivel;
	}

	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ArbolGeneral<T> aux;
		cola.encolar(this);
		cola.encolar(null);
		int cantidad=0, max=-1, nivel=0;
		while (!cola.esVacia()) {
			aux= cola.desencolar();
			if (aux!= null) {
				cantidad++;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> hijos= aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			else
				if (!cola.esVacia()) {
					cola.encolar(null);
					nivel++;
					if (cantidad > max) max=cantidad;
					cantidad=0;
				}
		}
		return max;
	}
	
	
	public boolean esAncestro(T a,T b) {
		ListaGenerica<T> lista= new ListaEnlazadaGenerica<T>();
		ListaGenerica<T> camino= new ListaEnlazadaGenerica<T>();
		lista.agregarInicio(this.getDato());
		esAncestro(a,b,lista,camino);
		if (((camino.incluye(a))) && (camino.incluye(b))) {
			return true;
		}
		return false;
	}
	
	private void clonar(ListaGenerica<T> lista, ListaGenerica<T> camino) {
		lista.comenzar();
		while (!lista.fin()) {
			camino.agregarFinal(lista.proximo());
		}
	}
	
	
	
	private void esAncestro(T a,T b, ListaGenerica<T> lista, ListaGenerica<T> camino) {
		if (this.getDato()==b) {
			clonar(lista,camino);
		}
		if (camino.esVacia()) {
			ListaGenerica<ArbolGeneral<T>> hijos= this.getHijos();
			hijos.comenzar();
			while ((!hijos.fin())&& (camino.esVacia())) {
				ArbolGeneral<T> aux= hijos.proximo();
				lista.agregarFinal(aux.getDato());
				aux.esAncestro(a, b,lista,camino);
				lista.eliminarEn(lista.tamanio());
			}
		}
	}

}