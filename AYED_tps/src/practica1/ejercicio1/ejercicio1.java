package practica1.ejercicio1;

public class ejercicio1 {
	public static void main (String[]args) {
		
		System.out.println("Utilizando for");
		imprimirConFor(4,8);
		
		System.out.println();
		System.out.println("Usando while");
		imprimirConWhile(4,8);
		
		System.out.println();
		System.out.println("Sin ninguna estructura");
		imprimirSinEstructura(4,8);
		
		
		
		
	}

	private static void imprimirSinEstructura(int i, int j) {
		if (i <= j) {
			System.out.println(i);
			i=i+1;
			imprimirSinEstructura(i,j);
		}
		else
			System.out.println();
		
		
	}

	private static void imprimirConWhile(int a, int b) {
		int i=a;
		while (i<=b) {
			System.out.println(i);
			i++;
		}
		
	}

	private static void imprimirConFor(int a, int b) {
		for (int i=a;i<=b;i++) {
			System.out.println(i);
		}
		
	}
}
