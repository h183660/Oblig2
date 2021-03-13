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
		// � returnerer hobbynavnet med �<� foran og �>� bak som
		// String (Eksempel: <tegne, male>)
		// Bmrk: Kan ogs� ha uten parenteser, men fors�k med parenteser.

		return "<" + hobbyNavn + ">";
	}

	public boolean equals(Object hobby2) {
		// evntuelt fylle ut f�rst med "standard" kode
		// som vi ofte har med overkj�ring av
		// equals-metoden
		Hobby hobbyDenAndre = (Hobby) hobby2;
		return (hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
}// end Hobby