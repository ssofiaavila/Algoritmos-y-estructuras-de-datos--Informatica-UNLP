package ayed.parcialesArboles.ejercicio5;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

/*Dado un árbol general, encontrar todos los caminos desde la raíz a una hoja, tales que la cantidad de
nodos en el camino sea un número par. Escribir el siguiente método dentro de la clase Parcial public ??
caminosPares(ArbolGeneral<Character> arbol) */


public class TestCaminosImpares {
    public static void main(String[] args){

        ArbolGeneral<Character> a = new ArbolGeneral<Character>('A');
        ArbolGeneral<Character> b= new ArbolGeneral<Character>('B');
        ArbolGeneral<Character> e= new ArbolGeneral<Character>('E');
        ArbolGeneral<Character> c= new ArbolGeneral<Character>('C');
        ArbolGeneral<Character> f= new ArbolGeneral<Character>('F');
        ArbolGeneral<Character> h= new ArbolGeneral<Character>('H');
        ArbolGeneral<Character> i= new ArbolGeneral<Character>('I');
        ArbolGeneral<Character> g= new ArbolGeneral<Character>('G');
        ArbolGeneral<Character> d= new ArbolGeneral<Character>('D');
        
        f.agregarHijo(h);
        f.agregarHijo(i);

        b.agregarHijo(e);
        c.agregarHijo(f);
        c.agregarHijo(g);
        a.agregarHijo(b);
        a.agregarHijo(c);
        a.agregarHijo(d);

        CaminosPares caminos= new CaminosPares();
        ListaGenerica<ListaEnlazadaGenerica<Character>> listaDeLista= caminos.caminosPares(a);
        //Espero que imprima 3 porque hay 3 caminos cuya cantidad de nodos es par
        System.out.println(listaDeLista.tamanio());



    }
    
}
