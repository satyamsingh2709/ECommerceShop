package com.shopping.ecommerce.testCases;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.shopping.ecommerce.pageObjects.HomePage;
import com.shopping.ecommerce.pageObjects.Login_SignUpPage;

import junit.framework.Assert;

public class SignupTest_TC001 extends BaseClass {

	Login_SignUpPage lsPage;
	HomePage hp;
	@Test
	public void signup() {
		lsPage = new Login_SignUpPage(driver);
		hp = new HomePage(driver);
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		lsPage.click_login_signupBtn();
		
		lsPage.setSignupName("AutomationTestTwo");
		String email = generateRandomMail()+"@gmail.com";
		lsPage.setSignupEmail(email);
		lsPage.clickSignup();
		
		lsPage.selectGender("mrs");
		lsPage.setFirstName("AutomationTest");
		lsPage.setLastName("Two");
		lsPage.setAddress1("address1");
		lsPage.setCity("vatican city");
		lsPage.setState("United State");
		lsPage.setCountry("Singapore");
		lsPage.selectDate("20");
		lsPage.selectMonth("5");
		lsPage.selectYear("2005");
		lsPage.setZipcode("220022");
		lsPage.setSignupPassword("testing");
		lsPage.setPhoneNo("9889899889");
		lsPage.submitInfo();
		
		lsPage.clickContinue();
		String userName = hp.getUserName();
		if(userName.equals("AutomationTestTwo")) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public String generateRandomMail() {
		String alphabets="abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder(6);
		Random random = new Random();
		for(int i=0;i<=5;i++) {
			int index = random.nextInt(alphabets.length());
			char randomChar = alphabets.charAt(index);
			sb.append(randomChar);
		}
		return sb.toString();
	}
	@AfterMethod
	public void logout() {
		hp.clickLogout();
	}
}
