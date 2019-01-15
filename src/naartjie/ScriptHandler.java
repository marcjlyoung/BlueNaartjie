/**
 *  Version: 1.0
 * 	Class: ScriptHandler
 * 	Description: Handles script creation
 * 	Developers: Marc Young & Randall Varden
 * 	Group: The Wild Cucumbers
 */

package naartjie;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class ScriptHandler 
{
	
	//Methods
	
	//Creates new scriptPDF
	public void createScript(String pNo, String pName, String patient, String drugs, String instructions, String doctor) 
	{
		Document document = new Document();
		try 
		{	
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			PdfWriter.getInstance(document, new FileOutputStream(pNo+"-"+pName + "-script-"+dateFormat.format(date)+".pdf"));
			Font font = FontFactory.getFont(FontFactory.COURIER, 24, BaseColor.BLUE);
			Font font2 = FontFactory.getFont(FontFactory.COURIER, 18, BaseColor.BLUE);
			Font font3 = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		    
		    
		    document.open();
		    document.add(new Paragraph("Medical Management Suite Script", font));
		    LineSeparator ls = new LineSeparator();
		    document.add(new Chunk(ls));
		    document.add(new Paragraph("Doctor", font3));
		    document.add(new Paragraph(doctor, font3));
		    document.add(Chunk.NEWLINE);
		    document.add(new Paragraph("Today's Date: \n"+ dateFormat.format(date), font3));
		    document.add(Chunk.NEWLINE);
		    document.add(new Paragraph("Patient Number: \n" + pNo, font3));
		    document.add(Chunk.NEWLINE);
		    document.add(new Paragraph("Patient: \n" + patient, font3));
		    document.add(new Chunk(ls));
		    document.add(new Paragraph("Perscribed Medication:" , font2));
		    document.add(new Chunk(ls));
		    document.add(new Paragraph(drugs, font3));
		    document.add(new Chunk(ls));
		    document.add(new Paragraph("Dosage Instructions:",font2));
		    document.add(new Chunk(ls));
		    document.add(new Paragraph(instructions,font3));
		    document.add(new Chunk(ls));
		    document.add(new Paragraph("Firm Stamp:",font2));
		    document.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (DocumentException e) 
		{
			JOptionPane.showMessageDialog(null,"Please close the script in order to overwrite it","Script Open",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
