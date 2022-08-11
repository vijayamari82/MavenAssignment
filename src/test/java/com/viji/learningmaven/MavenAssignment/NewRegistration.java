package com.viji.learningmaven.MavenAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewRegistration {

	WebDriver driver;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/home");
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.manage().window().maximize();

	}

	@Test

	public void register() throws InterruptedException {

		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("William");
		driver.findElement(By.id("input-lastname")).sendKeys("James");
		driver.findElement(By.id("input-email")).sendKeys("newweb@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("4372886598");
		driver.findElement(By.id("input-password")).sendKeys("welcome@123");
		driver.findElement(By.id("input-confirm")).sendKeys("welcome@123");
		driver.findElement(By.cssSelector("#content > form > fieldset:nth-child(3) > div > div > label:nth-child(2) > input[type=radio]")).click();
		driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)")).click();
		driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary")).click();
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		driver.navigate().refresh();
		// login test
		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();

		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("newweb@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("welcome@123");
		driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Phones & PDAs")).click();
		driver.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div:nth-child(2) > div.button-group > button:nth-child(1)")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cart-total")).click();
		driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(2) > strong")).click();
		// purchaseorder
		driver.findElement(By.cssSelector("#collapse-payment-address > div > form > div:nth-child(3) > label > input[type=radio]")).click();
		driver.findElement(By.id("input-payment-firstname")).sendKeys("William");
		driver.findElement(By.id("input-payment-lastname")).sendKeys("James");
		driver.findElement(By.id("input-payment-address-1")).sendKeys("112, old Street");
		driver.findElement(By.id("input-payment-city")).sendKeys("Toronto");
		driver.findElement(By.id("input-payment-postcode")).sendKeys("M3B3G2");
		Select s = new Select(driver.findElement(By.id("input-payment-country")));
		Thread.sleep(3000);

		s.selectByVisibleText("Canada");
		Select s1 = new Select(driver.findElement(By.id("input-payment-zone")));
		Thread.sleep(3000);

		s1.selectByVisibleText("Ontario");
		driver.findElement(By.id("button-payment-address")).click();

		driver.findElement(By.id("button-shipping-address")).click();
		driver.findElement(By.id("button-shipping-method")).click();

		driver.findElement(By.cssSelector("#collapse-payment-method > div > div.buttons > div > input[type=checkbox]:nth-child(2)")).click();
		driver.findElement(By.id("button-payment-method")).click();
		driver.findElement(By.id("button-confirm")).click();
		String expected = "Your order has been successfully processed!";
		String actual = driver.findElement(By.cssSelector("#content > p:nth-child(2)")).getText();
		Assert.assertEquals(expected, actual);

		// logout
		driver.findElement(By.cssSelector("#top-links > ul > li.dropdown > a")).click();
		driver.findElement(By.linkText("Logout")).click();
		String Expectedmsg = "Account Logout";
		String actuallogout = driver.findElement(By.cssSelector("#content > h1")).getText();
		Assert.assertEquals(Expectedmsg, actuallogout);

	}

}
