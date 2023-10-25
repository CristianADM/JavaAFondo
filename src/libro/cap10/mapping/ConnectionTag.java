package libro.cap10.mapping;

public class ConnectionTag {

	private String name;
	private String usuario;
	private String password;
	private String url;
	private String driver;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String toString() {
		return this.name + ", " + this.usuario + ", " + this.password + ", " + this.url + ", " + this.driver;
	}
}
