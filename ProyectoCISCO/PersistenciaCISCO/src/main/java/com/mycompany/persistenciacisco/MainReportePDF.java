/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.persistenciacisco;

/**
 *
 * @author Oribiel
 */
import DAOs.ReporteDAO;
import DTOs.ReporteUsoLaboratorioDTO;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

public class MainReportePDF {

    public static void main(String[] args) {
        ReporteDAO dao = new ReporteDAO();
        List<ReporteUsoLaboratorioDTO> reporte = dao.generarReporte(
            LocalDate.of(2025, 3, 1),
            LocalDate.of(2025, 3, 5)
        );

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("ReporteLaboratorio.pdf"));
            document.open();


            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph titulo = new Paragraph("Reporte de Uso de Laboratorios", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Periodo: 01-03-2025 a 05-03-2025"));
            document.add(new Paragraph(" "));


            PdfPTable table = new PdfPTable(5);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);


            String[] headers = {"Fecha", "Laboratorio", "Tiempo de servicio (min)", "Tiempo de uso (min)", "Tiempo sin uso (min)"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(cell);
            }

      
            for (ReporteUsoLaboratorioDTO dto : reporte) {
                table.addCell(dto.getFecha().toString());
                table.addCell(dto.getLaboratorio());
                table.addCell(String.valueOf(dto.getTiempoServicio()));
                table.addCell(String.valueOf(dto.getTiempoUso()));
                table.addCell(String.valueOf(dto.getTiempoSinUso()));
            }

            document.add(table);
            document.close();

            System.out.println(" PDF generado correctamente: ReporteLaboratorio.pdf");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

