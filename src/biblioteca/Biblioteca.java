package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private String nom;
	private ArrayList<Llibre> llistaLlibres;
	private ArrayList<Persona> llistaAdmins;
	private ArrayList<Persona> llistaUsuaris;
	private ArrayList<Reserva> llistaReserva;
	
	//Constructors
	public Biblioteca(String nom, ArrayList<Llibre> llistaLlibres, ArrayList<Persona> llistaAdmins, ArrayList<Persona> llistaUsuaris, ArrayList<Reserva> llistaReserva) {
		this.nom = new String();
		this.llistaLlibres = new ArrayList<Llibre>();
		this.llistaAdmins = new ArrayList<Persona>();
		this.llistaUsuaris = new ArrayList<Persona>();
		this.llistaReserva = new ArrayList<Reserva>();
		
		this.setNom(nom);
		if (llistaLlibres!=null) {
			this.setLlistaLlibres(llistaLlibres);
		}
		if (llistaAdmins!=null) {
			this.setLlistaAdmins(llistaAdmins);
		}
		if (llistaUsuaris!=null) {
			this.setLlistaUsuaris(llistaUsuaris);
		}
		if (llistaReserva!=null) {
			this.setLlistaReserva(llistaReserva);
		}
	}
	
	public Biblioteca (){
		this("Sense nom",null,null,null,null);
	}
	
	public Biblioteca(Biblioteca biblioteca) {
		this(biblioteca.getNom(),biblioteca.llistaLlibres,biblioteca.getLlistaAdmins(),biblioteca.getLlistaUsuaris(),biblioteca.getLlistaReserva());
	}
	
	//Altres mètodes
	@Override
	public String toString() {
		return "Biblioteca [nom=" + nom + ", llistaLlibres=" + llistaLlibres + ", llistaAdmins=" + llistaAdmins + "]";
	}
	
	public void mostrarLlibres() {
		for (int i=0; i<llistaLlibres.size();i=i+1) {
			System.out.println(llistaLlibres.get(i).toString());
		}	
	}
	
	public void mostrarLlibresDisponibles() {
		for (int i=0; i<llistaLlibres.size();i=i+1) {
			if(llistaLlibres.get(i).getNumCopiesDisponibles()>0) {
				System.out.println(llistaLlibres.get(i).toString());
			}	
		}	
	}
	
	public void mostrarReserves() {
		for (int i=0; i<llistaReserva.size();i=i+1) {
				System.out.println(llistaReserva.get(i).toString());
		}	
	}
	
	//Setters i getters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		Scanner teclat = new Scanner (System.in);
		while(Character.isLowerCase(nom.charAt(0))) {
			System.out.println("Introdueix un nom amb la primera lletra majuscula: ");
			nom=teclat.nextLine();		
		}
		this.nom = nom;
	}
	public ArrayList<Llibre> getLlistaLlibres() {
		return llistaLlibres;
	}
	public void setLlistaLlibres(ArrayList<Llibre> llistaLlibres) {
		this.llistaLlibres = llistaLlibres;
	}
	public ArrayList<Persona> getLlistaAdmins() {
		return llistaAdmins;
	}
	public void setLlistaAdmins(ArrayList<Persona> llistaAdmins) {
		this.llistaAdmins = llistaAdmins;
	}

	public ArrayList<Persona> getLlistaUsuaris() {
		return llistaUsuaris;
	}

	public void setLlistaUsuaris(ArrayList<Persona> llistaUsuaris) {
		this.llistaUsuaris = llistaUsuaris;
	}

	public ArrayList<Reserva> getLlistaReserva() {
		return llistaReserva;
	}

	public void setLlistaReserva(ArrayList<Reserva> llistaReserva) {
		this.llistaReserva = llistaReserva;
	}
	
	
}