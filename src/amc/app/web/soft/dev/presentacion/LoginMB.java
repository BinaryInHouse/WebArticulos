package amc.app.web.soft.dev.presentacion;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import amc.app.web.soft.dev.bean.UsuarioBean;
import amc.app.web.soft.dev.service.inf.UsuarioService;
import amc.app.web.soft.dev.util.Encrypt;


@Controller(value="loginMB")
@Scope("session")
public class LoginMB extends GenericoMB {

	@Autowired
	private UsuarioService usuarioService;

	private UsuarioBean usuarioBean;

	@PostConstruct
	public void init() {
		this.setUsuarioBean(new UsuarioBean());
	}

	public String validarAcceso() {
		String page = "index";
		String key = super.getStringJSF("Encrypt.key");
		Encrypt.init(key);

		try {
			String claveEncripatada = Encrypt.encrypt(this.getUsuarioBean().getClave());
			
			System.err.println("claveEncripatada " + claveEncripatada);
			
			this.getUsuarioBean().setClave(claveEncripatada);
			
			UsuarioBean oUsuarioBean = this.getUsuarioService().validarAcceso(this.getUsuarioBean());
			if (oUsuarioBean != null) {
				HttpSession session = super.getRequest().getSession(true);
				session.setAttribute("ID", session.getId());
				session.setAttribute("usuario", oUsuarioBean);
				page = "panel";
			} else {

				super.msgAlerta("Usuario y/o clave incorrecta");
			}

		} catch (Exception e) {
			this.msgError("Error al validar usuario " + e.getMessage());
		}

		return page;
	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public UsuarioBean getUsuarioActivo(){
		UsuarioBean oUsuarioBean=new UsuarioBean();
		HttpSession session= super.getRequest().getSession();
		if (session!=null) {
			Object obj=session.getAttribute("usuario");
			if (obj!=null) {
				oUsuarioBean=(UsuarioBean)obj; 
			}
		}
		return oUsuarioBean;
	}
	
	public String cerrarSesion() {
		
		HttpSession session = super.getRequest().getSession();
		session.removeAttribute("ID");
		session.removeAttribute("usuario");
		session.invalidate();
		
		return "index";
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
