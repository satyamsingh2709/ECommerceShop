package com.shopping.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\" Cart\"]")
	WebElement cartTab;
	
	@FindBy(xpath="(//tbody[1]//tr//td[2]//a)[1]")
	WebElement product1;
	
	@FindBy(xpath="(//tbody[1]//tr//td[2]//a)[2]")
	WebElement product2;
	
	@FindBy(xpath="(//tbody[1]//tr//td[2]//a)[3]")
	WebElement product3;
	
	@FindBy(xpath="(//tbody[1]//tr//td[2]//a)[4]")
	WebElement product4;
	
	@FindBy(xpath="//a[text()=\"Proceed To Checkout\"]")
	WebElement proceedToCheckoutBtn;
	
	public void clickCartTab() {
		cartTab.click();
	}
	
	public String getProduct1Name() {
		return product1.getText();
	}
	
	public String getProduct2Name() {
		return product2.getText();
	}
	
	public String getProduct3Name() {
		return product3.getText();
	}
	
	public String getProduct4Name() {
		return product4.getText();
	}
	
	public void clickProceedToCheckout() {
		proceedToCheckoutBtn.click();
	}
}
