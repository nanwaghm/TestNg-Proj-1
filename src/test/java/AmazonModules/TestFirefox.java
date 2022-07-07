package AmazonModules;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


	public class TestFirefox {
		
		WebDriver driver;
		  	
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\nandini.waghmare\\Downloads\\GeckoDriver.exe");
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("marionette",true);
		  driver= new FirefoxDriver(capabilities);
		  driver.manage().window().maximize();
		  driver.get("https://www.amazon.in/");
		  System.out.println("This is beforeClass");
		  
	  }
	  
	  @Parameters ({"minf", "maxf"})
	  @Test
	  public void mobileSearch(String minvalue, String  maxvalue) {
		  
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#nav-xshop > a:nth-child(3)")));
		  driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();;
		  Reporter.log("Navigated to mobile cataegory succesfully");
		  
		  	WebElement brand = driver.findElement(By.cssSelector("#s-refinements > div:nth-child(5) > ul > li:nth-child(2) > span > a > span"));
			brand.click();
			Reporter.log("Selected brand");

			WebElement minprice = driver.findElement(By.cssSelector("input#low-price"));
			minprice.sendKeys(minvalue);
			Reporter.log("Min 20k");
			
			WebElement maxprice = driver.findElement(By.cssSelector("input#high-price"));
			maxprice.sendKeys(maxvalue);
			Reporter.log("Min 60k");
			
			WebElement btngo = driver.findElement(By.cssSelector("input.a-button-input"));
			btngo.click();
			Reporter.log("Click Go");
			
			
			WebElement sortopt = driver.findElement(By.cssSelector("span.a-dropdown-prompt"));			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.a-dropdown-prompt")));
			sortopt.click();
			Reporter.log("Sorted");
			
			
			WebElement sort = driver.findElement(By.cssSelector("#s-result-sort-select_2"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#s-result-sort-select_2")));
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
			  //Assert.assertEquals(mobprice.get(i).getText().replaceAll(",", "") ,mobprice.get(i).getText().replaceAll(",", ""));
			}**/
	  }


	@AfterClass
	  public void afterClass() {
		  driver.quit();
		  System.out.println("This is afterClass");
	  }

	}


