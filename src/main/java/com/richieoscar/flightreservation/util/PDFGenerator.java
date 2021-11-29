package com.richieoscar.flightreservation.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.richieoscar.flightreservation.model.Reservation;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@Component
public class PDFGenerator {


    public void generateItenary(Reservation reservation, String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Phrase("FLIGHT ITENARY"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("FLIGHT DETAILS"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Airline");
        table.addCell(reservation.getFlight().getOperatingAirlines());

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());

        table.addCell("Departure Date");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());

        table.addCell("Estimated Departure Date");
        table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

        //passenger info

        cell = new PdfPCell(new Phrase("PASSENGER DETAILS"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirsName());

        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());

        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());
        table.addCell("Phone Number");
        table.addCell(reservation.getPassenger().getPhone());
        return table;

    }


}
