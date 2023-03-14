package com.qa.practiceTest;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	static WebDriver driver;
	static DropDown pt;
	static By startFR= By.id("hp-main-start-fundraiser");
	static By dropDown = By.xpath("//div[@class='d-flex flex-column w-100']//select[@id = 'beneficiaryType']");


	public static void main(String []args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.impactguru.com");
		pt = new DropDown();
		String parent= driver.getWindowHandle();
		pt.doClick(startFR);
		Set<String> pandc= driver.getWindowHandles();
		for(String e : pandc) {
			if(!(e.equals(parent))) {
				driver.switchTo().window(e);
			}
		}
		System.out.println(driver.getCurrentUrl());
		try {
		Thread.sleep(3000);
		} 
		catch(InterruptedException e ) {
			e.printStackTrace();
		}
			pt.byIndex(dropDown, 3);
			try {
				Thread.sleep(3000);
				} 
				catch(InterruptedException e ) {
					e.printStackTrace();
				}
			pt.byValue(dropDown,"1");
			try {
				Thread.sleep(3000);
				} 
				catch(InterruptedException e ) {
					e.printStackTrace();
				}
			pt.byVisibleText(dropDown,"Personal Cause");
			
			
		//driver.close();
	}
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}
	public void byIndex(By locator , int index) {
		Select s = new Select(getElement(locator));
		s.selectByIndex(index);
	}	
	public void byVisibleText(By locator , String text) {
		Select s = new Select(getElement(locator));
		s.selectByVisibleText(text);
	}
	public void byValue(By locator,String value) {	
		Select s = new Select(getElement(locator));
		s.selectByValue(value);
	}
	public void getSize(By locator)
	{
		Select s = new Select(getElement(locator));
		List<WebElement> opt = s.getOptions();
		int size = opt.size();
		System.out.println(size);	
	}
	public void getAllElementText(By locator) {
		Select s = new Select(getElement(locator));
		List<WebElement> opt=  s.getOptions();
		for(WebElement e : opt) {
			String text = e.getText();
			System.out.println(text);
		}
		/*for (int i=0; i<opt.size();i++) {
			String text = opt.get(i).getText();
			}
			*/
		
		
	}

}






