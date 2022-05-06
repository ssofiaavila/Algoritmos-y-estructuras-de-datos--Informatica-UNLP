package practica1B.ejercicio1;

public class Impresora {
	
	public Impresora() {
		
	}
	
	public void metodoA(int a,int b) {
		if (a<=b) {
			for (int i=a;i<=b;i++) {
				System.out.print(i+" ");
			}
		}
		else
		{ 
			for (int i=b;i<=a;i++) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}
	public void metodoB(int a,int b) {
		if (a <= b) {
			int i=a;
			while (i<=b) {
				System.out.print(i+" ");
				i++;
			}
		}
		else { 
			int i=b;
			while (i<=a) {
				System.out.print(i+" ");
				i++;
			}
	}
		System.out.println(); 
	}
	public void metodoC(int i,int j) {
		if (i <= j) {
			System.out.println(i);
			i=i+1;
			
		}
		else
			System.out.println();
	}
}
