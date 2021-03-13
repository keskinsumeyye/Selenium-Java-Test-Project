package com.testinium.qa.pages;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;

public class SelectProduct {
	private static Logger log  = Logger.getLogger(SelectProduct.class.getName());
	WebDriver driver;

	public SelectProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (this.driver,this);
		
}

	@FindBy(css ="li[product-id]")
	List<WebElement> productElems;
	
	public void product_select_click() {
		 log.info("Random urun secilir");
		   int maxProducts = productElems.size();
		   Random random = new Random();
		   int randomProduct = random.nextInt(maxProducts);
		   productElems.get(randomProduct).click();
		   
	}
	
	@FindBy(id="sp-price-lowPrice")
	WebElement price;
	
	public String product_price() {
		log.info("urunun fiyatı alınır");
	return price.getText().toString();
	}
}
