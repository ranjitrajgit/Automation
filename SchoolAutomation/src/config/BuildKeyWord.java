package config;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ReadProperties;

public class BuildKeyWord {
	ReadProperties ObjectName = new ReadProperties();
	Properties q=ObjectName.getObject();
	WebDriver driver= driverName(q);
	 WebDriverWait wait;
	/*Get the locator type*/
	private By getObject(Properties p,String ObjName,String ObjType) throws Exception{
		if (ObjType.equalsIgnoreCase("ID")){
			return By.id(p.getProperty(ObjName));
		}
		else if (ObjType.equalsIgnoreCase("Xpath")){
			return By.xpath(p.getProperty(ObjName));
		}
		else if (ObjType.equalsIgnoreCase("Name")){
			return By.name(p.getProperty(ObjName));
		}
		else if (ObjType.equalsIgnoreCase("PartialLink")){
			return By.partialLinkText(p.getProperty(ObjName));
		}
		else if (ObjType.equalsIgnoreCase("CSSSelector")){
			return By.cssSelector(p.getProperty(ObjName));
		}
		else if (ObjType.equalsIgnoreCase("LinkText")){
			return By.linkText(p.getProperty(ObjName));
		}
		else{
			return By.linkText(p.getProperty("BrowserName"));
		}
	}
	
	
	public void performOperation(Properties p,String Operation,String ObjName,String ObjType,String value ) throws Exception{
		System.out.println("Picking Element");
		switch(Operation){
		case "Click":
			driver.findElement(this.getObject(p, ObjName, ObjType)).click();
			break;
		case "SetText":
			driver.findElement(this.getObject(p, ObjName, ObjType)).sendKeys(value);
			break;
		case "GoToURL":
			System.out.println("Navigating to URL");
			driver.get(p.getProperty("URL"));
			break;
		case "SelectCheckBox":
			//Select element = new Select (driver.findElement(this.getObject(p, ObjName, ObjType)));
			driver.findElement(this.getObject(p, ObjName, ObjType)).click();
			break;
		case "SelectDropDown":
			Select country = new Select (driver.findElement(this.getObject(p, ObjName, ObjType)));
			country.selectByVisibleText(value);
			break;
		case "Scroll":
			Thread.sleep(5000);
			((JavascriptExecutor)driver).executeScript("scroll(0,400)");
			break;
				
		}
			
		}	
		
	public WebDriver driverName(Properties p){
		String Browser=p.getProperty("BrowserName");
				if(Browser.equalsIgnoreCase("FireFox")){
			System.out.println("Opening Firefox");
			System.setProperty("webdriver.gecko.driver",p.getProperty("GeckoDriverPath"));
            driver= new FirefoxDriver();
				}
		else if (Browser.equalsIgnoreCase("Chrome"))  {
			System.setProperty("webdriver.chrome.driver",p.getProperty("ChromeDriverPath"));
			driver= new ChromeDriver();
			driver.manage().window().maximize();
				}
		else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",p.getProperty("IEDriverPath"));
			driver= new InternetExplorerDriver();
									
				}
				return driver;
	}
	}


