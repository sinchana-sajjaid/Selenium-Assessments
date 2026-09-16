package AdvancedSeleniumDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Loginpage {
    WebDriver driver;
    public Loginpage(WebDriver driver){ this.driver=driver; }
    public void getUntf(String un){ driver.findElement(By.name("username")).sendKeys(un); }
    public void getPwdtf(String pwd){ driver.findElement(By.name("password")).sendKeys(pwd); }
    public void getLoginButton(){ driver.findElement(By.xpath("//button[@type='submit']")).click(); }
}
