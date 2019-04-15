package amc.app.web.soft.dev.bean;

public class GenericoBean {
	
	private long id;
	
    private long 	audIdUsuario;
    private String	audSesion;
    private String	audIp;
    
    
    public GenericoBean(){
    	
    }


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getAudIdUsuario() {
		return audIdUsuario;
	}


	public void setAudIdUsuario(long audIdUsuario) {
		this.audIdUsuario = audIdUsuario;
	}


	public String getAudSesion() {
		return audSesion;
	}


	public void setAudSesion(String audSesion) {
		this.audSesion = audSesion;
	}


	public String getAudIp() {
		return audIp;
	}


	public void setAudIp(String audIp) {
		this.audIp = audIp;
	}
    
    

}
