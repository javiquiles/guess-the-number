package main;

public class Game {
	
	private int secretNumber;
	private int attempts;	
	
	/* Constructors */
	public Game() {
		secretNumber = (int) (Math.random() * 100) + 1; //Generamos un nro. del 1 al 100.
		attempts = 10;
	}
	
	public Game(int attempts) {
		secretNumber = (int) (Math.random() * 100) + 1; //Generamos un nro. del 1 al 100.
		this.attempts = attempts;
	}

	/* Getters and Setters */
	public int getSecretNumber() {
		return secretNumber;
	}

	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	
	/* Functions */
	public boolean checkNumber(int n) {
		if (n == secretNumber)
			return true;
		
		return false;
	}
	
	public boolean checkAttempts() {
		if (attempts > 0) 
			return true;
		
		return false;
	}
	
	public void subtractAttempt() {
		attempts--;
	}

}
