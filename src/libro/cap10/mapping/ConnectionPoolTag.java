package libro.cap10.mapping;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ConnectionPoolTag extends DefaultHandler {

	private JDBCTag jdbc;
	private PoolsTag pools;
	
	private static ConnectionPoolTag instancia = null;
	
	private ConnectionPoolTag() {
		this.jdbc = new JDBCTag();
		this.pools = new PoolsTag();
	}
	
	public String toString() {
		String x = "";
		x = x + "-- JDBC --\n";
		x = x + this.jdbc.toString();
		x = x + "-- POOLS --\n";
		x = x + this.pools.toString();
		
		return x;
	}

	public JDBCTag getJdbc() {
		return jdbc;
	}

	public void setJdbc(JDBCTag jdbc) {
		this.jdbc = jdbc;
	}

	public PoolsTag getPools() {
		return pools;
	}

	public void setPools(PoolsTag pools) {
		this.pools = pools;
	}

	public static ConnectionPoolTag getInstancia() {
		try {
			if(instancia == null) {
				SAXParserFactory spf = SAXParserFactory.newNSInstance();
				SAXParser sp = spf.newSAXParser();
				sp.parse("conection.xml", new ConnectionPoolTag());
			}
			
			return instancia;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if(qName.equals("conection-pool")) {
			instancia = new ConnectionPoolTag();
		}
		
		if(qName.equals("jdbc")) {
			this.jdbc = new JDBCTag();
			instancia.setJdbc(jdbc);
		}
		
		if(qName.equals("pools")) {
			this.pools = new PoolsTag();
			instancia.setPools(pools);
		}
		
		if(qName.equals("conection")) {
			ConnectionTag c = new ConnectionTag();
			c.setName(attributes.getValue("name"));
			c.setDriver(attributes.getValue("driver"));
			c.setUrl(attributes.getValue("url"));
			c.setUsuario(attributes.getValue("user"));
			c.setPassword(attributes.getValue("password"));
			jdbc.addConnectionTag(c);
		}
		
		if(qName.equals("pool")) {
			int min = Integer.parseInt(attributes.getValue("minsize"));
			int max = Integer.parseInt(attributes.getValue("maxsize"));
			int steep = Integer.parseInt(attributes.getValue("steep"));
			
			PoolTag c = new PoolTag();
			c.setName(attributes.getValue("name"));
			c.setMinsize(min);
			c.setMaxsize(max);
			c.setSteep(steep);
			pools.addPoolTag(c);
		}
	}
	
	public void endElement(String uri, String localName, String qName) {
		
	}
}
