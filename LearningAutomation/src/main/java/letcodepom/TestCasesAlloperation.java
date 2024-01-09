package letcodepom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;

public class TestCasesAlloperation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	//	System.setProperty("webdriver.chrome.driver", "");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/books");
		

		// Creating object of home page
		HomePage home = new HomePage(driver);

		// Creating object of Login page
		LoginPage login = new LoginPage(driver);

		// Creating object of Dashboard
		DashboardPage dashboard = new DashboardPage(driver);

		// Click on Login button
		home.clickLogin();

		// Enter username & password
		login.enterUsername("gunjankaushik");
		login.enterPassword("Password@123");

		// Click on login button
		login.clickLogin();
		Thread.sleep(3000);

		// Capture the page heading and print on console
		//System.out.println("Search Content is --- " + search);
		System.out.println("The page heading is --- " + dashboard.getHeading());

		// Click on Logout button
		dashboard.clickLogout();

		// Close browser instance
		driver.quit();
	}
}
