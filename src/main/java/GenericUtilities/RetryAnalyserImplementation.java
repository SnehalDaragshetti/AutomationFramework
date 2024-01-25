package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author Snehal
 * This class provides implementation for the IretryAnalyzer interface of TestNG
 */

public class RetryAnalyserImplementation implements IRetryAnalyzer {
	int count =0;
	int retryCount =3; //manual analysis
	
	
	public boolean retry(ITestResult result) {
		
		//0<3 1<3 2<3 3<3-no
		while(count<retryCount) {
			count++;//1 2 3
			return true;//retry retry retry
		}
		return false;//stop retrying
		
	}

}
