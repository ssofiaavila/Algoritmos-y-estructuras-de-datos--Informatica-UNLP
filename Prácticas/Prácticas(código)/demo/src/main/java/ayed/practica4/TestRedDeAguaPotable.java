package ayed.practica4;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;
import ayed.tp04.ejercicio7.RedDeAguaPotable;

public class TestRedDeAguaPotable {
    public static void main(String[] args){
    ListaGenerica<ArbolGeneral<Character>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Character>>();
		
		ArbolGeneral<Character> a = new ArbolGeneral<Character>('a');
		ArbolGeneral<Character> b = new ArbolGeneral<Character>('b');
		ArbolGeneral<Character> c = new ArbolGeneral<Character>('c');
		ArbolGeneral<Character> d = new ArbolGeneral<Character>('d');
		ArbolGeneral<Character> e = new ArbolGeneral<Character>('e');
		ArbolGeneral<Character> f = new ArbolGeneral<Character>('f');
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('g');
		ArbolGeneral<Character> h = new ArbolGeneral<Character>('h');
		ArbolGeneral<Character> i = new ArbolGeneral<Character>('i');
		ArbolGeneral<Character> j = new ArbolGeneral<Character>('j');
		ArbolGeneral<Character> k = new ArbolGeneral<Character>('k');
		ArbolGeneral<Character> l = new ArbolGeneral<Character>('l');
		ArbolGeneral<Character> m = new ArbolGeneral<Character>('m');
		ArbolGeneral<Character> n = new ArbolGeneral<Character>('n');
		ArbolGeneral<Character> o = new ArbolGeneral<Character>('o');
		
		a.agregarHijo(b);
		a.agregarHijo(c);
		a.agregarHijo(d);
		a.agregarHijo(e);
		
		c.agregarHijo(f);
		c.agregarHijo(g);
		
		d.agregarHijo(h);
		d.agregarHijo(i);
		d.agregarHijo(j);
		d.agregarHijo(k);
		d.agregarHijo(o);
		
		j.agregarHijo(m);
		j.agregarHijo(n);
		
		
		RedDeAguaPotable test = new RedDeAguaPotable(a);	//espero 25.0
		System.out.println("MINIMO : "+ test.minimoCaudal(1000.00));
    
}
}