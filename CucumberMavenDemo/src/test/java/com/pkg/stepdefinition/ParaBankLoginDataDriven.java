package com.pkg.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankLoginDataDriven {

	public WebDriver driver;

	@Given("user launch parabank page")
	public void user_launch_parabank_page() {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		System.out.println("Application launch successfully");
	}

	@When("user enter credentials {string} and {string}")
	public void user_enter_credentials_and(String username, String password) {
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Enter username and password are entered successfully");
	}

	@And("click at login buttons")
	public void click_at_login_buttons() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		System.out.println("Clicked on login button");
		 
	}

	@Then("user should view home page")
	public void user_should_view_home_page() {
		boolean status=driver.findElement(By.partialLinkText("New Account")).isDisplayed();
		if(status) {
			System.out.println("User home page is displayed");
			
		}
	}

	@Then("user should close the application")
	public void user_should_close_the_application() {
		driver.quit();
		System.out.println("Application closed successfully");
	}


}
