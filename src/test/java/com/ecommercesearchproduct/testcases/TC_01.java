package com.ecommercesearchproduct.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommercesearchproduct.pageobjects.TestCase1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_01 {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@Test
	public void TC1(String browser) throws InterruptedException {
		
		logger = Logger.getLogger("EcommerceSearchProduct");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}else if(browser.equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement womanLink = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(womanLink).build().perform();
		
		TestCase1 tc1 = new TestCase1(driver);
		tc1.clickTShirtsLink();
		Thread.sleep(2000);
		
		
		//Product details before search
		String ImgSrcBSearch = tc1.getImageSourceB();//Image source before search
		
		String productNameB = tc1.getProductNameB();//productName before search
		
		String productPriceB =  tc1.getProductPriceB();//product price before search
		
		String productFirstColorB = tc1.getPFirstcolorB();//product first color before search
		
		String productSecondColorB = tc1.getPSecondcolorB();//product second color before search
		
		//Perform search
		tc1.inputSearchString(productNameB);
		tc1.clickSearchButton();
		Thread.sleep(3000);
		
		
		//Product details after search
		String ImgSrcASearch = tc1.getImageSourceA();//Image source after search
		
		String productNameA = tc1.getProductNameA();//productName after search
		
		String productPriceA =  tc1.getProductPriceA();//product price after search
		
		String productFirstColorA = tc1.getPFirstcolorA();//product first color after search
		
		String productSecondColorA = tc1.getPSecondcolorA();//product second color after search
		
		//Validation
		if(ImgSrcBSearch.equals(ImgSrcASearch) && productNameB.equals(productNameA) && productPriceB.equals(productPriceA) && productFirstColorB.equals(productFirstColorA) && productSecondColorB.equals(productSecondColorA)) {
			logger.info("Product details are same at both ends");
			logger.info("Test case passed");
		}else {
			logger.info("Product details are not same at both ends");
			logger.info("Test case failed");
		}
		
	}
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	
}
