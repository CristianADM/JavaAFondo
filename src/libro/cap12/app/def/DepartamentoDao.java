package libro.cap12.app.def;

import java.util.Collection;

import libro.cap04.dtos.DepartamentoDto;

public interface DepartamentoDao {

	public Collection<DepartamentoDao> buscarTodos();
	public Collection<DepartamentoDao> buscarXLoc(String loc);
	public DepartamentoDto buscar(int idDepartamento);
}
