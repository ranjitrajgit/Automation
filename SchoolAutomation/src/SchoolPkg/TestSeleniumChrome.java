package SchoolPkg;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.*;
	import org.openqa.selenium.remote.RemoteWebDriver;

	public class TestSeleniumChrome {
		
		WebDriver driver;
		
			public void invokebrowser(){
			
			try {
				System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\JAVA+Selenium\\Selenium\\chromedriver_win32\\chromedriver.exe");
				RemoteWebDriver driver = new ChromeDriver();
				
				driver.manage().deleteAllCookies();
				
				driver.get("https://www.google.co.in");
				driver.findElement(By.id("lst-ib")).sendKeys("hello world");
				driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
				
			
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		public static void main(String[] args) {
			
			TestSelenium myobj = new TestSelenium();
			myobj.invokebrowser();
			
		}

	}
