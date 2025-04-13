/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DTOs.ReporteUsoLaboratorioDTO;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Oribiel
 */
public class GeneradorReportePDF {

    public static void generarPDF(List<ReporteUsoLaboratorioDTO> datos, String nombreArchivo,  LocalDate fechaInicio, LocalDate fechaFin) {
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(nombreArchivo));
            doc.open();

            // Título
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph titulo = new Paragraph("Reporte de uso de laboratorios", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            doc.add(new Paragraph("Periodo: " + fechaInicio.toString() + " a " + fechaFin.toString()));
            doc.add(new Paragraph("Fecha de generación: " + LocalDate.now()));
            doc.add(new Paragraph(" "));

            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setWidths(new float[]{3, 2, 2, 2, 2});

            // Encabezados
            String[] headers = {
                "Laboratorio", "Fecha", "Tiempo de Servicio (min)",
                "Tiempo de Uso (min)", "Tiempo sin Uso (min)"
            };

            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(cell);
            }

            // Datos
            for (ReporteUsoLaboratorioDTO dto : datos) {
                tabla.addCell(dto.getLaboratorio());
                tabla.addCell(dto.getFecha().toString());
                tabla.addCell(String.valueOf(dto.getTiempoServicio()));
                tabla.addCell(String.valueOf(dto.getTiempoUso()));
                tabla.addCell(String.valueOf(dto.getTiempoSinUso()));
            }

            doc.add(tabla);
            doc.close();
            System.out.println("✅ PDF generado correctamente: " + nombreArchivo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
