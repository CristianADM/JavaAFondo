package libro.cap12.framework.xml;

import java.sql.ResultSet;

public class UXml {

	public static XTag getTableTag(String dtoName) {
		String path= "/framework/data-access/mapping/table";
		String attname = "type";
		String attvalue = dtoName;
		return  XMLFactory.getbyAttribute(path, attname, attvalue);
	}
	
	public static XTag[] getFieldsTag(String dtoName) {
		return getTableTag(dtoName).getSubtags("field");
	}
	
	public static XTag getConnectionPoolTag() {
		String path = "/framework/data-access/connection-pool";
		return XMLFactory.getByPath(path);
	}
}
