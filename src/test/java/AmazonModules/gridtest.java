package AmazonModules;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class gridtest {

	RemoteWebDriver driver;
  
  //public void f1() throws MalformedURLException {
	 // System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
	  //driver = new ChromeDriver(); 
	 // driver.manage().window().maximize();
	 // ChromeOptions chromeOpt = new ChromeOptions();
	  //chromeOpt.setCapability("platformName", "Windows 10");
	  //chromeOpt.setCapability("se:name", "My simple test"); 
	  //chromeOpt.setCapability("se:sampleMetadata", "Sample metadata value");
	 // driver = new RemoteWebDriver(new URL("http://localhost:4444"),chromeOpt);
	  
	  
	 // FirefoxOptions options = new FirefoxOptions();
	 // options.addPreference("network.proxy.type", 0);
	//  driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
	  
	   /** EdgeOptions options = new EdgeOptions();
	    options.setCapability("platform", "Any");
	    options.setCapability("browserName", "MicrosoftEdge");
	    driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
	    driver.get("http://www.google.com");
	 
	 // driver.get("https://www.amazon.in/");**/
  
  

	
  @Parameters ({"Browser"})
  @Test
  public void crossBrowser(String browserLaunch) throws MalformedURLException { 
	  
	  if(browserLaunch.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
		  ChromeOptions chromeOpt = new ChromeOptions();
		  chromeOpt.setCapability("platformName", "Windows 10");
		  chromeOpt.setCapability("se:name", "My Grid Chrome test"); 
		  chromeOpt.setCapability("se:sampleMetadata", "Sample metadata value");
		  driver = new RemoteWebDriver(new URL("http://localhost:4444"),chromeOpt);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
		 // driver.get("http://www.google.com");
	  }else if(browserLaunch.equalsIgnoreCase("IE")) {
		  
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\nandini.waghmare\\Downloads\\msedgedriver.exe");
		  EdgeOptions options = new EdgeOptions();
		    options.setCapability("platform", "Any");
		    options.setCapability("browserName", "MicrosoftEdge");
		    options.setCapability("se:name", "My Grid edge test");
		    driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
	  }else if(browserLaunch.equalsIgnoreCase("FireFox")){
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\nandini.waghmare\\Downloads\\GeckoDriver.exe");
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("marionette",true);
		  //driver= new FirefoxDriver(capabilities);
		  FirefoxOptions options = new FirefoxOptions();
		  options.addPreference("network.proxy.type", 0);
		  options.setCapability("se:name", "My Grid Firefox test");
		  driver = new RemoteWebDriver(new URL("http://localhost:4444"),options);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
		  
	  }
  }
	  
	  @Test
	 public void mobileSearch() throws AWTException {
		  driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
		  Reporter.log("Navigated to mobile cataegory succesfully");
		  
		  	WebElement brand = driver.findElement(By.cssSelector("#s-refinements > div:nth-child(5) > ul > li:nth-child(1) > span > a > span"));
			brand.click();
			Reporter.log("Selected brand");

			WebElement minprice = driver.findElement(By.cssSelector("input#low-price"));
			minprice.sendKeys("20000");
			Reporter.log("Min 20k");
			
			WebElement maxprice = driver.findElement(By.cssSelector("input#high-price"));
			maxprice.sendKeys("60000");
			Reporter.log("Min 60k");
			
			WebElement btngo = driver.findElement(By.cssSelector("input.a-button-input"));
			btngo.click();
			Reporter.log("Click Go");
			
			
			//WebElement sortopt = driver.findElement(By.cssSelector("span.a-dropdown-label"));
			WebElement sortopt = driver.findElement(By.xpath("//span[contains(text(),'Featured')]"));
			//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Featured')]")));		
			sortopt.click();
			Reporter.log("Sorted");
			
			
			WebElement sort = driver.findElement(By.xpath("//a[contains(text(),'Price: High to Low')]"));
			sort.click();
			Reporter.log("Sorted:Price High to low");
			
		
		/**By mySelector = By.cssSelector("div.s-title-instructions-style span");
		List<WebElement> myElements = driver.findElements(mySelector);
		for(int i=0; i<4; i++) {
			Reporter.log(myElements.get(i).getText());
		  Assert.assertTrue(myElements.get(i).getText().contains("OnePlus"),"First search result for selected mobile brand is not as expected");
		}
		
		By price = By.cssSelector("span.a-price-whole");
		List<WebElement> mobprice = driver.findElements(price);
		for(int i=0; i<4; i++) {
			Reporter.log(mobprice.get(i).getText());
		  Assert.assertEquals(mobprice.get(i).getText().replaceAll(",", "") ,mobprice.get(i).getText().replaceAll(",", ""));
		}**/
			driver.close();
			
	  }
}
