package lib;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AUT_lib 
{
	private static WebDriver odriver=null;
	public static WebDriver BrowserInit(String sbr) 
	{
		if(sbr.isEmpty())
		{
			System.err.println("Browser type is empmty fail to initialize the browser.");
			return odriver;
		}
		else 
		{
			String sdriverpath;
			switch (sbr.toUpperCase())
			{
			case "CHROME": sdriverpath="C:\\Selenium webDriver Demo\\Driver and jars\\chromedriver.exe";
		      System.setProperty("webdriver.chrome.driver", sdriverpath);
		      odriver =new ChromeDriver();
				
				
			break;
				
			case "EDGE":  sdriverpath="C:\\Selenium webDriver Demo\\Driver and jars\\msedgedriver.exe";
		      System.setProperty("webdriver.edge.driver", sdriverpath);
		      odriver =new  EdgeDriver();
				
				
			break;
				
			case "FIREFOX": sdriverpath="C:\\Selenium webDriver Demo\\Driver and jars\\geockodriver.exe";
		      System.setProperty("webdriver.gecko.driver", sdriverpath);
		      odriver =new FirefoxDriver();
				
				
			break;

			default:
				
				System.err.println("Invoking default chrome browser name specified: "+sbr);
			    sdriverpath="C:\\Selenium webDriver Demo\\Driver and jars\\chromedriver.exe";
		        System.setProperty("webdriver.chrome.driver", sdriverpath);
		        odriver =new ChromeDriver();
				break;
			}
			odriver.manage().window().maximize();
			odriver.manage().deleteAllCookies();
			odriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			odriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
			odriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return odriver;
		}
		
	}
	
	public static void passtheexecution(int isec) 
	{
		
		try {
			Thread.sleep(isec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void selectRedioButton(By oby,String name) 
	{
		if(odriver.findElement(oby).isSelected()==false) 
		{
			odriver.findElement(oby).click();
		}
		else
		{
			System.err.println(name+" :Redio button already seleted");
			
			
		}
		
	}
	
	
	public static void setCheckBoxOn(By oby,String name) 
	{
		if(odriver.findElement(oby).isSelected()==false) 
		{
			odriver.findElement(oby).click();
		}
		else
		{
			System.err.println(name+" :Check box already seleted");
			
			
		}
		
	}
	public static void waitforattributevaluematch(By oby,String attrname,String attrvalue) 
	{
		WebDriverWait owait=new WebDriverWait(odriver, 200);
		owait.until(ExpectedConditions.attributeContains(oby, attrname, attrvalue));
		
		
		
	}
	public static void waitforVISIBILITYOFELEMENT(By oby) 
	{
		WebDriverWait owait=new WebDriverWait(odriver, 200);
		owait.until(ExpectedConditions.visibilityOfElementLocated(oby));
		
		
	}
	public static void closealert(String slocation) 
	{
		try
		{
			System.out.println(odriver.switchTo().alert().getText());
			
			odriver.switchTo().alert().dismiss();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("alert not found slocation.");
			
	}
	}
	
	
		
		public static void captureScreenshot(String spath)
		{
			TakesScreenshot oscrScreenshot= ((TakesScreenshot)odriver);
			File srcFile=oscrScreenshot.getScreenshotAs(OutputType.FILE);
			File dstfile= new File(spath);
			try {
				FileUtils.copyFile(srcFile, dstfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	




