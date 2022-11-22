package ayed.parcialesArboles.ejercicio7;

import ayed.tp03.ejercicio1.ArbolBinario;

public class TestSumaImpares {
    public static void main(String[] args){

        ArbolBinario<Integer> nueve= new ArbolBinario<Integer>(9);
        ArbolBinario<Integer> diez= new ArbolBinario<Integer>(10);
        ArbolBinario<Integer> cuatroTres= new ArbolBinario<Integer>(43);
        ArbolBinario<Integer> uno= new ArbolBinario<Integer>(1);
        ArbolBinario<Integer> unoSeis= new ArbolBinario<Integer>(16);
        ArbolBinario<Integer> dos= new ArbolBinario<Integer>(2);
        ArbolBinario<Integer> ochoSiete= new ArbolBinario<Integer>(87);
        ArbolBinario<Integer> sieteSiete= new ArbolBinario<Integer>(77);
        ArbolBinario<Integer> nueveCuatro= new ArbolBinario<Integer>(94);
        ArbolBinario<Integer> tresOcho= new ArbolBinario<Integer>(38);
        ArbolBinario<Integer> tresUno= new ArbolBinario<Integer>(31);
        ArbolBinario<Integer> cinco= new ArbolBinario<Integer>(5);
        ArbolBinario<Integer> seis= new ArbolBinario<Integer>(6);
        ArbolBinario<Integer> cincoSeis= new ArbolBinario<Integer>(56);
        ArbolBinario<Integer> dosCinco= new ArbolBinario<Integer>(25);
        ArbolBinario<Integer> siete= new ArbolBinario<Integer>(7);

        cuatroTres.agregarHijoIzquierdo(nueve);
        cuatroTres.agregarHijoDerecho(diez);

        unoSeis.agregarHijoDerecho(cuatroTres);
        dos.agregarHijoIzquierdo(uno);

        sieteSiete.agregarHijoIzquierdo(unoSeis);
        nueveCuatro.agregarHijoDerecho(dos);

        tresOcho.agregarHijoIzquierdo(ochoSiete);
        tresOcho.agregarHijoDerecho(sieteSiete);
        tresUno.agregarHijoDerecho(nueveCuatro);
        cincoSeis.agregarHijoDerecho(tresUno);
        cincoSeis.agregarHijoIzquierdo(tresOcho);
        dosCinco.agregarHijoIzquierdo(cinco);
        dosCinco.agregarHijoDerecho(seis);
        siete.agregarHijoIzquierdo(cincoSeis);


        siete.agregarHijoDerecho(dosCinco);

        SumaImpares sumador= new SumaImpares();
        //siendo 30, deberá recornar 238, 87+43+77+31= 238
        System.out.println(sumador.sumaImparesPosOrdenMayorA(siete,30));




    }
}
