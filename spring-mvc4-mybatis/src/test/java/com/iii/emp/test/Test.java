package com.iii.emp.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.iii.emp.service.EmpService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Test {
	@Autowired
	EmpService empService;

	public JasperPrint print() throws JRException {

		// read jasper file
		String path = "META-INF/report-template/emp.jasper";
		InputStream jasperTemplate = getClass().getResourceAsStream(path);
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperTemplate);

		// put jasperParam
		Map<String, Object> jasperParam = new HashMap<>();
		jasperParam.put("userID", 6619);
		jasperParam.put("date", new Date());

		// put empsData
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(empService.getEmps());
		Map<String, JRDataSource> dataSource = new HashMap<>();
		dataSource.put(null, jrDataSource);

		JRDataSource jasperDataSource = null;
		// isWithSubReport
		if ("...".equals("...")) {
			List<Map<String, ?>> listDataSource = new ArrayList<>();
			listDataSource.add(dataSource);
			jasperDataSource = new JRMapCollectionDataSource(listDataSource);

		} else {
			Collection<JRDataSource> values = dataSource.values();
			jasperDataSource = (JRDataSource) values.iterator().next();

		}

		// 1. jasper file inputsteam 2. single param 3. list data
		return JasperFillManager.fillReport(jasperReport, jasperParam, jasperDataSource);
	}

	public static void main(String[] args) {

	}

}
