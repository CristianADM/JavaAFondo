package libro.cap10.mapping;

import java.util.Enumeration;
import java.util.Hashtable;

public class JDBCTag {
	
	private Hashtable<String, ConnectionTag> connection;
	
	public JDBCTag() {
		this.connection = new Hashtable<String, ConnectionTag>();
	}
	
	public ConnectionTag getConnectionTag(String name) {
		return this.connection.get(name);
	}
	
	public void addConnectionTag(ConnectionTag c) {
		this.connection.put(c.getName(), c);
	}
	
	public String toString() {
		String x = "";
		
		ConnectionTag aux;
		Enumeration<String> e = this.connection.keys();
		
		while(e.hasMoreElements()) {
			aux = this.connection.get(e.nextElement());
			x = x + aux.toString() + "\n";
		}
		
		return x;
	}

}
