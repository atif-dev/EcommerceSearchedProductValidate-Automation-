package com.ecommercesearchproduct.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TestCase1 {
	
	 WebDriver driver;
	    public TestCase1(WebDriver driver){
	        PageFactory.initElements(driver, this);
	    }
	    
	@FindBy(how = How.XPATH, using = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
	WebElement tShirtsLink;
	
	@FindBy(how = How.ID, using = "search_query_top")
	WebElement search;
	
	@FindBy(how = How.NAME, using = "submit_search")
	WebElement searchBtn;
	
	//Before search
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productImage;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	WebElement productName;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span")
	WebElement productPrice;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"color_1\"]")
	WebElement productcolor1;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"color_2\"]")
	WebElement productcolor2;
	
	//After search
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productImage2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	WebElement productName2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span")
	WebElement productPrice2;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"color_1\"]")
	WebElement productcolor1a;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"color_2\"]")
	WebElement productcolor2a;
	
	/*
	We are verifying before search product details and after search product details but
	if we see XPATHs of before search and after search they are same. What it means that
	our test case will pass,definitely.We can also validate our test case through this trick.
	*/
	    
	public void  clickTShirtsLink() throws InterruptedException {
			Thread.sleep(2000);
			tShirtsLink.click();
			
	}
	
	public String getProductNameB() { //get product name before search
		return productName.getText();
	}
	
	public String getImageSourceB() {//get image source before search
		return productImage.getAttribute("src");
	}
	
	public String getProductPriceB() {//get product price before search
		return productPrice.getText();
	}
	
	public String getPFirstcolorB() {//get product first color before search
		return productcolor1.getCssValue("background-color");
	}
	
	public String getPSecondcolorB() {//get product second color before search
		return productcolor2.getCssValue("background-color");
	}
	
	public void inputSearchString(String pName) {
		search.sendKeys(pName);
	}
	
	public void clickSearchButton() {
		searchBtn.click();
	}
	
	//After search
	public String getProductNameA() { //get product name after search
		return productName2.getText();
	}
	
	public String getImageSourceA() {//get image source after search
		return productImage2.getAttribute("src");
	}
	
	public String getProductPriceA() {//get product price after search
		return productPrice2.getText();
	}
	
	public String getPFirstcolorA() {//get product first color after search
		return productcolor1a.getCssValue("background-color");
	}
	
	public String getPSecondcolorA() {//get product second color after search
		return productcolor2a.getCssValue("background-color");
	}
	
	
	     

}

