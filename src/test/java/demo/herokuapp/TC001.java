package demo.herokuapp;
import static org.testng.Assert.assertEquals;

import java.util.Base64;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import demo.herokuapp.commons.ExcelHelpers;
import demo.herokuapp.commons.PageSetUp;

@Test
public class TC001 extends PageSetUp {

	   public void Login() throws InterruptedException {
	       
	       assertEquals(driver.getTitle(), "CURA Healthcare Service");
	       driver.findElement(By.id("btn-make-appointment")).click();
	       driver.findElement(By.id("txt-username")).sendKeys("John Doe");
	       String pw = new String(Base64.getDecoder().decode("VGhpc0lzTm90QVBhc3N3b3Jk"));
	       driver.findElement(By.id("txt-password")).sendKeys(pw);
	       driver.findElement(By.id("btn-login")).click();
	       
	   }


//	   public void book_appointments() throws InterruptedException {
//	       Login();
//	       
//	   }
	   
	   @Test (priority = 10)
	   public void login_w_data () throws Exception {
	      ExcelHelpers excel = new ExcelHelpers();
	      
	      excel.setExcelFile("//resources/Herokuapp_LoginUsers.xlsx", "Login");
	      driver.get("https://katalon-demo-cura.herokuapp.com/");
	      assertEquals(driver.getTitle(), "CURA Healthcare Service");
	      driver.findElement(By.id("btn-make-appointment")).click();
	      driver.findElement(By.id("txt-username")).sendKeys(excel.getCellData("username",1));
	      String pw = new String(Base64.getDecoder().decode(excel.getCellData("password", 1)));
	      driver.findElement(By.id("txt-password")).sendKeys(pw);
	      driver.findElement(By.id("btn-login")).click();
	   }


	   
	   
	}

