package Day10_data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SpecificData {

	public String productPage;
	public String cart;
	public String product;
	public String overviewPage;
	public String message;
	public String fn;
	public String ln;
	public String zipCode;
	
	public void data() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Day10/specificdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		productPage = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		cart = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		product = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		fn = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		ln = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		zipCode = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		overviewPage = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		message = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
	}
}
