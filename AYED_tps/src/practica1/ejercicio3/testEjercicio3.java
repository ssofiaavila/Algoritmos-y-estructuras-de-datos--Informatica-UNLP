package practica1.ejercicio3;

public class testEjercicio3 {
	public static void main(String[]args) {
		
		Estudiante[] estudiantes= new Estudiante[2];
		Profesor[] profesores= new Profesor[3];
		
		Profesor p1,p2,p3;
		Estudiante e1,e2;
		
		p1= new Profesor("Mariana", "Rodriguez","mari@mail.com","Matematica","Informatica");
		p2= new Profesor("Ana","Hudson","ani@mail.com","Quimica","Ingneieria");
		p3= new Profesor("Jose","Calchaqui","jose@mail.com","Fisica", "Ingenieria");
		profesores[0]=p1;
		profesores[1]=p2;
		profesores[2]= p3;
		
		e1= new Estudiante("Arenas","Joaquin","184","joaco@mail.com","Mitre 32");
		e2= new Estudiante("Avalos","Loana","155","loan@mail.com","Urquiza 77");
		estudiantes[0]=e1;
		estudiantes[1]= e2;
		
		
		System.out.println("Estudiantes: ");
		
		int i;
		for (i=0; i<estudiantes.length;i++) {
			System.out.println(estudiantes[i].tusDatos());
		}
		System.out.println("Profesores: ");
		
		for (i=0; i<profesores.length;i++) {
			System.out.println(profesores[i].tusDatos());
		}
	}
}
