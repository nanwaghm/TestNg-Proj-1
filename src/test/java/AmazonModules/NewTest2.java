package AmazonModules;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class NewTest2 {
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(Integer n, Integer m,String s) {
	  System.out.println("elements 1 are:"+n);
	  Reporter.log("elements 1 are:"+n);
	  System.out.println("elements 2 are:"+m);                                                                                                                                                                    
	  Reporter.log("elements 2 are:"+m);
	 System.out.println("Sum of the elements are:"+(n+m));
	 Reporter.log("Sum of the elements are:"+(n+m));
	 System.out.println("string:"+s);
	 //driver.get("https://www.google.com/");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1,2, "a" },
      new Object[] { 2,4,"b" },
    };
    
    
  }
  
}
