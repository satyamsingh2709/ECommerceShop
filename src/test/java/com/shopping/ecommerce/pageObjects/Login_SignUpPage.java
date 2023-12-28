package com.shopping.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login_SignUpPage {
	
	WebDriver driver;
	
	public Login_SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()=\" Signup / Login\"]")
	WebElement signup_loginBtn;
	
	@FindBy(name="email")
	WebElement login_email;
	
	@FindBy(name="password")
	WebElement login_password;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(name="name")
	WebElement signup_name;
	
	@FindBy(xpath="//input[@data-qa=\"signup-email\"]")
	WebElement signup_email;
	
	@FindBy(xpath="//button[@data-qa=\"signup-button\"]")
	WebElement signupBtn;
	
	@FindBy(id="id_gender1")
	WebElement title_mr;
	
	@FindBy(id="id_gender2")
	WebElement title_mrs;
	
	@FindBy(id="password")
	WebElement signup_password;
	
	@FindBy(id="days")
	WebElement dob_day;
	
	@FindBy(id="months")
	WebElement dob_month;
	
	@FindBy(id="years")
	WebElement dob_year;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="last_name")
	WebElement lastName;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="zipcode")
	WebElement zipcode;
	
	@FindBy(id="mobile_number")
	WebElement mobNo;
	
	@FindBy(xpath="//button[@data-qa=\"create-account\"]")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[@data-qa=\"continue-button\"]")
	WebElement continueBtn;
	
	public void click_login_signupBtn() {
		signup_loginBtn.click();
	}
	
	public void setLoginEmail(String email) {
		login_email.sendKeys(email);
	}
	
	public void setLoginPassword(String password) {
		login_password.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();

	}
	
	public void setSignupName(String name) {
		signup_name.sendKeys(name);
	}
	
	public void setSignupEmail(String email) {
		signup_email.sendKeys(email);
	}
	
	public void clickSignup() {
		signupBtn.click();
	}
	
	public void selectGender(String gender) {
		if(gender.equalsIgnoreCase("mr")) {
			title_mr.click();
		}else if(gender.equalsIgnoreCase("mrs")) {
			title_mrs.click();
		}
	}
	
	public void setSignupPassword(String password) {
		signup_password.sendKeys(password);
	}
	
	public void selectDate(String day) {
		Select select = new Select(dob_day);
		select.selectByValue(day);
	}
	
	public void selectMonth(String month) {
		Select select = new Select(dob_month);
		select.selectByValue(month);
	}
	
	public void selectYear(String year) {
		Select select = new Select(dob_year);
		select.selectByValue(year);
	}
	
	public void setFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void setLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void setAddress1(String add1) {
		address1.sendKeys(add1);
	}
	
	public void setCountry(String nation) {
		Select select = new Select(country);
		select.selectByValue(nation);
	}
	
	public void setState(String st) {
		state.sendKeys(st);
	}
	
	public void setCity(String ct) {
		city.sendKeys(ct);
	}
	
	public void setZipcode(String pin) {
		zipcode.sendKeys(pin);
	}
	
	public void setPhoneNo(String mob) {
		mobNo.sendKeys(mob);
	}
	
	public void submitInfo() {
		submitBtn.click();
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
}
