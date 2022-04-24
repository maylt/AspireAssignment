package basePages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends MainPage {
	
	WebDriver driver;
	
	public  String Email = "user@aspireapp.com";
	public  String Password = "@sp1r3app";  
	public  String URL = "https://aspireapp.odoo.com/web/login";
	
	By loginId	= By.xpath("//input[@id='login']");
    By password  = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[text()='Log in']");
    By userIcon = By.xpath("//img[contains(@class,'o_user_avatar')]");
    
    public LoginPage (WebDriver driver) {
    	this.driver = driver;
    	
    }
    
    public void openAspirePage(WebDriver driver) {
    	
    	driver.get(URL);
    	
    	driver.manage().window().maximize();
    	
    }
    
    public void LoginToPage(WebDriver driver) {
    	
    	openAspirePage(driver);
    	inputText(driver, loginId, Email);  // Input Email
    	inputText(driver, password, Password);  // Input Password
    	clickOnLocator(driver, loginButton); // Click on Login
    	
    	// Wait for User login image is displayed after clicking on Login button
    	WebElement imageUser = new WebDriverWait(driver, Duration.ofSeconds(10))
    			.until(ExpectedConditions.visibilityOfElementLocated(userIcon));
    	
    	if(imageUser.isDisplayed()) {
    		System.out.println("Login Successfully!");
    	}
    	else {
    		System.out.println("Login Failed!");
    	}
    }
}
