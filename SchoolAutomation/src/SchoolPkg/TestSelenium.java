package SchoolPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestSelenium {
	
	WebDriver driver;
	
	
	public void invokebrowser(){
		
		try {
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\JAVA+Selenium\\Selenium\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.google.co.in");
			driver.findElement(By.id("lst-ib")).sendKeys("hello world");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		TestSelenium myobj = new TestSelenium();
		myobj.invokebrowser();
		

	}

}
