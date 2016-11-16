package br.com.sisclinic.servlet.relatorio;





import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
 

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisclinic.utilitarios.GeraRelatorio;
 
@WebServlet("/RelatorioAlunoServlet")
public class RelatorioAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		try {
 
			// Pega o caminho completo de onde a aplicação está rodando
			ServletContext servletContext = getServletContext();
			String diretorio = servletContext.getRealPath(File.separator) + "relatorios\\";
 
			// Instaciar a classe que possui os métodos de geração de relatório
			GeraRelatorio geraRelatorio = new GeraRelatorio();
 
			// Chama o método que gera um array de bytes com o
			// conteúdo do arquivo PDF
			byte[] pdf = geraRelatorio.gerarPDF(diretorio);
 
			OutputStream outStream = response.getOutputStream();
			response.setHeader("Content-Disposition", "inline, filename=RelatorioAluno.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(pdf.length);
			outStream.write(pdf, 0, pdf.length);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}