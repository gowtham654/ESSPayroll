package com.ESS.Payroll.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ESS.Payroll.PageObjects.HomePage;
import com.ESS.Payroll.PageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginstepdefinition {
	public WebDriver driver;
	public LoginPage lp;
	public HomePage hp;

	@SuppressWarnings("deprecation")
	@Given("^User should be on login Page$")
	public void user_should_be_on_login_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://masterdemo1.gtpoi.gr8hr3.com/");
		lp = new LoginPage(driver);
		System.out.println("given Statement");
		
	}

	@When("^User enter the username and password$")
	public void user_enter_the_username_and_password() throws Throwable {
		lp.enter_credential("5018", "sa");
		lp.clickLogin();
	}

	@Then("User should be navigated to Homepage")
	public void user_should_be_navigated_to_homepage() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		boolean status = driver.findElement(By.xpath("//span[.='View My Info']")).isDisplayed();
		Assert.assertEquals(true, status);
		System.out.println("then Statement");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement Salary =  (WebElement)jse.executeScript("return document.querySelector(\"#mainSidebar > perfect-scrollbar > div > div.ps-content > gt-ess-menu\").shadowRoot.querySelector(\"nav > ul > span:nth-child(4) > li > a > span\")");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Salary);
		WebElement payslip=(WebElement)jse.executeScript("return document.querySelector(\"#mainSidebar > perfect-scrollbar > div > div.ps-content > gt-ess-menu\").shadowRoot.querySelector(\"nav > ul > span.expanded > ul > li:nth-child(1) > a\")");
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", payslip);
	}
}
