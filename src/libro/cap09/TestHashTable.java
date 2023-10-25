package libro.cap09;

import java.util.Enumeration;
import java.util.Hashtable;

public class TestHashTable {

	public static void main(String[] args) {
		//instanciamos varias personas
		Persona p1 = new Persona("Cristian", 25, "Colombiano");
		Persona p2 = new Persona("Logan", 14, "Norte Americano");
		Persona p3 = new Persona("Meghan", 5, "Inglesa");
		
		//creamos la tabla hash
		Hashtable<String, Persona> tabla = new Hashtable<String, Persona>();
		
		//agregamos las personas a la tabla
		tabla.put(p1.getNombre(), p1);
		tabla.put(p2.getNombre(), p2);
		tabla.put(p3.getNombre(), p3);
		
		//accedemos a cada elemento de la tabla por su nombre
		System.out.println(tabla.get("Cristian"));
		System.out.println(tabla.get("Logan"));
		System.out.println(tabla.get("Meghan"));
		
		//retorna null si no encuentra una clave asociada
		System.out.println(tabla.get("Patricio"));
		
		//Obtenemos una enumeracion de la tabla para poder recorrerla y mostrar la clave valor
		String aux;
		Enumeration<String> keys = tabla.keys();
		
		while(keys.hasMoreElements()) {
			aux = keys.nextElement();
			System.out.println(aux + " = " + tabla.get(aux));
		}
	}
}
