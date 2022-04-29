package practica1B.ejercicio5;


public class mainEjercicio5 {
	public static void main(String[]args) {
	int[]vector= new int[5];
	vector[0]= 4;
	vector[1]=7;
	vector[2]=2;
	vector[3]=5;
	vector[4]=11;
	
	double []valores1= obtenerValoresVector(vector); //inciso A
	
	
	//inciso b
	
	
	
	//inciso c
	double []valores3= new double [3];
	int dimF= vector.length,min=1000,max=-1,suma=0;
	
	for (int i=0;i<=dimF;i++) {
		if (vector[i] < min){
			min= vector[i];
		}
		if (vector[i] > max){
			max= vector[i];
		}
		suma=suma+ vector[i];
	}
	valores3[0]=min;
	valores3[1]=max;
	valores3[2]=suma/dimF;
	
	
	
	
	
	}	

	private static double[] obtenerValoresVector(int[] vector) {
		int dimF= vector.length;
		int min=1000,max=-1;
		int suma=0;
		for (int i=0; i<= dimF;i++) {
			if (vector[i] < min){
				min= vector[i];
			}
			if (vector[i] > max){
				max= vector[i];
			}
			suma=suma+ vector[i];
		}		
		
		double []rtdo= new double[3];
		rtdo[0]=min;
		rtdo[1]=max;
		rtdo[2]=suma/dimF;	
		
		
		return rtdo;
	}
}
