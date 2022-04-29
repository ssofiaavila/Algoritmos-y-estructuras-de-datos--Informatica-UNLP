package practica4.ejercicio5;

import ListasGenericas.tp02.ejercicio2.ListaEnlazadaGenerica;
import ListasGenericas.tp02.ejercicio2.ListaGenerica;
import practica2.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class AnalizadorArbol {
	
	public int devolverMaximoPromedio(ArbolGeneral<AreaEmpresa> arbol) {
		ColaGenerica<ArbolGeneral<AreaEmpresa>> cola= new ColaGenerica<ArbolGeneral<AreaEmpresa>>();
		ArbolGeneral<AreaEmpresa> aux;
		cola.encolar(arbol);
		cola.encolar(null);
		int total=0, max= -1, nivel=0, cantidad=0;
		while (!cola.esVacia()) {
			aux=cola.desencolar();
			if (aux !=null) {
				total=total+ aux.getDato().getTransmision();
				cantidad++;
				if (aux.tieneHijos()) {
					tp02.ejercicio2.ListaGenerica<ArbolGeneral<AreaEmpresa>> hijos=aux.getHijos();
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
					total= total/cantidad;
					if (total>max) max=total;
					cantidad=0;
					total=0;
				}
		}
		return max;
	}
}

