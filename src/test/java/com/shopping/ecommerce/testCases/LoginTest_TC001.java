package com.shopping.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.shopping.ecommerce.pageObjects.HomePage;
import com.shopping.ecommerce.pageObjects.Login_SignUpPage;


public class LoginTest_TC001 extends BaseClass {
	
	Login_SignUpPage lsPage;
	HomePage hp;
	@Test
	public void login() {
		
		lsPage = new Login_SignUpPage(driver);
		hp = new HomePage(driver);
		
		lsPage.click_login_signupBtn();
		lsPage.setLoginEmail(username);
		lsPage.setLoginPassword(password);
		lsPage.clickLogin();
		String userName = hp.getUserName();
		if(userName.equalsIgnoreCase("automationtest")) {
			logger.info("Login is successful");
			System.out.println("Login Successful");
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}

	@AfterMethod
	public void logout() {
		hp.clickLogout();
	}
}
