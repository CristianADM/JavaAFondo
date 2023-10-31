package libro.cap12.framework.test;

import java.sql.Date;

@Table(name="Emp")
public class EmpleadoDto {

	@Pk
	@Column(name="Id_Empleado")
	private int idEmpleado
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fecha_contratacion")
	private Date fechaContatado;
	
	@Column(name="id_Departamento")
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
