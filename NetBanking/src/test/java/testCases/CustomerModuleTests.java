package testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pageObjects.AddCustomerPage;
import pageObjects.DeleteCustomerPage;
import pageObjects.EditCustomerPage;
import pageObjects.LoginPage;

public class CustomerModuleTests extends BaseClass{
	
	public static String custID;
	
	@Test(enabled=true, priority=1)
	public void loginTest() throws InterruptedException, IOException{
			
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}
	
	@Test(enabled=true, priority=2)
	public void linkCountTest() throws InterruptedException{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		Thread.sleep(1000);
		logger.info("Manager Page Links Test Started");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Number of links on webpage: " + links.size());
		
		if(links.size()==48) {
			Assert.assertTrue(true);
			logger.info("Links Count Test PAssed");
			Thread.sleep(1000);
		}else {
			Assert.fail();
			logger.info("Links Count Test Failed");
		}
		
		
	}

	@Test(enabled=true, priority=3)
	public void addNewCustomer() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName(BaseClass.randomeString());
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		logger.info("validation started....");
		Thread.sleep(3000);
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			custID=driver.findElement(By.xpath("//tbody//td[text()='Customer ID']/following-sibling::td")).getText();
			System.out.println(custID);
			logger.info("Add New Customer test case passed....");
		}
		else
		{
			logger.info("Add New Customer test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled=true, priority=4)
	public void editCustomer() throws InterruptedException, IOException{
		
		logger.info("Edit New customer Test case started");
		
		//create object of EditCustomerPage
		LoginPage lp=new LoginPage(driver);
		EditCustomerPage editcust=new EditCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		//click on Edit customer
		editcust.clickEditCustomer();
		logger.info("Clicked on Edit Customer link");
		editcust.enterCustomerID(custID);
		logger.info("Customer ID Entered");
		Thread.sleep(100);
		editcust.clickSubmit();
				
		editcust.custaddress("Shree Nagar");
		editcust.custcity("wardha");
		editcust.custstate("Maharshtra");
		editcust.custpinno("440026");
		editcust.custtelephoneno(String.valueOf("8888888888"));
		editcust.custemailid(randomestring()+"@gmail.com");
		
		editcust.clickEditSubmit();
		Thread.sleep(1000);
		
		boolean res=driver.getPageSource().contains("Customer details updated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Edit Customer test case passed....");
			
		}
		else
		{
			logger.info("Edit Customer test case failed....");
			captureScreen(driver,"EditNewCustomer");
			Assert.assertTrue(false);
		}
	}

	
	@Test(enabled=true, priority=10)
	public void deleteCustomer() throws InterruptedException, IOException{
		logger.info("Delete Customer Test Case started");
		LoginPage lp=new LoginPage(driver);
		DeleteCustomerPage deletecust=new DeleteCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		logger.info("Customer Login Successfully");
		
		//click on delete customer link
		deletecust.clickDeleteCustomer();
		Thread.sleep(1000);
		
		deletecust.enterCustomerID(custID);
		deletecust.clickSubmit();
		logger.info("Customer ID entered and clicked on Submit button");
		
		driver.switchTo().alert().accept();
		logger.info("First alert closed");
		Thread.sleep(1000);
		
		String alertMessage=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		logger.info("Second alert closed");
		logger.info("First alert :" + alertMessage);
		
		if(alertMessage.equalsIgnoreCase("Customer deleted Successfully")) {
			Assert.assertTrue(true);
			logger.info("Customer delete Test Case Passed");
			
		}else {
			Assert.fail();
			logger.info("Customer delete Test Case Failed");
			captureScreen(driver,"DeleteCustomer");
		}
		
		
	}

	
	
}
