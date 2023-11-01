package libro.cap12.app.cliente;

import java.util.Collection;
import java.util.Scanner;

import libro.cap04.dtos.DepartamentoDto;
import libro.cap12.app.def.Facade;
import libro.cap12.framework.test.EmpleadoDto;
import libro.cap12.framework.xml.XFactory;

public class MiApp {

	public static void main(String[] args) {
		XFactory.load("configuracion2.xml");
		
		Facade facade = (Facade) XFactory.getInstancia().getBean("FACADE");
		
		Collection<DepartamentoDto> collDepts = facade.obtenerDepartamentos();

		_mostrarDepartamentos(collDepts);
		
		Scanner scanner = new Scanner(System.in);
		int idDepartamento = scanner.nextInt();
		
		Collection<EmpleadoDto> collEmps = facade.obtenerEmpleados(idDepartamento);
		_mostrarEmpleados(collEmps, idDepartamento);
	}

}
