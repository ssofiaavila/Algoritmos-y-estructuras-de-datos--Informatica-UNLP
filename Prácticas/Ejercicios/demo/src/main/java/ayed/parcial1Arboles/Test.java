package ayed.parcial1Arboles;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;

public class Test {
    public static void main(String[] args) {
        
		
		ArbolBinario<Integer> a43 = new ArbolBinario<Integer>(43);
		a43.agregarHijoIzquierdo(new ArbolBinario<Integer>(9));
		a43.agregarHijoDerecho(new ArbolBinario<Integer>(10));
		
		ArbolBinario<Integer> a16 = new ArbolBinario<Integer>(16);
		a16.agregarHijoDerecho(a43);
		
		ArbolBinario<Integer> a77 = new ArbolBinario<Integer>(77);
		a77.agregarHijoIzquierdo(a16);
		
		ArbolBinario<Integer> a38 = new ArbolBinario<Integer>(38);
		a38.agregarHijoDerecho(a77);
		a38.agregarHijoIzquierdo(new ArbolBinario<Integer>(87));
		
		ArbolBinario<Integer> a2 = new ArbolBinario<Integer>(2);
		a2.agregarHijoIzquierdo(new ArbolBinario<Integer>(1));
		
		ArbolBinario<Integer> a94 = new ArbolBinario<Integer>(94);
		a94.agregarHijoDerecho(a2);
		
		ArbolBinario<Integer> a31 = new ArbolBinario<Integer>(31);
		a31.agregarHijoDerecho(a94);
		
		ArbolBinario<Integer> a56 = new ArbolBinario<Integer>(56);
		a56.agregarHijoDerecho(a31);
		a56.agregarHijoIzquierdo(a38);
		
		ArbolBinario<Integer> a25 = new ArbolBinario<Integer>(25);
		a25.agregarHijoDerecho(new ArbolBinario<Integer>(6));
		a25.agregarHijoIzquierdo(new ArbolBinario<Integer>(5));
		
		ArbolBinario<Integer> a7 = new ArbolBinario<Integer>(7);
		a7.agregarHijoDerecho(a25);
		a7.agregarHijoIzquierdo(a56);
		



        /* dado un árbol binario y un número min devolver el recorrido en el cual la cantidad de nodos pares sea mayor o igual a min. Puede llegar a haber más de un recorrido,
         * devolver el primero. En caso no encontrarse retornar null 
         * 
         * MÉTODO= public ListaGenerica<Integer> resolver(ArbolBinario<Integer> ab, int min) 
         */
		
		/*           7
		 *        /     \
		 *       56     25
		 *      /  \   /  \
		 *     38  31 5    6
		 *    /  \  \	
		 *   87  77  94
		 *      /      \
		 *     16       2
		 *       \     /
		 *       43   1
		 *      / \
		 *     9   10  
		 * */

         RecorridoPares resolver= new RecorridoPares();

         ListaGenerica<Integer> recorrido= resolver.resolver(a7, 3);
         recorrido.comenzar();
         while (!recorrido.fin()){
            System.out.println(recorrido.proximo());
         }








    }
}
