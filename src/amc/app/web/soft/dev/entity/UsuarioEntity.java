package amc.app.web.soft.dev.entity;

import javax.persistence.*;



@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="usuario.validarAcceso", 
					procedureName="PKG_USUARIO.SP_VALIDAR_ACCESO",
					resultClasses= UsuarioEntity.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="P_CURSOR", type=void.class ),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_USUARIO", type=String.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="P_CLAVE", type=String.class)
						}					
				)		
		}
	)

@Entity(name="USUARIO")
public class UsuarioEntity  extends GenericoEntity{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name="ID_USUARIO")
	private long id;

	@Column(name="USUARIO")
	private String usuario;

	@Column(name="CLAVE")
	private String clave;

	@Column(name="NOMBRE")
	private String nombre;


	public UsuarioEntity() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + "]";
	}

}
