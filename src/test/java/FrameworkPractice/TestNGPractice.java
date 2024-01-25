package FrameworkPractice;

import org.testng.annotations.Test;

public class TestNGPractice {

	@Test
	public void createCustomer() {
		System.out.println("hello"); //fail pass

	}
	
	@Test(dependsOnMethods="createCustomer")
	public void modifyCustomer() {
		System.out.println("modify"); //skip run
	}
	
	@Test
	public void deleteCustomer() {
		System.out.println("delete");
	}

}
