package ejercicios_parciales.ejercicio7;

import tp04.ejercicio1.ArbolGeneral;

public class Ejercicio7Test {

	public static void main(String[] args) {
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer> (1);
		
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer> (3);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer> (2);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer> (5);
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer> (7);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer> (9);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer> (6);
		
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer> (10);
		
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer> (6);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer> (10);
		
		g.agregarHijo(e);
		g.agregarHijo(f);
		g.agregarHijo(j);
		
		e.agregarHijo(a);
		e.agregarHijo(b);
		e.agregarHijo(c);
		
		f.agregarHijo(d);
		
		j.agregarHijo(h);
		j.agregarHijo(i);
		
		Ejercicio7 test = new Ejercicio7 ();
		
		System.out.println(test.obtenerCamino(g));
	}

}
