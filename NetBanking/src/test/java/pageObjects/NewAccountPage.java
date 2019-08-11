package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	
static WebDriver driver;
	
	public NewAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[text()='New Account']"))
	WebElement linkNewAccount;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtcustID;
	
	@FindBy(xpath="//Select[@name='selaccount']")
	WebElement dropAccountType;

	@FindBy(xpath="//input[@name='inideposit']")
	WebElement txtdeposit;
	
	@FindBy(xpath="//input[@name='button2']")
	WebElement btnSubmit;
	
	public void clickNewAccount() {
		linkNewAccount.click();
	}
	
	public void enterCustomerID(String custid) {
		txtcustID.sendKeys(custid);
	}
	
	public void selectAccountType(String acctType) {
		Select dropdown=new Select(dropAccountType);
		//dropdown.selectByVisibleText(acctType);
		dropdown.selectByValue(acctType);
	}
	
	public void enterDeposit(String deposit) {
		txtdeposit.sendKeys(deposit);
	
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}