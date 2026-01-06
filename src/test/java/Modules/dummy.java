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

        	//d.findElement(By.xpath("//img[@title='Audit']")).click();
        	//d.findElement(By.xpath("//a[text()='Audit Commencement']")).click();	Thread.sleep(5000);
        	//d.findElement(By.xpath("//input[@id='btnsubmit']")).click();Thread.sleep(5000);
        	d.findElement(By.xpath("//img[@title='Audit']")).click();
        	d.findElement(By.xpath("//a[text()='Audit Observation']")).click();
        	d.findElement(By.xpath("//input[@id='prodSelectAll']")).click();
        	d.findElement(By.xpath("//button[@id='nextbtn']")).click();
        	
        	
        	Map<String, String[]> checklistData = Map.of(
        		    "11310049", new String[]{"LOW", ""},
        		    "11310050", new String[]{"HIGH", "CIBIL verification not consistently done"},
        		    "11310051", new String[]{"MEDIUM", "Deviation from RBI guidelines observed"},
        		    "11310052", new String[]{"LOW", ""},
        		    "11310053", new String[]{"HIGH", "ROI concessions without approval"}
        		);

        		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
        		JavascriptExecutor js = (JavascriptExecutor) d;

        		List<WebElement> rows = wait.until(
        		        ExpectedConditions.presenceOfAllElementsLocatedBy(
        		                By.xpath("//table[@id='checkListTable']//tr[td]")));

        		for (WebElement row : rows) {
        		    String checklistNo = row.findElement(By.xpath("./td[1]")).getText().trim();
        		    if (!checklistData.containsKey(checklistNo)) continue;

        		    String risk = checklistData.get(checklistNo)[0];
        		    String remarks = checklistData.get(checklistNo)[1];

        		    // Select dropdown
        		    new Select(row.findElement(By.xpath(".//select[contains(@id,'irrSelect')]")))
        		            .selectByVisibleText(risk);

        		    if (risk.equalsIgnoreCase("LOW")) continue;  // Only MEDIUM/HIGH require remarks

        		    List<WebElement> popup = d.findElements(By.id("indAuditObs"));
        		    if (popup.isEmpty() || !popup.get(0).isDisplayed()) {
        		        System.out.println("Popup not opened for checklist " + checklistNo);
        		        continue;
        		    }

        		    WebElement remarksBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("auditorcomnts")));
        		    js.executeScript(
        		        "arguments[0].value=''; arguments[0].value=arguments[1];" +
        		        "arguments[0].dispatchEvent(new Event('input'));" +
        		        "arguments[0].dispatchEvent(new Event('change'));", remarksBox, remarks
        		    );

        		    WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("auditObsSave")));
        		    js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", saveBtn);
        		    wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(saveBtn)));
        		}

        	d.findElement(By.xpath("//button[@id='saveprodbtn']")).click();
        	
        	
        	
        	}
}