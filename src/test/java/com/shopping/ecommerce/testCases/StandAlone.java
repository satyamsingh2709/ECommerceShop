package com.shopping.ecommerce.testCases;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StandAlone {
	WebDriver driver;
	@Test
	public void loginTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		SoftAssert sa = new SoftAssert();
		driver.get("https://automationexercise.com/");
		
		WebElement signup_LoginButton = driver.findElement(By.xpath("//a[text()=\" Signup / Login\"]"));
		signup_LoginButton.click();
		
		WebElement loginName = driver.findElement(By.name("email"));
		loginName.sendKeys("automation@gmail.com");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("testing");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[text()=\"Login\"]"));
		loginButton.click();

		WebElement userName = driver.findElement(By.xpath("//b[text()=\"automationtest\"]"));
		String user = userName.getText();
		System.out.println(user);
		
		WebElement productPage = driver.findElement(By.xpath("//a[text()=\" Products\"]"));
		productPage.click();
		//Assert.assertEquals(user,"automationtest" );	
		
		//Adding product to cart using list and iteration
		List<WebElement>productsName = driver.findElements(By.xpath("//img[contains(@alt,\"products\")]//following::p[1]"));
	
		WebElement continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
		
		int productCount = productsName.size();
		for(int i=0;i<productCount;i++) {
			WebElement product= productsName.get(i);
			String productName = product.getText();
			if(productName.equalsIgnoreCase("GRAPHIC DESIGN MEN T SHIRT - BLUE")) {
				int cartCount=i+1;
				WebElement productToCart1 = driver.findElement(By.xpath("(//div[contains(@class,\"productinfo\")]//a[text()=\"Add to cart\"])["+cartCount+"]"));
				productToCart1.click();
				Thread.sleep(2000);
				continueShoppingBtn.click();
				Thread.sleep(2000);
			}
		}
		//Thread.sleep(6000);
		
		//Adding product to cart through category
		WebElement expandWomenCategoryButton = driver.findElement(By.xpath("//a[@href=\"#Women\"]//following::i"));
		expandWomenCategoryButton.click();
		WebElement sareeCategory = driver.findElement(By.xpath("//div[@id=\"Women\"]//li//a[text()=\"Saree \"]"));
		sareeCategory.click();
		
		WebElement productToCart2 = driver.findElement(By.xpath("((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Beautiful Peacock Blue Cotton Linen Saree\"])/ancestor::div[1]//a)[1]"));
		productToCart2.click();
		Thread.sleep(2000);
		
		//Checking for Stale Element Condition
		boolean isConitueShoppingStale = ExpectedConditions.stalenessOf(continueShoppingBtn).apply(driver);

		// if the element is stale
		if (isConitueShoppingStale) {
		    // re-retrieving the desired input HTML element
			continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
		}

		continueShoppingBtn.click();
		
		WebElement productsMenu = driver.findElement(By.xpath("//a[text()=\"Products\"]"));
		
		
		productsMenu.click();
		Thread.sleep(6000);
		
		//Adding product through scrolling window
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1250)", "");
		WebElement productToCart3=driver.findElement(By.xpath("((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Fancy Green Top\"])/ancestor::div[1]//a)[1]"));
		productToCart3.click();
		Thread.sleep(2000);
		
		//Checking for Stale Element Condition
		boolean isConitueShoppingStale1 = ExpectedConditions.stalenessOf(continueShoppingBtn).apply(driver);

		// if the element is stale
		if (isConitueShoppingStale1) {
		    // re-retrieving the desired input HTML element
			continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
		}

		continueShoppingBtn.click();
		Thread.sleep(4000);
		
		//Adding product through Search Method
		
		WebElement searchItem = driver.findElement(By.id("search_product"));
		searchItem.sendKeys("Cotton Mull Embroidered Dress");
		WebElement searchBtn = driver.findElement(By.id("submit_search"));
		searchBtn.click();
		
		WebElement productToCart4 = driver.findElement(By.xpath("((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Cotton Mull Embroidered Dress\"])/ancestor::div[1]//a)[1]"));
		productToCart4.click();
		
		Thread.sleep(2000);
		
		//Checking for Stale Element Condition
		boolean isConitueShoppingStale2 = ExpectedConditions.stalenessOf(continueShoppingBtn).apply(driver);

		// if the element is stale
		if (isConitueShoppingStale2) {
		    // re-retrieving the desired input HTML element
			continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
		}

		continueShoppingBtn.click();
		Thread.sleep(4000);
		
		//Cart Operation
		WebElement cartButton = driver.findElement(By.xpath("//a[text()=\" Cart\"]"));
		cartButton.click();
		Thread.sleep(3000);
		 WebElement product1 = driver.findElement(By.xpath("//a[text()=\"GRAPHIC DESIGN MEN T SHIRT - BLUE\"]"));
		 String product1Name = product1.getText();
		 
		 WebElement product2 = driver.findElement(By.xpath("//a[text()=\"Beautiful Peacock Blue Cotton Linen Saree\"]"));
		 String product2Name =product2.getText();
		 
		 WebElement product3 = driver.findElement(By.xpath("//a[text()=\"Fancy Green Top\"]"));
		 String product3Name = product3.getText();
		 
		 WebElement product4 = driver.findElement(By.xpath("//a[text()=\"Cotton Mull Embroidered Dress\"]"));
		 String product4Name = product4.getText();
		 
		 if(product1Name.equals("GRAPHIC DESIGN MEN T SHIRT - BLUE")&& product2Name.equals("Beautiful Peacock Blue Cotton Linen Saree")&&
			product3Name.equals("Fancy Green Top")&& product4Name.equals("Cotton Mull Embroidered Dress")) {
	 
			 sa.assertTrue(true);
		 }else {
			 sa.assertTrue(false);
		 }
		 	 
		 WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//a[text()=\"Proceed To Checkout\"]"));
		 proceedToCheckoutBtn.click();
		 Thread.sleep(3000);
		 
		 WebElement placeOrderBtn = driver.findElement(By.xpath("//a[text()=\"Place Order\"]"));
		 placeOrderBtn.click();
		 Thread.sleep(3000);
		 
		 WebElement nameOnCard = driver.findElement(By.name("name_on_card"));
		 nameOnCard.sendKeys("automationtest");
		 
		 WebElement cardNo = driver.findElement(By.name("card_number"));
		 cardNo.sendKeys("123412341234");
		 
		 WebElement cvv = driver.findElement(By.name("cvc"));
		 cvv.sendKeys("314");
		 
		 WebElement expiryMonth = driver.findElement(By.name("expiry_month"));
		 expiryMonth.sendKeys("12");
		 
		 WebElement expiryYear= driver.findElement(By.name("expiry_year"));
		 expiryYear.sendKeys("2030");
		 
		 WebElement payAndConfirmOrder = driver.findElement(By.id("submit"));
		 payAndConfirmOrder.click();
		 Thread.sleep(3000);
		 WebElement orderConfirmation = driver.findElement(By.xpath("//b[text()=\"Order Placed!\"]"));
		 String orderConfirmationMessage = orderConfirmation.getText();
		 
		 if(orderConfirmationMessage.equals("ORDER PLACED!")) {
			 sa.assertTrue(true);
		 }else {
			 sa.assertTrue(false);
		 }
		 Thread.sleep(3000);
		 WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]"));
		 continueButton.click();
		 sa.assertAll();
	}
	
	@AfterClass
	public void tearDown() {
		WebElement logoutButton = driver.findElement(By.xpath("//a[text()=\" Logout\"]"));
		logoutButton.click();
		driver.quit();
	}
}
