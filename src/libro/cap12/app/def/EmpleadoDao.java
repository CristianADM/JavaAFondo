package libro.cap12.app.def;

import java.util.Collection;

import libro.cap04.dtos.EmpleadoDto;

public interface EmpleadoDao {

	public Collection<EmpleadoDto> buscarEmpleadoXDepartamento(int idDepartamento);
}
