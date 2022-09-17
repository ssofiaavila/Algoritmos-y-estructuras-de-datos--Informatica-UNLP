package ayed.practica3;

import ayed.tp03.ejercicio1.ArbolBinario;
import ayed.tp03.ejercicio4.RedBinariaLlena;

public class TestRedBinariaLlena {
    public static void main(String[] args){
    ArbolBinario<Integer> a = new ArbolBinario<Integer>(1); 
		ArbolBinario<Integer> b = new ArbolBinario<Integer>(1); 
		ArbolBinario<Integer> c = new ArbolBinario<Integer>(1); 
		ArbolBinario<Integer> d = new ArbolBinario<Integer>(0); 
		ArbolBinario<Integer> e = new ArbolBinario<Integer>(0);
		ArbolBinario<Integer> f = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> g = new ArbolBinario<Integer>(1);
		ArbolBinario<Integer> h = new ArbolBinario<Integer>(0);
		
		a.agregarHijoIzquierdo(b);
		a.agregarHijoDerecho(c);
		b.agregarHijoIzquierdo(d);
		b.agregarHijoDerecho(e);
		g.agregarHijoDerecho(h);
		f.agregarHijoDerecho(g);
		c.agregarHijoDerecho(f);
		
		RedBinariaLlena red = new RedBinariaLlena(a);
		
		System.out.println(red.retardoEnvio() + " SEGUNDOS");
    }
}
