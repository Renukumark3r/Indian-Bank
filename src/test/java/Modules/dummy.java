package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibraries.UtilityMethod;
import genericLibraries.login;

public class dummy {


	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		ChromeDriver d=new ChromeDriver(op);
		login lg=new login(d);
		d.get("https://192.9.200.27:2322/IB_12_4/login.htm");
		d.manage().window().maximize();
		lg.getUsername().sendKeys(UtilityMethod.getproperty("UN"));
		lg.getpassword().sendKeys(UtilityMethod.getproperty("PWD"));
		lg.loginbt().click();
		Thread.sleep(3000);
		try {
			Alert al= d.switchTo().alert();
		     al.accept();
             System.out.println("Alert found: " + al.getText());

		} catch(NoAlertPresentException e) {
		System.out.println("No alert appeared.");}
		Thread.sleep(3000);
	 	lg.Masterbt().click();
 		Thread.sleep(3000);
 		lg.auditeebt().click();
 		d.findElement(By.xpath("//h4[@class='cls_sidebar_menu_text' and contains(.,'Module Mapping')]")).click();
        d.findElement(By.xpath("//input[@id='searchid']")).sendKeys("121125");
    	List<WebElement> Module =d.findElements(By.xpath("//div[@class='search']//ul"));Thread.sleep(3000);
    	for(WebElement mod:Module) {
    		if(mod.getText().contains("121125"))
    		{
    			mod.click();
    			break;
    			}
          }
        List<WebElement> modulelst=d.findElements(By.xpath("//tbody[@class='sticky_tbody']/tr"));Thread.sleep(3000);
        	for(WebElement row:modulelst) {Thread.sleep(3000);
        		if(row.getText().contains("Risk")) {
        			WebElement radio =row.findElement(By.xpath(".//input[contains(@id,'checkFlag')]"));
        			radio.click();
        			break;
        		}Thread.sleep(3000);
        	}
        	d.findElement(By.xpath("//button[@type='button' and contains(.,'SAVE')]")).click();
        	//System.out.println("Module mapping done");
        
    	
	}
}