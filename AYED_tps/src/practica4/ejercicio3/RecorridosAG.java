package practica4.ejercicio3;
import tp04.ejercicio1.*;
import ListasGenericas.tp02.ejercicio2.ListaEnlazadaGenerica;
import ListasGenericas.tp02.ejercicio2.ListaGenerica;

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
	
	
}