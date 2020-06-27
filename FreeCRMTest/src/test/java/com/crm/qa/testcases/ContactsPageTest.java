package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	//TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "Contacts";
	
	public ContactsPageTest() {
		
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
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel() {
	Assert.assertEquals(contactsPage.verifyContactsLabel(),"Contacts");
		}
	
	
	@Test(priority=2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName();
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
	Object data[][] = TestUtil.getTestData(sheetName);
	 return data;
	}
	
		
		@Test(priority=3,dataProvider="getCRMTestData")
		public void validateCreateNewContact(String FirstName,String LastName, String Company) {
			contactsPage.clickNewButton();
			//contactsPage.createNewContact("tom","peter", "google", "Facebook");
			contactsPage.createNewContact(FirstName, LastName, Company);
		    contactsPage.clickSaveButton();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
