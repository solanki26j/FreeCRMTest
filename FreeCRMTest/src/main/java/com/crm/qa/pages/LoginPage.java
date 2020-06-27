package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory -OR:
	//@FindBy(xpath="//span[contains(text(),'Log In')]")
	//WebElement login;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginbtn;
	
	//@FindBy(xpath="//div[@class='rd-navbar-panel']//span[contains(text(),'free')]")
	//WebElement crmLogo;
	//Initializing the page objects.so,we need to create constructor of login page
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions:
	//public String validateLoginPageTitle() {
		//return driver.getTitle();
	//}
		
	//public boolean validateCRMImage() {
		 //return crmLogo.isDisplayed();
		 
		//}	
	
	//return of login page is HomePage means after linking on login button HomePage page will appear.
	public HomePage login(String un, String pwd) {
		//login.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		
		return new HomePage();
	}
		
	}


