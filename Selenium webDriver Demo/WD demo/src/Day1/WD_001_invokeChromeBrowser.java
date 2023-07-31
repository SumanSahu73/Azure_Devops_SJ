package Day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WD_001_invokeChromeBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String Sdriverpath="C:\\Selenium webDriver Demo\\Driver and jars\\chromedriver.exe";
      System.setProperty("webdriver.chrome.driver", Sdriverpath);
      WebDriver Owd=new ChromeDriver();
      
	}

}
