/*Llamaremos a un árbol general creciente si en cada nivel del árbol la cantidad de nodos que hay en ese nivel es igual al valor 
del nivel más 1. Es decir, el nivel 0 tiene exactamente un nodo, el nivel 1 tiene exactamente 2 nodos, el nivel k tiene exactamente k+1 nodos. Comprobar si un 
árbol general es creciente y en caso de que lo sea, retornar el nodo del árbol con mayor cantidad de hijos, en caso de no serlo, retornar null*/

package ayed.parcialesArboles.ejercicio3;

import ayed.tp04.ejercicio1.ArbolGeneral;

public class TestArbolCreciente {

    public static void main(String[] args){

        ArbolGeneral<Integer> tres= new ArbolGeneral<Integer>(3);
        ArbolGeneral<Integer> seis= new ArbolGeneral<Integer>(6);
        ArbolGeneral<Integer> unoDos= new ArbolGeneral<Integer>(12);
        ArbolGeneral<Integer> unoNueve= new ArbolGeneral<Integer>(19);
        ArbolGeneral<Integer> cincoSeis= new ArbolGeneral<Integer>(56);
        ArbolGeneral<Integer> dosUno= new ArbolGeneral<Integer>(21);
        ArbolGeneral<Integer> dosDos= new ArbolGeneral<Integer>(22);
        ArbolGeneral<Integer> unoOcho= new ArbolGeneral<Integer>(18);
        ArbolGeneral<Integer> cinco= new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> uno= new ArbolGeneral<Integer>(1);

        cincoSeis.agregarHijo(tres);
        unoOcho.agregarHijo(cincoSeis);
        uno.agregarHijo(unoOcho);
        dosUno.agregarHijo(seis);
        dosUno.agregarHijo(unoDos);
        unoOcho.agregarHijo(dosUno);

        dosDos.agregarHijo(unoNueve);
        cinco.agregarHijo(dosDos);
        uno.agregarHijo(cinco);

        ArbolCreciente creciente= new ArbolCreciente(uno);
        ArbolGeneral<Integer> masHijos= creciente.esCreciente();
        if (masHijos != null){
            System.out.println("El arbol es creciente");
            System.out.println(masHijos.getDato());
        }
        else
            System.out.println("El arbol no es creciente");
            



    }
    
}
