package com.shopping.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.shopping.ecommerce.pageObjects.CartPage;
import com.shopping.ecommerce.pageObjects.HomePage;
import com.shopping.ecommerce.pageObjects.Login_SignUpPage;
import com.shopping.ecommerce.pageObjects.PaymentsPage;
import com.shopping.ecommerce.pageObjects.ProductsPage;



public class BuyProductTest_TC001 extends BaseClass {
	Login_SignUpPage lsPage;
	HomePage homePage;
	ProductsPage prodPage;
	CartPage cartPage;
	PaymentsPage paymentsPage;
	@Test
	public void buyProductTest() throws InterruptedException {
		lsPage = new Login_SignUpPage(driver);
		lsPage.click_login_signupBtn();
		lsPage.setLoginEmail(username);
		lsPage.setLoginPassword(password);
		lsPage.clickLogin();
		
		homePage = new HomePage(driver);
		prodPage = new ProductsPage(driver);
		
		//Adding Product1 to cart
		prodPage.clickProductsTab();
		prodPage.selectProductFromList("GRAPHIC DESIGN MEN T SHIRT - BLUE");
		
		//Adding Product2 to cart
		prodPage.clickExpandWomenCategoryButton();
		prodPage.clickSareeCategory();
		Thread.sleep(3000);
		prodPage.selectProduct2();
		clickStaleElement();
		
		//Adding Product3 to cart
		prodPage.clickProductsTab();
		prodPage.scrollPage("0","1250");
		prodPage.selectProduct3();
		clickStaleElement();
		
		//Adding Product4 to cart
		prodPage.searchProduct("Cotton Mull Embroidered Dress");
		prodPage.clickSearchBtn();
		prodPage.selectProduct4();
		clickStaleElement();
		
		cartPage = new CartPage(driver);
		cartPage.clickCartTab();
		String product1Name = cartPage.getProduct1Name();
		String product2Name = cartPage.getProduct2Name();
		String product3Name = cartPage.getProduct3Name();
		String product4Name = cartPage.getProduct4Name();
		
		if(product1Name.equals("GRAPHIC DESIGN MEN T SHIRT - BLUE")&& product2Name.equals("Beautiful Peacock Blue Cotton Linen Saree")&&
			product3Name.equals("Fancy Green Top")&& product4Name.equals("Cotton Mull Embroidered Dress")) {
			Assert.assertTrue(true);
			System.out.println("Product matches");
		}else {
			System.out.println("Product doesnt match");
			Assert.assertTrue(false);
			
		}
		cartPage.clickProceedToCheckout();
		
		
		paymentsPage = new PaymentsPage(driver);
		paymentsPage.clickPlaceOrderBtn();
		paymentsPage.setNameOnCard("Automation Tester");
		paymentsPage.setCardNo("123443211243");
		paymentsPage.setCvv("300");
		paymentsPage.setExpiryMonth("12");
		paymentsPage.setExpiryYear("2029");
		paymentsPage.clickPayAndConfirmOrder();
		
		String message = paymentsPage.getConfirmationOrderMessage();
		 if(message.equals("ORDER PLACED!")) {
			 Assert.assertTrue(true);
			 System.out.println("Order Placed Successfully");
		 }else {
			 
			 System.out.println(message + "Order is not placed");
			 Assert.assertTrue(false);
			 
		 }
		 
		 paymentsPage.clickContinueBtn();
	}
	
	public void clickStaleElement() {
		if(prodPage.isContiuneShoppingBtnStale()) {
			prodPage.clickContinueShoppingBtn();
		}
		prodPage.clickContinueShoppingBtn();
	}
	
	@AfterMethod
	public void logout() {
		homePage.clickLogout();
	}

}
