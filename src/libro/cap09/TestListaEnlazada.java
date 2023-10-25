package libro.cap09;

public class TestListaEnlazada {

	public static void main(String[] args) {
		//instancio una lista enlazada
		ListaEnlazada<Integer> x = new ListaEnlazada<Integer>();
		
		//agrego elementos
		x.agregarAlFinal(4);
		x.agregarAlFinal(5);
		x.agregarAlFinal(6);
		x.agregarAlFinal(7);
		
		x.agregarAlPrincipio(3);
		x.agregarAlPrincipio(2);
		x.agregarAlPrincipio(1);
		
		//muestro el contenido
		System.out.println(x.toString());
		
		//verificamos si existe un nodo con el valor 6
		System.out.println(x.buscar(6).getInfo());
		
		//verifico si existe un nodo con el valor 15
		System.out.println(x.buscar(15) == null ? "Es null": "Se encontro el valor 15");
		
		//eliminamos al nodo con el valor 3
		System.out.println(x.eliminar(3).getInfo());
		
		//vuelvo a mostrar la lista
		System.out.println(x.toString());
	}
}
