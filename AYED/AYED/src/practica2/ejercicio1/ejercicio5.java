package practica2.ejercicio1;
import tp02.ejercicio1.*;
public class ejercicio5 {
	public static void main(String []args){
		
		ListaDeEnterosEnlazada lista= new ListaDeEnterosEnlazada();
		lista.agregarFinal(15);
		lista.agregarFinal(1);
		lista.agregarFinal(3);
		lista.agregarFinal(7);
		lista.comenzar();
		imprimirInverso(lista,1);
		
	}
	
	public static void imprimirInverso(ListaDeEnterosEnlazada lista,int indice){
	
	if (indice < lista.tamanio()){
		ejercicio5.imprimirInverso(lista,indice+1);
		
		
	}
	System.out.println(lista.elemento(indice));
	}
}
