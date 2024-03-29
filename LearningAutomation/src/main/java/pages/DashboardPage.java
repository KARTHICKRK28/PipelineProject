package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators for the page title and the logout button
	By heading = By.xpath("//div[@class=\"main-header\"]");
	By Search = By.id("searchBox");
	By logoutBtn = By.id("submit");

	// Method to capture the page heading
	public String getHeading() throws InterruptedException {
		String head = driver.findElement(heading).getText();
		driver.findElement(Search).sendKeys("speak");
		System.out.println("Content is Searched");
		Thread.sleep(3000);
		return head;
	}

	// Method to click on Logout button
	public void clickLogout() {
		driver.findElement(logoutBtn).click();
	}

}
