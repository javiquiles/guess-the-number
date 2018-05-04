package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Game;

public class GameTest {
	
	/* Comprobamos que los constructores funcionan correctamente */
	@Test
	public void ConstructTest() {
		Game game = new Game();
		assertEquals(10, game.getAttempts());
		assertTrue(game.getSecretNumber() > 0 && game.getSecretNumber() <= 100);
	}
	
	@Test
	public void ConstructTest2() {
		Game game = new Game(7);
		assertEquals(7, game.getAttempts());
		assertTrue(game.getSecretNumber() > 0 && game.getSecretNumber() <= 100);
	}
	
	@Test
	public void CheckNumberTest() {
		Game game = new Game();
		game.setSecretNumber(78);
		assertTrue(game.checkNumber(78));
	}
	
	@Test
	public void CheckAttemptsTest() {
		Game game = new Game(1);
		assertTrue(game.checkAttempts());
		
		game.subtractAttempt();
		assertFalse(game.checkAttempts());
	}

}
