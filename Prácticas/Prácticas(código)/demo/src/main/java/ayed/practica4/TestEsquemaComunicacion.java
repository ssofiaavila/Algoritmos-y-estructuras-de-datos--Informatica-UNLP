package ayed.practica4;

import ayed.tp04.ejercicio1.ArbolGeneral;
import ayed.tp04.ejercicio5.EsquemaComunicacion;

public class TestEsquemaComunicacion {
    public static void main(String[] args){
        
		ArbolGeneral<Integer> m = new ArbolGeneral<Integer>(14);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(13);
		ArbolGeneral<Integer> k = new ArbolGeneral<Integer>(25);
		ArbolGeneral<Integer> l = new ArbolGeneral<Integer>(10);		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(6);	
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(10);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(18);		
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(12);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(19);
		
		m.agregarHijo(j);
		m.agregarHijo(k);
		m.agregarHijo(l);
		
		j.agregarHijo(a);
		j.agregarHijo(b);
		j.agregarHijo(c);
		
		k.agregarHijo(d);
		k.agregarHijo(e);
		k.agregarHijo(f);
		
		l.agregarHijo(g);
		l.agregarHijo(h);
		l.agregarHijo(i);

        //TESTS, espero 16
        EsquemaComunicacion esquema= new EsquemaComunicacion(m);
        System.out.println("Mayor retardo de envio: "+ esquema.devolverMaximoPromedio(m));

        
    }
    
}
