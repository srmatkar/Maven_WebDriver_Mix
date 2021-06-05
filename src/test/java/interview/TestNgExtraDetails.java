package interview;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.SampleTest;

public class TestNgExtraDetails {
	
	@Test(invocationCount = 2)
	public void sampleTest() {
		System.out.println("This is a sample test");
		Assert.assertTrue(false);
	}
	@Test(alwaysRun = true,  dependsOnMethods = "sampleTest", dependsOnGroups = {"sanity"})
	public void dependentTest() {
		System.out.println("This depends on sampleTest");
	}
	
	@Test(groups = {"sanity", "functional"})
	public void sanity1() {
		System.out.println("This is sanity1 test");
	}

	@Test(groups = {"sanity", "functional"})
	public void sanity2() {
		System.out.println("This is sanity2 test");
	}
}
