package practica4.ejercicio3;
import tp04.ejercicio1.*;
import tp02.ejercicio2.*;
import ListasGenericas.tp02.ejercicio2.ListaEnlazadaGenerica;
import ListasGenericas.tp02.ejercicio2.ListaGenerica;

import practica2.ejercicio3.ColaGenerica;

public class RecorridosAG<T> {
	
	
	
	/*Returns a list with odd elements from "a" tree which are bigger than "n" value, inorder route */
	
	public ListaGenerica <Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> ab,Integer n){
		ListaEnlazadaGenerica<Integer> lis= new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePreOrden(n,lis,ab);
		return lis;
		}
		


	private void numerosImparesMayoresQuePreOrden(Integer n, ListaGenerica<Integer>lis,ArbolGeneral<Integer>ab) {
		if ((ab.getDato() % 2 == 1) && (ab.getDato()>n)){
			lis.agregarFinal(ab.getDato());
		}
		if (ab.tieneHijos()) {
			tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> lishijos= ab.getHijos();
			lishijos.comenzar();
			while (!lishijos.fin()) {
				numerosImparesMayoresQuePreOrden(n,lis,lishijos.proximo());
			}
		}
		
	}
	
	public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer>ab,Integer n){
		ListaEnlazadaGenerica<Integer> lis= new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQueInOrden(n,lis,ab);
		return lis;
	}


// cuando imprimo un general en in orden primero imprimo el mas a la izquierda, padre y luego el resto de los hijos
	private void numerosImparesMayoresQueInOrden(Integer n, ListaEnlazadaGenerica<Integer> lis,
			ArbolGeneral<Integer> ab) {
		if (ab.tieneHijos()) {
			tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> lisHijos= ab.getHijos();
			lisHijos.comenzar();
			numerosImparesMayoresQueInOrden(n,lis,lisHijos.proximo());			
		}
		if ((ab.getDato() % 2 == 1) && (ab.getDato()>n)){
			lis.agregarFinal(ab.getDato());
		}
		if (ab.tieneHijos()) {
			tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> lisHijos= ab.getHijos();
			while (!lisHijos.fin()){
			numerosImparesMayoresQueInOrden(n,lis,lisHijos.proximo());		
			}
		}
	}
	
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral <Integer> ab, Integer n){
		ListaEnlazadaGenerica<Integer> lis= new ListaEnlazadaGenerica<Integer>();
		numerosImparesMayoresQuePostOrden(n,lis,ab);
		return lis;
	}
	
	private void numerosImparesMayoresQuePostOrden(Integer n, ListaEnlazadaGenerica<Integer>lis, ArbolGeneral<Integer>ab) {
		if (ab.tieneHijos()) {
			tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> lisHijos= ab.getHijos();
			lisHijos.comenzar();
			numerosImparesMayoresQuePostOrden(n,lis,lisHijos.proximo());			
		}
		if ((ab.getDato() % 2 == 1) && (ab.getDato()>n)){
			lis.agregarFinal(ab.getDato());
		}
	}
	
	
	public ListaGenerica<Integer> numerosImparesMayoresQuePorNiveles(ArbolGeneral <Integer> ab,Integer n){
		ListaEnlazadaGenerica<Integer> lis= new ListaEnlazadaGenerica<Integer>();
		ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>();
		ArbolGeneral<Integer> aux;
		cola.encolar(ab);
		cola.encolar(null);
		
		while (!cola.esVacia()) {
			aux=cola.desencolar();
			if (aux != null) {
				if ((aux.getDato() %2 ==1) && (aux.getDato() >n)){
					lis.agregarFinal(aux.getDato());
				}
				if (aux.tieneHijos()) {
					tp02.ejercicio2.ListaGenerica<ArbolGeneral<Integer>> lisHijos= aux.getHijos();
					lisHijos.comenzar();
					while (!lisHijos.fin()) {
						cola.encolar(lisHijos.proximo());
					}
					
				}
			}
			else
				if (!cola.esVacia()) cola.encolar(null);
		}
		return lis;
	}
	
	
	
	
	
}