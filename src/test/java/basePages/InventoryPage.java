package basePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testdata.TestData;


public class InventoryPage extends MainPage {
	
	WebDriver driver;
	
	By inventoryLinkMenu = By.xpath("//a[text()='Inventory']");
	By inventoryOverviewText = By.xpath("//span[text()='Inventory Overview']");
	By productDropdown = By.xpath("//span[text()='Products']/../..");
	By productDropdownItem = By.xpath("//a[text()='Products']");
	
	By productNameXpath = By.xpath("//input[@name='name']");	
	By internalReference = By.xpath("//input[@name='default_code']");
	By barcode = By.xpath("//input[@name='barcode']");
	By internalNoteXpath = By.xpath("//p[contains(@class,'temporary-hint')]");
	
	By updateQuantity = By.xpath("//span[text()='Update Quantity']");   //  //button[@name='action_update_quantity_on_hand']
	By inventoryQuantity = By.xpath("//input[@name='inventory_quantity']");
	By updateQuantitySearch = By.xpath("//span[@class='o_facet_value']/../..");
	By inventoryQuantityDataField = By.xpath("//span[@name='inventory_quantity']");
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnInventory() {
		clickOnLocator(driver, Inventory);
	}
	
	public String createProduct(WebDriver driver, String productName) {
		// Click on Products in header
		clickOnLocator(driver, productDropdown);
				
		WebElement productItem = new WebDriverWait(driver, Duration.ofSeconds(10))
    			.until(ExpectedConditions.visibilityOfElementLocated(productDropdownItem));
		// Click on Product Item
		productItem.click();
		
		clickOnLocator(driver, createButton);
		
		inputText(driver, productNameXpath, TestData.productName);
	
		clickOnLocator(driver, saveButton);
		
		System.out.println("New Product is created: " + productName );
				
		return productName;
		
	}
		
	public void updateProductQuantity(WebDriver driver, double inventQuantity) throws InterruptedException {
		
		Thread.sleep(2000);  // Wait for loading page and prevent failure when clicking on Update Quantity button
		WebElement updateQuantityButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(updateQuantity));
		updateQuantityButton.click();
		
		WebElement updateQuantityFacet = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(updateQuantitySearch));
		
		updateQuantityFacet.isDisplayed();
		
		WebElement createButtonVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(createButton));
		
		// Click on Create button
		createButtonVisible.click();
		
		WebElement inventNumber = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(inventoryQuantity));
		
		inventNumber.clear();
			
		inventNumber.sendKeys(String.valueOf(inventQuantity));
	    
		clickOnLocator(driver, saveButton);
		
		String quantity = driver.findElement(inventoryQuantityDataField).getText();
		
		double quantityDouble = Double.parseDouble(quantity);		
		
		System.out.println("Inventory Quatity is updated to " + quantityDouble );
		
		if (quantityDouble == inventQuantity) System.out.println("Quantity is update successfully!");
		else System.out.println("Quantity is updated Unsuccessfully!");
				
	}
	

}
