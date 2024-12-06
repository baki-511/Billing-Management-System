package com.billing.stystem.service;

import com.billing.stystem.dto.DetailedBillingReportDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.util.List;

public interface ReportService {
    public JasperPrint generateDetailedBillingReport(List<DetailedBillingReportDTO> data) throws JRException;
    
    public byte[] exportReportToPdf(JasperPrint jasperPrint) throws JRException;
}
