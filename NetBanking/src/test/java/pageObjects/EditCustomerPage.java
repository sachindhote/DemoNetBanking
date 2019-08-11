package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

	static WebDriver driver;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Edit Customer']")
	@CacheLookup
	WebElement linkEditCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtCustomerID;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;

	@FindBy(xpath="//input[@name='res']")
	WebElement btnReset;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnEditSubmit;
	
	public void clickEditCustomer() {
		linkEditCustomer.click();
	}
	
	public void enterCustomerID(String custID) {
		txtCustomerID.sendKeys(custID);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void custaddress(String caddress) {
		txtaddress.clear();
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.clear();
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.clear();
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.clear();
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.clear();
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.clear();
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.clear();
		txtpassword.sendKeys(cpassword);
	}

	public void clickEditSubmit() {
		btnEditSubmit.click();
	}
	

}
