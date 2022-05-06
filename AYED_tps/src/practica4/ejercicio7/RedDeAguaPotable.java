package practica4.ejercicio7;

import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
	private ArbolGeneral<Bifurcacion> red;
	
	
	
	public RedDeAguaPotable(ArbolGeneral<Bifurcacion> red) {
		this.red=red;
	}
	
	public double minimoCaudal(double caudal) {
		double min=9999;
		return minimoCaudal(red,caudal,min);
	}
	
	private double minimoCaudal(ArbolGeneral<Bifurcacion> red, double caudal, double min) {
		if(red.esHoja())
			if(caudal < min)
				return caudal;
		
		ListaGenerica<ArbolGeneral<Bifurcacion>> hijos = red.getHijos();
		hijos.comenzar();
		caudal = caudal / hijos.tamanio();
		while(!hijos.fin())
			min=minimoCaudal(hijos.proximo(),caudal,min);
		return min;
	}
}
