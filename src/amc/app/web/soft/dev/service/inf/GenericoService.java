package amc.app.web.soft.dev.service.inf;

import java.util.List;

import amc.app.web.soft.dev.service.exception.ServiceException;


public interface GenericoService<T> {
	
    public List<T> listar(T t) throws ServiceException;
    
    public T buscarXId(T t) throws ServiceException;
    
    public boolean insertar(T t) throws ServiceException;
    
    public boolean actualizar(T t) throws ServiceException;
    
    public boolean eliminar(T t) throws ServiceException;

}
