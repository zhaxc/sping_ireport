package com.sample.sping_ireport;

import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;

public class CustomReportView extends JasperReportsMultiFormatView {
	private JasperReport report;
	
	public CustomReportView() {
		super();
	}
	
	protected JasperPrint fillReport(Map<String, Object> model) throws Exception {
		if (model.containsKey("url")) {
			setUrl(String.valueOf(model.get("url")));
			this.report = loadReport();
		}
		
		return super.fillReport(model);
	}
	
	protected JasperReport getReport() {
		return this.report;
	}
}
