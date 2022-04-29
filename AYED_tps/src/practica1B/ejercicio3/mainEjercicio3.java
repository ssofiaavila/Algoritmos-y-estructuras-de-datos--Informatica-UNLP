package practica1B.ejercicio3;

public class mainEjercicio3 {
	public static void main (String[]args) {
		Estudiante[] e1= new Estudiante[3];
		Profesor[] p1 = new Profesor [2];
		
		Estudiante est1,est2,est3;
		Profesor prof1,prof2;
		est1= new Estudiante("Sofia", "Avila","avilasofia076@gmail.com", "Azucenaga 3294", 4);
		est2= new Estudiante("Florencia", "Romero", "mflorenciaromero@hotmail.com", "Azcuenaga 3294", 1);
		est3= new Estudiante("Antonio","Avila","avila_afs@hotmail.com", "Azcuenaga 3294", 3);
		prof1= new Profesor("Juan", "Lopez","jualopez@gmail.com","Informatica","Objetos");
		prof2 = new Profesor("Erica", "Leguizamon", "erilegui@gmail.com","Ingenieria", "Quimica");
		e1[0]= est1;
		e1[1]=est2;
		e1[2]=est3;
		p1[0]=prof1;
		p1[1]= prof2;
		
		for (int i=0; i< e1.length;i++) {			
			System.out.println(e1[i].tusDatos());
		}
		for (int i=0;i<p1.length;i++) {			
			System.out.println(p1[i].tusDatos());
		}
	}
}
