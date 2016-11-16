package br.com.sisclinic.utilitarios;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraRelatorio {
	
	List<Object> dadaosRelatorio = new ArrayList<Object>(); 
	
	public List<Object> listarDados( List<Object> objetos ){
		dadaosRelatorio = objetos;
		return objetos;

	}
	
	// Método para ser executado em JSE
	public static void main(String[] args) {
		
	

		
		System.out.println("Inicio");
		GeraRelatorio geraRelatorio = new GeraRelatorio();
		String path = "C:/desenvolvimento/projetoIntegrador/sisclinic/WebContent/relatorios";
		geraRelatorio.gerarPDF(path);
		System.out.println("Fim");
		
		
	}

	public byte[] gerarPDF(String diretorio) {
		byte[] retorno = null;
		String relatorio = diretorio + "relDividaPaciente.jrxml";
		String imagem = diretorio + "logoRelatorio.png";
		try {
			// Faz a compilação do relatório
			JasperReport jasperReport = JasperCompileManager.compileReport(relatorio);

			// Cria o mapa de parâmetros que será enviado ao relatório
			HashMap<String, Object> paramatros = new HashMap<String, Object>();

			// Faz o apontamento para a imagem que aparece no top do relatório
			paramatros.put("logo", imagem);

			// Preenche os dados do relatório
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramatros, new JRBeanCollectionDataSource(dadaosRelatorio));

			// Objeto para a ser retornado
			retorno = JasperRunManager.runReportToPdf(jasperReport, paramatros, new JRBeanCollectionDataSource(dadaosRelatorio));

			// Gera o arquivo PDF no caminho especificado
			JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/desenvolvimento/projetoIntegrador/sisclinic/WebContent/relatorios/RelatorioPaciente.pdf");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
}