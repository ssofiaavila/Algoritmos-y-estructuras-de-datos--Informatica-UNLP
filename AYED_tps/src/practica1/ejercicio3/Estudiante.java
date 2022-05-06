package practica1.ejercicio3;

public class Estudiante {
	private String apellido, nombre, comision, email, direccion;

	
	
	
	public Estudiante(String apellido, String nombre, String comision, String email, String direccion) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.comision = comision;
		this.email = email;
		this.direccion = direccion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String tusDatos() {
		String cadena= "Nombre: "+ this.getNombre() + " Apellido: "+ this.getApellido()+
" Comision: "+ this.getComision()+ " Email: "+ this.getEmail()+ " Direccion: "+ this.getDireccion();
return cadena;
	}
	
}
