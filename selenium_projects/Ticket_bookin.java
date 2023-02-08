package maxgen_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ticket_bookin {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='product_3186']")).click();
		driver.findElement(By.xpath("//input[@id='travname']")).sendKeys("Sanket");
		
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
	       WebElement yer = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		     Select yr=new Select(yer);
		     yr.selectByVisibleText("2000");
		      
		     
		     WebElement mont=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
				Select mon=new Select(mont);
				mon.selectByVisibleText("Mar");
		                
		          
		
		Thread.sleep(3000);
				String date="10";
		List<WebElement> allDates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
		
		
		for(WebElement ele:allDates)
		{    String dt=ele.getText();		
			if(date.equals(dt)) {
				ele.click();
				break;
			}
				
		}

             driver.findElement(By.xpath("//input[@id='sex_1']")).click();
		 
		
		driver.findElement(By.xpath("//input[@id='addmorepax']")).click();
		List<WebElement> allOpt=driver.findElements(By.xpath("//select[@name='addpaxno']/child::option"));
		 System.out.println(allOpt.size());
		 
		 for(int i=0; i<allOpt.size(); i++)
		 {
			 String lst=allOpt.get(i).getText();
			 if(lst.equals("I'm the only traveler "))
			 {
				 allOpt.get(i).click();
				 
			 }
		 } 
		 driver.findElement(By.xpath("//p[@id='traveltype_field']//span[@class='woocommerce-input-wrapper']")).click();
		 
		 driver.findElement(By.xpath("//input[@id='fromcity']")).sendKeys("Kolhapur");
			 driver.findElement(By.xpath("//input[@id='tocity']")).sendKeys("pune");
			 
			 //departure date
			 
			 
			
	
		//deleivery options  
       List<WebElement> dumTickOpt= driver.findElements(By.xpath("//select[@name='reasondummy']/child::option"));	 
 	System.out.println(dumTickOpt.size());		
		for(int i=0; i<dumTickOpt.size(); i++)
		{
			String opt3=dumTickOpt.get(i).getText();
			if(opt3.equals("Office work place needs it"))
			{
				dumTickOpt.get(i).click();
				break;
			}					
		}
		
		//receive dummy ticket
		driver.findElement(By.xpath("//input[@id='deliverymethod_3']")).click();
		
		//biling details
		
	driver.findElement(By.xpath("//input[@id='billname']")).sendKeys("Sanket patil");
		
		driver.findElement(By.xpath("//input[@id='billing_phone']")).sendKeys("9503704610");
		
		driver.findElement(By.xpath("//input[@id='billing_email']")).sendKeys("abc@gmail.com");
		
//	WebElement ctry=driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
//		Select countr=new Select(ctry);
//		countr.selectByValue("India");
		
		//driver.findElement(By.xpath("//*[@id=\"select2-billing_country-result-vrii-IN\"]")).click();
		
		driver.findElement(By.xpath("//input[@id='billing_address_1']")).sendKeys("near marathi school, Chinchwad");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='billing_address_2']")).sendKeys("near Patil sport");
		driver.findElement(By.xpath("//input[@id='billing_city']")).sendKeys("KOLHAPUR");
		
	//State selection

//       driver.findElement(By.cssSelector("span[id='select2-billing_state-container'] span[class='select2-selection__placeholder']")).sendKeys("Maharashtra");
//		 Thread.sleep(2000);
//      Actions act=new Actions(driver);
//		   act.sendKeys(Keys.ENTER).perform();
				   
      
         
//         for(int i=0; i<allState.size(); i++)
//         {
//        	 String ste=allState.get(i).getText();
//        	 if(ste.equals("Maharashtra"))
//        	 {
//        		 allState.get(i).click();
//        		 break;
//        	 }
//         }
		driver.findElement(By.xpath("//input[@id='billing_postcode']")).sendKeys("416119");
		driver.findElement(By.xpath("//textarea[@id='order_comments']")).sendKeys("Happy Journy");
		
		   driver.findElement(By.xpath("//button[@id='place_order']")).click();
		
		
	}

}
