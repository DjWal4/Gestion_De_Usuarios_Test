package ar.edu.unlam;

public class Usuario  {

	String nombre;
	int edad;
	String email;

	public Usuario(String nombre, int edad, String email) {
		this.nombre = nombre;
		this.edad = edad;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

}
