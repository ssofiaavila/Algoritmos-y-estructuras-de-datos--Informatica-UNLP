package practica4.ejercicio5;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	
	public int devovlerMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		int total=0,cant=0,max=0;
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola= new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> aux;
		cola.encolar(arbol);
		cola.encolar(null);
		while (!cola.esVacia()) {
			aux=cola.desencolar();
			if (aux != null) {
				total= total+ aux.getDato().getTransmision();
				cant++;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos= aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			else
				if(!cola.esVacia()) {
					cola.encolar(null);
					total=total/cant;
					if (total >max) max=total;
					cant=0;
					total=0;
				}
		}
		return max;
	}
}
