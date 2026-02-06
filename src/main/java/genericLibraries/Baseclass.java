package genericLibraries;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclass {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//public static WebDriver driver;
	   // public static WebDriverWait wait;

	    // Launch Browser
	    public void launchBrowser() throws InterruptedException {
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
	    }

	}


