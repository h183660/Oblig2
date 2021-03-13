public class DobbelNode<T> {
	private T element;
	private DobbelNode<T> neste;
	private DobbelNode<T> forrige;

//Konstruktør og nødvendige get- og set-metoder
	public DobbelNode() {
		element = null;
		neste = null;
		forrige = null;
	}

	public DobbelNode(T element) {
		this.element = element;
		neste = null;
		forrige = null;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public void setNeste(DobbelNode<T> neste) {
		this.neste = neste;
	}

	public void setForrige(DobbelNode<T> forrige) {
		this.forrige = forrige;
	}

	public T getElement() {
		return element;
	}

	public DobbelNode<T> getNeste() {
		return neste;
	}

	public DobbelNode<T> getForrige() {
		return forrige;
	}

}// class