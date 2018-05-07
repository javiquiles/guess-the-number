package main;

public class Game {
	
	private int min;
	private int max;
	private int counter;
	private int attempts;
	private int secretNumber;	
	
	/* Constructors */
	public Game() {
		this(10); //Por defecto damos 10 intentos.
	}
	
	public Game(int attempts) {
		min = 1;
		max = 100;
		counter = 1;
		this.attempts = attempts;
		secretNumber = (int) (Math.random() * max) + min; //Generamos un nro. del 1 al 100.
	}

	/* Getters and Setters */
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getSecretNumber() {
		return secretNumber;
	}

	public void setSecretNumber(int secretNumber) {
		this.secretNumber = secretNumber;
	}

	/* Functions */
	public boolean checkNumber(int n) {
		if (n == secretNumber)
			return true;
		
		return false;
	}
	
	public boolean checkNumber(char c) {
		if (c == '=')
			return true;
		
		return false;
	}
	
	public boolean checkAttempts() { //Comprobamos si quedan intentos.
		if (attempts > 0) 
			return true;
		
		return false;
	}
	
	public void guess() {
		secretNumber = (int) (Math.random() * (max - min + 1)) + min; //Generamos un nro. del min al max.
	}
	
	public void subtractAttempt() { //Restamos un intento.
		attempts--;
		counter++;
	}
	
	public void addAttempt() { //Sumamos un intento.
		attempts++;
		counter--;
	}

}
