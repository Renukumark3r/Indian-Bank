package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		lg.getUsername().sendKeys("COUSER26");
		lg.getpassword().sendKeys("1234");
		lg.loginbt().click();
		Thread.sleep(3000);
		try {
			Alert al= d.switchTo().alert();
		     al.accept();
             System.out.println("Alert found: " + al.getText());

		} catch(NoAlertPresentException e) {
		System.out.println("No alert appeared.");}
		Thread.sleep(3000);
		List<WebElement> modules = d.findElements(By.xpath("//div[@class='cls_ms_box_wrap']"));

		for (WebElement mod : modules) {
		    String name = mod.getText().trim();
		   // System.out.println(name);
		    if (name.contains("Management")) {
		        mod.click();
		        break;
		    }
		
	 	}
        	List<WebElement> submod=d.findElements(By.xpath("//a[@class='userhomehref']"));
		   

        	for(WebElement sub:submod) {
        		String mod1=sub.getText().trim(); 
    		    //System.out.println(mod1);
        		if(mod1.contains("Management Audit - Zone")) {
        			sub.click();
        			break;
        		}
        	}
        	
        	d.findElement(By.xpath("//div[@class='cls_menu_level1_options' and contains(.,'Audit')]")).click();
        	d.findElement(By.xpath("//a[text()='Audit Schedule']")).click();Thread.sleep(3000);
        	d.findElement(By.xpath("//input[@id='auditDue']")).sendKeys("100");
        	d.findElement(By.xpath("//button[text()='Generate']")).click();
        	d.findElement(By.xpath("//input[@id='searchid']")).sendKeys("0825");
        	Thread.sleep(500); 
        	List<WebElement> search=d.findElements(By.xpath("//div[@class='search']//ul[@class='listitem']/li"));
        	
        	Thread.sleep(2000);
        	
        	for(WebElement sea:search) {
        		if(sea.getText().equalsIgnoreCase("0825-TRIVANDURM")) {
        			sea.click();
        			break;
        		}
        	}
        	WebElement radio=d.findElement(By.xpath("//input[@class='rowChkBox']"));
        	radio.click();
        	// Click the search field
        	
        	
	}
}