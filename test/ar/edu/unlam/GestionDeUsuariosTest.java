package ar.edu.unlam;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionDeUsuariosTest {
	
	private GestionDeUsuarios gestion;
	private Usuario persona1;
	private Usuario persona2;
	
	@BeforeEach
	void inicializacion() {	
		persona1 = new Usuario("Julian", 31, "example@example.com");
		persona2 = new Usuario("Luciano", 33, "example@example.com.ar");
		gestion = new GestionDeUsuarios(10);
	}
	
	@Test
	public void agregarUnUsuarioTest() {
		assertTrue(gestion.agregarUsuario(persona1));
	}
	
	@Test
	public void agregarUsuarioDuplicadoTest() {
		assertTrue(gestion.agregarUsuario(persona1));
		assertFalse(gestion.agregarUsuario(persona1));
	}
	
	@Test
	public void agregarUsuarioEmailCorectoQueTermineConPuntoComYConPuntoAR() {
		assertTrue(gestion.agregarUsuario(persona1));
		assertTrue(gestion.agregarUsuario(persona2));
	}
	
	@Test
	public void agregarUsuarioEmailIncorrectoTest() {
		Usuario usuarioConMailIncorrecto = new Usuario("Julian", 31, "example.com");
		assertFalse(gestion.agregarUsuario(usuarioConMailIncorrecto));
	}
	
	@Test
	public void agregarUsuarioEmailIncorrectoTest2() {
		Usuario usuarioConMailIncorrecto = new Usuario("Julian", 31, "juli.com@example");
		assertFalse(gestion.agregarUsuario(usuarioConMailIncorrecto));
	}
	
	@Test
	public void testEliminarUsuarioPorEmailCorrectamente() {
		assertTrue(gestion.agregarUsuario(persona1));
		assertTrue(gestion.eliminarUsuario("example@example.com"));
		assertFalse(gestion.eliminarUsuario("example@example.com"));
		
	}
	
	@Test
	public void testObtenerLaCantidadDeUsuariosRegistrados() {
		gestion.agregarUsuario(persona1);
		assertEquals(1, gestion.getUsuariosRegistrados());
	}
	
	@Test
	public void testObtenerLaCantidadDeUsuariosRegistradosLuegoDeEliminar() {
		gestion.agregarUsuario(persona1);
		assertEquals(1, gestion.getUsuariosRegistrados());
		gestion.eliminarUsuario("example@example.com");
		assertEquals(0, gestion.getUsuariosRegistrados());
	}
}
