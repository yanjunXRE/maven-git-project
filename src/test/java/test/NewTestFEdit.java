package test;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestFEdit {
	private WebDriver webDriver;
  @Test
	public void checkEditTitle() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/forumEdit.jsp");
		webDriver.findElement(By.id("title")).sendKeys("test title");
	}
  @Test
 	public void checkEditText() {
 		// Load website as a new page
 		webDriver.navigate().to("http://localhost:8088/devopsproject/forumEdit.jsp");
 		webDriver.findElement(By.id("text")).sendKeys("test text");
 	}
  @Test
 	public void checkEditType() {
 		// Load website as a new page
 		webDriver.navigate().to("http://localhost:8088/devopsproject/forumEdit.jsp");
 		webDriver.findElement(By.id("type")).sendKeys("test type");
 	}
  @Test
	public void checkSubmit() {
		webDriver.findElement(By.id("type")).submit();
	}
  
  @BeforeTest
  public void beforeTest() {
	// Setting system properties of ChromeDriver
			// to amend directory path base on your local file path
			String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", chromeDriverDir);

			// initialize FirefoxDriver at the start of test
			webDriver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	// Quit the ChromeDriver and close all associated window at the end of test
			webDriver.quit();
  }

}
