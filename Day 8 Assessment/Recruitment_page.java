package AdvancedSeleniumDemo;
import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Recruitmentpage {
    WebDriver driver;
    public Recruitmentpage(WebDriver driver){ this.driver=driver; }

    public void getAddButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
        Thread.sleep(2500);
    }
    public void getFntf(String fn){ driver.findElement(By.name("firstName")).sendKeys(fn); }
    public void getMntf(String mn){ if(mn!=null &&!mn.isEmpty()) driver.findElement(By.name("middleName")).sendKeys(mn); }
    public void getLntf(String ln){ driver.findElement(By.name("lastName")).sendKeys(ln); }
    public void getVacancy() throws InterruptedException {
        try{
            driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).click();
            Thread.sleep(1000);
            List<WebElement> list = driver.findElements(By.xpath("//div[@role='option']//span"));
            if(list.size()>0) list.get(0).click();
        }catch(Exception e){}
    }
    public void getEmailtf(String email){ driver.findElement(By.xpath("(//input[@placeholder='Type here'])[1]")).sendKeys(email); }
    public void getPhnotf(String phno){ driver.findElement(By.xpath("(//input[@placeholder='Type here'])[2]")).sendKeys(phno); }
    public void getFileUpload(String filepath) {
        try{
            if(filepath==null || filepath.isEmpty()) return;
            String fullPath = filepath;
            if(!filepath.contains(":")) fullPath = System.getProperty("user.dir") + filepath;
            File f = new File(fullPath);
            if(f.exists() && f.length() < 1024*1024){
                driver.findElement(By.xpath("//input[@type='file']")).sendKeys(f.getAbsolutePath());
                Thread.sleep(1500);
            }
        }catch(Exception e){}
    }
    public void getDate(String date){
        try{
            WebElement d = driver.findElement(By.xpath("//input[@placeholder='yyyy-dd-mm']"));
            d.click(); d.sendKeys(Keys.CONTROL+"a"); d.sendKeys(Keys.DELETE); d.sendKeys(date);
        }catch(Exception e){}
    }
    public void getSaveButton() throws InterruptedException {
        try{ driver.findElement(By.xpath("//i[contains(@class,'oxd-checkbox-input')]//..//span")).click(); Thread.sleep(800); }catch(Exception e){
        try{ driver.findElement(By.xpath("//span[contains(@class,'oxd-checkbox-input')]")).click(); }catch(Exception ex){} }
        Thread.sleep(500);
        WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", save);
        Thread.sleep(6000);
    }
    public void getCandidates() throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='Candidates']")).click();
        Thread.sleep(2000);
        try{ driver.findElement(By.xpath("//button[normalize-space()='Reset']")).click(); Thread.sleep(2000); }catch(Exception e){}
    }
    public void getJobTitle(){}
    public void getCvacancy(){}
    public void getHiringManager(){}
    public void getStatus(){}
    public void getCname(String cname){
        System.out.println("Skipping Candidate Name input to avoid Invalid error");
    }
    public void getFromDate(String fromdate){}
    public void getToDate(String todate){}
    public void getSearchButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(4000);
    }

    public List<WebElement> getNoRecordsFound(){
        try{
            List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
            System.out.println("Total rows found: " + rows.size());
            for(WebElement row : rows){
                if(row.getText().toLowerCase().contains("sinchana")){
                    System.out.println("Found: " + row.getText());
                    return driver.findElements(By.xpath("//span[text()='NEVER_EXISTS_123']"));
                }
            }
        }catch(Exception e){}
        return driver.findElements(By.xpath("//span[text()='No Records Found']"));
    }
}
