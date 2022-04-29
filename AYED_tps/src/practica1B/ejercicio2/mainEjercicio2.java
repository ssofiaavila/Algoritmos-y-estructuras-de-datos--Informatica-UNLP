package practica1B.ejercicio2;
import java.util.Scanner;

public class mainEjercicio2 {
	public static void main(String[]args) {
		Contador c= new Contador();
		Scanner leer=new Scanner(System.in);
		System.out.println("Ingrese un numero");
		int num= leer.nextInt();
		int [] vc= new int[num];
		vc=c.obtenerMultiplos(num);
		for (int i=0; i< num;i++) {
			System.out.println(vc[i]);
		}
	}

}