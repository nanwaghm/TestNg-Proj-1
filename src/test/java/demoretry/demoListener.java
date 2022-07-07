package demoretry;

import static org.junit.Assert.assertTrue;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class demoListener implements IRetryAnalyzer {
 public int counter = 0;
		 public int maxretry = 3;
 
	
	@Test(retryAnalyzer = demoretry.demoListener.class)
  public void retryfail() {
	  System.out.println("in retry dummy function");
	  Assert.assertTrue(false);
  }

@Override

public boolean retry(ITestResult result) {
	// TODO Auto-generated method stub
	if (counter<maxretry) {
		counter++;
		return true;
	}
	return false;
}
}
