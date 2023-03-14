package com.qa.practiceTest;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindows {
	static WebDriver driver;	
	public static void main(String []args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver ();
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.get("https://www.impactguru.com/");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");


	}








}
