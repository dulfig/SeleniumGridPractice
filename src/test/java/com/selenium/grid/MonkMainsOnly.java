package com.selenium.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MonkMainsOnly {
	private static final String url = "https://wiki.project1999.com/monk";
	
	public RemoteWebDriver driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);	
	}
	@Test
	public void testTitleInChrome() {
		driver.get(url);
		Assert.assertTrue(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/h1[1]/span[1]")).getText().equalsIgnoreCase("Monk"), "Damn must be a Necro");
	}
	/*
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}*/
}
