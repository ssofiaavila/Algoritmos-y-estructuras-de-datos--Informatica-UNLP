package ayed.parcialesArboles.ejercicio9;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class TestCaminoLejano {
    public static void main(String[] args){
        ArbolGeneral<Integer> ocho= new ArbolGeneral<Integer>(8);
        ArbolGeneral<Integer> tres= new ArbolGeneral<Integer>(3);
        ArbolGeneral<Integer> cinco= new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> cuatro= new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> siete= new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> seis= new ArbolGeneral<Integer>(6);
        ArbolGeneral<Integer> uno= new ArbolGeneral<Integer>(1);
        ArbolGeneral<Integer> nueve= new ArbolGeneral<Integer>(9);
        ArbolGeneral<Integer> diez= new ArbolGeneral<Integer>(10);
        ArbolGeneral<Integer> dos= new ArbolGeneral<Integer>(2);

        siete.agregarHijo(dos);

        tres.agregarHijo(cuatro);
        tres.agregarHijo(siete);
        tres.agregarHijo(seis);
        
        cinco.agregarHijo(uno);
        cinco.agregarHijo(nueve);
        cinco.agregarHijo(diez);

        ocho.agregarHijo(tres);
        ocho.agregarHijo(cinco);


        //TEST
        CaminoLejano prueba= new CaminoLejano(ocho);
        ListaGenerica<ArbolGeneral<Integer>> camino= prueba.caminoMasLejos();
        camino.comenzar();
        while (!camino.fin()){
            System.out.println(camino.proximo().getDato());
        }

        //tiene que imprimir 8 3 7 2


    }
}
