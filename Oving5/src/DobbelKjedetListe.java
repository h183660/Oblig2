// Ny, spesiell ordnet liste med dobbelkjeding
public class DobbelKjedetListe<T extends Comparable<T>> {
	private DobbelNode<T> foerste;
	private DobbelNode<T> siste;
	private int antall;

	public DobbelKjedetListe(T minVerdi, T maksVerdi) {
		foerste = new DobbelNode<T>(minVerdi);
		siste = new DobbelNode<T>(maksVerdi);
		antall = 0;

		foerste.setNeste(siste);
		siste.setForrige(foerste);
	}

	public void leggTil(T ny) {
		DobbelNode<T> nyNode = new DobbelNode<T>(ny);
		DobbelNode<T> node = foerste;

		while (node != null) {
			if (node.getElement().compareTo(ny) >= 0) {
				nyNode.setNeste(node);
				nyNode.setForrige(node.getForrige());
				node.getForrige().setNeste(nyNode);
				node.setForrige(nyNode);
				antall++;
				break;
			}
			node = node.getNeste();
		}
	}

	public T fjern(T x) {

		DobbelNode<T> node = foerste;
		T resultat = null;
		while (node != null) {
			if (x == node.getElement()) {
				resultat = node.getElement();
				node.getForrige().setNeste(node.getNeste());
				node.getNeste().setForrige(node.getForrige());
				antall--;
				return resultat;
			}
			node = node.getNeste();
		}
		return resultat;
	}

	public boolean fins(T x) {
		DobbelNode<T> node = foerste;

		while (node != null) {
			if (x == node.getElement()) {
				return true;
			}
			node = node.getNeste();
		}
		return false;
	}

	public void visListe() {
		DobbelNode<T> node = foerste;

		if (antall == 0) {
			System.out.println("Listen er tom.");
		} else {
			while (node != null) {
				System.out.println(node.getElement());
				node = node.getNeste();
			}
		}
	}

}// class