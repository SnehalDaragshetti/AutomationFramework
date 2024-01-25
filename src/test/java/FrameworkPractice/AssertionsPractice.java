package FrameworkPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractice {
	
	@Test
	public void sample() {
		String data = "abc";
		
		System.out.println("step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(1, 1);
		
		Assert.assertTrue(data.contains("c"));
		
		System.out.println("step 3");
		System.out.println("step 4");
	}
	
	@Test
	public void softSample() {
		String data1 = "abc";
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step 1");
		System.out.println("step 2");
		
		sa.assertEquals(0, 1);
		
		System.out.println("step 3");
		System.out.println("step 4");
		
		sa.assertAll();// if we don't use this this soft assert will give 
					   // pass only, this is why hard assert is better
		
	}

}
