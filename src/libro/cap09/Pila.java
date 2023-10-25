package libro.cap09;

public class Pila<T> {

	Nodo<T> p;
	
	public void apilar(T valor) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(valor);
		nuevo.setRef(p);
		p = nuevo;
	}
	
	public Nodo<T> desapilar() {
		Nodo<T> n = p;
		
		if(p != null) {
			p = p.getRef();
		}
		
		return n;
	}
}
