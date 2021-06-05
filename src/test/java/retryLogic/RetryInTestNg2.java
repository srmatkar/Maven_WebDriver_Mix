package retryLogic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryInTestNg2 {

	// Using annotation transformation

	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(1, 1);
	}
	
	@Test
	public void test4() {
		Assert.assertEquals("abc", "abc");
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(1.00f, 1.01f);
	}

}
