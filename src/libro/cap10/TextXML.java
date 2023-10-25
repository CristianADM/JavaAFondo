package libro.cap10;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TextXML {

	public static void main(String[] args) {
		try {
			//obtenemos el parser
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			
			//parseamos el archivo depts.xml
			sp.parse("conection.xml", new CPoolXMLHandler());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
