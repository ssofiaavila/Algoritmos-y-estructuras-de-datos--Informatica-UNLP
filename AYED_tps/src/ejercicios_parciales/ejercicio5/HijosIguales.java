package ejercicios_parciales.ejercicio5;

import practica3.ejercicio1.ArbolBinario;
import tp02.ejercicio2.ListaEnlazadaGenerica;
import tp02.ejercicio2.ListaGenerica;

/*5) Implemente en la clase Parcial, el método con la siguiente firma:

resolver (ArbolBinario<Integer> arbol)
que devuelva una lista con los valores de los nodos que tengan el mismo numero
de descendientes por su subárbol izquierdo como por su subárbol derecho*/


public class HijosIguales {
	
	public ListaGenerica<Integer> resolver(ArbolBinario<Integer>arbol){
		ListaGenerica<Integer> lista= new ListaEnlazadaGenerica<Integer>();
		this.resolver(arbol,lista);
		return lista;
		
		
	}

	private int resolver(ArbolBinario<Integer> arbol, ListaGenerica<Integer> lista) {
		int izq=0,dcho=0,total=0;;
		if (arbol.esHoja()) {
			lista.agregarFinal(arbol.getDato());
		}
		else
		{	
			if (arbol.tieneHijoIzquierdo()) {
				izq+= resolver(arbol.getHijoIzquierdo(),lista);
				total+= izq;
			}
			if(arbol.tieneHijoDerecho()) {
				dcho += resolver(arbol.getHijoIzquierdo(),lista);	
				total+=dcho;
			}
			 if (izq==dcho) lista.agregarFinal(arbol.getDato());
		}
		return total;
		
	}
	
	
}
