package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditAccountPage {

static WebDriver driver;
	
	public EditAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//a[text()='Edit Account']"))
	WebElement linkEditAccount;
	
	@FindBy(xpath=("//input[@name='accountno']"))
	WebElement txtAccountNumber;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;
	
	@FindBy(xpath="//Select[@name='a_type']")
	WebElement dropAccountType;
	
	public void clickEditAccount() {
		linkEditAccount.click();
	}
	
	public void enterAccountNumber(String acctNo) {
		txtAccountNumber.sendKeys(acctNo);
	}
	
	public void updateAccountType(String accttype) {
		Select dropdown=new Select(dropAccountType);
		//dropdown.selectByVisibleText(accttype);
		dropdown.selectByValue(accttype);
	}
	
	public void clickSubmitButton() {
		btnSubmit.click();
	}
}