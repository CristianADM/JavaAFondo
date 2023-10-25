package libro.cap12.framework.xml;

public class XFactory {

	private static XFactory instancia;
	
	private XSession session;
	private XConnectionPool connectionPool;
	
	private XFactory() {
		session = new XSession();
		connectionPool = new XConnectionPool();
	}
	
	public static XFactory getInstancia() {
		if(instancia == null) {
			instancia = new XFactory();
		}
		
		return instancia;
	}
	
	public static void load(String xmlfilename) {
		XMLFactory.load(xmlfilename);
	}
	
	public XConnectionPool getConnectionPool() {
		return connectionPool;
	}
	
	public XSession getSession() {
		return session;
	}
}
