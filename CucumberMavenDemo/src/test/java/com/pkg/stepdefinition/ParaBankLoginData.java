package com.pkg.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankLoginData {

	public WebDriver driver;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		System.out.println("Application launch successfully");
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys("testdemo12");
		driver.findElement(By.name("password")).sendKeys("testdemo123");
		System.out.println("Enter username and password are entered successfully");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		System.out.println("Clicked on login button");
	}

	@Then("display user home page")
	public void display_user_home_page() {
		boolean status=driver.findElement(By.partialLinkText("New Account")).isDisplayed();
		if(status) {
			System.out.println("User home page is displayed");
		}
	}

	@And("user will close the application")
	public void user_will_close_the_application() {
		driver.quit();
		System.out.println("Application closed successfully");
	}


}
