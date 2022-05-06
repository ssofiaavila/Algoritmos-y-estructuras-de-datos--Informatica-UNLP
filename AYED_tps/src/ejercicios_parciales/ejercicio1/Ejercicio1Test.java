package ejercicios_parciales.ejercicio1;


import ejercicios_parciales.ejercicio7.Ejercicio7;
import tp02.ejercicio1.*;
import tp02.ejercicio2.ListaGenerica;
import tp04.ejercicio1.ArbolGeneral;

public class Ejercicio1Test {
	public static void main(String []args) {
		
		ArbolGeneral<Character> g = new ArbolGeneral<Character>('A');
		
		ArbolGeneral<Character> e = new ArbolGeneral<Character> ('B');
		ArbolGeneral<Character> f = new ArbolGeneral<Character> ('C');
		ArbolGeneral<Character> j = new ArbolGeneral<Character> ('D');
		
		ArbolGeneral<Character> a = new ArbolGeneral<Character> ('E');
		ArbolGeneral<Character> b = new ArbolGeneral<Character> ('F');
		ArbolGeneral<Character> c = new ArbolGeneral<Character> ('G');
		
		ArbolGeneral<Character> d = new ArbolGeneral<Character> ('H');
		
		ArbolGeneral<Character> h = new ArbolGeneral<Character> ('I');
		ArbolGeneral<Character> i = new ArbolGeneral<Character> ('J');
		
		g.agregarHijo(e);
		g.agregarHijo(f);
		g.agregarHijo(j);
		
		e.agregarHijo(a);
		e.agregarHijo(b);
		e.agregarHijo(c);
		
		f.agregarHijo(d);
		
		j.agregarHijo(h);
		j.agregarHijo(i);
		
		Caminos c1 = new Caminos ();
		
		ListaGenerica<tp02.ejercicio2.ListaGenerica<Character>> caminos= c1.caminosPares(g);
		caminos.comenzar();
		while (!caminos.fin()) {
			ListaGenerica<Character> lista= caminos.proximo();
			lista.comenzar();
			while (!lista.fin()) {
				System.out.println(lista.proximo());
			}
		}
	}


}

