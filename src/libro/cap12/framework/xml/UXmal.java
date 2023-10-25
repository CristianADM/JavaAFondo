package libro.cap12.framework.xml;

public class UXmal {

	public static XTag getTableTAG(String dtoName) {
		String path= "/framework/data-access/mapping/table";
		String attname = "type";
		String attvalue = dtoName;
		return  XMLFactory.getbyAttribute(path, attname, attvalue);
	}
}
