
package ayed.tp04.ejercicio3;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class RecorridoAG{
    ArbolGeneral<Integer>arbol;


    public RecorridoAG(ArbolGeneral<Integer>arbol){
        this.arbol = arbol;
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        numerosImparesMayoresQuePreOrden(a,n, lista);
        return lista;
    }

    private void numerosImparesMayoresQuePreOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
        
        if (! a.esVacio()){
            if ((a.getDato() % 2 == 1) && (a.getDato() > n )){
                lista.agregarFinal(a.getDato());
            }
            ListaGenerica<ArbolGeneral<Integer>> lHijos= a.getHijos();
            lHijos.comenzar();
            while (!lHijos.fin()){
                numerosImparesMayoresQuePreOrden(lHijos.proximo(),n,lista);
            }
        }
    
    
    }

    public ListaGenerica<Integer> numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, int n) {
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        numerosImparesMayoresQueInOrden(a,n, lista);
        return lista;

    }

    private void numerosImparesMayoresQueInOrden(ArbolGeneral<Integer> a, int n, ListaGenerica<Integer> lista) {
        if (!a.esVacio()) {
			if (a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos= a.getHijos();
				hijos.comenzar();
                numerosImparesMayoresQueInOrden(hijos.proximo(),n,lista);
                if ((a.getDato() % 2 != 0 && (a.getDato() > n))) {
                    lista.agregarFinal(a.getDato());			
                }
				while (!hijos.fin()) {
					numerosImparesMayoresQueInOrden(hijos.proximo(),n,lista);
				}
			}
            else{ //en caso de que no tenga datos pero el nodo tiene algún dato
                if ((a.getDato() % 2 != 0 && (a.getDato() > n))) {
                    lista.agregarFinal(a.getDato());			
                }
            }
			
		}
        
    }

    public ListaGenerica<Integer> numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n){
        ListaGenerica<Integer> lista = new ListaEnlazadaGenerica<Integer>();
        numerosImparesMayoresQuePostOrden(a,n, lista);
        return lista;


    }

    private void numerosImparesMayoresQuePostOrden(ArbolGeneral<Integer> a, Integer n, ListaGenerica<Integer> lista) {
        if (!a.esVacio()) {
			if (a.tieneHijos()) {
				ListaGenerica<ArbolGeneral<Integer>> hijos= a.getHijos();
				hijos.comenzar();
				while (!hijos.fin()) {
					numerosImparesMayoresQueInOrden(hijos.proximo(),n,lista);
				}
                if ((a.getDato() % 2 != 0 && (a.getDato() > n))) {
                    lista.agregarFinal(a.getDato());			
                }
			}
            else{ //en caso de que no tenga datos pero el nodo tiene algún dato
                if ((a.getDato() % 2 != 0 && (a.getDato() > n))) {
                    lista.agregarFinal(a.getDato());			
                }
            }
			
		}

    }


}