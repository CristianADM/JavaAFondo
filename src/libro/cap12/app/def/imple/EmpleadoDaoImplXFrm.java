package libro.cap12.app.def.imple;

import java.util.Collection;

import libro.cap04.dtos.EmpleadoDto;
import libro.cap12.app.def.EmpleadoDao;
import libro.cap12.framework.xml.XFactory;
import libro.cap12.framework.xml.XSession;

public class EmpleadoDaoImplXFrm implements EmpleadoDao {

	@Override
	public Collection<EmpleadoDto> buscarEmpleadoXDepartamento(int idDepartamento) {
		XSession sess = XFactory.getInstancia().getSession();
		return sess.findByWhere(EmpleadoDto.class, "WHERE idDepartamento=" + idDepartamento);
	}

}
