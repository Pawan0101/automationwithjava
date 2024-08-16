package com.pkg.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBankLoginScenario {

	public WebDriver driver;

	@Given("launch the application")
	public void launch_the_application() {
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		System.out.println("Application launch successfully");

	}

	@When("username and password are entered")
	public void username_and_password_are_entered() {

		driver.findElement(By.name("username")).sendKeys("testdemo12");
		driver.findElement(By.name("password")).sendKeys("testdemo123");
		System.out.println("Enter username and password are entered successfully");
	}

	@And("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
		System.out.println("Clicked on login button");
	}
	


	@Then("display the user home page")
	public void display_the_user_home_page() {

		//driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/p/b"));
		String actTitle=driver.getTitle();
		String expTitle="ParaBank | Accounts Overview";

		if(actTitle.equals(expTitle)) {

			System.out.println("User home page display successfully");
			System.out.println("The title of the page is " + actTitle);
		}
		else {
			System.out.println("The actual and expected title are not same");
			System.out.println("The actual title of the page is " + actTitle);
			System.out.println("The expected title of the page is " + expTitle);

		}
	}

	@And("logout the application")
	public void logout_the_application() {
		//*[@id="leftPanel"]/ul/li[8]/a  //*[@id="leftPanel"]/ul/li[8]/a
		driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
		System.out.println("Logout successfully");
	}

	@And("close the application")
	public void close_the_application() {
		driver.quit();
		System.out.println("Application closed successfully");
	}	
	
	@When("invalid username and Password are entered")
	public void invalid_username_and_password_are_entered() {
		driver.findElement(By.name("username")).sendKeys("testdemo82");
		driver.findElement(By.name("password")).sendKeys("Pkg@4997");
		System.out.println("Invalid username and password entered");
	}

	//@Then("click on login button")
	//public void click_on_login_button() {
	//	driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input")).click();
	//	System.out.println("Clicked on login button");
		
	//}
	
	@Then("unable to login")
	public void unable_to_login() {
		WebElement errMsg=	driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
		System.out.println(errMsg.getText());
	    System.out.println("Unable to login");
	}


}
