package amc.app.web.soft.dev.service.inf;

import amc.app.web.soft.dev.bean.ArticuloBean;
import amc.app.web.soft.dev.service.exception.ServiceException;

public interface ArticuloService extends GenericoService<ArticuloBean> {
	
	 public int validarNombre(ArticuloBean productoBean) throws ServiceException;

}
