package libro.cap09;

public class ListaEnlazada<T> {

	//referencia al primer nodo de la lista
	private Nodo<T> p = null;
	
	public void agregarAlFinal(T valor) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(valor);
		nuevo.setRef(null);
		
		if(this.p == null) {
			this.p = nuevo;
			return;
		}
		
		Nodo<T> aux = p;
		
		while(aux.getRef() != null) {
			aux = aux.getRef();
		}
		
		aux.setRef(nuevo);
	}
	
	public void agregarAlPrincipio(T valor) {
		Nodo<T> nuevo = new Nodo<T>();
		nuevo.setInfo(valor);
		nuevo.setRef(this.p);
		this.p = nuevo;
	}
	
	public Nodo<T> buscar(T valor) {
		Nodo<T> aux = p;
		while((aux != null) && (!aux.getInfo().equals(valor)) ) {
			aux = aux.getRef(); 
		}
		return aux;
	}
	
	public Nodo<T> eliminar(T valor) {
		Nodo<T> actual = p;
		Nodo<T> anterior = null;
		
		while((actual != null) && (!actual.getInfo().equals(valor)) ) {
			anterior = actual;
			actual = actual.getRef(); 
		}
		
		//lo encuentro al principio
		if((actual != null) && (anterior == null)){
			Nodo<T> retornar = actual;
			p = actual.getRef();
			return retornar;
		}
		
		//lo encontramos por el medio
		if((actual != null) && (anterior != null)){
			Nodo<T> retornar = actual;
			anterior.setRef(actual.getRef());
			return retornar;
		}
		
		return null;
	}
	
	public String toString() {
		String x = "";
		
		Nodo<T> aux = p;
		while(aux!=null) {
			x = x + "" + aux.getInfo() + (aux.getRef() != null ? ", " : "");
			aux = aux.getRef();
		}
		
		return x;
	}
}
