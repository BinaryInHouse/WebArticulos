package amc.app.web.soft.dev.persistencia.inf;

import java.util.List;

import amc.app.web.soft.dev.persistencia.exception.PersistenciaException;

public interface GenericoRepository <T>{
	
    public List<T> listar(T t) throws PersistenciaException;
    
    public T buscarXId(T t) throws PersistenciaException;
    
    public boolean insertar(T t) throws PersistenciaException;
    
    public boolean actualizar(T t) throws PersistenciaException;
    
    public boolean eliminar(T t) throws PersistenciaException;

}
