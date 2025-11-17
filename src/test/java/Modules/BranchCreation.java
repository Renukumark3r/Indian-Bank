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

public class BranchCreation {


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
		lg.branchbt().click();
		lg.addbrnchbt().click();
		lg.branchcd().sendKeys(UtilityMethod.getproperty("BRCODE"));
		lg.branchname().sendKeys(UtilityMethod.getproperty("BRNAME"));
		Select branch = new Select(lg.brtype());
		branch.selectByValue("MAIN");
		lg.addredss().sendKeys(UtilityMethod.getproperty("Address"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,500)");
		lg.bscode().sendKeys(UtilityMethod.getproperty("BSR"));
		lg.datecal().click();
		
		// Select Year
		Thread.sleep(3000);
		Select year = new Select (lg.selyear());
		year.selectByVisibleText(UtilityMethod.getproperty("YEAR"));
		Thread.sleep(3000);
		// Select Month
		Select month = new Select(lg.selmonth());
		month.selectByVisibleText(UtilityMethod.getproperty("MONTH"));

		// Select Day
		List<WebElement> day = lg.seldate();
	
	for(WebElement dd: day) {
		if(dd.getText().equalsIgnoreCase(UtilityMethod.getproperty("DAY"))) {
			dd.click();
			break;
		}
	}
	  Select BRType =new Select(lg.catagr());
		BRType.selectByVisibleText(UtilityMethod.getproperty("BRTYPE"));
		Select RBIAtype=new Select(lg.rbiatyp());
		RBIAtype.selectByVisibleText(UtilityMethod.getproperty("RBIATYPE"));
		lg.citytyp().sendKeys(UtilityMethod.getproperty("CITY"));
		lg.pincode().sendKeys(UtilityMethod.getproperty("PINCODE"));
		js.executeScript("window.scrollBy(0,500)");
		lg.statedt().click();
		Thread.sleep(3000);
		
		List<WebElement> State = lg.liststs();	Thread.sleep(3000);

		 for(WebElement st:State)
		 {
			 if(st.getText().equalsIgnoreCase(UtilityMethod.getproperty("STATE"))) {
				 st.click();
					 break;
			 }
		 }
		 Thread.sleep(3000);
		
			
			  lg.distric().click();
			  List<WebElement>District = lg.ditlist();
			  
			  for(WebElement DI:District) { 
				  if(DI.getText().contains(UtilityMethod.getproperty("DISTRICT")))
				  { 
					  DI.click();
			  break;
			  } } 
			  Thread.sleep(3000);
			    lg.email().sendKeys(UtilityMethod.getproperty("EMAIL"));
			  Thread.sleep(3000);
			  Select Foreign = new Select(lg.ForeignEXC());
			  Foreign.selectByVisibleText(UtilityMethod.getproperty("FOREIGN"));
			  lg.fromdt().sendKeys(UtilityMethod.getproperty("FROM"));
			  lg.todt().sendKeys(UtilityMethod.getproperty("TO"));
			  Select Weekly=new Select(lg.Week());
			  Weekly.selectByVisibleText(UtilityMethod.getproperty("WEEK"));
			  Thread.sleep(3000); 
			 
			 lg.Attach().click();
			  Thread.sleep(3000);
			  List<WebElement> Attached = lg.Attachlst();
			  for(WebElement AT:Attached)
			  {
				  if(AT.getText().contains(UtilityMethod.getproperty("ATTACH")))
			  { AT.click();
			  break; } }
			  
			  Thread.sleep(3000);
		    lg.Branchca().click();
		     List<WebElement>Category = lg.Branchlst();
		     for(WebElement CA:Category )
		     {
		    	 if(CA.getText().contains(UtilityMethod.getproperty("CATE")))
		    	 {CA.click();
	}
		    	// lg.savebty() .click();
		   

}
	}

}
