package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	//TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest() {
		
		//To call super (parent) class constructor i.e,from TestBase class constructor is called to read properties fiile(config file)		
				super();
			}
	@BeforeMethod
	public void setup() {
	//To call initialization method from TestBase class to initilise the method	
		initialization();
       // testUtil = new TestUtil();
        contactsPage = new ContactsPage();
		landingPage = new LandingPage();
		landingPage.landing();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		//testUtil.switchToFrame();
	  Assert.assertTrue(homePage.verifyCorrectuserName());
	}
	  
	  @Test(priority=3)
	  public void verifyContactsLinkTest() {
		//testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	  }
	  
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
