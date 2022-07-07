package AmazonModules;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.time.Duration;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	 WebDriver driver;
	
  @Parameters ({"Browser"})
  @Test
  public void crossBrowser(String browserLaunch) { 
	  
	  if(browserLaunch.equalsIgnoreCase("chrome")) {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
		  driver = new ChromeDriver(); 
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
	  }else if(browserLaunch.equalsIgnoreCase("IE")) {
		  
		  System.setProperty("webdriver.edge.driver", "C:\\Users\\nandini.waghmare\\Downloads\\msedgedriver.exe");
		  driver= new EdgeDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
	  }else if(browserLaunch.equalsIgnoreCase("FireFox")){
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\nandini.waghmare\\Downloads\\GeckoDriver.exe");
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("marionette",true);
		  driver= new FirefoxDriver(capabilities);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
		  
	  }
  }
	  
	  @Test
	 public void mobileSearch() throws AWTException {
		  driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
		  Reporter.log("Navigated to mobile cataegory succesfully");
		  
		  	WebElement brand = driver.findElement(By.cssSelector("#s-refinements > div:nth-child(5) > ul > li:nth-child(2) > span > a > span"));
			brand.click();
			Reporter.log("Selected brand");

			WebElement minprice = driver.findElement(By.cssSelector("input#low-price"));
			minprice.sendKeys("2000");
			Reporter.log("Min 20k");
			
			WebElement maxprice = driver.findElement(By.cssSelector("input#high-price"));
			maxprice.sendKeys("60000");
			Reporter.log("Min 60k");
			
			WebElement btngo = driver.findElement(By.cssSelector("input.a-button-input"));
			btngo.click();
			Reporter.log("Click Go");
			
			
			WebElement sortopt = driver.findElement(By.cssSelector("span.a-dropdown-label"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-dropdown-label")));
			sortopt.click();
			Reporter.log("Sorted");
			
			
			WebElement sort = driver.findElement(By.cssSelector("#s-result-sort-select_2"));
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
			
			
	  }
	  
	 
  }

