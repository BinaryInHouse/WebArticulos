package amc.app.web.soft.dev.bean;

public class UsuarioBean extends GenericoBean{
	
	private String usuario;
	private String clave;
	private String nombre;
	
	
	public UsuarioBean() {
	}

	public String getClave() {
		return this.clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return this.nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	@Override
	public String toString() {
		return "UsuarioBean [usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + "]";
	}

}
