package Day10_data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CommonData {
	public String browser;
	public String url;
	public String un;
	public String pwd;
	
	public String productPage;
	public String cart;
	public String product;
	public String overviewPage;
	public String message;
	public String fn;
	public String ln;
	public String zipCode;
	
	public void data() throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Day10/commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		
		browser = p.getProperty("browser");
		url = p.getProperty("url");
		un = p.getProperty("username");
		pwd = p.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day10/specificdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);
		
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
