package amc.app.web.soft.dev.presentacion;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import amc.app.web.soft.dev.bean.ArticuloBean;
import amc.app.web.soft.dev.service.inf.ArticuloService;

@Controller(value="articuloMB")
@Scope("session")
public class ArticuloMB extends GenericoMB {
	
	private List<ArticuloBean> lstArticuloBeans;
	private ArticuloBean articuloBean;
	
	@Autowired
	private ArticuloService articuloService;

	
	@PostConstruct
	public void init() {
		this.setLstArticuloBeans(new ArrayList<ArticuloBean>());
		this.setArticuloBean(new ArticuloBean());
		this.listar();
	}

	public String nuevo(){
		this.setArticuloBean(new ArticuloBean());
		return "articulo_registro";
	}
	
	public String cancelar(){
		this.setArticuloBean(new ArticuloBean());
		return "articulo_listado";
	}
	
	
	public String modificar(ArticuloBean articuloBean){
		try {
			ArticuloBean oArticuloBean=this.getArticuloService().buscarXId(articuloBean);
			this.setArticuloBean(oArticuloBean);
		} catch (Exception e) {
			e.printStackTrace();
			super.msgError("Error al modificar");
		}
		
		return "articulo_registro";
	}
	
	
	public void eliminar(ArticuloBean articuloBean){
		try {
			super.setAuditoria(articuloBean);
			boolean sw =this.getArticuloService().eliminar(articuloBean);

			if (sw) {
				super.msgAviso("Exito al eliminar");
			} else {
				super.msgError("Error al eliminar");
			}
		} catch (Exception e) {
			super.msgError("Error al eliminar");
		}
	}
	
	public void grabar(){
		
		if (!this.validar()) {
			return;
		}
		super.setAuditoria(this.getArticuloBean());
		try {
			System.out.println("Id "+this.getArticuloBean().getId());
			boolean sw=false; 
			if (this.getArticuloBean().getId()==0) {
				sw=this.getArticuloService().insertar(this.getArticuloBean());
			}else{
				sw=this.getArticuloService().actualizar(this.getArticuloBean());
			}
			
			if (sw) {
				super.msgAviso("Exito al grabar");

			} else {
				super.msgError("Error al grabar");
			}
			
		} catch (Exception e) {
			
		}
	}
	
	public void listar(){
		
		try {
			lstArticuloBeans=this.getArticuloService().listar(this.getArticuloBean());
			for (ArticuloBean articuloBean : lstArticuloBeans) {
				System.out.println(articuloBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private boolean validar(){
		
		if (this.getArticuloBean().getDescripcion().trim().length()<3 ||
		    this.getArticuloBean().getMarca().trim().length()<3 ||
		    this.getArticuloBean().getModelo().trim().length()<3) {
			super.msgAlerta("El Información es requerida y debe tener"
					+ " como mínimo 3 caracteres");
			return false;
		}else{
			try {
				int ret=this.getArticuloService().validarNombre(this.getArticuloBean());
				if (ret>0) {
					super.msgAlerta("El Articulo " 
							+ this.getArticuloBean().getDescripcion()
							+" ya existe");
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		/*
		if (this.getArticuloBean().getPrecio()<=0) {
			super.msgAlerta("El precio es requerido y debe ser mayor que cero");
			return false;
		}*/
		
		return true;
	}
	
	
    public void exportExcel() {

        try {

            HttpServletResponse response = super.getResponse();

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=Listado_Articulos.xls");

            HSSFWorkbook libro = new HSSFWorkbook();
            HSSFSheet hoja = libro.createSheet("Listado de Articulos");

            int countRow = 0;

            // CABECERA
            Row row = hoja.createRow(countRow);

            Cell cell = row.createCell(0);
            cell.setCellValue("Item");
            super.setStyleLisCabecera(libro, cell);

            cell = row.createCell(1);
            cell.setCellValue("Id");
            super.setStyleLisCabecera(libro, cell);

            cell = row.createCell(2);
            cell.setCellValue("Código");
            super.setStyleLisCabecera(libro, cell);

            cell = row.createCell(3);
            cell.setCellValue("Serie");
            super.setStyleLisCabecera(libro, cell);
            
            cell = row.createCell(4);
            cell.setCellValue("Descripcion");
            super.setStyleLisCabecera(libro, cell);

            cell = row.createCell(5);
            cell.setCellValue("Marca");
            super.setStyleLisCabecera(libro, cell);
            
            cell = row.createCell(6);
            cell.setCellValue("Modelo");
            super.setStyleLisCabecera(libro, cell);
            
            // LISTADO
            int item = 0;

            for (ArticuloBean articuloBean : this.lstArticuloBeans) {

                countRow++;
                item++;

                row = hoja.createRow(countRow);

                cell = row.createCell(0);
                cell.setCellValue(item);

                // Id
                cell = row.createCell(1);
                cell.setCellValue(articuloBean.getId());

                // Codigo
                cell = row.createCell(2);
                cell.setCellValue(articuloBean.getCodigo());

                // Serie
                cell = row.createCell(3);
                cell.setCellValue(articuloBean.getSerie());
                
                // Descripcion
                cell = row.createCell(4);
                cell.setCellValue(articuloBean.getDescripcion());
                
                // Marca
                cell = row.createCell(5);
                cell.setCellValue(articuloBean.getMarca());

                // Modelo
                cell = row.createCell(6);
                cell.setCellValue(articuloBean.getModelo());
            }

            OutputStream out = response.getOutputStream();
            libro.write(out);
            out.close();
            
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }	
	
	public List<ArticuloBean> getLstArticuloBeans() {
		this.listar();
		return lstArticuloBeans;
	}


	public void setLstArticuloBeans(List<ArticuloBean> lstArticuloBeans) {
		this.lstArticuloBeans = lstArticuloBeans;
	}


	public ArticuloBean getArticuloBean() {
		return articuloBean;
	}


	public void setArticuloBean(ArticuloBean articuloBean) {
		this.articuloBean = articuloBean;
	}


	public ArticuloService getArticuloService() {
		return articuloService;
	}


	public void setArticuloService(ArticuloService articuloService) {
		this.articuloService = articuloService;
	}
}
