package ayed.practica2.ejercicio1;

import ayed.tp02.ejercicio1.ListaDeEnterosEnlazada;

public class ejercicio1_6 {
    
    private ListaDeEnterosEnlazada lista = new ListaDeEnterosEnlazada(); 
	
		public ListaDeEnterosEnlazada sucesion (int n) {
			if (n != 1 ) {
				if (n % 2 == 0 ) {
					n = n/2;
				}
				else
					n = 3*n+1;
				lista.agregarFinal(n);
				sucesion(n);
			}
			return lista;
		}

	public static void main(String[] args) {
		int n = 6;
		ejercicio1_6 f = new ejercicio1_6(); 
		ListaDeEnterosEnlazada l = f.sucesion(n); 
		System.out.println("SUCESION DE " + n );
		l.comenzar();
		while (!l.fin()) {
			System.out.println(l.proximo());
		}
	}


}
