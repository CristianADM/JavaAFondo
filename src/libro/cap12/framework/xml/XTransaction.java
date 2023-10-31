package libro.cap12.framework.xml;

import java.sql.Connection;

public class XTransaction {
	
	private Connection connection; 

	public void commit() {
		try {
			connection.commit();
			XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
			pool.releaseConnectionForTransaction(connection);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void rollBack() {
		try {
			connection.rollback();
			XConnectionPool pool = XFactory.getInstancia().getConnectionPool();
			
			pool.releaseConnectionForTransaction(connection);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
