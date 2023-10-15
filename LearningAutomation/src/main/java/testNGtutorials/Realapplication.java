package testNGtutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Realapplication {
	WebDriver driver;

	@BeforeClass
	public void startbrowser() {
		driver = new ChromeDriver();
		System.out.println("Browser is started");
	}

	@Test
	public void startapp() {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("auth/login"));
		System.out.println("Application loaded");

	}

	@Test(dependsOnMethods = "startapp")
	public void loginApp() {
		driver.findElement(
				By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
				.sendKeys("Admin");
		driver.findElement(
				By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"))
				.sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		boolean status = driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a"))
				.isDisplayed();
		Assert.assertTrue(status);
		System.out.println("Login Successfull and verified");

	}

	@Test(dependsOnMethods = "loginApp")
	public void logoutapp() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\'app\']/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.findElement(
				By.xpath("//*[@id=\'app\']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
				.isDisplayed();
		System.out.println("Logout Successfully");
	}
	
	@AfterClass
	public void closingbrowser() {
		driver.quit();
		System.out.println("Browser is closed successfully");
	}
}
