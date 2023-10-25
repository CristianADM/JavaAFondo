package libro.cap11;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo2 {

	
	public static void main(String[] args) {
		try {
			// Defino el nombre de la clase y obtengo el Class
			String sClass = "java.awt.Frame";
			Class clazz = Class.forName(sClass);
			
			//invoco al constructor que recibe un string como argumento
			Class[] pTypesConst = { String.class };
			Object[] pValueConst = { "Ventana AWt Reflect "};
			Constructor ctor = clazz.getConstructor(pTypesConst);
			Object obj = ctor.newInstance(pValueConst);
			
			// invoco al metodo setsize que recibe dos enteros
			String mtdName1 = "setSize";
			Class[] pTypes1 = { Integer.TYPE, Integer.TYPE };
			Object[] pValues1 = {300, 300};
			Method mtd = obj.getClass().getMethod(mtdName1, pTypes1);
			mtd.invoke(obj, pValues1);
			
			//invoco al metodo setVisible que recibe un boolean
			String mtdName2 = "setVisible";
			Class[] pTypes2 = { Boolean.TYPE };
			Object[] pValues2 = { true };
			Method mtd2 = obj.getClass().getMethod(mtdName2, pTypes2);
			mtd2.invoke(obj, pValues2);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
