import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTestF {
	private WebDriver webDriver;	
  @Test
  public void checkTitle() {
	  webDriver.navigate().to("http://localhost:8090/devopsproject/AddForum.jsp");
	  WebElement we =  webDriver.findElement(By.id("title"));
	  
	  System.out.println("id title: "+we.getAttribute("placholder"));
	  Assert.assertEquals(we.getAttribute("placeholder"), "Enter title");
  }
  @Test
  public void checkText() {
	  webDriver.navigate().to("http://localhost:8090/devopsproject/AddForum.jsp");
	  WebElement we =  webDriver.findElement(By.id("text"));

	  System.out.println("id text: "+we.getAttribute("placholder"));
	  Assert.assertEquals(we.getAttribute("placeholder"), "Enter text");
  }
  @Test
  public void checkType() {
	  webDriver.navigate().to("http://localhost:8090/devopsproject/AddForum.jsp");
	  WebElement we =  webDriver.findElement(By.id("type"));
	  
	  System.out.println("id type: "+we.getAttribute("placholder"));
	  Assert.assertEquals(we.getAttribute("placeholder"), "Enter type of comment");
  }
  @Test
  public void checkZubmit() {
	  webDriver.findElement(By.id("type")).submit();
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
	  //webDriver.quit();
  }

}
