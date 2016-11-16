package br.com.sisclinic.servlet.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisclinic.framework.json.core.JSONArray;
import br.com.sisclinic.framework.json.core.JSONException;
import br.com.sisclinic.framework.json.core.JSONObject;
import br.com.sisclinic.model.controller.service.impl.UsuarioService;
import br.com.sisclinic.model.entities.Usuario;

import com.google.gson.Gson;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})  
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService UsuarioService;

	List<Usuario> listarUsuarios = new ArrayList<Usuario>();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  

		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String jsonRecebido = "";
		if (br != null) {
			jsonRecebido = br.readLine();
		}
		
		String login = "";
		String senha = "";
		try {
			JSONObject jsonObject = new JSONObject(jsonRecebido);
			String nome = jsonObject.getString("nome");
			senha = jsonObject.getString("senha");
			login = jsonObject.getString("login");

			//			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		JSONObject usuariosObjeto = new JSONObject();

		PrintWriter out = response.getWriter();
		try{    
			Usuario usuario = getUsuarioService().buscarUsuario(login, senha);
			usuariosObjeto.put("id", usuario.getId());
			usuariosObjeto.put("nome", usuario.getNome());
			usuariosObjeto.put("email", usuario.getEmail());
			usuariosObjeto.put("login", usuario.getLogin());
			usuariosObjeto.put("senha", usuario.getSenha());
			String usuarioJson =  usuariosObjeto.toString();
			out.print(usuarioJson);  
		} catch (Exception ex) {  
			out.print(usuariosObjeto.toString());  
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

	public UsuarioService getUsuarioService() {
		return UsuarioService;
	}

}
