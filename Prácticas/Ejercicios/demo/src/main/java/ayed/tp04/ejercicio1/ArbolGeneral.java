package ayed.tp04.ejercicio1;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;

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


	/*devuelve la altura del árbol, es decir, la longitud del camino más largo desde el nodo raíz hasta una hoja. */	
	public Integer altura() {
		Integer total=0;
		if (this.esHoja()){
			return 0;
		}
		else{
			ListaGenerica<ArbolGeneral<T>> hijos= this.getHijos();
			hijos.comenzar();
			while (!hijos.fin()){
				total= 1+ hijos.proximo().altura();
			}
		}
		return total;
	}


	/*devuelve la profundidad o nivel del dato en el árbol. El nivel de un nodo es la longitud del único camino de la raíz al nodo. */
	public Integer nivel(T dato) {
		Integer niv_actual=0;

		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>(); //para ir guardando los nodos de cada nivel
		ArbolGeneral<T> arbol_aux; //para guardar el nodo en el que me encuentro
		cola.encolar(this); //nivel 0
		cola.encolar(null);
		while (!cola.esVacia()){
			arbol_aux=cola.desencolar();
			if (arbol_aux != null){
				if (arbol_aux.getDato() == dato){
					return niv_actual;
				}
				if (arbol_aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos= arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}
			}
			else {
				if (!cola.esVacia()){
					cola.encolar(null);
					niv_actual++;
					}
				}
			}
		
		return -1;
	}


	/*el ancho de un árbol se define como la cantidad de nodos que se encuentran en el nivel que posee la mayor cantidad de nodos*/

	public Integer ancho() {
		Integer cant_max=0,cant_actual=0;

		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>(); //para ir guardando los nodos de cada nivel
		ArbolGeneral<T> arbol_aux; //para guardar el nodo en el que me encuentro
		cola.encolar(this); //nivel 1
		cola.encolar(null);
		while (!cola.esVacia()){
			arbol_aux=cola.desencolar();
			if (arbol_aux != null){
				if (arbol_aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos= arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
						cant_actual++;
					}
				}
			}
			else {
				if (!cola.esVacia()){
					cola.encolar(null);
					if (cant_actual >cant_max){
						cant_max=cant_actual;
						cant_actual=0;
					}
				}
			}
		}
		return cant_max;
	}


	/* Se dice que un nodo n es ancestro de un nodo m si existe un camino desde n a m.
Se dice que un nodo n es descendiente de un nodo m si existe un camino desde m a n.
 determine si un valor a es ancestro de un valor b.*/
 public Boolean esAncestro (T a,T b) {
	ArbolGeneral<T> nodo_a= buscarA(this,a); //en el árbol tengo que encontrar el nodo del ancestro o sea el nodo que contiene A
	boolean result= tieneAncestro(nodo_a,b); //una vez que tengo el nodo raíz que contiene a A, entre sus hijos voy a buscar a B
	return result;
 } 

 private ArbolGeneral<T> buscarA(ArbolGeneral<T> ab,T a){
	boolean encontre= false;
	ArbolGeneral<T> raiz_A= null; //voy a devolver la raíz o sea A
	ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>(); 
	ArbolGeneral<T> arbol_aux; 
	cola.encolar(ab); 
	cola.encolar(null);

	while ((!cola.esVacia()) && (!encontre)){
			arbol_aux=cola.desencolar();
			if (arbol_aux != null){
				if (arbol_aux.getDato() == a){
					raiz_A= arbol_aux;
					encontre=true;
				}
				if (arbol_aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<T>> hijos= arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						cola.encolar(hijos.proximo());
					}
				}
			}
			else {
				if (!cola.esVacia()){
					cola.encolar(null);
                }          		  			
			}
		}
		return raiz_A;
 }

 public boolean tieneAncestro(ArbolGeneral<T> nodo_a, T b){
	boolean encontre= false;
	ListaGenerica<ArbolGeneral<T>> hijos= nodo_a.getHijos();
	hijos.comenzar();
	while (!hijos.fin()){
		encontre= encontre || recursiva(hijos.proximo(),b);
	}
	return encontre;

 }

 public boolean recursiva(ArbolGeneral<T> nodo, T b){
	if (nodo.getDato() == b){
		return true;
	}
	else{
		
			boolean encontro= false;
			ListaGenerica<ArbolGeneral<T>> hijos= nodo.getHijos();
			hijos.comenzar();
			while (!hijos.fin()){
				encontro= encontro || recursiva(hijos.proximo(), b);
			}
			return encontro;		
		
		
	}
	
 }

	

}