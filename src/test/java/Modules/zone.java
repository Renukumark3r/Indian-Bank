package Modules;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericLibraries.UtilityMethod;
import genericLibraries.login;

public class zone {


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
 		d.findElement(By.xpath("//h4[@class='cls_sidebar_menu_text' and contains(.,'Zone Master')]")).click();		Thread.sleep(3000);

        d.findElement(By.xpath("//button[@type='button' and contains(.,'Add')]")).click();
        WebElement zoneCode = d.findElement(By.id("zoneCode"));
        zoneCode.clear();
        zoneCode.sendKeys("1222POL");

        WebElement zoneName = d.findElement(By.id("zoneName"));
        zoneName.click();         // Force focus
        Thread.sleep(500);
        zoneName.sendKeys("Polur");
        d.findElement(By.xpath("//input[@id='email']")).sendKeys("renukumat@ncssoft.in");
        d.findElement(By.xpath("//td[@class='lblval dtlData']//i")).click();Thread.sleep(3000);
        List<WebElement> ics=d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//ul[@class='listitem']//li"));
        for(WebElement ic:ics) {
        	if(ic.getText().contains("CBI")) {
        		ic.click();
        		break;
        	}
        }
        d.findElement(By.xpath("//button[@type='button' and contains(.,'SAVE')]")).click();
        		
	}
}