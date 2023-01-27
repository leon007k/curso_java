package temasvistos;

import java.util.Scanner;

public class doWhile {
	public int response = 0;
	
	public void selectCinema() {
		// Arreglo de cines
		String[] cine = {"cinepolis","cinemex","cinebox"};
		
		do {
			//Mostramos opciones de cinemas
			System.out.println("Selecciona el numero de la opcion deseada");
			/* Recorremos el array para obtener el nombre de los cines
			* realizamos una suma para darle formato y
			* que no se duplique el valor 0 ejem:
			* 1. cinepolis
			*/
			for(int i = 0; i < cine.length; i++) {
				System.out.println((i+1) + ". " + cine[i]);
			}
			System.out.println("0. Salir");
			
			//Obtenemos opcion elegida
			Scanner sc = new Scanner(System.in); 
			response = Integer.valueOf(sc.nextLine());
			
			switch(response) {
				case 0:
					System.out.println("Gracias por visitarnos");
				break;
				case 1:
				case 2:
				case 3:
					/*obtenemos el nombre del cine.
					 * Realizamos una resta para obtener el nombre correct ejem:
					 * cinepolis tiene la posicion 0 --> cine[0] = cinepolis
					 * por lo tanto hacemos lo siguiente
					 * response=1
					 * cine[1-1] --> cine[0] = cinepolis
					 * */
					System.out.println("Bienvenido a " + cine[response - 1]);
				break;
				default:
					System.out.println("Selecciona una opcion correcta");
			}
			
		}while(response != 0);
		
		System.out.println("Hemos terminado");
	}
}
