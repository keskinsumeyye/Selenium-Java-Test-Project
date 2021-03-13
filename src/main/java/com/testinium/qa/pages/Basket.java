package com.testinium.qa.pages;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Basket {
	private static Logger log  = Logger.getLogger(Basket.class.getName());
	WebDriver driver;
	public Basket(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (this.driver,this);
}
	@FindBy(tagName="select")
	 WebElement number;
	
	@FindBy(css ="a[title='Sil']")
	WebElement delete;
	
	@FindBy(css="div[class='total-price']")
	WebElement price;
	
	public void number_of_product() {
	log.info("Product sayısı 2 yapılır.");
	Select piece = new Select(number);
	piece.selectByVisibleText("2");
	}
	
	public void delete_product_click() {
		log.info("Urunler silinir.");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	  	jse.executeScript("arguments[0].click()", delete);
	}
	
	public String product_price_2() {
		log.info("urunun fiyati alinir.");
	return price.getText().toString();
		}
	public String getNumberofProduct() {
	log.info("Product sayısı kontrolu");
	Select piece = new Select(number);
	return piece.getFirstSelectedOption().getText().toString();
	}
	
}

