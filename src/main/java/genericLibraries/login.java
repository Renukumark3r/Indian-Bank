package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	
	
    private WebDriver d;
    
    

	@FindBy(xpath="//input[@id='userid']")
	private WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement Login;
  
	@FindBy(xpath="//img[@title='Master']")
	private WebElement master;
	
	@FindBy (xpath="//h4[@class='cls_sidebar_menu_text' and contains(., 'Auditee')]")
	private WebElement auditee;
	
	
    public login(WebDriver d) {
        this.d = d;
        PageFactory.initElements(d, this);

	}
    public WebElement getUsername() {
        return username;
    }
    public WebElement getpassword() {
    	return password;
    }
    
    public WebElement loginbt() {
    	return Login;
    }

    public WebElement Masterbt() {
    	return master;
    }
    public WebElement auditeebt() {
    	return auditee;
    }
	

	
}
