package com.testinium.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class LoginPage  {
	private static Logger log  = Logger.getLogger(LoginPage.class.getName());
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements (this.driver,this);
		
	}
	@FindBy(id="L-UserNameField")
	WebElement username;
	
	@FindBy(id="L-PasswordField")
	WebElement password;	
	
	@FindBy(id="gg-login-enter")
	WebElement commit;	
	
	 public void setUser_email(String email){
		 log.info("Mail Adresi alınıyor");
		 username.clear();
		 username.sendKeys(email);
	   }
	 
	 public void enterPassword(String pass) {
		 log.info("Password alınıyor");
		 password.clear();
		 password.sendKeys(pass);
		 }
	 
	 public void signin(){
		 log.info("Login Yapılıyor");
	       commit.click();
	   }	
	 public void isLoggedin(WebDriverWait wait) {
		 log.info("Login Kontrolu");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='Hesabım']") ));
	 }
	   }

