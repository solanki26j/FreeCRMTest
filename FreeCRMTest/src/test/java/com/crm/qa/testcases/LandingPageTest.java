package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LandingPageTest extends TestBase{
	
	LandingPage landingPage;
	LoginPage loginPage;

	
	public LandingPageTest() {
		
		//To call super (parent) class constructor i.e,from TestBase class constructor is called to read properties fiile(config file)		
				super();
			}
			
			@BeforeMethod
			public void setup() {
			//To call initialization method from TestBase class to initilise the method	
				initialization();
				landingPage = new LandingPage();

}
			
			@Test(priority=1)
			public void landingPageTitleTest() {
			 String title=landingPage.validateLandingPageTitle();
				Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
			}
			
			@Test(priority=2)
			public void CRMLogoImageTest() {
				boolean flag = landingPage.validateCRMImage();
				Assert.assertTrue(flag);
			}
			
			@Test(priority=3)
			public void landingTest() {
			landingPage.landing();
			}
			
			@AfterMethod
			public void tearDown() {
				driver.quit();
			}
}
