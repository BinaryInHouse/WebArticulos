package amc.app.web.soft.dev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@NamedStoredProcedureQueries(
		{
				@NamedStoredProcedureQuery(
					name="articulo.listar", 
					procedureName="PKG_ARTICULO.SP_LISTAR",
					resultClasses= ArticuloEntity.class,
					parameters={
								@StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="A_CURSOR", type=void.class),
								@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_CODIGO", type=String.class)
								
						}					
				),
				@NamedStoredProcedureQuery(
						name="articulo.buscarXId", 
						procedureName="PKG_ARTICULO.SP_BUSCAR_X_ID",
						resultClasses= ArticuloEntity.class,
						parameters={
								    @StoredProcedureParameter(mode=ParameterMode.REF_CURSOR,name="A_CURSOR", type=void.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,name="A_ID", type=Long.class),
									@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_CODIGO", type=String.class),
								    @StoredProcedureParameter(mode=ParameterMode.IN,  name="A_SERIE", type=String.class)
									
							}					
					),
				@NamedStoredProcedureQuery(
						name="articulo.insertar", 
						procedureName="PKG_ARTICULO.SP_INSERTAR",
						parameters={
										@StoredProcedureParameter(mode=ParameterMode.OUT, name="A_ID", type=Long.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_CODIGO", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_SERIE", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_DESCRIPCION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_MARCA", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_MODELO", type=String.class),
										
										// Auditoria
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IDUSUARIO", type=Long.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_SESION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IP", type=String.class)
										
						}					
					),
				@NamedStoredProcedureQuery(
						name="articulo.actualizar", 
						procedureName="PKG_ARTICULO.SP_ACTUALIZAR",
						parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN, name="A_ID", type=Long.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_DESCRIPCION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_MARCA", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_MODELO", type=String.class),
										
										// Auditoria
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IDUSUARIO", type=Long.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_SESION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IP", type=String.class)
										
						}					
					),
				@NamedStoredProcedureQuery(
						name="articulo.eliminar", 
						procedureName="PKG_ARTICULO.SP_ELIMINAR",
						parameters={
										@StoredProcedureParameter(mode=ParameterMode.IN, name="A_ID", type=Long.class),		
										// Auditoria
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IDUSUARIO", type=Long.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_SESION", type=String.class),
										@StoredProcedureParameter(mode=ParameterMode.IN,  name="A_AUD_IP", type=String.class)
										
						}					
					)
		
		  }
		)


@Entity(name = "ARTICULO")
public class ArticuloEntity {

	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "SERIE")
	private String serie;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "MARCA")
	private String marca;

	@Column(name = "MODELO")
	private String modelo;

	public ArticuloEntity() {

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
		return "ArticuloBean [id=" + id + ", codigo=" + codigo + ", serie=" + serie + ", descripcion=" + descripcion
				+ ", marca=" + marca + ", modelo=" + modelo + "]";
	}

}
