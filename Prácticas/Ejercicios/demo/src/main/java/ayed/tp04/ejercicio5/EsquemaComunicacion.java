package ayed.tp04.ejercicio5;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class EsquemaComunicacion {
    private ArbolGeneral<Integer> esquema;

    public EsquemaComunicacion(ArbolGeneral<Integer> esquema) {
        this.esquema = esquema;
    }

    public int devolverMaximoPromedio(ArbolGeneral<Integer> esquema) {
        int cant_nodos=0, suma=0, max_promedio=-1;

		ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>(); 
		ArbolGeneral<Integer> arbol_aux; 

		cola.encolar(this.getEsquema()); 
		cola.encolar(null);

		while (!cola.esVacia()){
			arbol_aux=cola.desencolar();
			if (arbol_aux != null){
                suma = suma +  arbol_aux.getDato();
                cant_nodos++;
				if (arbol_aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<Integer>> hijos= arbol_aux.getHijos();
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
                suma= suma / cant_nodos;
                if (suma > max_promedio){
                    max_promedio=suma;
                } 
                suma=0;
                cant_nodos=0;		
                    			
				
			}
		}
		return max_promedio;
    }

    public ArbolGeneral<Integer> getEsquema(){
        return this.esquema;
    }
}
