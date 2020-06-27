package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(),'Shishir Solanki')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the page objects.so,we need to create constructor of home page
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectuserName() {
		 return userNameLabel.isDisplayed();
	}
	
	//return of clickoOnContactsLink is ContactsPage means after linking on contact link contacts page will appear.
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	//return of clickoOnDealsLink is DealsPage means after linking on Deals link Deals page will appear.
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	//return of clickoOnTaskssLink is TasksPage means after linking on Tasks link Tasks page will appear.
		public TasksPage clickOnTasksLink() {
			tasksLink.click();
			return new TasksPage();
		}
}
