package practica1B.ejercicio2;

public class Contador {
	
	public Contador() {
		
	}
	
	public int[] obtenerMultiplos(int num) {
			 int[] vector= new int[num];
			 for (int i=0; i<num;i++) {
				 vector[i]=num*(i+1);				 
			 }
		return vector;
	}
}
