package ejercicios_parciales.ejercicio2;

import practica3.ejercicio1.ArbolBinario;

/*2) Implemente en la clase Parcial el método sumarImparesPosOrdenMayorA que recibe
un árbol binario de enteros positivos y un numero entero. Este método suma todos
los números impares del árbol que son mayores al parametro realizandolo en un recorrido posOrden
public Integer sumaImparesaPosOrdenMayorA(ArbolBinario <Integer> ab, int limite)
*/
public class Sumador {
	
	public Integer sumarImparesPosOrdenMayorA(ArbolBinario<Integer>ab,int limite) {
		int total=0;
		if (ab.esVacio()){
			return 0;
		}
		else {
			if (ab.tieneHijoIzquierdo()) total+= sumarImparesPosOrdenMayorA(ab.getHijoIzquierdo(),limite);
			if (ab.tieneHijoDerecho()) total+= sumarImparesPosOrdenMayorA(ab.getHijoDerecho(),limite);
			if (ab.getDato() > limite) total += ab.getDato();
			return total;
			
		}
		
	}
}
