package libro.cap10.mapping;

import java.util.Enumeration;
import java.util.Hashtable;

public class PoolsTag {
	
	private Hashtable<String, PoolTag> pool;
	
	public PoolsTag() {
		this.pool = new Hashtable<String, PoolTag>();
	}
	
	public PoolTag getPoolTag(String name) {
		return this.pool.get(name);
	}
	
	public void addPoolTag(PoolTag c) {
		this.pool.put(c.getName(), c);
	}
	
	public String toString() {
		String x = "";
		
		PoolTag aux;
		Enumeration<String> e = this.pool.keys();
		
		while(e.hasMoreElements()) {
			aux = this.pool.get(e.nextElement());
			x = x + aux.toString() + "\n";
		}
		
		return x;
	}

}
