package Testscript;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePages.InventoryPage;
import basePages.LoginPage;
import basePages.ManufacturingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import testdata.TestData;

public class testcase {
	static WebDriver driver;
	
	@BeforeTest
	public void setUptest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage login = new LoginPage(driver);
		login.LoginToPage(driver);
		
		String title = driver.getTitle();		
		System.out.println("The page title is "+ title);		
		
	}
	
	@Test
	public void Testcase() throws InterruptedException {
		
		//Go to Inventory Page
		InventoryPage newInventoryPage = new InventoryPage(driver);
		newInventoryPage.clickOnInventory();
		
		//Create a new product
		String newProduct = newInventoryPage.createProduct(driver, TestData.productName);
		assertEquals(newProduct, TestData.productName);
		
		//Update product quantity to greater than 10
		newInventoryPage.updateProductQuantity(driver, TestData.quantity);
		
		//Go to Manufacturing page and create a new Manufacturing with new created Product
		ManufacturingPage newManufacturing = new ManufacturingPage(driver);
		newManufacturing.clickOnHomeMenu(driver);
		newManufacturing.clickOnManufacturing(driver);
		String productOfManufacturing = newManufacturing.createManufacturing(driver);
		assertEquals(productOfManufacturing, TestData.productName);
	}

	@AfterTest
	public void tearDownTest() {
		// Close browser
		driver.quit();
	}	
}
