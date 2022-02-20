import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTestR {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkName() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		WebElement we = webDriver.findElement(By.id("name"));

		System.out.println("id name: " + we.getAttribute("placeholder"));
		Assert.assertEquals(we.getAttribute("placeholder"), "Enter Name");
	}
	
	@Test
	public void checkAddress() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		WebElement we = webDriver.findElement(By.id("address"));

		System.out.println("id address: " + we.getAttribute("placeholder"));
		Assert.assertEquals(we.getAttribute("placeholder"), "Enter Address");
	}
	
	@Test
	public void checkImage() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		WebElement we = webDriver.findElement(By.id("image"));

		System.out.println("id image: " + we.getAttribute("placeholder"));
		Assert.assertEquals(we.getAttribute("placeholder"), "Enter Image");
	}
	
	@Test
	public void checkPhone() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		WebElement we = webDriver.findElement(By.id("phone"));

		System.out.println("id phone: " + we.getAttribute("placeholder"));
		Assert.assertEquals(we.getAttribute("placeholder"), "Enter Phone");
	}
	
	@Test
	public void checkDescription() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		WebElement we = webDriver.findElement(By.id("description"));

		System.out.println("id description: " + we.getAttribute("placeholder"));
		Assert.assertEquals(we.getAttribute("placeholder"), "Enter Description");
	}
	
	@Test
	public void checkSubmit() {
		webDriver.findElement(By.id("description")).submit();
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
