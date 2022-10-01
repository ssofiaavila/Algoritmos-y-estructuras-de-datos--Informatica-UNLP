package ayed.tp04.ejercicio7;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp02.ejercicio3.ColaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class RedDeAguaPotable {
    ArbolGeneral<Character> red;

    public RedDeAguaPotable(ArbolGeneral<Character> red) {
        this.red = red;
    }

    public double minimoCaudal(Double caudal){
        
        double auxCaudal, caudalMin=9999;


		ColaGenerica<ArbolGeneral<Character>> colaNodos= new ColaGenerica<ArbolGeneral<Character>>();
        ColaGenerica<Double> colaCaudal= new ColaGenerica<Double>();
		ArbolGeneral<Character> arbol_aux; 
		colaNodos.encolar(this.red);
		colaNodos.encolar(null);

        colaCaudal.encolar(caudal);
        colaCaudal.encolar(0.0);

		while (!colaNodos.esVacia()){
            int cant_hijos=0;

            auxCaudal= colaCaudal.desencolar();
			arbol_aux=colaNodos.desencolar();

			if (arbol_aux != null){

                if (auxCaudal < caudalMin){
                    caudalMin= auxCaudal;
                }

				if (arbol_aux.tieneHijos()){
					ListaGenerica<ArbolGeneral<Character>> hijos= arbol_aux.getHijos();
					hijos.comenzar();
					while (!hijos.fin()){
						colaNodos.encolar(hijos.proximo());
                        cant_hijos++;						
					}
                    auxCaudal= auxCaudal / (double) cant_hijos;
				}
                else{
                    auxCaudal=0.0;
                }
                for (int i=0; i < cant_hijos; i++){
                    colaCaudal.encolar(auxCaudal);
                }
			}
			else {
				if (!colaNodos.esVacia()){
					colaNodos.encolar(null);		
                    colaCaudal.encolar(0.0);			
				}
                
                
                
			}
		}
		



        return caudalMin;
    }
}
