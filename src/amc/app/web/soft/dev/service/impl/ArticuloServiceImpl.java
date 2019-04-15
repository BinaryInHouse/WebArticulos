package amc.app.web.soft.dev.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amc.app.web.soft.dev.bean.ArticuloBean;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;
import amc.app.web.soft.dev.persistencia.inf.ArticuloRepository;
import amc.app.web.soft.dev.service.exception.ServiceException;
import amc.app.web.soft.dev.service.inf.ArticuloService;




@Service("articuloService")
public class ArticuloServiceImpl implements ArticuloService{

	@Autowired
	private ArticuloRepository articuloRepository;
	
	public ArticuloServiceImpl() {
		
	}

	@Override
	public List<ArticuloBean> listar(ArticuloBean articuloBean) throws ServiceException {
		try {
			return this.getArticuloRepository().listar(articuloBean);
		} catch (PersistenciaException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public ArticuloBean buscarXId(ArticuloBean articuloBean) throws ServiceException {
		try {
			return this.getArticuloRepository().buscarXId(articuloBean);
		} catch (PersistenciaException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public boolean insertar(ArticuloBean articuloBean) throws ServiceException {
		try {
			return this.getArticuloRepository().insertar(articuloBean);
		} catch (PersistenciaException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public boolean actualizar(ArticuloBean articuloBean ) throws ServiceException {
		try {
			return this.getArticuloRepository().actualizar(articuloBean);
		} catch (PersistenciaException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public boolean eliminar(ArticuloBean articuloBean ) throws ServiceException {
		try {
			return this.getArticuloRepository().eliminar(articuloBean);
		} catch (PersistenciaException e) {

			throw new ServiceException(e);
		}
	}

	@Override
	public int validarNombre(ArticuloBean articuloBean) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArticuloRepository getArticuloRepository() {
		return articuloRepository;
	}

	public void setArticuloRepository(ArticuloRepository articuloRepository) {
		this.articuloRepository = articuloRepository;
	}
	
	

}
