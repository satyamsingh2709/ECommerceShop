package com.shopping.ecommerce.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()=\" Products\"]")
	WebElement productsTab;
	
	@FindBy(xpath="//img[contains(@alt,\"products\")]//following::p[1]")
	List<WebElement> productsName;
	
	@FindBy(xpath="//button[text()='Continue Shopping']")
	public WebElement continueShoppingBtn;
	
	@FindBy(xpath="//a[@href=\"#Women\"]//following::i")
	WebElement expandWomenCategoryButton;
	
	@FindBy(xpath="//div[@id=\"Women\"]//li//a[text()=\"Saree \"]")
	WebElement sareeCategory;
	
	@FindBy(xpath="((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Beautiful Peacock Blue Cotton Linen Saree\"])/ancestor::div[1]//a)[1]")
	WebElement productToCart2;
	
	@FindBy(xpath="((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Fancy Green Top\"])/ancestor::div[1]//a)[1]")
	WebElement productToCart3;
	
	@FindBy(id="search_product")
	WebElement searchItem;
	
	@FindBy(id="submit_search")
	WebElement searchBtn;
	 
	@FindBy(xpath="((//img[@alt=\"ecommerce website products\"]//following::p[text()=\"Cotton Mull Embroidered Dress\"])/ancestor::div[1]//a)[1]")
	WebElement productToCart4;
	
	public void clickProductsTab() {
		productsTab.click();
	}
	
	public void selectProductFromList(String OrigProductName) {
		int productCount = productsName.size();
		for(int i=0;i<productCount;i++) {
			WebElement product= productsName.get(i);
			String productName = product.getText();
			if(productName.equalsIgnoreCase(OrigProductName)) {
				int cartCount=i+1;
				WebElement productToCart1 = driver.findElement(By.xpath("(//div[contains(@class,\"productinfo\")]//a[text()=\"Add to cart\"])["+cartCount+"]"));
				productToCart1.click();
				clickContinueShoppingBtn();
				
			}
		}
	}
	
	public void clickContinueShoppingBtn() {
		continueShoppingBtn.click();
	}
	
	public boolean isContiuneShoppingBtnStale() {
		boolean isConitueShoppingStale = ExpectedConditions.stalenessOf(continueShoppingBtn).apply(driver);

		// if the element is stale
		if (isConitueShoppingStale) {
		    // re-retrieving the desired input HTML element
			continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue Shopping']"));
			return true;
		}
		return false;
	}
	
	public void clickExpandWomenCategoryButton() {
		expandWomenCategoryButton.click();
	}
	
	public void clickSareeCategory() {
		sareeCategory.click();
	}
	
	public void selectProduct2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(productToCart2)); 
		productToCart2.click();
	}
	public void scrollPage(String len, String br) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+len+","+br+")", "");
	}
	
	public void selectProduct3() {
		productToCart3.click();
	}
	
	public void searchProduct(String productName) {
		searchItem.sendKeys(productName);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public void selectProduct4() {
		productToCart4.click();
	}
}
