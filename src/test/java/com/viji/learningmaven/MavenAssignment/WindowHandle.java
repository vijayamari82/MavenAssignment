package com.viji.learningmaven.MavenAssignment;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle {

	WebDriver driver;
	Actions ac;

	@BeforeMethod
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		ac = new Actions(driver);

		// driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();

		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test()
	public void windowHandleExample() {

		String windowHAndle = driver.getWindowHandle();
		System.out.println(windowHAndle);

		driver.findElement(By.id("tabButton")).click();
		Set<String> h1 = driver.getWindowHandles();

		for (String windowHandle : h1) {
			if (!windowHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

//String textFromNewTab = driver.findElement(By.id("sampleHeading")).getText();
//System.out.println(textFrom);

		driver.switchTo().window(windowHAndle);

		driver.findElement(By.id("windowButton")).click();
		Set<String> h2 = driver.getWindowHandles();

		for (String windowHandle : h2) {
			if (!windowHandle.equals(windowHandle)) {
				driver.switchTo().window(windowHandle);
			}
		}

		driver.switchTo().window(windowHAndle);

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
