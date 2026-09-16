package AdvancedSeleniumDemo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Day8assessment {

    public static String getData(Sheet sh,int r,int c){
        try{
            DataFormatter df = new DataFormatter();
            if(sh.getRow(r)==null) return "";
            if(sh.getRow(r).getCell(c)==null) return "";
            return df.formatCellValue(sh.getRow(r).getCell(c)).trim();
        }catch(Exception e){ return ""; }
    }

	public static void main(String [] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/DDT/Day8TestCase1Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("un");
		String pwd = p.getProperty("pwd");
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/DDT/Day8testcase.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Sheet1");
		
		String fn = getData(sh,1,0);
		String mn = getData(sh,1,1);
		String ln = getData(sh,1,2);
		String email = getData(sh,1,3);
		String phno = getData(sh,1,4);
		String filepath = getData(sh,1,5);
		String date = getData(sh,1,6);
		String cname = getData(sh,1,7);
		String fromdate = getData(sh,1,8);
		String todate = getData(sh,1,9);
		wb.close();
		
		if(cname.isEmpty()) cname = fn+" "+ln;
		if(date.isEmpty()) date = "2026-15-09";
		
		EdgeOptions opt = new EdgeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.setExperimentalOption("excludeSwitches", new String[]{"enable-logging"});
		WebDriver driver = new EdgeDriver(opt);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Loginpage login = new Loginpage(driver);
		Homepage homepage = new Homepage(driver);
		Recruitmentpage rec = new Recruitmentpage(driver);
		
		driver.get(url);
		Thread.sleep(3000);
		
		login.getUntf(un);
		login.getPwdtf(pwd);
		login.getLoginButton();
		Thread.sleep(3000);
		
		homepage.getRecruitment();
		rec.getAddButton();
		rec.getFntf(fn);
		rec.getMntf(mn);
		rec.getLntf(ln);
		rec.getVacancy();
		rec.getEmailtf(email);
		rec.getPhnotf(phno);
		rec.getFileUpload(filepath);
		rec.getDate(date);
		rec.getSaveButton();
		Thread.sleep(6000);

		rec.getCandidates();
		rec.getCname(cname);
		rec.getSearchButton();
		Thread.sleep(4000);
		
		if(rec.getNoRecordsFound().size()>0)
			System.out.println("FAIL: Record not found for "+cname);
		else
			System.out.println("PASS: Record found for "+cname);
		
		Thread.sleep(2000);
    
		homepage.getLogoutButton();
		System.out.println("Logged out successfully");
		
		Thread.sleep(2000);
		driver.quit();
	}
}
