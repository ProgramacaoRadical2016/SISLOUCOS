package br.com.sisclinic.servlet.relatorio;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;


//@Named
//@RequestScoped
public class RelatorioDespesaPaciente implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	private Date dataInicio;
//	private Date dataFim;
//
//	@Inject
//	private FacesContext facesContext;
//
//	@Inject
//	private HttpServletResponse response;
//
//	@Inject
//	private EntityManager manager;
//
//	public void emitir() {
//		Map<String, Object> parametros = new HashMap<>();
//		parametros.put("data_inicio", this.dataInicio);
//		parametros.put("data_fim", this.dataFim);
//		
//		
//		Session session = manager.unwrap(Session.class);
//	//	session.doWork(executor);
////		
////		if (executor.isRelatorioGerado()) {
////			facesContext.responseComplete();
////		} else {
////			//FacesUtil.addErrorMessage("A execu��o do relat�rio n�o retornou dados.");
////		}
//	}
//
//
//	public Date getDataInicio() {
//		return dataInicio;
//	}
//
//	public void setDataInicio(Date dataInicio) {
//		this.dataInicio = dataInicio;
//	}
//
//	public Date getDataFim() {
//		return dataFim;
//	}
//
//	public void setDataFim(Date dataFim) {
//		this.dataFim = dataFim;
//	}

}
