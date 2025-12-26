package Modules;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
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
        	d.findElement(By.xpath("//input[@id='branchsearch']")).sendKeys("0825");
        	Thread.sleep(500); 
        	List<WebElement> lsbranch=d.findElements(By.xpath("//tbody[@class='sticky_tbody']//a"));
        	for(WebElement lsbranchs:lsbranch) {
        		if(lsbranchs.getText().equalsIgnoreCase("0825-TRIVANDURM")) {
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
        	Random rand =new Random();
        	List<WebElement> rows = d.findElements(By.xpath("//div[contains(@class,'checklist')]//tr"));
        	if(rows.size()==0)
        	{
        		 throw new RuntimeException("No checklist rows found");
        	}
        	// 2️⃣ Pick random row
        	WebElement randomRow = rows.get(rand.nextInt(rows.size()));

        	// 3️⃣ Select random risk (LOW / MEDIUM / HIGH)
        	WebElement riskDropdown = randomRow.findElement(By.tagName("select"));
        	Select riskSelect = new Select(riskDropdown);

        	String[] risks = {"LOW", "MEDIUM", "HIGH"};
        	String randomRisk = risks[rand.nextInt(risks.length)];
        	riskSelect.selectByVisibleText(randomRisk);
        	WebElement remarkField = randomRow.findElement(
        		    By.xpath(".//textarea | .//input[@type='text']")
        		);

        		remarkField.clear();
        		remarkField.sendKeys("Automated remark added for testing");

        		// 5️⃣ Scroll into view (optional but safe)
        		((JavascriptExecutor) d).executeScript(
        		    "arguments[0].scrollIntoView(true);", randomRow
        		);

        	}
}