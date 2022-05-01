package practica2.ejercicio2;
import practica1.ejercicio3.Estudiante;
import tp02.ejercicio2.*;
public class TestListaEnlazadaGenerica {
	public static void main(String[]args) {
	Estudiante e1,e2,e3,e4;
	
	e1= new Estudiante("Perez","Agustina","150","agos@mail.com","Cordoba 189");
	e2= new Estudiante("Corral","Lautaro","88", "lauty@mail.com", "Brasil 5020");
	e3= new Estudiante("Moreno","Camila","88", "cami@mail.com", "Zamora 257");
	e4= new Estudiante("Roman","Sofia","59", "soso@mail.com", "Antazena 555");
	
	ListaEnlazadaGenerica<Estudiante> lista= new ListaEnlazadaGenerica<Estudiante>();
	lista.agregarFinal(e1);
	lista.agregarFinal(e2);
	lista.agregarFinal(e3);
	lista.agregarFinal(e4);
	
	lista.comenzar();
	while (!lista.fin()) {
		System.out.println(lista.proximo().tusDatos());
		
	}
	
}
}