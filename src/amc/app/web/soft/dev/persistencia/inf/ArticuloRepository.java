package amc.app.web.soft.dev.persistencia.inf;

import amc.app.web.soft.dev.bean.ArticuloBean;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;


public interface ArticuloRepository extends GenericoRepository<ArticuloBean> {
	
	public int validarNombre(ArticuloBean articuloBean)throws PersistenciaException;
		
}
