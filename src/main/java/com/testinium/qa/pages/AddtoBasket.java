package com.testinium.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoBasket {
	WebDriver driver;
	public AddtoBasket(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (this.driver,this);	
	}
	
	@FindBy(id="add-to-basket")
	WebElement addButton;
	
	@FindBy(xpath="//body/div[@id='topContainer']/div[@id='GGHeaderWrapper']/div[@id='header_wrapper']/div[4]/div[3]/div[1]/a[1]")
	WebElement goBasket;
	
	public void add_to_basket_click() {
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	   jse.executeScript("arguments[0].click()", addButton);
	}
	
	public void go_to_basket_click() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", goBasket);
	}
	
}
