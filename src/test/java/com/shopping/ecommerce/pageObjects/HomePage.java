package com.shopping.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//b")
	WebElement userName;
	
	@FindBy(xpath="//a[text()=\" Logout\"]")
	WebElement logoutBtn;
	
	public String getUserName() {
		String user_name = userName.getText();
		return user_name;
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}

}
