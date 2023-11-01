package libro.cap12.app.def.imple;

import java.util.Collection;

import libro.cap04.dtos.DepartamentoDto;
import libro.cap12.app.def.DepartamentoDao;
import libro.cap12.framework.xml.XFactory;
import libro.cap12.framework.xml.XSession;

public class DepartamentoDaoImplXFrm implements DepartamentoDao {

	@Override
	public DepartamentoDto buscar(int idDepartamento) {
		XSession sess = XFactory.getInstancia().getSession();
		return (DepartamentoDto) sess.findByPrimaryKey(DepartamentoDto.class, idDepartamento);
	}
	
	@Override
	public Collection<DepartamentoDao> buscarTodos() {
		XSession sess = XFactory.getInstancia().getSession();
		return sess.findAll(DepartamentoDto.class);
	}

	@Override
	public Collection<DepartamentoDao> buscarXLoc(String loc) {
		XSession sess = XFactory.getInstancia().getSession();
		return sess.findByWhere(DepartamentoDto.class, "WHERE loc ="+loc);
	}

	

}
