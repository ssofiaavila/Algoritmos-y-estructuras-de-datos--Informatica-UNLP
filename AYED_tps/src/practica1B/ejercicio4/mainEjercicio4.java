package practica1B.ejercicio4;

public class mainEjercicio4 {
	public static void main (String []args) {
		int a = 1, b = 2;
		Integer c = 3, d = 4;
		swap1(a,b);
		swap2(c,d);
		System.out.println("a=" + a + " b=" + b) ;
		System.out.println("c=" + c + " d=" + d) ;
		
		
		
	}

	private static void swap2(Integer x, Integer y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
		}
	}

	private static void swap1(int x, int y) {
		if (x < y) {
			int tmp = x ;
			x = y ;
			y = tmp;
			}
		
	}
}
