package practica1B.ejercicio1;

public class mainEjercicio1 {
	public static void main(String []args) {
		int a=1,b=1;
		Impresora i1= new Impresora();
		System.out.println("Con for");
		i1.metodoA(a,b);
		System.out.println("Con while");
		i1.metodoB(a,b);
		System.out.println("Sin estructura");
		i1.metodoC(a,b);
		
		
		
		
	}
}
