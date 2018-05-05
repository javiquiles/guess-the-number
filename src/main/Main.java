package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game(7);
		Scanner sc = new Scanner(System.in);
		
		int counter = 1;
		
		System.out.println("Bienvenido al juego de Adivinar el Número");
		System.out.println("=========================================");
		System.out.println("Por favor, elige una opción: ");
		System.out.println("1) Adivina el número que yo pienso.");
		System.out.println("2) Te adivino el número que estás pensando.");		
		int option = sc.nextInt();
		
		if (option == 1) {
			int num = 0;
			
			System.out.println("He pensado un número del 1 al 100");
			System.out.println("Tenes solo " + game.getAttempts() + " intentos para adivinarlo");
			num = sc.nextInt();
			
			while (!game.checkNumber(num) && game.checkAttempts()) {
				game.subtractAttempt();
				counter++;
				
				if (!game.checkAttempts()) //Para no mostrar los mensajes en el último intento.
					break;
				
				if (num > game.getSecretNumber()) {
					System.out.println("Incorrecto, el número que pienso es Menor");
				}
				else {
					System.out.println("Incorrecto, el número que pienso es Mayor");
				}
					
				System.out.println("Te quedan " + game.getAttempts() + " intentos");
				num = sc.nextInt();
			}
			
			if (game.checkNumber(num)) {
				System.out.println("Felicidades, lo has adivinado en " + counter + " intentos");
			}
			else {
				System.out.println("Has perdido, el número era " + game.getSecretNumber());
			}			
		}
		else if (option == 2) {
			char help = ' ';
			
			System.out.println("Piensa un número del 1 al 100");
			System.out.println("Tengo solo " + game.getAttempts() + " intentos para adivinarlo");
			System.out.println("Indica '+' si es mayor, '-' si es menor o '=' si adiviné");
			System.out.println("¿El número que pensaste es " + game.getSecretNumber() + "?");
			help = sc.next().charAt(0);
			
			while (!game.checkNumber(help) && game.checkAttempts()) {				
				game.subtractAttempt();
				counter++;
				
				if (help == '+') {
					game.setMin(game.getSecretNumber() + 1);
				}
				else if (help == '-') {
					game.setMax(game.getSecretNumber() - 1);
				}
				else {
					System.out.println("Error, introduce solo '-', '+' o '='");
					game.addAttempt();
					counter--;
				}
				
				game.guess();
					
				if (game.checkAttempts()) { //Para no mostrar el mensaje en el último intento.
					System.out.println("Me quedan " + game.getAttempts() + " intentos");
					System.out.println("¿El número que pensaste es " + game.getSecretNumber() + "?");
					help = sc.next().charAt(0);
				}
			}
			
			if (game.checkNumber(help)) {
				System.out.println("Genial, lo he adivinado en " + counter + " intentos");
			}
			else {
				System.out.println("He perdido, tu número estaba entre " + game.getMin() + " y " + game.getMax());
			}
		}
		
		sc.close();
	}

}
