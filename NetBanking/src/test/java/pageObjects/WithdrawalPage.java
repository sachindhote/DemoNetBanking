package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WithdrawalPage {
	
public static WebDriver driver;
	
	public WithdrawalPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Withdrawal']")
	WebElement clickDeposit;
	
	@FindBy(xpath="//input[@name='accountno']")
	WebElement txtAccountNo;
	
	@FindBy(xpath="//input[@name='ammount']")
	WebElement txtAmount;
	
	@FindBy(xpath="//input[@name='desc']")
	WebElement txtDescription;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;
	
	
	public void clickWithdrawLink() {
		clickDeposit.click();
	}
	
	public void enterAccountNo(String acctno) {
		txtAccountNo.sendKeys(acctno);
	}
	
	public void enterWithdrawAmount(String depoamt) {
		txtAmount.sendKeys(depoamt);
	}
	
	public void enterDescription(String desc) {
		txtDescription.sendKeys(desc);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
