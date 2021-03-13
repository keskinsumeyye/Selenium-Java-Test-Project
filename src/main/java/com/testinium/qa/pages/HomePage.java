package com.testinium.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

public class HomePage {
private static Logger log  = Logger.getLogger(HomePage.class.getName());
WebDriver driver;


public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements (this.driver,this);	
}

@FindBy(css ="div[title='Giriş Yap']")
WebElement hover;
@FindBy(linkText = "Giriş Yap")
WebElement login;


public void moveElement(Actions actions) {
log.info("Giris Yap uzerine mouse getiriliyor");
actions.moveToElement(hover).build().perform();
}
public void waitlogin(WebDriverWait wait) {
log.info("Mouse bekletiliyor");
wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Giriş Yap") ));
}
public void click(Actions actions) {
	log.info("Giris Yap butonuna tıklanıyor");
	actions.moveToElement(login).click().build().perform();
}

}