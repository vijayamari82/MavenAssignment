package com.viji.learningmaven.MavenAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAssign1 {
	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();

	}

	@Test
	
	public void SendKeysTest() {
		
	WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
	firstNameInputField.sendKeys("Meenu");
		
//	WebElement firstNameInputField = driver.findElement(By.id("input-firstname"));
//	firstNameInputField.sendKeys("Priya");
		
//	WebElement firstNameInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(2) input"));
//	firstNameInputField.sendKeys("Vijaya");
		
	WebElement lastNameInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(3) input"));
	lastNameInputField.sendKeys("Mari");
	
	WebElement emailInputField = driver.findElement(By.id("input-email"));
	emailInputField.sendKeys("vijayamr@gmail.com");
	
	WebElement telephoneInputField = driver.findElement(By.id("input-telephone"));
	telephoneInputField.sendKeys("43726577");
	
	WebElement passwordInputField = driver.findElement(By.id("input-password"));
	passwordInputField.sendKeys("welcome123");
	
	WebElement confirmPasswordInputField = driver.findElement(By.id("input-confirm"));
	confirmPasswordInputField.sendKeys("welcome123");
	
//	WebElement policyCheckInputField = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(1)"));
//	policyCheckInputField.click();
	
//	WebElement checkBoxInputField = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(1)"));
//	checkBoxInputField.click();
	
	WebElement continueButtonInputField = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(2)"));
	continueButtonInputField.click();
	
	WebElement alertBanne = driver.findElement(By.cssSelector("#account-register div.alert"));
	String alertBannerText=alertBanne.getText();
	System.out.println(alertBannerText);
	Assert.assertEquals(alertBannerText,"Warning: You must agree to the Privacy Policy!","Text does not match");
	
	
	}

	@AfterMethod

	public void tearDown() {
	driver.close();

}
	



}
