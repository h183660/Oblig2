package no.hvl.dat102.oppgave2;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Medlem {
	private String navn;
	private MengdeADT<Hobby> hobbyer;
	private int statusIndeks;

	// Konstruktør
	public Medlem() {
		this.navn = "";
		this.hobbyer = new KjedetMengde<Hobby>();
		this.statusIndeks = -1;
	}
	
	public Medlem(String navn) {
		this.navn = navn;
		this.hobbyer = new KjedetMengde<Hobby>();
		this.statusIndeks = -1;
	}

	// Set og Get metoder
	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setStatusIndeks(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}

	public void leggTilHobby(String hobby) {
		Hobby hobbyen = new Hobby(hobby);
		hobbyer.leggTil(hobbyen);
	}

	public String slettHobby(Hobby hobby) {
		String fjernetHobby = hobby.toString();
		hobbyer.fjern(hobby);
		return "Hobbyen :" + fjernetHobby + "ble fjernet.";
	}

	public MengdeADT<Hobby> getHobbyer() {
		return hobbyer;
	}

	public String getNavn() {
		return navn;
	}

	public int getstatusIndeks() {
		return statusIndeks;
	}

//… Andre metoder
	public boolean passerTil(Medlem medlem2) {
		return this.hobbyer.equals(medlem2.getHobbyer());
	}
	public String toString() {
		//Returnerer en tekststreng med alle medlemsdataene.

		return "Navn: " + navn +
				" Hobbyer: " + hobbyer.toString() +
				" Statusindeks: " + statusIndeks;
	}
}//