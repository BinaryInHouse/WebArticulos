package amc.app.web.soft.dev.bean;

public class ArticuloBean extends GenericoBean{

	private String codigo;
	private String serie;
	private String descripcion;
	private String marca;
	private String modelo;

	public ArticuloBean() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "ArticuloBean [codigo=" + codigo + ", serie=" + serie + ", descripcion=" + descripcion + ", marca="
				+ marca + ", modelo=" + modelo + "]";
	}
}
