package basePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

	WebDriver driver;
	
	By Discuss = By.xpath("//a[@id='result_app_0']");
	By Inventory = By.xpath("//a[@id='result_app_1']");
	By Manufactoring = By.xpath("//a[@id='result_app_2']");
	
	By createButton = By.xpath("//button[contains(text(),'Create')]");
	
	By saveButton = By.xpath("//button[contains(text(),'Save')]");
	
	By homeMenu = By.xpath("//a[@title='Home menu']");
	
		
	public void clickOnLocator(WebDriver driver, By locator) {
		
		driver.findElement(locator).click();
		
	}
	
	public void inputText(WebDriver driver, By locator, String text) {
		
		driver.findElement(locator).sendKeys(text);

    }
	
	public void inputNumber(WebDriver driver, By locator, int number) {
		
		driver.findElement(locator).sendKeys(String.valueOf(number));

    }
	
	public void inputNumber(WebDriver driver, By locator, double number) {
		
		driver.findElement(locator).sendKeys(String.valueOf(number));

    }
	
}
