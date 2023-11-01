package libro.cap12.app.def;

import java.util.Collection;

import libro.cap04.dtos.DepartamentoDto;
import libro.cap12.framework.test.EmpleadoDto;


public interface Facade {

	public Collection<DepartamentoDto> obtenerDepartamentos();
	public Collection<EmpleadoDto> obtenerEmpleados(int idDepartamento);
}
