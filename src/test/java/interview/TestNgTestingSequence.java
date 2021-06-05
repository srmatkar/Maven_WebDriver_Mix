package interview;

import org.testng.annotations.Test;

public class TestNgTestingSequence {

	@Test(priority = -1)
	public void PriorityNegativeOne() {

		System.out.println("PriorityNegativeOne executed");
	}

	@Test
	public void NoExplicitPriority() {

		System.out.println("NoExplicitPriority executed");

	}

	@Test(priority = 1)
	public void PriorityOne() {

		System.out.println("PriorityOne executed");

	}

	@Test
	public void PriorityOneTwo() {

		System.out.println("After PriorityOneSecond executed (albhabetically after PriorityOneSecond");
	}

	@Test
	public void PriorityOneSecond() {

		System.out.println("After PriorityOne executed -PriorityOneSecond ");
	}

}
