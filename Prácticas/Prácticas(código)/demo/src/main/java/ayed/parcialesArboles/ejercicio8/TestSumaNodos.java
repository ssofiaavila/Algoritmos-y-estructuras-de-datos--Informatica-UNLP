package ayed.parcialesArboles.ejercicio8;

import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;

public class TestSumaNodos {
    public static void main(String[] args){

        ArbolGeneral<Integer> dos= new ArbolGeneral<Integer>(2);
        ArbolGeneral<Integer> uno= new ArbolGeneral<Integer>(1);
        ArbolGeneral<Integer> doce= new ArbolGeneral<Integer>(12);
        ArbolGeneral<Integer> catorce= new ArbolGeneral<Integer>(14);
        ArbolGeneral<Integer> cinco1= new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> cuatro1= new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> ocho= new ArbolGeneral<Integer>(8);
        ArbolGeneral<Integer> cuatro2= new ArbolGeneral<Integer>(4);
        ArbolGeneral<Integer> siete= new ArbolGeneral<Integer>(7);
        ArbolGeneral<Integer> nueve= new ArbolGeneral<Integer>(9);
        ArbolGeneral<Integer> diez= new ArbolGeneral<Integer>(10);
        ArbolGeneral<Integer> cinco2= new ArbolGeneral<Integer>(5);
        ArbolGeneral<Integer> tres= new ArbolGeneral<Integer>(3);
        ArbolGeneral<Integer> trece= new ArbolGeneral<Integer>(13);

        cuatro1.agregarHijo(nueve);
        cuatro1.agregarHijo(diez);
        cuatro1.agregarHijo(cinco2);
        ocho.agregarHijo(tres);
        siete.agregarHijo(trece);

        uno.agregarHijo(cinco1);
        uno.agregarHijo(cuatro1);
        doce.agregarHijo(ocho);
        doce.agregarHijo(cuatro2);
        doce.agregarHijo(siete);

        dos.agregarHijo(uno);
        dos.agregarHijo(doce);
        dos.agregarHijo(catorce);

        SumaNodos sumador= new SumaNodos(dos);
        ListaGenerica<Integer> lista= sumador.resolver();
        lista.comenzar();

        //espero que imprima 24 3 13 19 27
        while (!lista.fin()){
            System.out.println(lista.proximo());
        }






    }
}
