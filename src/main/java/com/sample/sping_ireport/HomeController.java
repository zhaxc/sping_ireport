package com.sample.sping_ireport;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.sping_ireport.model.JavaBeanPerson;
import com.sample.sping_ireport.model.JavaBeanRecord;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	@Autowired
	private CustomReportView customReportView;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String report(Model model,HttpServletResponse response) {
		//		
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanPerson.getList());
		

		model.addAttribute("url", "/WEB-INF/jasper/spring_report.jasper");
		model.addAttribute("format", "pdf");
		model.addAttribute("jrMainDataSource", jrDataSource);

//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("pa","https://github.com/dihaw-team/dihaw-jasperreports");

		//model.addAttribute("parameters",params);
		model.addAttribute("pa","ddddddd");
		response.setContentType("application/x-pdf");
		return "reportView"; // 瀵瑰簲jasper-views.xml涓殑bean id
	}


	/**
	 * 测试模板
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/reports", method = RequestMethod.GET)
	public @ResponseBody CustomReportView  reports(Model model,HttpServletResponse response) {

		//获得数据源
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanRecord.getList());
		
		//指定模板位置及格式
		model.addAttribute("url", "/WEB-INF/jasper/report.jasper");
		model.addAttribute("format", "pdf"); 
		model.addAttribute("jrMainDataSource", jrDataSource);


		//添加parameters参数
		//model.addAttribute("parameters",params);
		model.addAttribute("times","2017-10至11");
		model.addAttribute("paySum",new BigDecimal(100.106));
		model.addAttribute("receiveSum",new BigDecimal(111.106));
		model.addAttribute("profitSum",new BigDecimal(99.106));
	
		response.setContentType("application/x-pdf");
		//return "reportView";
		return customReportView;
	}

	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public @ResponseBody CustomReportView  reportsHtml(Model model,HttpServletResponse response,HttpServletRequest request) throws JRException {
		
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(JavaBeanRecord.getList());
		
		model.addAttribute("url", "/WEB-INF/jasper/report.jasper");
		model.addAttribute("format", "html"); 
		model.addAttribute("jrMainDataSource", jrDataSource);
		
		
		
//		Map<String,Object> params = new HashMap<String,Object>();
//		params.put("pa","https://github.com/dihaw-team/dihaw-jasperreports");
		
		//model.addAttribute("parameters",params);
		model.addAttribute("times","2017-10至11");
		model.addAttribute("paySum",new BigDecimal(100.106));
		model.addAttribute("receiveSum",new BigDecimal(111.106));
		model.addAttribute("profitSum",new BigDecimal(99.106));
	
		JRHtmlExporter exporter=new JRHtmlExporter();
		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,Boolean.FALSE);
		
		//exporter.exportReport();
		//return "reportView";
		response.setContentType("text/html; charset=GBK");
		return customReportView;
	}
	
	
}
