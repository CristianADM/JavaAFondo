¡package libro.cap12.framework.test;

import libro.cap04.dtos.DepartamentoDto;
import libro.cap04.dtos.EmpleadoDto;

public class TestDB1 {

	public static void main(String[] args) {
		
		//leo el archivo de configuracion
		XFactory.load("configuracion.xml");
		
		//obtengo una session
		XSession session = XFactory.getInstancia().getSession();
		
		//busco el departamento cuyo id_departamento es 1 
		DepartamentoDto dept;
		dept = (DepartamentoDto) session.findByPrimaryKey(DepartamentoDto.class, 1);
		System.out.println(dept);
		
		//busco el empleado cuyo id_empleado es 1
		EmpleadoDto emp;
		emp = (EmpleadoDto) session.findByPrimaryKey(EmpleadoDto.class, 1);
		System.out.println(emp);
	}

}
