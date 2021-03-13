package com.testinium.qa.pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	private static Logger log  = Logger.getLogger(SearchPage.class.getName());
	WebDriver driver;
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (this.driver,this);
	}
    
	@FindBy(tagName="input")
	WebElement search;
	@FindBy(css="button[data-cy='search-find-button']")
	WebElement button;
	@FindBy(linkText ="2")
    WebElement second_page;	
	
	 public void search(String srh){
		 log.info("Search kelimesi alınır");
		 search.clear();
		 search.sendKeys(srh);
	   }
	 
     public void searchClick() {
    	 log.info("Search edilir");
    	 button.click();
     }
	
     public void second_page_click() {
      log.info("Second page acilir.");
      JavascriptExecutor jse = (JavascriptExecutor)driver;
  	  jse.executeScript("arguments[0].click()", second_page);
     }
     
       public boolean isPageOpened(){
       log.info("Sayfa kontrolu yapılır.");
       boolean durum =   driver.getCurrentUrl().contains("&sf=2"); 
       return durum;
     }
}
