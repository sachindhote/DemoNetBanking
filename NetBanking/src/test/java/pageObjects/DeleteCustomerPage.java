package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	
	static WebDriver driver;
	public DeleteCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Delete Customer']")
	WebElement linkDeletCustomer;
	
	@FindBy(xpath="//input[@name='cusid']")
	WebElement txtCustomerID;

	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement btnSubmit;

	@FindBy(xpath="//input[@name='res']")
	WebElement btnReset;

	public void clickDeleteCustomer() {
		linkDeletCustomer.click();
	}
	
	public void enterCustomerID(String custID) {
		txtCustomerID.sendKeys(custID);
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}


}
