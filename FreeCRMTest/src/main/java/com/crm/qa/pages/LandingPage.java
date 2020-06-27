package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	//page factory -OR:
		@FindBy(xpath="//span[contains(text(),'Log In')]")
		WebElement login;
		
		
		@FindBy(xpath="//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
		WebElement crmLogo;
		
		//Initializing the page objects.so,we need to create constructor of login page
		
		public LandingPage() {
			
			PageFactory.initElements(driver, this);
			
		}
		
		//Actions:
		public String validateLandingPageTitle() {
			return driver.getTitle();
		}
			
		public boolean validateCRMImage() {
			 return crmLogo.isDisplayed();
			 
			}	
		//return of login page is HomePage means after clicking on login button Loginpage will appear.
		public LoginPage landing() {
			login.click();
			return new LoginPage();
		}

}
