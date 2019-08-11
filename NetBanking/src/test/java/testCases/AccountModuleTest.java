package testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddCustomerPage;
import pageObjects.DeleteAccountPage;
import pageObjects.DeleteCustomerPage;
import pageObjects.DepositAmount;
import pageObjects.EditAccountPage;
import pageObjects.LoginPage;
import pageObjects.NewAccountPage;
import pageObjects.WithdrawalPage;

public class AccountModuleTest extends BaseClass{
	
	public static String acctID;
	public static String transactionID;
	
	@Test(enabled=true, priority=5)
	public void addNewAccount() throws IOException, InterruptedException {
		logger.info("Add Account Test Case started");
		LoginPage lp=new LoginPage(driver);
		DeleteCustomerPage deletecust=new DeleteCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		logger.info("Customer Login Successfully");
		
		NewAccountPage acctpage=new NewAccountPage(driver);
		acctpage.clickNewAccount();
		logger.info("Clicked on NEw Account link");
		acctpage.enterCustomerID(CustomerModuleTests.custID);
		//acctpage.enterCustomerID("52577");
		logger.info("Customer ID entered");
		acctpage.selectAccountType("Savings");
		acctpage.enterDeposit(String.valueOf("50000"));
		acctpage.clickSubmit();
		logger.info("Clicked on Submit button");
		Thread.sleep(1000);
		
		boolean res=driver.getPageSource().contains("Account Generated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			acctID=driver.findElement(By.xpath("//tbody//td[text()='Account ID']/following-sibling::td")).getText();
			System.out.println(acctID);
			logger.info("Add new Account test case passed....");
			
		}
		else
		{
			logger.info("Add new Account  test case failed....");
			captureScreen(driver,"AddNewAccount");
			Assert.assertTrue(false);
		}

	}
	
	
	@Test(enabled=true, priority=6)
	public void editAccount() throws IOException, InterruptedException {
		
		logger.info("Edit Account Test Case started");
		LoginPage lp=new LoginPage(driver);
		DeleteCustomerPage deletecust=new DeleteCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		logger.info("Customer Login Successfully");
		
		
		EditAccountPage editacct=new EditAccountPage(driver);
		editacct.clickEditAccount();
		logger.info("Clicked on Edit Account link");
		editacct.enterAccountNumber(acctID);
		editacct.clickSubmitButton();
		logger.info("CLick on Submit button");
		Thread.sleep(1000);
		
		editacct.updateAccountType("Current");
		editacct.clickSubmitButton();
		Thread.sleep(1000);
		
		boolean res=driver.getPageSource().contains("Account details updated Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Edit Account test case passed....");
			
		}
		else
		{
			logger.info("Edit Account test case Failed....");
			captureScreen(driver,"EditNewAccount");
			Assert.assertTrue(false);
		}
	}	
		
	@Test(enabled=true, priority=7)
	public void depositAmount() throws IOException{
		logger.info("Deposit amount Test Case started");
		LoginPage lp=new LoginPage(driver);
		DeleteCustomerPage deletecust=new DeleteCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		logger.info("Customer Login Successfully");
		
		DepositAmount depoamt=new DepositAmount(driver);
		depoamt.clickDepositLink();
		logger.info("Deposit Link is clicked");
		
		depoamt.enterAccountNo(acctID);
		logger.info("Account Number is entered");
		
		depoamt.enterDepositAmount("5000");
		logger.info("Amount is entered");
		
		depoamt.enterDescription("amount is deposited");
		
		depoamt.clickSubmit();
		logger.info("Submit is clicked");
		
		boolean res=driver.getPageSource().contains("Transaction details of Deposit for Account "+ acctID);
		
		if(res==true)
		{
			Assert.assertTrue(true);
			transactionID=driver.findElement(By.xpath("//tbody//td[text()='Transaction ID']/following-sibling::td")).getText();
			System.out.println("Transaction ID " +transactionID );
			logger.info("Deposit AMount test case passed....");
			
		}
		else
		{
			logger.info("Deposit AMount test case Failed....");
			captureScreen(driver,"DepositAMount");
			Assert.assertTrue(false);
		}
	}
	
	@Test(enabled=true, priority=8)
	public void withdrawAmount() throws IOException{
		logger.info("Withdraw amount Test Case started");
		LoginPage lp=new LoginPage(driver);
		DeleteCustomerPage deletecust=new DeleteCustomerPage(driver);
		
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		logger.info("Customer Login Successfully");
		
		WithdrawalPage withamt=new WithdrawalPage(driver);
		withamt.clickWithdrawLink();
		logger.info("Withdraw Link is clicked");
		
		withamt.enterAccountNo(acctID);
		logger.info("Account Number is entered");
		
		withamt.enterWithdrawAmount("5000");
		logger.info("Amount is entered");
		
		withamt.enterDescription("amount is withdrawen");
		
		withamt.clickSubmit();
		logger.info("Submit is clicked");
		
		boolean res=driver.getPageSource().contains("Transaction details of Withdrawal for Account "+ acctID);
		
		if(res==true)
		{
			Assert.assertTrue(true);
			transactionID=driver.findElement(By.xpath("//tbody//td[text()='Transaction ID']/following-sibling::td")).getText();
			System.out.println("Transaction ID " +transactionID );
			logger.info("Withdraw AMount test case passed....");
			
		}
		else
		{
			logger.info("Withdraw AMount test case Failed....");
			captureScreen(driver,"DepositAMount");
			Assert.assertTrue(false);
		}
	}
	
		@Test(enabled=true, priority=9)
		public void deleteAccount() throws InterruptedException, IOException{
			logger.info("Delete Account Test Case started");
			LoginPage lp=new LoginPage(driver);
			DeleteAccountPage deleteacct=new DeleteAccountPage(driver);
			
			lp.setUserName(username);
			logger.info("User name is provided");
			lp.setPassword(password);
			logger.info("Passsword is provided");
			lp.clickSubmit();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			logger.info("Customer Login Successfully");
			
			//click on delete customer link
			deleteacct.clickDeleteAccounnLink();
			Thread.sleep(1000);
			
			deleteacct.enterAccountNumber(acctID);
			
			deleteacct.clickSubmitButton();
			logger.info("Accont ID entered and clicked on Submit button");
			
			driver.switchTo().alert().accept();
			logger.info("First alert closed");
			Thread.sleep(1000);
			
			String alertMessage=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			logger.info("Second alert closed");
			logger.info("First alert :" + alertMessage);
			
			if(alertMessage.equalsIgnoreCase("Account Deleted Sucessfully")) {
				Assert.assertTrue(true);
				logger.info("Account delete Test Case Passed");
				
			}else {
				Assert.fail();
				logger.info("Account delete Test Case Failed");
				captureScreen(driver,"DeleteAccount");
			}
			
	}
	
}
