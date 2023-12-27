package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LearnDataProvider {

	// @Parameters({"emailId"})

	@Test(dataProvider = "getData", dataProviderClass = DataUtils.class)
	public void login(String data[]) throws InterruptedException {
		// TODO Auto-generated method stub

		System.err.println("Email :" + data[0]);
		System.err.println("Pass :" + data[1]);

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://letcode.in/");
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.name("email")).sendKeys(data[0]);
		driver.findElement(By.name("password")).sendKeys(data[1]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='LOGIN']"));
		String title = driver.getTitle();
		System.out.println("Title is :" + title);
		driver.quit();
	}

}
