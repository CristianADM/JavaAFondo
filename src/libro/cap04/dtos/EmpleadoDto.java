package libro.cap04.dtos;

import java.util.Date;

public class EmpleadoDto {
	private int idEmpleado;
	private String nombre;
	private Date fechaContrado;
	private int idDepartamento;
	
	public String toString() {
		return this.idEmpleado + ", " + this.nombre + ", " + this.fechaContrado + ", " + this.idDepartamento;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaContrado() {
		return fechaContrado;
	}

	public void setFechaContrado(Date fechaContrado) {
		this.fechaContrado = fechaContrado;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
}
