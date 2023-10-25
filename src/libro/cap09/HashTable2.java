package libro.cap09;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;

public class HashTable2<T> {

	private Hashtable<String, LinkedList<T>> tabla;
	private Vector<String> claves;
	
	public HashTable2() {
		tabla = new Hashtable<String, LinkedList<T>>();
		claves = new Vector<String>();
	}
	
	public void put(String key, T elemento) {
		LinkedList<T> list = tabla.get(key);
		if(list == null) {
			list = new LinkedList<T>();
			tabla.put(key, list);
			claves.add(key);
		}
		
		list.addLast(elemento);
	}
	
	public LinkedList<T> get(String key){
		return tabla.get(key);
	}
	
	public Collection<String> keys(){
		return claves;
	}

}
