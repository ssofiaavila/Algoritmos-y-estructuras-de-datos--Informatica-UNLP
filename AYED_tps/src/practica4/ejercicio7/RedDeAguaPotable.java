package practica4.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<Bifurcacion> red;
	
	public RedDeAguaPotable(ArbolGeneral<Bifurcacion>red) {
		this.red=red;
	}
	
	public double minimoCaudal(double caudal) {
		int cant=0;
		double min=caudal;
		ColaGenerica<ArbolGeneral<Bifurcacion>> cola= new ColaGenerica<ArbolGeneral<Bifurcacion>>();
		ArbolGeneral<Bifurcacion> aux;
		cola.encolar(red);
		cola.encolar(null);
		while (!cola.esVacia()) {
			aux= cola.desencolar();
			if (aux != null) {
				cant= cant+1;
				if (aux.tieneHijos()) {
					ListaGenerica<ArbolGeneral<Bifurcacion>> hijos= aux.getHijos();
					while (!hijos.fin()) {
						cola.encolar(hijos.proximo());
					}
				}
			}
			else
				if (!cola.esVacia()) {
					min= min/cant; ///ver
					cant=0;
					cola.encolar(null);
				}
		}
		return min;
		
		
	}
}
