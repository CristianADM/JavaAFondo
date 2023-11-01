package libro.cap12.framework.test;

import java.sql.Date;

import libro.cap12.framework.annotations.Colum;
import libro.cap12.framework.annotations.Pk;
import libro.cap12.framework.annotations.Table;

@Table(name="Emp")
public class EmpleadoDto {

	@Pk
	@Colum(name="Id_Empleado")
	private int idEmpleado;
	
	@Colum(name="nombre")
	private String nombre;
	
	@Colum(name="fecha_contratacion")
	private Date fechaContatado;
	
	@Colum(name="id_Departamento")
	private int idDepartamento;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaContatado() {
		return fechaContatado;
	}

	public void setFechaContatado(Date fechaContatado) {
		this.fechaContatado = fechaContatado;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
	
}
