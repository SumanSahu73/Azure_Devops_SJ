package Day1;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import lib.AUT_lib;

public class TestCase01 {
	
   /* public boolean purchaseValidation() {
    	 By owd = null;
    	 
		WebElement p= Driver.class(By.xpath("//h2[text()='Thank you for your purchase!']"));
       // HighlightElement.highlightElement(driver, //h2[text()='Thank you for your purchase!']);
        if (p.getAttribute("innerText").contains("Thank you for your purchase"))
            return true;
        else
            return false;

 

    }
    */


	private String getAttribute(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	private static final String Assert = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		TestCase01 obj= new TestCase01();
		
     WebDriver owd=AUT_lib.BrowserInit("Chrome");
     if(owd==null) 
     {
    	 System.err.println("Script Execution Stops because WebDriver initialization failed.");
    	 
     }
     else 
     {
    	 
    	 String SAutUrl="https://www.demoblaze.com/index.html";
    	 owd.get(SAutUrl);
    	 if(owd.getCurrentUrl().contains(SAutUrl)==true)
    	 {
    		 System.out.println("page title: "+owd.getTitle());
    		 System.out.println("browser handle number: "+owd.getWindowHandle());
    	     System.out.println("No of browser instances open till in current run session: "+owd.getWindowHandles().size());
    	     
    	     System.setProperty("webdriver.chrome.driver", "C:\\\\Selenium webDriver Demo\\\\Driver and jars\\\\chromedriver.exe");
    	 //	WebDriver owd=new ChromeDriver();
    	 	owd.manage().window().maximize();
    	// 	driver.get("https://www.demoblaze.com/index.html");
    	 	owd.findElement(By.xpath("//*[@id=\"login2\"]")).click();
    	 	Thread.sleep(2000);
    	 	//WebElement username=driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[2]/form/div[1]/label"));
    	 	 owd.findElement(By.xpath("//label[@for='log-name']/following-sibling::input[1]")).sendKeys("aa");
    	 	 Thread.sleep(2000);
    	 	//WebElement password=driver.findElement(By.xpath("//*[@id=\"loginpassword\"]"));
    	 	 owd.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("aa");
    	 	//WebElement login=driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
    	 	 Thread.sleep(2000);
    	 	
    	 	 owd.findElement(By.xpath("//button[text()='Log in']")).click();
    	 	
    	 	Thread.sleep(2000);
    	 //	String actualUrl="https://www.demoblaze.com/index.html#";
    	 //	String expectedUrl= driver.getCurrentUrl();
    	 //	Assert.assertEquals(expectedUrl,actualUrl);
    	     
    	    owd.findElement(By.linkText("Samsung galaxy s6")).click();
    	    owd.findElement(By.linkText("Add to cart")).click();
    	   // owd.switchTo().alert().accept();
    	    owd.findElement(By.xpath("//a[@href='cart.html']")).click();
    	    owd.findElement(By.xpath("//button[text()='Place Order']")).click();
    	    owd.findElement(By.xpath("//label[text()='Name:']/following-sibling::input")).sendKeys("Suman");
    	    owd.findElement(By.xpath("//label[text()='Country:']/following-sibling::input")).sendKeys("India");
    	    owd.findElement(By.xpath("//label[text()='City:']/following-sibling::input")).sendKeys("Raipur");
    	    owd.findElement(By.xpath("//label[text()='Credit card:']/following-sibling::input")).sendKeys("123456789");
    	    owd.findElement(By.xpath("//label[text()='Month:']/following-sibling::input")).sendKeys("july");
    	    owd.findElement(By.xpath("//label[text()='Year:']/following-sibling::input")).sendKeys("2023");
    	    Thread.sleep(2000);
    	    owd.findElement(By.xpath("//button[text()='Purchase']")).click();
    	    Thread.sleep(2000);
    	   // obj.purchaseValidation();
    	    owd.findElement(By.xpath("//button[text()='OK']")).click();
    	    Thread.sleep(2000);
    	   System.out.println("current url: "+owd.getCurrentUrl());  
    	   if(owd.getCurrentUrl().contains(SAutUrl)==true)
    	   {
    		   System.err.println("We are in home page");
    	   }
    	   owd.findElement(By.linkText("Log out")).click();
    	   
    	  /*   owd.findElement(By.id("sb_form_q")).clear();
    	     owd.findElement(By.id("sb_form_q")).sendKeys("blue");
    	     owd.findElement(By.id("sb_form_go")).submit();
    	     */
    	     AUT_lib.passtheexecution(5);
    	     
    	     
    	     
    	    
    			    		    		 
    	 }
    	 
    	 else {
    		 System.err.println("Navigated to invalid url,:"+owd.getTitle());
    	 }
    	
    	 
     }
     owd.quit();
     
    		 
	}

}
