package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Llibre {
	private String isbn;
	private String titol;
	private String autor;
	private String editorial;
	private int numCopies;
	private int numCopiesDisponibles;
	private static int numTitols=0;
	
	//Constructors
	public Llibre() {
		this(null,null,null,null,1,1);
	}
	
	public Llibre(Llibre llibre) {
		this(llibre.getIsbn(),llibre.getTitol(),llibre.getAutor(),llibre.getEditorial(),llibre.getNumCopies(),llibre.getNumCopiesDisponibles());
	}
	
	public Llibre(String isbn, String titol, String autor, String editorial, int numCopies, int numCopiesDisponibles) {
		this.isbn = new String();
		this.titol = new String();
		this.autor = new String();
		this.editorial = new String();
		
		this.setIsbn(isbn);
		this.setTitol(titol);
		this.setAutor(autor);
		this.setEditorial(editorial);
		this.setNumCopies(numCopies);
		this.setNumCopiesDisponibles(numCopiesDisponibles);
		numTitols=numTitols+1;
	}
	
	//Altres mètodes
	@Override
	public String toString() {
		return " ISBN: " + isbn + "\n Títol: " + titol + "\n Autor: " + autor + "\n Editorial: " + editorial
				+ "\n Còpies: " + numCopies + "\n Còpies Disponibles: " + numCopiesDisponibles + "\n\n";
	}
	
	public static void afegirLlibre(ArrayList<Llibre> llistaLlibres, Llibre llibre) {
		llistaLlibres.add(llibre);
	}
	
	public static void afegirLlibre(ArrayList<Llibre> llistaLlibres) {
		Scanner teclat = new Scanner (System.in);
		Llibre llibre = new Llibre();
		
		System.out.println("Introdueix el ISBN: ");
		llibre.setIsbn(teclat.nextLine());
		
		System.out.println("Introdueix el títol: ");
		llibre.setTitol(teclat.nextLine());
		
		System.out.println("Introdueix l'autor: ");
		llibre.setAutor(teclat.nextLine());
		
		System.out.println("Introdueix l'editorial: ");
		llibre.setEditorial(teclat.nextLine());
		
		System.out.println("Introdueix el número de còpies: ");
		llibre.setNumCopies(Integer.parseInt(teclat.nextLine()));
		
		System.out.println("Introdueix el número de còpies disponibles: ");
		llibre.setNumCopiesDisponibles(Integer.parseInt(teclat.nextLine()));
		
		llistaLlibres.add(llibre);
	}

	public static int cercarLlibreISBNaReserves(ArrayList<Reserva> llistaReserves) {
		Scanner teclat = new Scanner (System.in);
		String isbn;
		boolean trobat = false;
		int posicio = -1;
		
		System.out.println("Introdueix el ISBN a cercar: ");
		isbn=teclat.nextLine();
		
		int i = 0;
		while(!trobat && i<llistaReserves.size()) {
			if (llistaReserves.get(i).getLlibre().getIsbn().equals(isbn)) {
				trobat=true;
				posicio = i;
			}
			i=i+1;
		}
		if (trobat) {
			//System.out.println("S'ha trobat el llibre a la posició: "+posicio);
			//System.out.println(llistaLlibres.get(posicio).toString());
		}else {
			System.out.println("No s'ha trobat cap coincidència.");
		}
		
		return posicio;
	}
	
	
	public static int cercarLlibreISBN(ArrayList<Llibre> llistaLlibres) {
		Scanner teclat = new Scanner (System.in);
		String isbn;
		boolean trobat = false;
		int posicio = -1;
		
		System.out.println("Introdueix el ISBN a cercar: ");
		isbn=teclat.nextLine();
		
		int i = 0;
		while(!trobat && i<llistaLlibres.size()) {
			if (llistaLlibres.get(i).getIsbn().equals(isbn)) {
				trobat=true;
				posicio = i;
			}
			i=i+1;
		}
		if (trobat) {
			//System.out.println("S'ha trobat el llibre a la posició: "+posicio);
			//System.out.println(llistaLlibres.get(posicio).toString());
		}else {
			System.out.println("No s'ha trobat cap coincidència.");
		}
		
		return posicio;
	}
	
	public static void cercarLlibreTitol(ArrayList<Llibre> llistaLlibres) {
		Scanner teclat = new Scanner(System.in);
		String titol = new String();
		
		System.out.println("Introdueix un títol a cercar: ");
		titol = teclat.nextLine();
		
		boolean trobat = false;
		for (int i=0; i<llistaLlibres.size();i++) {
			if (llistaLlibres.get(i).getTitol().contains(titol)) {
				trobat=true;
				System.out.println(llistaLlibres.get(i).toString());
			}
		}
		
		if(!trobat) {
			System.out.println("No s'ha trobat cap coincidencia.");
		}	
	}
	
	public static void eliminarLlibre(ArrayList<Llibre> llistaLlibres, ArrayList<Reserva> llistaReservas) {
		Scanner teclat = new Scanner(System.in);
		int posicio = cercarLlibreISBN(llistaLlibres);
		
		
		if (posicio>=0) {
			boolean reserva = Reserva.llibreTeReserva(llistaReservas, llistaLlibres.get(posicio));
			if (!reserva) {
				System.out.println("Segur que el vols eliminar? (s/n)");
				String resposta;
				resposta=teclat.nextLine();
				if (resposta.equals("s")) {
					llistaLlibres.remove(posicio);
					System.out.println("El llibre ha estat eliminat");
				}
				
			}else {
				System.out.println("El llibre no s'ha pogut eliminar perque té una reserva.");
			}
		}
	}
	
	//Setters i Getters
	public String getIsbn() {return isbn;}
	public void setIsbn(String isbn) {this.isbn = isbn;}
	public String getTitol() {return titol;}
	public void setTitol(String titol) {this.titol = titol;}
	public String getAutor() {return autor;}
	public void setAutor(String autor) {this.autor = autor;}
	public String getEditorial() {return editorial;}
	public void setEditorial(String editorial) {this.editorial = editorial;}
	public int getNumCopies() {return numCopies;}
	public void setNumCopies(int numCopies) {this.numCopies = numCopies;}
	public int getNumCopiesDisponibles() {return numCopiesDisponibles;}
	public void setNumCopiesDisponibles(int numCopiesDisponibles) {this.numCopiesDisponibles = numCopiesDisponibles;}
	public static int getNumTitols() {return numTitols;}
	protected static void setNumTitols(int numTitols) {Llibre.numTitols = numTitols;}

	
	
	
	
}