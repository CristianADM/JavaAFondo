package libro.cap09;

public class Cola<T> {

	Nodo<T> primero;
	Nodo<T> ultimo;
	
	public void encolar(T valor) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(valor);
		nuevo.setRef(null);
		
		if(primero == null) {
			primero = nuevo;
		} else {
			ultimo.setRef(nuevo);
		}
		
		ultimo = nuevo;
	}
	
	public Nodo<T> desencolar(){
		Nodo<T> ret = primero;
		
		if(primero != ultimo) {
			primero = primero.getRef();
		} else {
			primero = null;
			ultimo = null;
		}
		
		return ret;
	}
}
