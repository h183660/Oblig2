package no.hvl.dat102.oppgave2;

public class Hobby {
	private String hobbyNavn;

	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}

	public void setHobbyNavn(String hobby) {
		hobbyNavn = hobby;
	}

	public String getHobbyNavn() {
		return hobbyNavn;
	}

	public String toString() {
		// … returnerer hobbynavnet med ”<” foran og ”>” bak som
		// String (Eksempel: <tegne, male>)
		// Bmrk: Kan også ha uten parenteser, men forsøk med parenteser.

		return "<" + hobbyNavn + ">";
	}

	public boolean equals(Object hobby2) {
		// evntuelt fylle ut først med "standard" kode
		// som vi ofte har med overkjøring av
		// equals-metoden
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}// end Hobby