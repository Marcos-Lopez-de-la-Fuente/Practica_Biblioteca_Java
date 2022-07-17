package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Reserva {
	Persona persona;
	Llibre llibre;
	Estat estat;
	
	//Constructors
	public Reserva(Persona persona, Llibre llibre, Estat estat) {
		persona = new Persona();
		llibre = new Llibre();
		
		this.setPersona(persona);
		this.setLlibre(llibre);
		this.setEstat(estat);
	}
	
	public Reserva () {
		this(null,null,null);
	}
	
	//Altres mètodes
	@Override
	public String toString() {
		return "-----\n" +
			   "USUARI:\n " + 
				persona + 
				"\nLLIBRE:\n" + llibre + "ESTAT:\n " + estat +"\n";
	}
	
	public static void afegirReserva(ArrayList<Reserva> llistaReserves, ArrayList<Llibre> llistaLlibres, ArrayList<Persona> llistaUsuaris) {
		Reserva reserva = new Reserva();
		int posPersona = Persona.cercarPersonaDNI(llistaUsuaris);
		
		if (posPersona>-1) {
			int quantitatReserves = 0;			
			for (int i=0;i<llistaReserves.size();i++) {
				if (llistaReserves.get(i).getPersona().getDni().equals(llistaUsuaris.get(posPersona).getDni())) {
					quantitatReserves++;
				}
			}
			if (quantitatReserves<=5) {
				reserva.setPersona(llistaUsuaris.get(posPersona));
				
				int posLlibre = Llibre.cercarLlibreISBN(llistaLlibres);
				if (posLlibre>-1) {
					if (llistaLlibres.get(posLlibre).getNumCopiesDisponibles()>0) {
						reserva.setLlibre(llistaLlibres.get(posLlibre));
						reserva.setEstat(Estat.Vigent);
						llistaReserves.add(reserva);
						llistaLlibres.get(posLlibre).setNumCopiesDisponibles(llistaLlibres.get(posLlibre).getNumCopiesDisponibles()-1);
						System.out.println("Reserva realitzada correctament");
					}else {
						System.out.println("El llibre no té còpies disponibles");
					}
					
				}
			}else {
				System.out.println("Reserva no realitzada. L'usuari ja ha arribat al màxim de 5 reserves");
			}
			}
	}
	
	public static boolean llibreTeReserva(ArrayList<Reserva> llistaReserves, Llibre llibre) {
		boolean reserva=false;
		int i=0;
		while(!reserva && i<llistaReserves.size()){
			if(llistaReserves.get(i).getLlibre().getIsbn().equals(llibre.getIsbn())) {
				reserva=true;
			}
			i=i+1;
		}
		
		return reserva;
	}
	
	public static void eliminarReserva(ArrayList<Reserva> llistaReserves) {
		Scanner teclat = new Scanner (System.in);
		System.out.println("Introdueix el DNI de l'usuari: ");
		String dni = teclat.nextLine();
		System.out.println("Introdueix el ISBN del llibre: ");
		String isbn = teclat.nextLine();
		
		int i=0;
		boolean trobat=false;
		while(!trobat && i<llistaReserves.size()) {
			if (llistaReserves.get(i).getPersona().getDni().equals(dni) && llistaReserves.get(i).getLlibre().getIsbn().equals(isbn)) {
				trobat=true;
				System.out.println("Reserva eliminada");
				llistaReserves.get(i).getLlibre().setNumCopiesDisponibles(llistaReserves.get(i).getLlibre().getNumCopiesDisponibles()+1);
				llistaReserves.remove(i);
			}
		}
		if (!trobat) {
			System.out.println("No s'ha trobat cap coincidencia.");
		}
	}
	
	//Setters i getters
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Llibre getLlibre() {
		return llibre;
	}
	public void setLlibre(Llibre llibre) {
		this.llibre = llibre;
	}
	public Estat getEstat() {
		return estat;
	}
	public void setEstat(Estat estat) {
		this.estat = estat;
	}	
}