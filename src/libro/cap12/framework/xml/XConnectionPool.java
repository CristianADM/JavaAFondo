package libro.cap12.framework.xml;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;

public class XConnectionPool {

	private Vector<Connection> libres;
	private Vector<Connection> usadas;
	private Hashtable<Long, Connection> enTransaccion;
	
	public Connection getConnectionForTransaction() {
		Connection con = getConnection();
		long threadId = Thread.currentThread().getId();
		enTransaccion.put(threadId, con);
		return con;
	}
	
	public synchronized Connection getConnection() {
		//verifico si hay una transaccion abierta
		long threadId = Thread.currentThread().getId();
		Connection con = enTransaccion.get(threadId);
		
		if(con != null) {
			return con;
		}
		
		if(libres.size() <= 0) {
			if(!_crearMasConexiones()) {
				throw new RuntimeException("No hay mas conexiones...");
			}
		}
		
		con = libres.remove(0);
		usadas.add(con);
		return con;
	}
	
	public void releaseConnectionForTransaction(Connection con) {
		long threadId = Thread.currentThread().getId();
		enTransaccion.remove(threadId);
		releaseConnection(con);
	}
	
	public synchronized void releaseConnection(Connection con) {
		
		if(con != null) {
			usadas.remove(con);
			libres.add(con);
		}
	}
	
	private Boolean _crearMasConexiones() {
		
	}
}
