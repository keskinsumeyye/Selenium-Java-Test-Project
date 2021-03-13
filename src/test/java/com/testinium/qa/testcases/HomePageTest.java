
package com.testinium.qa.testcases;
import com.testinium.qa.pages.AddtoBasket;
import com.testinium.qa.pages.Basket;
import com.testinium.qa.pages.HomePage;
import com.testinium.qa.pages.LoginPage;
import com.testinium.qa.pages.SearchPage;
import com.testinium.qa.pages.SelectProduct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import com.testinium.qa.base.TestBase;


public class HomePageTest extends TestBase {
	private static Logger log  = Logger.getLogger(HomePageTest.class.getName());
	@Before
	public void BeforeMethod() {
	PropertyConfigurator.configure("C:\\Users\\sumey\\eclipse-workspace\\projectt\\src\\test\\java\\resource\\log4j.properties");
	log.info("Setup Test");
	super.BeforeMethod();	
	String URL = "https://www.gittigidiyor.com/"; 
	log.info("Siteye Gidiliyor");
	driver.get(URL);
	assertEquals("Sayfaya ulaşılamadı", URL, driver.getCurrentUrl());
	
	}	
   @Test
	public void HomeTest() throws InterruptedException {
		// TODO Auto-generated method stub
    HomePage home = new HomePage(driver);
    
    LoginPage login = new LoginPage(driver);
    
    SearchPage search = new SearchPage(driver);
    
    SelectProduct product = new SelectProduct(driver);
    
    AddtoBasket addproduct= new AddtoBasket(driver);
    
    Basket basket= new Basket(driver);
    
    Actions actions = new Actions(driver);
    home.moveElement(actions);
    home.waitlogin(wait);
    home.click(actions);  
    
    login.setUser_email("email here");
    login.enterPassword("password here");
    login.signin();
    login.isLoggedin(wait);
   
    search.search("Bilgisayar");
    search.searchClick();
    search.second_page_click();
    assertTrue("2.sayfa acilmadi.",search.isPageOpened());
    
    
    product.product_select_click();
    String p_price = product.product_price();
    addproduct.add_to_basket_click();
    Thread.sleep(10000);
    addproduct.go_to_basket_click();
    String b_price=basket.product_price_2();
    assertEquals("esit degil",p_price,b_price);
    basket.number_of_product();
    System.out.println(basket.getNumberofProduct());
    assertEquals("Urun 2 adet degil","2",basket.getNumberofProduct());
    Thread.sleep(10000);
    basket.delete_product_click();
	}
   
   @After
   public  void AfterMethod(){		     
	   super.AfterMethod();	
	}
}
