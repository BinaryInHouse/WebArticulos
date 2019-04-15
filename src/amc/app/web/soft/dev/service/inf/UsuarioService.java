package amc.app.web.soft.dev.service.inf;

import amc.app.web.soft.dev.bean.UsuarioBean;
import amc.app.web.soft.dev.service.exception.ServiceException;

public interface UsuarioService extends GenericoService<UsuarioBean> {
	
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean) throws ServiceException;

}
