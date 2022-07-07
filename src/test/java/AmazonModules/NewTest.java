package AmazonModules;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	
	RemoteWebDriver driver;
	  	
 
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
	  //driver = new ChromeDriver(); 
	 // driver.manage().window().maximize();
	  ChromeOptions chromeOpt = new ChromeOptions();
	  chromeOpt.setCapability("platformName", "Windows");
	  chromeOpt.setCapability("se:name", "My simple test"); 
	  chromeOpt.setCapability("se:sampleMetadata", "Sample metadata value");
	  //driver = new RemoteWebDriver(new URL("http://gridUrl:4444"), chromeOptions);
	  driver = new RemoteWebDriver(new URL("http://localhost:4444/ui"),chromeOpt);
	  driver.get("http://www.google.com");
	 
	 // driver.get("https://www.amazon.in/");
	  System.out.println("This is beforeClass");
	  
  }
  
  /**
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is BeforeTest");
	  Reporter.log("This is BeforeTest");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is BeforeMerthod");
	  Reporter.log("This is BeforeMerthod");
  }
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is AfterMethod");
	  Reporter.log("This is AfterMethod");
  }
  @AfterTest
  public void afterTest() {
	  System.out.println("This is AfterTest");
	  Reporter.log("This is AfterTest");
  }

  @Test
  public void dummyTest() {
	  System.out.println("This is dummy Test method");
	  
  }**/
 
  @Parameters ({"min", "max"})
  @Test
  public void mobileSearch(String minvalue, String  maxvalue) {
	  
	  driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();;
	  Reporter.log("Navigated to mobile cataegory succesfully");
	  
	  	WebElement brand = driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']/following::span[contains(text(),'OnePlus')]"));
		brand.click();
		Reporter.log("Selected brand");

		WebElement minprice = driver.findElement(By.xpath("//input[@id='low-price']"));
		minprice.sendKeys(minvalue);
		Reporter.log("Min 20k");
		
		WebElement maxprice = driver.findElement(By.xpath("//input[@id='high-price']"));
		maxprice.sendKeys(maxvalue);
		Reporter.log("Min 60k");
		
		WebElement btngo = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
		btngo.click();
		Reporter.log("Click Go");
		
		WebElement sortopt = driver.findElement(By.xpath("//span[contains(text(),'Featured')]"));
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
  }


@AfterClass
  public void afterClass() {
	  driver.quit();
	  System.out.println("This is afterClass");
  }

@AfterSuite
public void aftersuite1() {
	 
	  System.out.println("This is @AfterSuite1");
}

@BeforeSuite
public void beforesuite1() {
	 
	  System.out.println("This is @beforesuite1");
}

}
