package practica1.ejercicio3;

public class Profesor {
	private String nombre, apellido, email,catedra,facultad;
	
	
	
	public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.catedra = catedra;
		this.facultad = facultad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String cadena= "Nombre: "+ this.getNombre() + " Apellido: "+ this.getApellido()+
" Catedra: "+ this.getCatedra()+ " Email: "+ this.getEmail()+ " Facultad: "+ this.getFacultad();
return cadena;
	}
	
}
