package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import genericLibraries.UtilityMethod;
import genericLibraries.login;

public class dummy {

	
	public static void main(String[] args)  throws InterruptedException, IOException {

		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		ChromeDriver d=new ChromeDriver(op);
		login lg=new login(d);
		d.get("https://192.9.200.27:2322/IB_12_4/login.htm");
		d.manage().window().maximize();
		lg.getUsername().sendKeys("1515");
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
        	d.findElement(By.xpath("//input[@id='branchsearch']")).sendKeys("ZONE001");
        	Thread.sleep(500); 
        	List<WebElement> lsbranch=d.findElements(By.xpath("//tbody[@class='sticky_tbody']//a"));
        	for(WebElement lsbranchs:lsbranch) {
        		if(lsbranchs.getText().equalsIgnoreCase("ZONE001-VELACHERY")) {
        			lsbranchs.click();
        			break;
        		}
        	}
        	
        	// Audit Observation 
        	
        	/*d.findElement(By.xpath("//img[@title='Audit']")).click();
        	d.findElement(By.xpath("//a[contains(@href,'transauditauthorization.htm')]")).click();
        	d.findElement(By.xpath("//input[@id='selectallpts']")).click();
        	d.findElement(By.xpath("//button[@id='saveaudpts']")).click();
        	d.findElement(By.xpath("//img[@title='Audit']")).click();
        	d.findElement(By.xpath("//a[@href='listwrapupaudit.htm?wrap=A&menuOptId=106&webServiceFlg=null']")).click();
        	d.findElement(By.xpath("//button[@id='savebtn']")).click();*/
        	d.findElement(By.xpath("//img[@title='Audit']")).click();
        	
        	
        	//d.findElement(By.xpath("//a[text()='Audit Mandays Updation']")).click();
        	
        	
        	}
}