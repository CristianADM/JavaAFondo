package libro.cap12.framework.xml;

import java.util.Hashtable;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import libro.cap09.Pila;

public class XMLFactory extends DefaultHandler {

	private static XMLFactory instancia = null;
	private Stack<XTag> pila;
	private XTag raiz;
	
	private XMLFactory() {
		pila = new Stack<XTag>();
	}
	
	public static void load(String xmlFileName) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			
			instancia = new XMLFactory();
			sp.parse(xmlFileName, instancia);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		
		//paso los atributos a una hashtable
		Hashtable<String, String> atts = _cloneAttributes(attributes);
		
		XTag t = new XTag(name, atts);
		if(pila.isEmpty()) {
			raiz = t;
		}
		
		pila.push(t);
	}
	
	public void endElement(String uri, String localName, String name) throws SAXException {
		if(pila.size() > 1) {
			XTag hijo = pila.pop();
			XTag padre = pila.pop();
			padre.addSubtag(hijo);
			pila.push(padre);
		}
	}
	
	private Hashtable<String, String> _cloneAttributes(Attributes attributes) {
		Hashtable<String, String> atts = new Hashtable<String, String>();
		for (int i = 0; i < attributes.getLength(); i++) {
			atts.put(attributes.getQName(i), attributes.getValue(i));
		}
		
		return atts;
	}
	
	public static XTag getByPath(String path) {
		return instancia.raiz.getSubtag(path);
	}
	
	public static XTag getbyAttribute(String path, String attname, String value) {
		return instancia.raiz.getSubtagByAttributes(path, attname, value);
	}
}
