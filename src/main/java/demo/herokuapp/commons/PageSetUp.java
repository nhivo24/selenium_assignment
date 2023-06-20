package demo.herokuapp.commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageSetUp {
	
	protected WebDriver driver;
	protected  String projectPath = System.getProperty("user.dir");

	       @BeforeTest
	       public void beforeTest() {
	    	   System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
	    	   driver = new FirefoxDriver();
	           driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	           driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	           driver.manage().window().maximize();
	           driver.get("https://rise.fairsketch.com/signin");
	       }
	     
	       @AfterTest
	       public void afterTest() throws Exception {
	           Thread.sleep(3000);
	           driver.quit();


}
}
