package libro.cap12.framework.xml;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UBean {

	public static void invoqueSetter(Object dto, String attName, Object value) {
		try {
			//dado el attName obetengo el nombre del setter
			String mtdName = getSetterName(attName);
			
			Class[] argsType = null;
			Method mtd = null;
			
			try {
				//intento obtener el metodo...
				argsType[0] = value.getClass();
				mtd = dto.getClass().getMethod(mtdName, argsType);
				
			} catch (NoSuchMethodException e) {
				//fallo... pruebo con el tipo primitivo
				argsType[0] = _wraperToType(value.getClass());
				mtd = dto.getClass().getMethod(mtdName, argsType);
			}
			
			//invoco al setter
			mtd.invoke(dto, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static Object invoqueGetter(Object dto, String att) {
		try {
			//dado el att obetengo el nombre del getter
			String mtdName = getGetterName(att);
			Class[] parameterTypes = new Class[0];
			Method mtd = dto.getClass().getMethod(mtdName, parameterTypes);
			
			Object[] parameterValues = new Object[0];
			return mtd.invoke(dto, parameterValues);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private static Class _wraperToType(Class clazz) {
		if(clazz.equals(Byte.class)) {
			return Byte.TYPE;
		}
		if(clazz.equals(Short.class)) {
			return Short.TYPE;
		}
		if(clazz.equals(Integer.class)) {
			return Integer.TYPE;
		}
		if(clazz.equals(Long.class)) {
			return Long.TYPE;
		}
		if(clazz.equals(Character.class)) {
			return Character.TYPE;
		}
		if(clazz.equals(Float.class)) {
			return Float.TYPE;
		}
		if(clazz.equals(Double.class)) {
			return Double.TYPE;
		}
		
		return clazz;
	}
	
	public static String getSetterName(String attName) {
		return UString.switchCase("set"+ attName, 3);
	}
	
	public static String getGetterName(String attName) {
		return UString.switchCase("set"+ attName, 3);
	}
	
	
	
	
}
