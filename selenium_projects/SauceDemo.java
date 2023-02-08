package maxgen_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {
  WebDriver driver;
  
  @BeforeTest
  void setUp() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  
			  
  }
  @Test(priority=1)
  void Login() {
	  driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	  driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
	  driver.findElement(By.xpath("//input[@id='login-button']")).click();
	  
  }
  @Test(priority=2)
	void productPageItem() throws InterruptedException {
		List<WebElement> sort=driver.findElements(By.xpath("//select[@class='product_sort_container']/child::option"));
        
		System.out.println(sort.size());
		
		for(int i=0; i<sort.size(); i++) {
			System.out.println(sort.get(i).getText());
			
		}
  
  driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
  
  Thread.sleep(5000);
  
  driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
  
  driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
  
  
  }
  @Test(priority=3)
  void checkOut() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//button[@id='checkout']")).click();
	  driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Sanket");
	  driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Patil");
	  driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("416619");
	  driver.findElement(By.xpath("//input[@id='continue']")).click();
	  
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//button[@id='finish']")).click();
	  
	 String title =driver.findElement(By.xpath("//h2[@class='complete-header']")).getText();
	  Assert.assertEquals(title,"THANK YOU FOR YOUR ORDER");
	  
	  
	  
	  
  }
	@AfterTest
  void tearDown() {
	  
	  driver.close();
  }
	
}
