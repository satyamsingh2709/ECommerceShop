package com.shopping.ecommerce.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.shopping.ecommerce.pageObjects.HomePage;
import com.shopping.ecommerce.utilities.ReadConfig;

public class BaseClass {
	
	public static WebDriver driver;
	
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.baseUrl();
	String username = readConfig.userName();
	String password = readConfig.password();
	static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		
		if(br.equals("Chrome")) {
			driver=new ChromeDriver();	
		} else if(br.equals("Firefox")) {
			driver = new FirefoxDriver();			
		} else if(br.equals("IE")){
			driver = new EdgeDriver();
		}	
		
		driver.manage().window().maximize();			
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	

}
