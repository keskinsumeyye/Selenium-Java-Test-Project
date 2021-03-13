package com.testinium.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestBase {
    
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;

public void BeforeMethod(){
 
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\sumey\\Selenium\\ChromeDriver\\chromedriver.exe"); 
     driver = new ChromeDriver();
     wait = new WebDriverWait(driver,15);
     driver.manage().window().maximize();
}

public void AfterMethod(){		     
    driver.quit();		    
   
}
}