package amc.app.web.soft.dev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amc.app.web.soft.dev.bean.UsuarioBean;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;
import amc.app.web.soft.dev.persistencia.inf.UsuarioRepository;
import amc.app.web.soft.dev.service.exception.ServiceException;
import amc.app.web.soft.dev.service.inf.UsuarioService;


@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public UsuarioServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean)
			throws ServiceException {
		try {
			return this.getUsuarioRepository().validarAcceso(usuarioBean);
		} catch (PersistenciaException e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public List<UsuarioBean> listar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioBean buscarXId(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean actualizar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(UsuarioBean t) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
}
