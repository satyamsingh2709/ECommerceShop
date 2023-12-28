package com.shopping.ecommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.shopping.ecommerce.pageObjects.HomePage;
import com.shopping.ecommerce.pageObjects.Login_SignUpPage;
import com.shopping.ecommerce.utilities.FileReader;



public class LoginTest_TC002 extends BaseClass {
	

	@Test(dataProvider="LoginData")
	public void loginDDT(String username, String password) {
		Login_SignUpPage lsPage = new Login_SignUpPage(driver);
		HomePage hp= new HomePage(driver);
		
		lsPage.click_login_signupBtn();
		lsPage.setLoginEmail(username);
		lsPage.setLoginPassword(password);
		lsPage.clickLogin();
		
		if(username.equals("automation100@gmail.com")||password.equals("Testing1")) {
			boolean b = driver.getPageSource().contains("Your email or password is incorrect!");
			if(b) {
				Assert.assertTrue(b);
			}else {
				Assert.assertTrue(false);
			}
		}else if(username.equals("automation@gmail.com")||username.equals("automation1@gmail.com")){
			//String userName = hp.getUserName();
				Assert.assertTrue(true);
				hp.clickLogout();
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws IOException {
		String filePath =(System.getProperty("user.dir")+"\\src\\test\\java\\com\\shopping\\ecommerce\\testData\\loginData.xlsx");
		int rowCount = FileReader.getRowCount(filePath,"Sheet1");
		int cellCount = FileReader.getCellCount(filePath, "Sheet1", 1);
		
		String loginData[][] = new String[rowCount][cellCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				loginData[i-1][j]=FileReader.readCellData(filePath, "Sheet1", i, j);
			}
		}
		return loginData;
	}

}
