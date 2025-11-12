package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericLibraries.UtilityMethod;

public class BranchCreation {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions op=new ChromeOptions();
		op.setAcceptInsecureCerts(true);
		ChromeDriver d=new ChromeDriver(op);
		d.get("https://192.9.200.27:2322/IB_12_4/login.htm");
		d.findElement(By.xpath("//input[@id='userid']")).sendKeys(UtilityMethod.getproperty("UN"));
		d.findElement(By.xpath("//input[@type='password']")).sendKeys(UtilityMethod.getproperty("PWD"));
		d.findElement(By.xpath("//button[@type='button']")).click();

		Thread.sleep(3000);
		d.findElement(By.xpath("//img[@title='Master']")).click();
		Thread.sleep(3000);
		d.findElement(By.xpath("//h4[@class='cls_sidebar_menu_text' and contains(., 'Auditee')]")).click();
		//d.findElements(By.partialLinkText("listbranch.htm?menuOptId=501"))
		WebElement branchMaster = d.findElement(By.linkText("Branch Master"));
		branchMaster.click();
		d.findElement(By.xpath("//button[@onclick='addbranch();']")).click();
		d.findElement(By.xpath("//input[@id='brancd']")).sendKeys(UtilityMethod.getproperty("BRCODE"));
		d.findElement(By.xpath("//input[@id='brannm']")).sendKeys(UtilityMethod.getproperty("BRNAME"));
		Select branch = new Select(d.findElement(By.xpath("//select[@id='mainCd']")));
		branch.selectByValue("MAIN");
		d.findElement(By.xpath("//input[@id='address1']")).sendKeys(UtilityMethod.getproperty("Address"));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("window.scrollBy(0,500)");
		d.findElement(By.xpath("//input[@id='bsrcode']")).sendKeys(UtilityMethod.getproperty("BSR"));
		d.findElement(By.xpath("//input[@id='opendate']")).click();
		/*
		 * WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
		 * "ui-datepicker-calendar")));
		 */

		// Select Year
		Thread.sleep(3000);
		Select year = new Select(d.findElement(By.xpath("//select[@title='Change the year']")));
		year.selectByVisibleText(UtilityMethod.getproperty("YEAR"));
		Thread.sleep(3000);
		// Select Month
		Select month = new Select(d.findElement(By.xpath("//select[@title='Change the month']")));
		month.selectByVisibleText(UtilityMethod.getproperty("MONTH"));

		// Select Day
	List<WebElement> day = d.findElements(By.xpath("//div[@class='datepick-month']//tbody//td"));
	
	for(WebElement dd: day) {
		if(dd.getText().equalsIgnoreCase(UtilityMethod.getproperty("DAY"))) {
			dd.click();
			break;
		}
	}
		Select BRType =new Select(d.findElement(By.xpath("//select[@id='catogry']")));
		BRType.selectByVisibleText(UtilityMethod.getproperty("BRTYPE"));
		Select RBIAtype=new Select(d.findElement(By.xpath("//select[@id='rbiaType']")));
		RBIAtype.selectByVisibleText(UtilityMethod.getproperty("RBIATYPE"));
		d.findElement(By.xpath("//input[@id='city']")).sendKeys(UtilityMethod.getproperty("CITY"));
		d.findElement(By.xpath("//input[@id='pinNum']")).sendKeys(UtilityMethod.getproperty("PINCODE"));
		d.findElement(By.xpath("//tr[@id='st']//i")).click();
		Thread.sleep(3000);
		
		 List<WebElement> State = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li"));		Thread.sleep(3000);

		 for(WebElement st:State)
		 {
			 if(st.getText().equalsIgnoreCase(UtilityMethod.getproperty("STATE"))) {
				 st.click();
					 break;
			 }
		 }
		 Thread.sleep(3000);
		
			
			  d.findElement(By.xpath("//tr[@id='dist']//i")).click();
			  List<WebElement>District = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li"));
			  
			  for(WebElement DI:District) { 
				  if(DI.getText().contains(UtilityMethod.getproperty("DISTRICT")))
				  { 
					  DI.click();
			  break;
			  } } 
			  Thread.sleep(3000);
			  d.findElement(By.xpath("//input[@id='email']")).sendKeys(UtilityMethod.getproperty("EMAIL"));
			  Thread.sleep(3000);
			  Select Foreign = new Select(d.findElement(By.xpath("//select[@id='forEx']")));
			  Foreign.selectByVisibleText(UtilityMethod.getproperty("FOREIGN"));
			 d.findElement(By.xpath("//input[@id='fromval']")).sendKeys(UtilityMethod.getproperty("FROM"));
			  d.findElement(By.xpath("//input[@id='toval']")).sendKeys(UtilityMethod.getproperty("TO"));
			  Select Weekly=new Select(d.findElement(By.xpath("//select[@id='wklyFull']")));
			  Weekly.selectByVisibleText(UtilityMethod.getproperty("WEEK"));
			  Thread.sleep(3000); 
			
			  d.findElement(By.xpath("//tr[@id='zo']//i")).click();
			  Thread.sleep(3000);
			  List<WebElement> Attached = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li"));
			  for(WebElement AT:Attached)
			  {
				  if(AT.getText().contains(UtilityMethod.getproperty("ATTACH")))
			  { AT.click();
			  break; } }
			  
			  Thread.sleep(3000);
		     d.findElement(By.xpath("//tr[@id='bc']//i")).click();
		     List<WebElement>Category = d.findElements(By.xpath("//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li"));
		     for(WebElement CA:Category )
		     {
		    	 if(CA.getText().contains(UtilityMethod.getproperty("CATE")))
		    	 {CA.click();
	}
		    	// d.findElement(By.xpath("//button[@type='button' and contains(@onclick,'saveBranch') ]")).click();
		 	//d.close();

}}}
