package amc.app.web.soft.dev.persistencia.inf;

import amc.app.web.soft.dev.bean.UsuarioBean;
import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;

public interface UsuarioRepository extends GenericoRepository<UsuarioBean>{
	
	public UsuarioBean validarAcceso(UsuarioBean usuarioBean) throws PersistenciaException;

}
