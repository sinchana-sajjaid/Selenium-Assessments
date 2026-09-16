package AdvancedSeleniumDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Homepage {
    WebDriver driver;
    public Homepage(WebDriver driver){ this.driver=driver; }
    public void getRecruitment() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Recruitment']")).click(); Thread.sleep(2000);
    }
    public void getLogoutButton() throws InterruptedException {
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click(); Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Logout']")).click(); Thread.sleep(1500);
    }
}
