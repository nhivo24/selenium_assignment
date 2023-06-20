package com.techweb.helloworld.LoginFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import demo.herokuapp.commons.PageSetUp;

public class AddClientTestTest  extends PageSetUp {

  @Test
  public void testAddNewClientTest() {
	  driver.get("https://rise.fairsketch.com/signin");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@demo.com");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(), 'Dashboard')]")).getText(), "Dashboard");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//a[.//span[text()='Clients']")).click();
      driver.findElement(By.xpath("//a[@title='Add client']")).click();
   
		driver.findElement(By.id("company_name")).sendKeys("kms");
		WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='select2-drop select2-display-none select2-with-searchbox select2-drop-active']"));

		Select dropdown = new Select(dropdownElement);

		dropdown.selectByValue("John Doe");
  }
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
