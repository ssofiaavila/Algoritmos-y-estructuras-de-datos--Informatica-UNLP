package practica4.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<Bifurcacion> red;
	
	private ArbolGeneral<String> red;
	
	public RedDeAguaPotable(ArbolGeneral<String> red) {
		this.red=red;
	}
	
	public double minimoCaudal(double caudal) {
		double min=9999;
		return minimoCaudal(red,caudal,min);
	}
	
	private double minimoCaudal(ArbolGeneral<String> red, double caudal, double min) {
		if(red.esHoja())
			if(caudal < min)
				return caudal;
		
		ListaGenerica<ArbolGeneral<String>> hijos = red.getHijos();
		hijos.comenzar();
		caudal = caudal / hijos.tamanio();
		while(!hijos.fin())
			min=minimoCaudal(hijos.proximo(),caudal,min);
		return min;
	}
}
