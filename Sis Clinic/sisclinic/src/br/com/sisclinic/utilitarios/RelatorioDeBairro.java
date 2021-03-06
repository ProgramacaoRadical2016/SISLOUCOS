package br.com.sisclinic.utilitarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sisclinic.model.entities.Bairro;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class RelatorioDeBairro {
	public static void main(String[] args) throws JRException, SQLException {

		System.out.println("Gerando relatório...");
		// lista com os nossos clientes
		List<Bairro> lista = new ArrayList<Bairro>();

		Bairro c1 = new Bairro();
		c1.setNome("Alexandre Macedo");
		

		Bairro c2 = new Bairro();
		c2.setNome("Rafael Cosentino");
		

		Bairro c3 = new Bairro();
		c3.setNome("Daniel Machado");
	

		lista.add(c1);
		lista.add(c2);
		lista.add(c3);

		// compilacao do JRXML
		JasperReport report = JasperCompileManager.compileReport("C:/desenvolvimento/projetoIntegrador/sisclinic/WebContent/relatorios/relBairro.jrxml");

		// preenchimento do relatorio, note que o metodo recebe 3 parametros:
		// 1 - o relatorio
		//
		// 2 - um Map, com parametros que sao passados ao relatorio
		// no momento do preenchimento. No nosso caso eh null, pois nao
		// estamos usando nenhum parametro
		//
		// 3 - o data source. Note que nao devemos passar a lista diretamente,
		// e sim "transformar" em um data source utilizando a classe
		// JRBeanCollectionDataSource
		JasperPrint print = JasperFillManager.fillReport(report, null,
				new JRBeanCollectionDataSource(lista));

		// exportacao do relatorio para outro formato, no caso PDF
		JasperExportManager.exportReportToPdfFile(print,
				"relatorios/relBairro.pdf");

		System.out.println("Relatório gerado.");
	}
}