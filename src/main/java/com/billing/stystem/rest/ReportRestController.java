package com.billing.stystem.rest;

import com.billing.stystem.dto.DetailedBillingReportDTO;
import com.billing.stystem.service.BillingService;
import com.billing.stystem.service.ReportService;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportRestController {
    @Autowired
    private ReportService reportService;
    
    @Autowired
    private BillingService billingService;
    
    
    @GetMapping("/generate-bill-report")
    public ResponseEntity<byte[]> generateDetailedBillingReport() {
        try {
            List<DetailedBillingReportDTO> data = billingService.getDetailedBillingReport();
            JasperPrint jasperPrint = reportService.generateDetailedBillingReport(data);
            byte[] pdfBytes = reportService.exportReportToPdf(jasperPrint);
            
//            Set Headers
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_PDF);
//            headers.setContentDispositionFormData("inline", "Bill_Report.pdf");
//
//            return ResponseEntity.ok()
//                    .header(String.valueOf(headers))
//                    .body(bytes);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", "DetailedBillingReport.pdf");
            
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    
}
