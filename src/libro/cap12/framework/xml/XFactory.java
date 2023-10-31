package libro.cap12.framework.xml;

import java.util.Hashtable;

public class XFactory {

	private static XFactory instancia;
	private Hashtable<String, Object> beans = null;
	
	private XSession session;
	private XConnectionPool connectionPool;
	
	private XFactory() {
		beans = new Hashtable<String, Object>();
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
	
	public Object getBean(String bname) {
		Object o = beans.get(bname);
		if(o == null) {
			o = _instanciarBean(bname);
			beans.put(bname, o);
		}
		return o;
	}
	
	private Object _instanciarBean(String bname) {
		try {
			String path = "/framework/bean-access/bean";
			String attName = "name";
			
			XTag t = XMLFactory.getbyAttribute(path, attName, attName);
			
			String sClazz = t.getAtts().get("type");
			return Class.forName(sClazz).getDeclaredConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
