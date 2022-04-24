package basePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testdata.TestData;

public class ManufacturingPage extends MainPage {
	
	WebDriver driver;
	
	By productInput = By.xpath("//div[@name='product_id']//input");
	By productItemDropdown = By.xpath("//a[contains(text(),'" + TestData.productName + "')]");
	By confirmButton = By.xpath("//span[text()='Confirm']/..");
	By maskAsDoneButton = By.xpath("//button[contains(@confirm,'no components')]/span[text()='Mark as Done']/..");
	By okButton = By.xpath("//span[text()='Ok']/..");
	By applyButton = By.xpath("//span[text()='Apply']/..");
	By ariaCheckAttribute = By.xpath("//button[@aria-checked='true']");
	By productOfManufacturing = By.xpath("//a[@name='product_id']/span");
	
	public ManufacturingPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void clickOnHomeMenu(WebDriver driver) {
		
		clickOnLocator(driver, homeMenu);
		
	}
	
	public void clickOnManufacturing(WebDriver driver) {
		
		clickOnLocator(driver, Manufactoring);
	
	}
	
	public String createManufacturing (WebDriver driver) throws InterruptedException {
		
		WebElement createButtonVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(createButton));
		
		// Click on Create button
		createButtonVisible.click();
		
		inputText(driver, productInput, TestData.productName);
		
		WebElement productItemVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(productItemDropdown));
		
		
		productItemVisible.click();
//		clickOnLocator(driver, productItemDropdown);
		
		clickOnLocator(driver, saveButton);
		
		Thread.sleep(2000); // Wait for updating page and prevent failure when click on button
		
		WebElement confirmBtnVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(confirmButton));
		
		confirmBtnVisible.click();
		
		Thread.sleep(2000); // Wait for updating page and prevent failure when click on button
		
		WebElement markAsDoneBtnVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(maskAsDoneButton));
		
		markAsDoneBtnVisible.click();
		
		WebElement okBtnVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(okButton));
		
		okBtnVisible.click();
		
		WebElement applyBtnVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(applyButton));
		
		applyBtnVisible.click();
		
		Thread.sleep(2000); // Wait for updating page and prevent failure when click on button
//		WebElement ariaCheckVisible = new WebDriverWait(driver, Duration.ofSeconds(10))
//				.until(ExpectedConditions.visibilityOfElementLocated(ariaCheckAttribute));
		
		String manufactoringStatus = driver.findElement(ariaCheckAttribute).getText();
		
		if (manufactoringStatus.equalsIgnoreCase("Done")) {
			System.out.println("Manufactoring is updated to " + manufactoringStatus);
		}
		else  System.out.println("Manufactoring is NOT updated to Done");
		
		return driver.findElement(productOfManufacturing).getText();
		
	}

}
