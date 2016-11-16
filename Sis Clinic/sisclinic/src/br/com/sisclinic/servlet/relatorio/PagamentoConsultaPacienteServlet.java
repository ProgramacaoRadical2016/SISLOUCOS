package br.com.sisclinic.servlet.relatorio;





import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
 

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sisclinic.model.entities.ConsultaProcedimento;
import br.com.sisclinic.model.entities.MedicamentoValor;
import br.com.sisclinic.model.entities.ProcedimentoValor;
import br.com.sisclinic.model.entities.TriagemMedicamento;
import br.com.sisclinic.model.repository.IConsultaProcedimentoRepository;
import br.com.sisclinic.model.repository.IMedicamentoValorRepository;
import br.com.sisclinic.model.repository.ITriagemMedicamentoRepository;
import br.com.sisclinic.model.repository.impl.ConsultaProcedimentoRepository;
import br.com.sisclinic.model.repository.impl.MedicamentoValorRepository;
import br.com.sisclinic.model.repository.impl.ProcedimentoValorRepository;
import br.com.sisclinic.model.repository.impl.TriagemMedicamentoRepository;
import br.com.sisclinic.model.values.DividaPaciente;
import br.com.sisclinic.utilitarios.GeraRelatorio;
 
@WebServlet("/PagamentoConsultaPacienteServlet")
public class PagamentoConsultaPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ConsultaProcedimentoRepository consultaProcedimentoRepository;

	
	@Inject
	private TriagemMedicamentoRepository triagemMedicamentoRepository;
	
	
	@Inject
	private MedicamentoValorRepository medicamentoValorRepository;
	
	
	
	@Inject
	private ProcedimentoValorRepository procedimentoValorRepository;
		
 
	public ConsultaProcedimentoRepository getConsultaProcedimentoRepository() {
		return consultaProcedimentoRepository;
	}

	public TriagemMedicamentoRepository getTriagemMedicamentoRepository() {
		return triagemMedicamentoRepository;
	}

	public MedicamentoValorRepository getMedicamentoValorRepository() {
		return medicamentoValorRepository;
	}

	public ProcedimentoValorRepository getProcedimentoValorRepository() {
		return procedimentoValorRepository;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
 
			// Pega o caminho completo de onde a aplicação está rodando
			ServletContext servletContext = getServletContext();
			String diretorio = servletContext.getRealPath(File.separator) + "relatorios/";
 
			// Instaciar a classe que possui os métodos de geração de relatório
			GeraRelatorio geraRelatorio = new GeraRelatorio();
			geraRelatorio.listarDados(listarDividaPaciente());
			// Chama o método que gera um array de bytes com o
			// conteúdo do arquivo PDF
			byte[] pdf = geraRelatorio.gerarPDF(diretorio);
 
			ServletOutputStream outStream = response.getOutputStream();
			response.setHeader("Content-Disposition", "inline, filename=RelatorioPaciente.pdf");
			response.setContentType("application/pdf");
			response.setContentLength(pdf.length);
			outStream.write(pdf, 0, pdf.length);
			outStream.flush();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Object> listarDividaPaciente() {
		List<MedicamentoValor> medicamentosValor = new ArrayList<MedicamentoValor>();
		List<TriagemMedicamento> triagemMedicamentos = new ArrayList<TriagemMedicamento>();
		List<ProcedimentoValor> procedimentosValor = new ArrayList<ProcedimentoValor>();
		List<ConsultaProcedimento> consultaProcedimentos = new ArrayList<ConsultaProcedimento>();
		medicamentosValor = getMedicamentoValorRepository().listarMedicamentoValor();
		triagemMedicamentos = getTriagemMedicamentoRepository().listarTriagemMedicamento();
		procedimentosValor = getProcedimentoValorRepository().listarProcedimentoValor();
		consultaProcedimentos = getConsultaProcedimentoRepository().listarConsultaProcedimento();
		List<Object> dividasPaciente = new ArrayList<Object>();
		DividaPaciente dividaPaciente = null;
		for(TriagemMedicamento triagemMedicamento : triagemMedicamentos ){
			dividaPaciente = new DividaPaciente();
			dividaPaciente.setNomePaciente(triagemMedicamento.getTriagem().getAtendimento().getPaciente().getPessoa().getNome());
			dividaPaciente.setDescricao(triagemMedicamento.getMedicamento().getDescricao());
			dividaPaciente.setQuantidade(triagemMedicamento.getQuantidade());
			for(MedicamentoValor medicamentoValor : medicamentosValor){
				dividaPaciente.setValorUnitario(medicamentoValor.getValor());
				dividaPaciente.setValorTotal(medicamentoValor.getValor() * triagemMedicamento.getQuantidade() );
			}
			
			dividasPaciente.add(dividaPaciente);
			
		}
		
		for(ConsultaProcedimento consultaProcedimento : consultaProcedimentos ){
			
			dividaPaciente = new DividaPaciente();
			dividaPaciente.setNomePaciente(consultaProcedimento.getConsulta().getAtendimento().getPaciente().getPessoa().getNome());
			dividaPaciente.setDescricao(consultaProcedimento.getProcedimento().getDescricao());
			dividaPaciente.setQuantidade(consultaProcedimento.getQuantidade());
			for(ProcedimentoValor procedimentoValor : procedimentosValor){
				dividaPaciente.setValorUnitario(procedimentoValor.getValor());
				dividaPaciente.setValorTotal(procedimentoValor.getValor() * consultaProcedimento.getQuantidade() );
			}
			
			dividasPaciente.add(dividaPaciente);
			
		}
		
		
		
		return dividasPaciente;
	}
	
}