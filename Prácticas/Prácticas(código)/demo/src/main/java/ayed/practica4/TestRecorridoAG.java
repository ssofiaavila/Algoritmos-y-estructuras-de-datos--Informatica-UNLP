package ayed.practica4;

import ayed.tp02.ejercicio2.ListaEnlazadaGenerica;
import ayed.tp02.ejercicio2.ListaGenerica;
import ayed.tp04.ejercicio1.ArbolGeneral;
import ayed.tp04.ejercicio3.RecorridoAG;

public class TestRecorridoAG {
    public static void main(String[] args){
        ListaGenerica<ArbolGeneral<Integer>> lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		ArbolGeneral<Integer> c = new ArbolGeneral<Integer>(3);
		ArbolGeneral<Integer> d = new ArbolGeneral<Integer>(4);
		ArbolGeneral<Integer> e = new ArbolGeneral<Integer>(5);
		ArbolGeneral<Integer> f = new ArbolGeneral<Integer>(6);
		ArbolGeneral<Integer> g = new ArbolGeneral<Integer>(7);
		ArbolGeneral<Integer> h = new ArbolGeneral<Integer>(8);
		ArbolGeneral<Integer> i = new ArbolGeneral<Integer>(9);
		ArbolGeneral<Integer> j = new ArbolGeneral<Integer>(10);
		
		f.agregarHijo(h);
		f.agregarHijo(i);
		
		g.agregarHijo(j);
		
		lista.agregarFinal(c);
		lista.agregarFinal(d);
		lista.agregarFinal(e);
		
		ArbolGeneral<Integer> b = new ArbolGeneral<Integer>(13,lista);

		
		lista = new ListaEnlazadaGenerica<ArbolGeneral<Integer>>();
		
		lista.agregarFinal(b);
		lista.agregarFinal(f);
		lista.agregarFinal(g);
		
		ArbolGeneral<Integer> a = new ArbolGeneral<Integer>(11,lista);
		
		RecorridoAG recorridos= new RecorridoAG(a);

        // VALORES ESPERADOS: 7 9 13


        // RECORRIDO preOrden
        System.out.println("Recorrido preOrden");
        ListaGenerica<Integer> preOrden= recorridos.numerosImparesMayoresQuePreOrden(a, 5);
        preOrden.comenzar();
        while (!preOrden.fin()){
            System.out.println(preOrden.proximo());
        }
        

        //RECORRIDO inOrden
        System.out.println("Recorrido InOrden");
        ListaGenerica<Integer> inOrden= recorridos.numerosImparesMayoresQueInOrden(a,5);
        inOrden.comenzar();
        while (!inOrden.fin()){
            System.out.println(inOrden.proximo());
        }


		// RECORRIDO postOrden
		System.out.println("Recorrido PostOrden");
		ListaGenerica<Integer> postOrden= recorridos.numerosImparesMayoresQuePostOrden(a, 5);
		inOrden.comenzar();
		while (!inOrden.fin()){
			System.out.println(inOrden.proximo());
		}

    }
}
