package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		
		//To call super (parent) class constructor i.e,from TestBase class constructor is called to read properties fiile(config file)		
		super();
	}
	
	@BeforeMethod
	public void setup() {
	//To call initialization method from TestBase class to initilise the method	
		initialization();
		landingPage = new LandingPage();
		landingPage.landing();
		loginPage = new LoginPage();
		
		
	}
	//@Test(priority=1)
	//public void loginPageTitleTest() {
		//String title=loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	//}
	
	//@Test(priority=2)
	//public void CRMLogoImageTest() {
		//boolean flag = loginPage.validateCRMImage();
		//Assert.assertTrue(flag);
	//}
	
	@Test(priority=1)
	public void loginTest() {
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
