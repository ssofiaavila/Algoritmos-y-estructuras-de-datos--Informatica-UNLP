
package ayed.practica3;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp03.ejercicio1.ArbolBinario;


public class TestContadorArbol {
	public static void main (String[]args) {
		ArbolBinario<Integer> ab= new ArbolBinario<Integer>(10);
        
        ArbolBinario<Integer> h1= new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> h2= new ArbolBinario<Integer>(6);
        ArbolBinario<Integer> h3= new ArbolBinario<Integer>(8);

        ArbolBinario<Integer> h4= new ArbolBinario<Integer>(11);
        ArbolBinario<Integer> h5= new ArbolBinario<Integer>(24);


        h2.agregarHijoDerecho(h1);
        h3.agregarHijoIzquierdo(h2);

        ab.agregarHijoIzquierdo(h3);
        h5.agregarHijoIzquierdo(h4);
        ab.agregarHijoDerecho(h5);
        
        // espero imprimir 24 8 6 10
        ContadorArbol contar= new ContadorArbol(ab);
        ListaGenerica<Integer> lista= contar.numerosParesPostOrden();
        
        lista.comenzar();
        while (!lista.fin()) {
        	System.out.println(lista.proximo());
        }
	

}}