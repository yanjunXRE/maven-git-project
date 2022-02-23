package test;
import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTestrEdit {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test
	public void checkEditName() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantEdit.jsp");
		webDriver.findElement(By.id("name")).sendKeys("Jollibean");
	}
	
	@Test
	public void checkEditAddress() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantEdit.jsp");
		webDriver.findElement(By.id("address")).sendKeys("Jurong West");
	}
	
	@Test
	public void checkEditImage() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantEdit.jsp");
		webDriver.findElement(By.id("name")).sendKeys("image");
	}
	
	@Test
	public void checkEditPhone() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantEdit.jsp");
		webDriver.findElement(By.id("name")).sendKeys("90102100");
	}
	
	@Test
	public void checkEditDescription() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8088/devopsproject/restaurantList.jsp");
		webDriver.findElement(By.id("name")).sendKeys("FR chicken better than kfc, Kfc for boomer");
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
