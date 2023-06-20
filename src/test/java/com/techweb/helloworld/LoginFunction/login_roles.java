package com.techweb.helloworld.LoginFunction;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import demo.herokuapp.commons.PageSetUp;

public class login_roles extends PageSetUp {

	@Test
	public void TC_05_SignIn_Admin() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@demo.com");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//li[contains(@class, 'main')]//a[span[text()='Clients']]")).getText(), "Clients");

	}
	@Test
	public void Logout() {
		driver.findElement(By.xpath("//*[@id='user-dropdown']")).click();
		driver.findElement(By.xpath("//li/a[contains(text(), 'Sign Out')]")).click();
		
	}
	@Test
	public void TC_05_SignIn_Client() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("client@demo.com");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='announcement-1']//a[text()='Welcome to Demo!')]")).getText(), "Welcome to Demo!");

	}
}
