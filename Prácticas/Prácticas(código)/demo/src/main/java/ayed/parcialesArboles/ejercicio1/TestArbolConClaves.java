/*Sea un árbol general en donde cada nodo tiene un valor numérico, usted debe devolver el camino determinado por el valor que posee 
cada nodo. Es decir, el camino comienza en el nodo raíz, luego debe seguir por el hijo que se encuentra en la posición indicada por el 
valor en el nodo raíz y así debe seguir hasta llegar a su hoja. Para el siguiente árbol, el camino a retornar es GEC*/

package ayed.parcialesArboles.ejercicio1;


import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class TestArbolConClaves {
    public static void main(String[] args){


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


        ArbolConClaves ab= new ArbolConClaves(g);

        ListaGenerica<Integer> recorrido= ab.recorridoPorClaves();
        recorrido.comenzar();
        while (!recorrido.fin()){
            System.out.println(recorrido.proximo());
        }




    }
}
