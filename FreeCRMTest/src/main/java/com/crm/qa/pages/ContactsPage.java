package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//Page Factory
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[@class='ui celled sortable striped table custom-grid table-scroll']//tr[2]//td//div[@class='ui fitted read-only checkbox']")
	WebElement contactCheckbox;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newButton;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	//@FindBy(xpath="//div[@name='company']//input[@class='search']")
	//WebElement company;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebtn;
	
	
	//Initializing the page objects.so,we need to create constructor of home page
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName() {
		contactCheckbox.click();
	}
	
	public void clickNewButton() {
		
		newButton.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
	}
	
	public void createNewContact(String ftName,String ltName, String comp) {
		//newButton.click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		//company.sendKeys(comp);
		//Select select=new Select(driver.findElement(By.xpath("//div[@name='channel_type']//select[@class='dropdown icon']")));
		//select.selectByVisibleText(channelType);
		//savebtn.click();
	}
	
	public void clickSaveButton() {
		savebtn.click();
	}

}
