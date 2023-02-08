package selenium_projects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight_Project {

	public static void main(String[] args) throws InterruptedException {
		
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			// 1.open link
			driver.get("https://blazedemo.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			// 2.select portland from departure city
		List<WebElement> drp_Total	=driver.findElements(By.xpath("//select[@name='fromPort']/child::option"));
			System.out.println("Total no. of dropdowns in departure city :"+ drp_Total.size());
				
			for(int i=0; i<drp_Total.size(); i++) {
				String options=drp_Total.get(i).getText();
			     if(options.equals("Portland")) 
			     {
			    	 drp_Total.get(i).click();
			     }
			}
			Thread.sleep(3000);
			     //3.select london from destinat. city
			List<WebElement> drp_total2=driver.findElements(By.xpath("//select[@name='toPort']/child::option"));
			System.out.println("Total no. of options in destination city :"+ drp_total2.size());
			     /*
			     for(int i=0; i<drp_total2.size();i++)
			     {
			    	 System.out.println(drp_total2.get(i).getText());
			     }
			     */
			     for(int i=0; i<drp_total2.size();i++)
			     {
			    	 String options2=drp_total2.get(i).getText();
			    	 if(options2.equals("London"))
			    	 {
			    		 drp_total2.get(i).click();
			    	 }
			     }
			     
			   //4.click on final flights
			     driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
			     Thread.sleep(3000);
			     // 5.Total no. of  flights displayed
			    List<WebElement> Total_Flight =driver.findElements(By.xpath("//tbody/tr"));
			    
			     System.out.println("Total no. of flights  displayed for portland to london :"+Total_Flight.size());
			     
			     // 6 click on 2nd  flightbutton
			     driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
			     Thread.sleep(3000);
			     // 7. Validate the details
			          //validate airline name
			     String airline_Txt=driver.findElement(By.xpath("//p[normalize-space()='Airline: United']")).getText();
			     
			     System.out.println(airline_Txt);
			     if(airline_Txt.equalsIgnoreCase("Airline: United"))
			     {
			    	 System.out.println("Test 1 is passed");
			     }
			     else {
			    	 System.out.println("Test 1 is failed");
			     }
			     Thread.sleep(3000);
			       //validate flight number
			     String txt_flightno=driver.findElement(By.xpath("//p[normalize-space()='Flight Number: UA954']")).getText();
			     
			     if(txt_flightno.equalsIgnoreCase("Flight Number: UA954"))
			     {
			    	 System.out.println("Test 2 is passed");
			     }
			     else
			     {
			    	 System.out.println("Test 2 is failed");
			     }
			     
			     //validate price
			     String price=driver.findElement(By.xpath("//p[normalize-space()='Price: 400']")).getText();
			
	  if(price.equalsIgnoreCase("Price: 400") )
	  {
		  System.out.println("Test 3 is passed");
	  }
	  else
	  {
		  System.out.println("Test 3 is failed");
	  }
	  Thread.sleep(3000);
	//validate arbitary fees
	   String txt_arbitaryFees=driver.findElement(By.xpath("//p[normalize-space()='Arbitrary Fees and Taxes: 514.76']")).getText();
	
	if (txt_arbitaryFees.equalsIgnoreCase("Arbitrary Fees and Taxes: 514.76"))
	   {
		System.out.println("Test 4 is passed");
	   }
	else
	{
		System.out.println("Test 4 is failed");
	}
	Thread.sleep(3000);
	//validate total cost
	String txt_totalCost=driver.findElement(By.xpath("//em[normalize-space()='914.76']")).getText();
	
	if(txt_totalCost.equalsIgnoreCase("914.76"))
	{
		System.out.println("Test 5 is passed");
	}
	else
	{
		System.out.println("Test 5 is failed");
	}
	
	// 8.provide all the details 
	driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Sanket");
	
	driver.findElement(By.xpath("//input[@id='address']")).sendKeys("chinchwad");
	
	driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kolhapur");
	
	driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Maharashtra");
	
	driver.findElement(By.xpath("//input[@id='zipCode']")).sendKeys("416119");
	
	 List<WebElement> drp_cardType=driver.findElements(By.xpath("//select[@class='form-inline']/child::option"));
	 drp_cardType.size();
	  Thread.sleep(2000);
	 for(int i=0; i< drp_cardType.size(); i++)
	 {
		 String options=drp_cardType.get(i).getText();
		 if(options.equalsIgnoreCase("visa"))
		 {
			 drp_cardType.get(i).click();
			 
		 }
	 }
	
	 
//	 driver.findElement(By.xpath("//input[@id='creditCardNumber']")).sendKeys("123456789");
//	 
//	 driver.findElement(By.xpath("//input[@id='creditCardMonth']")).sendKeys("03");
//	 
//	 driver.findElement(By.xpath("//input[@id='creditCardYear']")).sendKeys("2029");
//	 
//	 driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("Sanket Patil");
	 
	 //click on purchase flight btn
	 
	 driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
	 
	 // 9 . verify the details
	 
	 String txt_tnk=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
	
	if(txt_tnk.equalsIgnoreCase("Thank you for your purchase today!"))
	{
		System.out.println("Test is r1 pass");
	}
	else
	{
		System.out.println("Test is r1 fail");
	}
	
	String  id=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();

	String id2=driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
	System.out.println(id + id2);
	 
	

	String id3=id.concat(id2);
	System.out.println(id3);
	

	if(id3.equals("Id1674816020765"))
	{
		System.out.println("R2 passs");
	}
	else
	{
		System.out.println("r2 fail");
	}
	
	
	}

}


