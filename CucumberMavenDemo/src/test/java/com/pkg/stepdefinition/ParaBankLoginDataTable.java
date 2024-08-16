package com.pkg.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankLoginDataTable {

	public WebDriver driver;

	@Given("user on login page")
	public void user_on_login_page() {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		System.out.println("Application launch successfully");
	}

	@When("user enters the credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		List<Map<String, String>> credentials= dataTable.asMaps(String.class, String.class);
		String username=credentials.get(0).get("UserName");
		String password=credentials.get(0).get("Password");
		System.out.println("credentials is: "+username +","+ password );
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Enter username and password are entered successfully");
	}

	@And("clicks at login button")
	public void clicks_at_login_button() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		System.out.println("Clicked on login button");
	}

	@Then("display view home page")
	public void display_view_home_page() {
		boolean status=driver.findElement(By.partialLinkText("New Account")).isDisplayed();
		if(status) {
			System.out.println("User home page is displayed");
			
		}
	}
	
	@And("close application")
	public void close_application() {
		driver.quit();
		System.out.println("Application closed successfully");
	}


}
