package com.shopping.ecommerce.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentsPage {
	WebDriver driver;
	public PaymentsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\"Place Order\"]")
	WebElement placeOrderBtn;
	
	@FindBy(name="name_on_card")
	WebElement nameOnCard;
	
	@FindBy(name="card_number")
	WebElement cardNo;
	
	@FindBy(name="cvc")
	WebElement cvv;
	
	@FindBy(name="expiry_month")
	WebElement expiryMonth;
	
	@FindBy(name="expiry_year")
	WebElement expiryYear;
	
	@FindBy(id="submit")
	WebElement payAndConfirmOrder;
	
	@FindBy(xpath="//b[text()=\"Order Placed!\"]")
	WebElement orderConfirmation;
	
	@FindBy(xpath="//a[@data-qa=\"continue-button\"]")
	WebElement continueBtn;
	
	public void clickPlaceOrderBtn() {
		placeOrderBtn.click();
	}
	
	public void setNameOnCard(String name) {
		nameOnCard.sendKeys(name);
	}
	
	public void setCardNo(String no) {
		cardNo.sendKeys(no);
	}
	
	public void setCvv(String cvvNo) {
		cvv.sendKeys(cvvNo);
	}
	
	public void setExpiryMonth(String month) {
		expiryMonth.sendKeys(month);
	}
	
	public void setExpiryYear(String year) {
		expiryYear.sendKeys(year);
	}
	
	public void clickPayAndConfirmOrder() {
		payAndConfirmOrder.click();
	}
	public String getConfirmationOrderMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf((orderConfirmation))); 
		String message = orderConfirmation.getText();
		return message;
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
