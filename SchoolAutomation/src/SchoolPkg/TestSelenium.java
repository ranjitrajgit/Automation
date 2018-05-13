package SchoolPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestSelenium {
	
	WebDriver driver;
	
		public void invokebrowser(){
		
		try {
			System.setProperty("webdriver.gecko.driver", "D:\\Softwares\\JAVA+Selenium\\Selenium\\geckodriver-v0.20.0-win64\\geckodriver.exe");
			RemoteWebDriver driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			
			driver.get("https://www.google.co.in");
			//driver.findElement(By.id("lst-ib")).sendKeys("Ranjit Kumar");
			//driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Ranjit_Kumar']")).click();
			//driver.findElement(By.linkText("Ranjit_Kumar")).click();
			//driver.findElement(By.partialLinkText("https://en.wikipedia.org/wiki/Ranjit_Kumar")).click();
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			for(WebElement ele: links)
				System.out.println(ele.getAttribute("href"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		TestSelenium myobj = new TestSelenium();
		myobj.invokebrowser();
		

	}

}
