package practica1B.ejercicio3;

public class Profesor extends Persona {
	String facultad,catedra;
	
	public Profesor(String nombre, String apellido, String email, String facultad, String catedra) {
		super(nombre, apellido, email);
		this.setFacultad(facultad);;
		this.setCatedra(catedra);;
	}
	
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	@Override
	public String tusDatos() {
		String aux= super.getInfo()+ " Facultad: "+ this.getFacultad()+ " Catedra: "+ this.getCatedra();
		return aux;
	}
	
	
	
	
}
