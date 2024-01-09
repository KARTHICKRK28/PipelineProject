package pages;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;

	}

	// Locator for login button
	By LoginBtn = By.id("login");

	
	// Method to click login button
	public void clickLogin() {
		driver.findElement(LoginBtn).click();
	}

}
