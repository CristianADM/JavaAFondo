package libro.cap12.framework.test;

import libro.cap04.DepartamentoDao;
import libro.cap12.framework.xml.XFactory;

public class Test {

	public static void main(String[] args) {
		
		XFactory.load("configuracion2.xml");
		
		DepartamentoDao depDao = (DepartamentoDao) XFactory.getInstancia().getBean("DEPARTAMENTO");
		
		System.out.println(depDao);
	}

}
