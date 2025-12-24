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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibraries.UtilityMethod;
import genericLibraries.login;

public class SchedulAuthorization  {


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
        	d.findElement(By.xpath("//a[text()='Audit Schedule Authorization']")).click();
        	d.findElement(By.xpath("//select[@id='zoneCode']")).click();
        	//d.findElement(By.xpath("//select[@id='zoneCode']/option[@value='0825']")).click();
        	String val="0825";
        	Select drop=new Select(d.findElement(By.xpath("//select[@id='zoneCode']")));
        	drop.selectByValue(val);
        	
        	List<WebElement> shrows = d.findElements(By.xpath("//tr[contains(@class,'Rows')]"));
        	System.out.println("Rows count: " + shrows.size());
        	for(WebElement shlstrows:shrows) {
        		if(shlstrows.getText().equalsIgnoreCase("0825-TRIVANDURM")) {
                WebElement checkbox = shlstrows.findElement(By.xpath(".//input[@type='checkbox']"));
        			
        			Thread.sleep(500);
        			checkbox.click();
        		}
        	}
    		d.findElement(By.xpath("//button[@onclick='saveData();']")).click();
    		System.out.println("Schedule authorization save sucessfully " );
   
        	/*WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));

    		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(
            	    By.xpath("//img[@title='Logout']")
            	));
            	logout.click();*/
    		//d.get("logout.htm?menuOptId=56");
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