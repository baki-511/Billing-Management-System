package com.billing.stystem.service.impl;

import com.billing.stystem.dto.DetailedBillingReportDTO;
import com.billing.stystem.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    
    @Override
    public JasperPrint generateDetailedBillingReport(List<DetailedBillingReportDTO> data) throws JRException {
        // Load the .jrxml file
        InputStream reportStream = this.getClass().getResourceAsStream("/reports/detailed_billing_report.jrxml");
        if (reportStream == null) {
            System.out.println("Resource not found!");
            return null;
        } else {
            System.out.println("Resource loaded successfully!");
        }
        // Compile the report
        JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);
        
        // Create data source
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        
        // Parameters (if any)
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("ReportTitle", "Detailed Billing Report");
        
        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        
        return jasperPrint;
    }
    
    public byte[] exportReportToPdf(JasperPrint jasperPrint) throws JRException {
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}
