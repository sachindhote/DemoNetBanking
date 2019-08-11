package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountPage {

	public static WebDriver driver;
	
	public DeleteAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Delete Account']")
	WebElement linkDeleteAccount;
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtAccountNumber;
	
	@FindBy(xpath="//a[text()='Delete Account']")
	WebElement buttonSubmit;
	
	
	public void clickDeleteAccounnLink() {
		linkDeleteAccount.click();
	}
	
	public void enterAccountNumber(String acctNo) {
		txtAccountNumber.sendKeys(acctNo);
	}
	 
	public void clickSubmitButton() {
		buttonSubmit.click();
	}
		
	
}
