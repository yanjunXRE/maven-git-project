package test;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestFDelete {
	private WebDriver webDriver;
	@Test
	public void deleteButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/GuideServlet/dashboard");
		webDriver.findElement(By.id("delete")).click();
	}
	@Test
	public void editButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/GuideServlet/dashboard");
		webDriver.findElement(By.id("edit")).click();
	}
	@Test
	public void addButton() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/GuideServlet/dashboard");
		webDriver.findElement(By.id("addButton")).click();
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
		webDriver.quit();
  }

}
