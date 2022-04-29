package practica4.ejercicio7;

import ListasGenericas.tp02.ejercicio2.ListaGenerica;
import practica2.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable <T> {
	ArbolGeneral<T> abb;
	
	public RedDeAguaPotable(ArbolGeneral<T> abb) {
		this.abb=abb;
	}
	
	public double minimoCaudal(double caudal) {
		ColaGenerica<ArbolGeneral<T>> cola= new ColaGenerica<ArbolGeneral<T>>();
		ColaGenerica<Double> colaCaudal = new ColaGenerica<Double>();
		ArbolGeneral<T> aux;
		double auxCaudal;
		int nivel=0;
		double min= 99999.9;
		cola.encolar(this.abb);
		colaCaudal.encolar(0.0);
		System.out.println("Nivel:"+nivel);
		auxCaudal= colaCaudal.desencolar();
		while (!cola.esVacia()) {
			int cantidad=0;
			aux=cola.desencolar();
			auxCaudal= colaCaudal.desencolar();
			if (aux!=null) {
				if (auxCaudal < min) {
					min= auxCaudal;
				}
				if (aux.tieneHijos()) {
					tp02.ejercicio2.ListaGenerica<ArbolGeneral<T>> hijos= aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()) {
						cantidad++;
						cola.encolar(hijos.proximo());
					}
					auxCaudal= auxCaudal/ cantidad;
				}
				else
					auxCaudal=0.0;
				for (int i=0; i<cantidad;i++) {
					colaCaudal.encolar(auxCaudal);
				}
				System.out.println("Nodo "+ aux.getDato()+ "caudal: "+ auxCaudal);
			}
		}
		System.out.println(" ");
		return min;
	}
}
