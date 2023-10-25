package libro.cap04.dtos;

public class DepartamentoDto {
	private int idDepartamento;
	private String nombre;
	private String locacion;
	
	public String toString() {
		return this.idDepartamento + ", " + this.nombre + ", " + this.locacion;
	}

	public int getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}
}
