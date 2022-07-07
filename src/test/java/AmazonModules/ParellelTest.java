package AmazonModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParellelTest {
	
		WebDriver driver;
		
		@Test
		public void method1() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
			  driver = new ChromeDriver(); 
			  driver.manage().window().maximize();
			  driver.get("https://www.amazon.in/");
			System.out.println("method1: "+Thread.currentThread());
		}
		
		@Test
		public void method2() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nandini.waghmare\\Downloads\\chromedriver.exe");
			  driver = new ChromeDriver(); 
			  driver.manage().window().maximize();
			  driver.get("https://www.amazon.in/");
			System.out.println("method2: "+Thread.currentThread());
		}

	
}
