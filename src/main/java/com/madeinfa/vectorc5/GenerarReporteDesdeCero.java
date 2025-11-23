package com.madeinfa.vectorc5;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;

public class GenerarReporteDesdeCero {
    public static void main(String[] args) throws Exception {
        String dest = "Reporte_Generado.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(20, 20, 20, 20);

        // --- 1. Encabezado (Logos y Títulos) [cite: 1, 16, 17] ---
        // Usamos una tabla de 3 columnas para simular: Logo STC | Títulos | Logo Siemens
        float[] headerWidths = {1, 4, 1};
        Table headerTable = new Table(UnitValue.createPercentArray(headerWidths)).useAllAvailableWidth();

        // Columna Izq: Aquí iría el logo del STC
        headerTable.addCell(new Cell().add(new Paragraph("LOGO STC")).setTextAlignment(TextAlignment.CENTER));

        // Columna Central: Título y Metadatos
        Paragraph title = new Paragraph("\nReporte de Incidencias en Vía \n Ficha n°")
                .setTextAlignment(TextAlignment.CENTER);
        headerTable.addCell(new Cell().add(title));

        // Columna Der: Logo Siemens/MRTE
        headerTable.addCell(new Cell().add(new Paragraph("LOGO SIEMENS")).setTextAlignment(TextAlignment.CENTER));

        document.add(headerTable);
        document.add(new Paragraph("\n")); // Espacio

        // --- 2. Tabla de Datos Generales (Recreando la sección de Incidencia)  ---
        // El PDF original tiene una estructura compleja. Usaremos una tabla de 4 columnas.
        float[] colWidths = {2, 3, 1, 3};
        Table tableDatos = new Table(UnitValue.createPercentArray(colWidths)).useAllAvailableWidth();

        Cell titulo = new Cell(1,4)
                .add(new Paragraph("Datos generales"))
                .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                        .simulateBold();

        tableDatos.addCell(titulo);
        // Fila 1
        addCell(tableDatos, "Semana N°:", true);
        addCell(tableDatos, "26", false);
        Cell tecnicos = new Cell(4,1)
                .add(new Paragraph("Tecnicos"))
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY);;
        tableDatos.addCell(tecnicos);
        addCell(tableDatos, "Omar Ojeda", false);

        // Fila 2
        addCell(tableDatos, "Fecha del reporte:", true);
        addCell(tableDatos, "23/06/2025", false); // Dato extraído del [cite: 10]
        addCell(tableDatos, "Adrian Garcia", false);

        // Fila 3
        addCell(tableDatos, "Turno", true);
        addCell(tableDatos, "Nocturno", false);
        addCell(tableDatos, "", false);

        // Fila 4
        addCell(tableDatos, "Ubicacion", true);
        addCell(tableDatos, "Local tecnico pantitlan", false);
        addCell(tableDatos, "", false);

        document.add(tableDatos);

        // Tabla de incidencias

        Table tablaInc = new Table(UnitValue.createPercentArray(headerWidths)).useAllAvailableWidth();
        Cell titInc = new Cell(1,4)
                .add(new Paragraph("Incidencia"))
                .setHorizontalAlignment(HorizontalAlignment.CENTER)
                .setBackgroundColor(ColorConstants.LIGHT_GRAY)
                .simulateBold();

        // Fila 1
        addCell(tablaInc, "N° Incidencia", true);
        addCell(tablaInc, "556", false);
        addCell(tablaInc, "Comunica la incidencia: ", true);
        addCell(tablaInc, "CRRC-MC", false);

        // Fila 2
        addCell(tablaInc, "Incidencia abierta el:", true);
        addCell(tablaInc, "23/06/2025", false);
        addCell(tablaInc, "Tecnica:", true);
        addCell(tablaInc, "CBTC", true);

        // Fila 3
        addCell(tablaInc, "", true);
        addCell(tablaInc, "", false);
        addCell(tablaInc, "Sistema", true);
        addCell(tablaInc, "Señalizacion", false);


        document.close();
        System.out.println("PDF Creado Exitosamente");
    }

    // Helper para añadir celdas rápido
    private static void addCell(Table table, String text, boolean isHeader) {
        Cell cell = new Cell().add(new Paragraph(text));
        if (isHeader) {
            cell.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        }
        table.addCell(cell);
    }
}
