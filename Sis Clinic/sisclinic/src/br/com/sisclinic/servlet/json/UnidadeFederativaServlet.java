package br.com.sisclinic.servlet.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;

import br.com.sisclinic.model.controller.service.IUnidadeFederativaService;
import br.com.sisclinic.model.controller.service.impl.UnidadeFederativaService;
import br.com.sisclinic.model.entities.Article;
import br.com.sisclinic.model.entities.UnidadeFederativa;

@WebServlet(name = "UnidadeFederativaServlet", urlPatterns = {"/UnidadeFederativaServlet"})  
public class UnidadeFederativaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UnidadeFederativa unidadeFederativa;
    
    @Inject
    private UnidadeFederativaService unidadeFederativaService;
    
    List<UnidadeFederativa> listarUnidadeFederativa = new ArrayList<UnidadeFederativa>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

    	ArrayList<Object> arrobj = new ArrayList<Object>();  
    	Gson objJson = new Gson();  
    	PrintWriter out = response.getWriter();
    	try{  
    		List<UnidadeFederativa> unidades = new ArrayList<UnidadeFederativa>();  
    		unidades = getUnidadeFederativaService().listar();
    		arrobj.add(unidades);  
    		String json =  objJson.toJson(arrobj);
    		out.print(json);  
    

    	} catch (Exception ex) {  
    		out.print(objJson.toJson(arrobj));  
    	} finally {  
    		out.close();  
    	}  
    } 
 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    	 response.setContentType("application/json");    
    	  processRequest(request, response);  
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
    
    public UnidadeFederativa buscarUnidadeFederativa(){
    	UnidadeFederativa unidade = new UnidadeFederativa() ;
    	for( UnidadeFederativa unidadeFederativa : listarUnidadesFederativa() ) {
    		unidade = unidadeFederativa;
    	}
    	return unidade;
    }
    
    public List<UnidadeFederativa> listarUnidadesFederativa() {
    	return getUnidadeFederativaService().listar();
    }

	public UnidadeFederativa getUnidadeFederativa() {
		return unidadeFederativa;
	}

	public void setUnidadeFederativa(UnidadeFederativa unidadeFederativa) {
		this.unidadeFederativa = unidadeFederativa;
	}

	public UnidadeFederativaService getUnidadeFederativaService() {
		return unidadeFederativaService;
	}

	public void setUnidadeFederativaService( UnidadeFederativaService unidadeFederativaService) {
		this.unidadeFederativaService = unidadeFederativaService;
	}
    
    

}
