package com.techweb.helloworld.LoginFunction;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.herokuapp.commons.PageSetUp;

public class login_rise_fairsketch extends PageSetUp{
	//WebDriver driver;

	@Test
	public void TC_01_SignIn_Empty_Data(){
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false);
		//Assert.assertTrue(true);
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("email-error")).getText(), "This field is required.");
		Assert.assertEquals(driver.findElement(By.id("password-error")).getText(), "This field is required.");
	}

	@Test
	public void TC_02_SignIn_Invalid_Email() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("vothinhi");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false);
		//Assert.assertTrue(true);
		//Verify error message as expected
		
		Assert.assertEquals(driver.findElement(By.id("email-error")).getText(), "Please enter a valid email address.");
		
		
	}

	@Test
	public void TC_03_SignIn_Incorrect_Email() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("vothinhi2410@gmail.com");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		sleepInSecond(2);
		
		//kiểm tra dữ liệu trả về đúng/sai
		//Assert.assertFalse(false);
		//Assert.assertTrue(true);
		//Verify error message as expected
		

		try {
            WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]//text()[contains(., 'Authentication failed!')]"));
            System.out.println("Thông báo lỗi xác thực tồn tại.");
        } catch (Exception e) {
            System.out.println("Thông báo lỗi xác thực không tồn tại.");
        }

	
	}


//	@Test
//	public void TC_04_SignIn_Incorrect_Password() {
//		driver.get("https://rise.fairsketch.com/signin");
//		driver.findElement(By.id("email")).clear();
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("email")).sendKeys("admin@demo.com");
//		driver.findElement(By.id("password")).sendKeys("rise");
//		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
//		sleepInSecond(2);
//		
//		//kiểm tra dữ liệu trả về đúng/sai
//		//Assert.assertFalse(false);
//		//Assert.assertTrue(true);
//		//Verify error message as expected
//		
//
//		try {
//            WebElement alert = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger') and contains(text(), 'Authentication failed!')]"));
//            System.out.println("Thông báo lỗi xác thực tồn tại.");
//        } catch (Exception e) {
//            System.out.println("Thông báo lỗi xác thực không tồn tại.");
//        }
//
//		
//	}

	@Test
	public void TC_05_SignIn_Sucessfully() {
		driver.get("https://rise.fairsketch.com/signin");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("email")).sendKeys("admin@demo.com");
		driver.findElement(By.id("password")).sendKeys("riseDemo");
		driver.findElement(By.xpath("//button[text()='Sign in'] ")).click();
		sleepInSecond(2);
		
		Assert.assertEquals(driver.findElement(By.xpath("//h4[contains(text(), 'Dashboard')]")).getText(), "Dashboard");

	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
