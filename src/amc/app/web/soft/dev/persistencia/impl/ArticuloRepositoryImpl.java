package amc.app.web.soft.dev.persistencia.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amc.app.web.soft.dev.bean.ArticuloBean;
import amc.app.web.soft.dev.entity.ArticuloEntity;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;
import amc.app.web.soft.dev.persistencia.inf.ArticuloRepository;

@Transactional
@Repository("articuloRepository") 
public class ArticuloRepositoryImpl implements ArticuloRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	

	@Override
	public List<ArticuloBean> listar(ArticuloBean articuloBean) throws PersistenciaException {
		
		List<ArticuloBean> articulos = new ArrayList<ArticuloBean>();
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.listar");
			// IN
			spq.setParameter("A_CODIGO", articuloBean.getCodigo());

			if (spq.execute()) {
				@SuppressWarnings("unchecked")
				List<ArticuloEntity> lst = (List<ArticuloEntity>) spq.getOutputParameterValue("A_CURSOR");

				for (ArticuloEntity articuloEntity : lst) {
					ArticuloBean oArticuloBean = new ArticuloBean();
					
					BeanUtils.copyProperties(oArticuloBean, articuloEntity);
					
					articulos.add(oArticuloBean);
				}

			}
			em.close();

			return articulos;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	@Override
	public ArticuloBean buscarXId(ArticuloBean articuloBean) throws PersistenciaException {
		ArticuloBean oArticuloBean = null;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.buscarXId");
			// IN
			spq.setParameter("A_ID", articuloBean.getId());
			spq.setParameter("A_CODIGO", articuloBean.getCodigo());
			spq.setParameter("A_SERIE", articuloBean.getSerie());

			if (spq.execute()) {
				@SuppressWarnings("unchecked")
				List<ArticuloEntity> lst = (List<ArticuloEntity>) spq.getOutputParameterValue("A_CURSOR");
				
				if (lst!=null) {
					if (lst.size()>0) {
						ArticuloEntity articuloEntity= lst.get(0);
						oArticuloBean = new ArticuloBean();
						BeanUtils.copyProperties(oArticuloBean, articuloEntity);
					}
				}
			}
			em.close();

			return oArticuloBean;
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
	}

	@Override
	public boolean insertar(ArticuloBean articuloBean) throws PersistenciaException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.insertar");
			// IN
			spq.setParameter("A_CODIGO", articuloBean.getCodigo().trim().toUpperCase());
			spq.setParameter("A_SERIE", articuloBean.getSerie().trim().toUpperCase());
			spq.setParameter("A_DESCRIPCION", articuloBean.getDescripcion().trim().toUpperCase());
			spq.setParameter("A_MARCA", articuloBean.getMarca().trim().toUpperCase());
			spq.setParameter("A_MODELO", articuloBean.getModelo().trim().toUpperCase());
			
			//Auditoria
			
			spq.setParameter("A_AUD_IDUSUARIO", articuloBean.getAudIdUsuario());
			spq.setParameter("A_AUD_SESION", articuloBean.getAudSesion());
			spq.setParameter("A_AUD_IP", articuloBean.getAudIp());
			
			spq.execute();
			Object id=spq.getOutputParameterValue(1); //P_ID
			if (id!=null) {
				articuloBean.setId(Long.valueOf(id.toString()));
				sw=true;
			}
			
			em.close();
			
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean actualizar(ArticuloBean articuloBean) throws PersistenciaException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.actualizar");
			
			// IN
			spq.setParameter("A_ID", articuloBean.getId());
			spq.setParameter("A_DESCRIPCION", articuloBean.getDescripcion().trim().toUpperCase());
			spq.setParameter("A_MARCA", articuloBean.getMarca().trim().toUpperCase());
			spq.setParameter("A_MODELO", articuloBean.getModelo().trim().toUpperCase());
			
			//Auditoria
			spq.setParameter("A_AUD_IDUSUARIO", articuloBean.getAudIdUsuario());
			spq.setParameter("A_AUD_SESION", articuloBean.getAudSesion());
			spq.setParameter("A_AUD_IP", articuloBean.getAudIp());
			
			spq.execute();
			
			sw=true;
			
			em.close();
			
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public boolean eliminar(ArticuloBean articuloBean) throws PersistenciaException {
		boolean sw=false;
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("articulo.eliminar");
			
			// IN
			spq.setParameter("A_ID", articuloBean.getId());

			
			//Auditoria
			
			spq.setParameter("A_AUD_IDUSUARIO", articuloBean.getAudIdUsuario());
			spq.setParameter("A_AUD_SESION", articuloBean.getAudSesion());
			spq.setParameter("A_AUD_IP", articuloBean.getAudIp());
			
			spq.execute();
			
			sw=true;
			
			em.close();
			
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return sw;
	}

	@Override
	public int validarNombre(ArticuloBean articuloBean) 
			   throws PersistenciaException {
		// TODO Auto-generated method stub
		return 0;
	}

}
