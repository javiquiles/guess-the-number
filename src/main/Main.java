package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Game game = new Game(7);
		Scanner sc = new Scanner(System.in);
		
		int counter = 0;
		
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
			
			while (!game.checkNumber(num) && game.checkAttempts()) {
				num = sc.nextInt();
				game.subtractAttempt();
				counter++;
				
				if (game.checkAttempts()) { //Para no mostrar los mensajes en el último intento.
					if (num > game.getSecretNumber()) {
						System.out.println("Incorrecto, el número que pienso es Menor");
					}
					else {
						System.out.println("Incorrecto, el número que pienso es Mayor");
					}
							
					System.out.println("Te quedan " + game.getAttempts() + " intentos");
				}
			}
			
			if (game.checkNumber(num)) {
				System.out.println("Felicidades, lo has adivinado en " + counter + " intentos");
			}
			else {
				System.out.println("Has perdido, el número era " + game.getSecretNumber());
			}			
		}
		
		sc.close();

	}

}
