package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericLibraries.UtilityMethod;
import genericLibraries.login;

public class Schedule {

	@Test
	public  void schedule() throws InterruptedException, IOException {

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
        	d.findElement(By.xpath("//input[@id='searchid']")).sendKeys("0325");
        	Thread.sleep(500); 
        	List<WebElement> search=d.findElements(By.xpath("//div[@class='search']//ul[@class='listitem']/li"));
        	
        	Thread.sleep(2000);
        	
        	for(WebElement sea:search) {
        		if(sea.getText().equalsIgnoreCase("0325-NAVALUR")) {
        			sea.click();
        			break;
        		}
        	}

        	List<WebElement> rows = d.findElements(By.xpath("//tr[contains(@class,'Rows')]"));
        	System.out.println("Rows count: " + rows.size());
        	for(WebElement lstrows:rows) {
        		if(lstrows.getText().equalsIgnoreCase("0325-NAVALUR")) {
        			WebElement checkbox = lstrows.findElement(By.xpath(".//input[@type='checkbox']"));
        			
        			Thread.sleep(500);
        			checkbox.click();
        		}
        	}
        	for(WebElement lstrows:rows) {
                if(lstrows.getText().equalsIgnoreCase("0325-NAVALUR")) {
    			WebElement checkbox = lstrows.findElement(By.xpath(".//a[@title='Team Leader']//i"));
    			Thread.sleep(500);
    			checkbox.click();
    		}
    	}
        	//d.findElement(By.xpath("//input[@id='teamLeadFiSearch']")).sendKeys("1515");
         	List<WebElement> lsttl = d.findElements(By.xpath(".//ul[@class='listitem']/li"));Thread.sleep(1000);
        	System.out.println("Rows countlsttl: " + lsttl.size());

        	for (WebElement TLlst : lsttl) {
        	    if (TLlst.getAttribute("id").equals("1515")) {
        	        System.out.println("TL: " + TLlst);
        	        TLlst.findElement(By.xpath(".//input[@type='radio']")).click();
        	        break;
        	    }
        	}
        	try {
        		
        	
        	Alert Al=d.switchTo().alert();
        	Al.accept();

        	} catch(NoAlertPresentException e) {
        		System.out.println("No alert present in Team Lead Selection.");
        	}
    		Thread.sleep(3000);

        	for(WebElement lstrows:rows) {
                if(lstrows.getText().equalsIgnoreCase("0325-NAVALUR")) {
        	WebElement FromDate = lstrows.findElement(By.xpath(".//input[contains(@id,'fromDate')]"));
			((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", FromDate);
			FromDate.click();
			//d.findElement(By.xpath("//a[text()='13']")).click();

                }
        	}
        	Actions a = new Actions(d);
    		a.sendKeys(Keys.ENTER).perform();
    		d.findElement(By.xpath("//button[@onclick='saveData();']")).click();
    		System.out.println("Schedule save sucessfully " );
        	
        	
        	
    		By logoutBtn = By.xpath("//img[@title='Logout']");
    		By modal = By.id("modallogininfo");

    		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));

    		// wait until modal disappears (if present)
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(modal));

    		// re-find and click
    		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
    		((JavascriptExecutor) d).executeScript("arguments[0].click();", logout);
    		Alert alert = d.switchTo().alert();
        	System.out.println(alert.getText());
        	alert.accept();
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
	}
}