package practica2.ejercicio1;
import tp02.ejercicio1.*;


public class ejercicio1_6 {
	public static void main (String[]args) {
		
	System.out.println("Sucesion de 4:");
	ListaDeEnterosEnlazada rtdo= calcularSucesion(4);
	rtdo.comenzar();
	while (!rtdo.fin()) {
		System.out.println(rtdo.proximo());
	}
		
		
		
	}
	public static ListaDeEnterosEnlazada calcularSucesion(int n) {
		ListaDeEnterosEnlazada lis;
		lis = n > 1 ? calcularSucesion(calcular(n)) : new ListaDeEnterosEnlazada();
		lis.agregarInicio(n);
		return lis;
	}
	
	public static int calcular (int n) {
		if (n>1) {
			n= n%2 ==0 ? (n/2) : (n*3+1);
		}
		return n;
	}
}
