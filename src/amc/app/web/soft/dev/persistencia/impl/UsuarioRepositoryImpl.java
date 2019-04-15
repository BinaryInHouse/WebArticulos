package amc.app.web.soft.dev.persistencia.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import amc.app.web.soft.dev.bean.UsuarioBean;
import amc.app.web.soft.dev.entity.UsuarioEntity;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;
import amc.app.web.soft.dev.persistencia.inf.UsuarioRepository;


@Transactional
@Repository("usuarioRepository") 
public class UsuarioRepositoryImpl implements UsuarioRepository{

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean)
			throws PersistenciaException {
		UsuarioBean oUsuarioBean = null;	
		try {
			StoredProcedureQuery spq = em.createNamedStoredProcedureQuery("usuario.validarAcceso");
			
			spq.setParameter("P_USUARIO", usuarioBean.getUsuario());
			spq.setParameter("P_CLAVE", usuarioBean.getClave());
			
			if (spq.execute()) {
				@SuppressWarnings("unchecked")
				List<UsuarioEntity> lstUsuarioBeans = (List<UsuarioEntity>)spq.getOutputParameterValue("P_CURSOR");
				if (lstUsuarioBeans!=null) {
					if (lstUsuarioBeans.size()>0) {
						UsuarioEntity usuarioEntity=lstUsuarioBeans.get(0);
						oUsuarioBean= new UsuarioBean();
						BeanUtils.copyProperties(oUsuarioBean, usuarioEntity);
					}
				}
			}
			em.close();
			
		} catch (Exception e) {
			throw new PersistenciaException(e);
		}
		return oUsuarioBean;
	}
	
	@Override
	public List<UsuarioBean> listar(UsuarioBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}
		
	@Override
	public UsuarioBean buscarXId(UsuarioBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(UsuarioBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(UsuarioBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioBean t) throws PersistenciaException {
		// TODO Auto-generated method stub
		return false;
	}
}
