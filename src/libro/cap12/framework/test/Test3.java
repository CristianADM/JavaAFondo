package libro.cap12.framework.test;

import java.util.Date;

import libro.cap04.dtos.DepartamentoDto;
import libro.cap04.dtos.EmpleadoDto;
import libro.cap12.framework.xml.XFactory;
import libro.cap12.framework.xml.XSession;
import libro.cap12.framework.xml.XTransaction;

public class Test3 {

	public static void main(String[] args) {
		XFactory.load("configuracion2.xml");
		
		//Defino un  DepartamentoDto
		DepartamentoDto ddto = new DepartamentoDto();
		ddto.setIdDepartamento(50);
		ddto.setNombre("Marketing");
		ddto.setLocacion("Isla Canarias");
		
		//Defino un EmpleadoDto
		EmpleadoDto edto = new EmpleadoDto();
		edto.setIdEmpleado(332);
		edto.setNombre("Josecito");
		edto.setFechaContrado(new Date(System.currentTimeMillis()));
		edto.setIdDepartamento(ddto.getIdDepartamento());
		
		//Obtengo la session
		XSession sess = XFactory.getInstancia().getSession();
		
		//Comienzo una transaccion
		XTransaction trx = sess.beginTransaction();
		
		//inserto ambos
		sess.insert(ddto);
		sess.insert(edto);
		
		//Commit
		trx.commit();

	}

}
