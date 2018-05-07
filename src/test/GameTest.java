package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Game;

public class GameTest {
	
	/* Comprobamos funcionamiento de los constructores */
	@Test
	public void ConstructTest() {
		Game game = new Game();
		
		assertEquals(1, game.getMin());
		assertEquals(100, game.getMax());
		assertEquals(1, game.getCounter());
		assertEquals(10, game.getAttempts());
		assertTrue(game.getSecretNumber() > 0 && game.getSecretNumber() <= 100);
	}
	
	@Test
	public void ConstructTest2() {
		Game game = new Game(7);
		
		assertEquals(1, game.getMin());
		assertEquals(100, game.getMax());
		assertEquals(1, game.getCounter());
		assertEquals(7, game.getAttempts());
		assertTrue(game.getSecretNumber() > 0 && game.getSecretNumber() <= 100);
	}
	
	/* Comprobamos las demás funciones */
	@Test
	public void CheckNumberTest() {
		Game game = new Game();
		
		game.setSecretNumber(78);
		assertTrue(game.checkNumber(78));
	}
	
	@Test
	public void CheckAttemptsTest() {
		Game game = new Game(0);
		
		game.addAttempt(); //Intentos = 1.
		assertEquals(0, game.getCounter());
		assertEquals(1, game.getAttempts());
		assertTrue(game.checkAttempts());
		
		game.subtractAttempt(); //Intentos = 0.
		assertEquals(1, game.getCounter());
		assertEquals(0, game.getAttempts());
		assertFalse(game.checkAttempts());
	}
	
	@Test
	public void GuessTest() {
		Game game = new Game();
		
		game.setMin(25);
		game.setMax(75);
		game.guess();
		assertTrue(game.getSecretNumber() >= 25 && game.getSecretNumber() <= 75);
		
		game.setMin(49);
		game.setMax(51);
		game.guess();
		assertTrue(game.getSecretNumber() >= 49 && game.getSecretNumber() <= 51);
		
		game.setMin(50);
		game.setMax(50);
		game.guess();
		assertTrue(game.getSecretNumber() == 50);
	}

}
