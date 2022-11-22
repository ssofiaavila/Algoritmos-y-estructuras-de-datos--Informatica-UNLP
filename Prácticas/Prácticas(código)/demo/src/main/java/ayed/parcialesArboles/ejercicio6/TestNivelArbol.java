package ayed.parcialesArboles.ejercicio6;

import ayed.tp03.ejercicio1.ArbolBinario;

public class TestNivelArbol {
    public static void main(String[] args){

        ArbolBinario<Integer> dos1= new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> siete= new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> cinco1= new ArbolBinario<Integer>(5);
        ArbolBinario<Integer> seis= new ArbolBinario<Integer>(6);
        ArbolBinario<Integer> nueve= new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> cuatro= new ArbolBinario<Integer>(4);
        ArbolBinario<Integer> cinco2= new ArbolBinario<Integer>(5);
        ArbolBinario<Integer> dos2= new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> once= new ArbolBinario<Integer>(11);

        seis.agregarHijoIzquierdo(cinco2);
        seis.agregarHijoDerecho(once);
        nueve.agregarHijoIzquierdo(cuatro);
        siete.agregarHijoIzquierdo(dos2);
        siete.agregarHijoDerecho(seis);
        cinco1.agregarHijoDerecho(nueve);
        dos1.agregarHijoDerecho(cinco1);
        dos1.agregarHijoIzquierdo(siete);

        NivelArbol nivel= new NivelArbol(dos1);
        ArbolBinario<Integer> resultado= nivel.minEnNivelAB(3);

        //Espero que imprima 4 porque en el nivel 3 el subárbol hoja con menor valor es 4
        System.out.println(resultado.getDato());





    }
}
