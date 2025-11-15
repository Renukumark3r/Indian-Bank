package genericLibraries;

import java.util.List;

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
	
	@FindBy(linkText="Branch Master")
	private WebElement branch;
	
	@FindBy(xpath="//button[@onclick='addbranch();']")
	private WebElement addbranch;
	
	@FindBy(xpath="//input[@id='brancd']")
	private WebElement brcode;
	
	@FindBy(xpath="//input[@id='brannm']")
	private WebElement brname;
	
	@FindBy(xpath="//select[@id='mainCd']")
	private WebElement brtyp;
	
	@FindBy(xpath="//input[@id='address1']")
	private WebElement addre;
	
	@FindBy (xpath="//input[@id='bsrcode']")
	private WebElement bsrcode;
	
	@FindBy(xpath="//input[@id='opendate']")
	private WebElement opendate;
	
	@FindBy (xpath="//select[@title='Change the year']")
	private WebElement year;
	
	@FindBy (xpath="//select[@title='Change the month']")
	private WebElement month;
	
	@FindBy(xpath="//div[@class='datepick-month']//tbody//td")
	private List<WebElement> date;
	
	@FindBy(xpath="//select[@id='catogry']")	
	private WebElement catagry;
	
	@FindBy(xpath="//select[@id='rbiaType']")
	private WebElement RBIA;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement CITY;
	
	@FindBy(xpath="//input[@id='pinNum']")
	private WebElement PIN;
	
	@FindBy(xpath="//tr[@id='st']//i")
	private WebElement state;
	
	@FindBy(xpath="//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li")
	private List<WebElement> listst;
	
	@FindBy(xpath="//tr[@id='dist']//i")
	private WebElement dist;
	
	@FindBy(xpath="//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li")
	private List <WebElement> distlst;
	
	@FindBy (xpath="//input[@id='email']")
	private WebElement mail;
	
	@FindBy (xpath="//select[@id='forEx']")
	private WebElement Foreign;
	
	@FindBy(xpath="//input[@id='fromval']")
	private WebElement from;
	
	@FindBy(xpath="//input[@id='toval']")
	private WebElement To;
	
	@FindBy (xpath="//select[@id='wklyFull']")
	private WebElement Weekly;
	
	@FindBy(xpath="//tr[@id='zo']//i")
	private WebElement Attached;
	
	@FindBy(xpath="//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li")
	private List<WebElement> Attachedlst;
	
	@FindBy(xpath="//tr[@id='bc']//i")
	private WebElement Branchcat;
	
	@FindBy(xpath="//div[@class='popupcontent p-b-b']//ul[@class='listitem']/li")
	private List<WebElement> Branchcatlst;
	
	@FindBy(xpath="//button[@type='button' and contains(@onclick,'saveBranch') ]")
	private WebElement save;
	
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
	
    public WebElement branchbt() {
    	return branch;
    	
    }
    
    public WebElement addbrnchbt() {
    	return addbranch;
    }
    
    public WebElement branchcd() {
    	return brcode;
    }

    public WebElement branchname() {
    	return brname;
    }
    public WebElement brtype() {
    	return brtyp;
    }
    public WebElement addredss() {
    	return addre;
    }
	public WebElement bscode() {
		return bsrcode;
	}
	public WebElement datecal() {
		return opendate;
	}
	public WebElement selyear() {
		return year;
	}
	public WebElement selmonth() {
		return month;
	}
	public List<WebElement> seldate() {
		return date;
	}
	public WebElement catagr() {
		return catagry;
	}
	public WebElement rbiatyp() {
		return RBIA;
	}
	public WebElement citytyp() {
		return CITY;
	}
	public WebElement pincode() {
		return PIN;
	}
	public WebElement statedt(){
		return state;
	}
	public List<WebElement> liststs(){
		return listst;
	}
	public WebElement distric() {
	 return dist;
	}
	public List<WebElement> ditlist() {
		return distlst;
	}
	public WebElement email() {
		return mail;
	}
	public WebElement ForeignEXC() {
		return Foreign;
	}
	public WebElement fromdt() {
		return from;
	}
	public WebElement todt() {
		return To;
	}
	public WebElement Week() {
		return Weekly;
	}
	public WebElement Attach() {
		return Attached;
	}
	public List<WebElement> Attachlst() {
		return Attachedlst;
	}
	public WebElement Branchca() {
		return Branchcat;
	}
	public List<WebElement> Branchlst(){
		return Branchcatlst;
	}
	public WebElement savebty() {
		return save;
	}
}
