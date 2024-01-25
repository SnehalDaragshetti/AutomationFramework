package FrameworkPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.IRetryAnalyzer;


public class RetryAnalyserPractice {

	@Test(retryAnalyzer = GenericUtilities.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("hi");
	}

}
