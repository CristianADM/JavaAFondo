package libro.cap12.app.def.imple;

import java.util.Collection;

import libro.cap04.DepartamentoDao;
import libro.cap04.dtos.DepartamentoDto;
import libro.cap04.dtos.EmpleadoDto;
import libro.cap12.app.def.EmpleadoDao;
import libro.cap12.app.def.Facade;
import libro.cap12.framework.xml.XFactory;

public class FacadeImpleXFrm implements Facade {

	@Override
	public Collection<DepartamentoDto> obtenerDepartamentos() {
		DepartamentoDao departamento = (DepartamentoDao) XFactory.getInstancia().getBean("DEPARTAMENTO");
		return departamento.buscarTodosDepartamentos();
	}

	@Override
	public Collection<EmpleadoDto> obtenerEmpleados(int idDepartamento) {
		EmpleadoDao emp = (EmpleadoDao) XFactory.getInstancia().getBean("EMPLEADO");
		return emp.buscarEmpleadoXDepartamento(idDepartamento);
	}

}
