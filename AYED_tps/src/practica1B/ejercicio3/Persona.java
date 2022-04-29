package practica1B.ejercicio3;

public abstract class Persona {
	String nombre, apellido, email;
	public Persona(String nombre,String apellido, String email) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEmail(email);
	}
	
	public String getInfo() {
		String aux= "Nombre: "+ this.getNombre()+ " Apellido: "+ this.getApellido()+
				" Email: "+ this.getEmail()	;
	return aux;
	}
	
	public abstract String tusDatos();
	
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
	
	
}
