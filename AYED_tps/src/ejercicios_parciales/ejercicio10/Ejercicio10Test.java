package ejercicios_parciales.ejercicio10;
import practica3.ejercicio1.ArbolBinario;
public class Ejercicio10Test {
	public static void main(String[]args) {
		ArbolBinario<Integer> raiz= new ArbolBinario<Integer>(3);
		ArbolBinario<Integer> hijo1= new ArbolBinario<Integer>(10);
		ArbolBinario<Integer> hijo2= new ArbolBinario<Integer>(20);
		
		ArbolBinario<Integer> hijo3= new ArbolBinario<Integer>(30);
		ArbolBinario<Integer> hijo4= new ArbolBinario<Integer>(55);
		
		ArbolBinario<Integer> hijo5= new ArbolBinario<Integer>(60);
		ArbolBinario<Integer> hijo6= new ArbolBinario<Integer>(70);
		
		raiz.agregarHijoIzquierdo(hijo1);
		raiz.agregarHijoDerecho(hijo2);
		
		hijo1.agregarHijoDerecho(hijo3);
		hijo1.agregarHijoIzquierdo(hijo4);
		
		hijo2.agregarHijoIzquierdo(hijo5);
		hijo2.agregarHijoDerecho(hijo6);
		
		Sumador sumador= new Sumador(raiz);
		System.out.println("La suma de los elementos del arbol es: " + sumador.sumarElementos());
		
	}
}
