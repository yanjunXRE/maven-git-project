package test;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
  //declare Selenium WebDriver
  private WebDriver webDriver;		
  
  @Test
  public void checkEmailPlaceHolder() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8088/devopsproject/login.jsp");
	  WebElement we =  webDriver.findElement(By.id("email"));
	  
	  System.out.println("id email: "+we.getAttribute("placeholder"));
	  Assert.assertEquals(we.getAttribute("placeholder"), "Enter email");
  }
  @Test
  public void checkPasswordPlaceHolder() {
	  //Load website as a new page
	  webDriver.navigate().to("http://localhost:8088/devopsproject/login.jsp");
	  WebElement we =  webDriver.findElement(By.id("pwd"));
	  
	  System.out.println("id email: "+we.getAttribute("placeholder"));
	  Assert.assertEquals(we.getAttribute("placeholder"), "Enter password");
  }
  
  
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver.quit();			
  }

}
