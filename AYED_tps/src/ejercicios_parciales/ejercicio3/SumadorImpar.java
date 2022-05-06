package ejercicios_parciales.ejercicio3;

import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;
import tp02.ejercicio3.ColaGenerica;
import tp04.ejercicio1.ArbolGeneral;

/*3) Implemente en la clase Parcial que tiene como variable de instancia un ArbolGeneral<Integer> el método
ListaGenerica<Integer> resolver() que devuelve en la lista la suma de los datos contenidos en los nodos del árbol que tienen un número impar hijos.
Realice un recorrido postOrden*/

public class SumadorImpar {

	private ArbolGeneral<Integer> arbol;
	
	public SumadorImpar(ArbolGeneral<Integer> abb) {
		this.arbol=abb;
	}
	
	
	public ListaGenerica<Integer> resolver(){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.resolver(arbol,lista);
		return lista;
		
	}


	private void resolver(ArbolGeneral<Integer> ab, ListaGenerica<Integer> lista) {
		ColaGenerica<ArbolGeneral<Integer>> cola= new ColaGenerica<ArbolGeneral<Integer>>();
		int suma=0;		
		if (ab.tieneHijos()){					
				ListaGenerica<ArbolGeneral<Integer>> hijos=ab.getHijos();			
				if (hijos.tamanio() % 2 ==1) { 
					hijos.comenzar();
					while (!hijos.fin()) {
						ArbolGeneral<Integer> aux= hijos.proximo();
						suma+= aux.getDato();
						resolver(aux,lista);
					
				}
					lista.agregarFinal(suma);
			}
			
			
		}
		
				
	}

}

