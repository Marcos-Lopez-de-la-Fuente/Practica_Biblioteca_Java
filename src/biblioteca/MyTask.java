package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MyTask {
	
	public static void liniesBlanc(int salts) {
		for (int i=0;i<salts;i++) {
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		Scanner teclat = new Scanner(System.in);
		
		//////////////////////////////////////////////////
		Llibre llibre1 = new Llibre ("1234","Harry Potter","JK Rowling","Percebe",10,10);
		Llibre llibre2 = new Llibre ("2345","El señor de los anillos","Tolkien","Anchoa",1,1);
		Llibre llibre3 = new Llibre ("3456","Cincuenta sombras de grey", "Manolo","Teclat",3,3);
		Llibre llibre4 = new Llibre ("4567","El corredor del Laberinto","Maria","Ratoli",2,2);
		Persona usuari1 = new Persona ("Miquel","Taberner","1X","12345678");
		Persona usuari2 = new Persona ("Marti","Taberner","2X","12345678");
		Persona usuari3 = new Persona ("Toni","Taberner","3X","12345678");
		Persona usuari4 = new Persona ("Tomeu","Taberner","4X","12345678");
		//////////////////////////////////////////////////
		
		Biblioteca biblioteca = new Biblioteca("Francesc de Borja Moll",null,null,null,null);
		
		//////////////////////////////////////////////////
		Llibre.afegirLlibre(biblioteca.getLlistaLlibres(), llibre1);
		Llibre.afegirLlibre(biblioteca.getLlistaLlibres(), llibre2);
		Llibre.afegirLlibre(biblioteca.getLlistaLlibres(), llibre3);
		Llibre.afegirLlibre(biblioteca.getLlistaLlibres(), llibre4);
		//////////////////////////////////////////////////
		Persona.afegirPersona(biblioteca.getLlistaUsuaris(), usuari1);
		Persona.afegirPersona(biblioteca.getLlistaUsuaris(), usuari2);
		Persona.afegirPersona(biblioteca.getLlistaUsuaris(), usuari3);
		Persona.afegirPersona(biblioteca.getLlistaUsuaris(), usuari4);
		
		
		//////////////////////////////////////////////////
		
		boolean exit = false;
		while (!exit) {
			liniesBlanc(10);
			System.out.println("Benvingut a la Biblioteca "+biblioteca.getNom());
			liniesBlanc(1);
			System.out.println("1. Gestió de Llibres");
			System.out.println("2. Gestió de Reserves");
			System.out.println("3. Gestió d'Usuaris");
			System.out.println("4. Gestió d'Administradors");
			System.out.println("5. Sortir del programa");
			
			String opcio;
			opcio=teclat.nextLine();
			
			boolean enrere=false;
			while(!enrere) {
				switch(opcio) {
				case "1":
					liniesBlanc(10);
					System.out.println("Menu");
					System.out.println(" >Gestió de Llibres");
					System.out.println("1. Veure llista de Llibres");
					System.out.println("2. Veure llista de Llibres Disponibles");
					System.out.println("3. Afegir un llibre");
					System.out.println("4. Eliminar un llibre");
					System.out.println("5. Enrere");
					System.out.println("6. Sortir del programa");
					
					String opcio2;
					opcio2=teclat.nextLine();
					liniesBlanc(10);
					
					switch(opcio2) {
					case "1":
						System.out.println("Llista de Llibres de la Biblioteca "+biblioteca.getNom());
						liniesBlanc(1);
						biblioteca.mostrarLlibres();
						System.out.println("Total llibres: "+biblioteca.getLlistaLlibres().size());
						liniesBlanc(1);
						System.out.println("Polsa enter per continuar");
						teclat.nextLine();
						break;
						
					case "2":
						System.out.println("Llista de Llibres Disponibles de la Biblioteca "+biblioteca.getNom());
						liniesBlanc(1);
						biblioteca.mostrarLlibresDisponibles();

						break;
					
					case "3":
						Llibre.afegirLlibre(biblioteca.getLlistaLlibres());
						break;
						
					case "4":
						System.out.println("Introdueix les dades del Llibre a eliminar:");
						Llibre.eliminarLlibre(biblioteca.getLlistaLlibres(), biblioteca.getLlistaReserva());
						System.out.println("Polsa enter per continuar");
						teclat.nextLine();
						break;
						
					case "5":
						enrere=true;
						break;
					case "6":
						enrere=true;
						exit=true;
						break;
					}
					break;
				case "2":
					liniesBlanc(10);
					System.out.println("Menu");
					System.out.println(" >Gestió de Reserves");
					System.out.println("1. Veure llista de Reserves");
					System.out.println("2. Afegir una Reserva");
					System.out.println("3. Eliminar una Reserva");
					System.out.println("4. Enrere");
					System.out.println("5. Sortir del programa");
					
					String opcio3;
					opcio3=teclat.nextLine();
					liniesBlanc(10);
					
					switch(opcio3) {
					case "1":
						System.out.println("Llista de Reserves de la Biblioteca "+biblioteca.getNom());
						liniesBlanc(1);
						biblioteca.mostrarReserves();
						System.out.println("Total Reserves: "+biblioteca.getLlistaReserva().size());
						liniesBlanc(1);
						System.out.println("Polsa enter per continuar");
						teclat.nextLine();
						break;
						
					case "2":
						System.out.println("Realitzar una reserva de la Biblioteca "+biblioteca.getNom());
						liniesBlanc(1);
						Reserva.afegirReserva(biblioteca.getLlistaReserva(), biblioteca.getLlistaLlibres(), biblioteca.getLlistaUsuaris());
						liniesBlanc(1);
						System.out.println("Polsa enter per continuar");
						teclat.nextLine();
						break;
					
					case "3":
						System.out.println("Introdueix les dades de la Reserva a eliminar:");
						Reserva.eliminarReserva(biblioteca.getLlistaReserva());
						System.out.println("Polsa enter per continuar");
						teclat.nextLine();
						break;
						
					case "4":
						enrere=true;
						break;
						
					case "5":
						enrere=true;
						exit=true;
						break;
						
					}
					break;
				}
			}
			enrere=false;
		}		
	}
}