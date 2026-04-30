package ar.edu.unlam;

public class GestionDeUsuarios {

	private Usuario[] usuarios;
	private Integer usuariosActivos;

	public GestionDeUsuarios(Integer i) {
		
		usuarios = new Usuario[i];
		usuariosActivos = 0;
	}
	

	public Boolean agregarUsuario(Usuario persona1) {
		
		Boolean seAgrego = false;
		if (validarUsuario(persona1)) {
			usuarios[usuariosActivos] = persona1;
			usuariosActivos++;
			 seAgrego = true;
			 }
			return seAgrego;
		}
	

	public Boolean validarUsuario(Usuario persona1) {
		return validarEmail(persona1.getEmail()) && (buscarUsuarioPorEmail(persona1.getEmail()) == null);
	}
	

	public Boolean validarEmail(String email) {
		return email.contains("@") && email.endsWith(".com") || email.endsWith(".ar") ;
	}

	public Usuario buscarUsuarioPorEmail(String email) {
	
		Usuario usuarioEncontrado = null;
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getEmail().equals(email)) {
				usuarioEncontrado = usuarios[i];
			}
		}
		return usuarioEncontrado;
	}
	

	public Boolean eliminarUsuario(String email) {

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getEmail().equals(email)) {
				usuarios[i] = null;
				usuariosActivos--;
				return true;
			}
		}
		return false;
	}
	

	public Integer getUsuariosRegistrados() {
		return usuariosActivos;
	}

}
