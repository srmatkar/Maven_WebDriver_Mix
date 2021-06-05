package retryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryInTestNg1 { 
	
	// Basic approach is to include retry analyser from testng 
	// Not very good since you have to include this for each and every test

	@Test(retryAnalyzer =analysers.MyRetryAnalyser.class)
	public void test1() {

		Assert.assertEquals(false, true);

	}

	@Test
	public void test2() {

		Assert.assertEquals(false, true);
	}

}
