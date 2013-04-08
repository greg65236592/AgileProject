import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Test int showRank(String ID)
public class testshowRank
{
	GradeSystems testGradeSystems;
	
	@Before
	public void setUp() throws Exception
	{
		testGradeSystems = new GradeSystems();
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	//Test Case 1¡Ginput¡G 955002056 expected output¡G9
	public void test1()
	{
		String input = "955002056";
		int expected = 9;
		int result;

		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}
	
	@Test
	//Test Case 2¡Ginput¡G 986002026 expected output¡G32
	public void test2()
	{
		String input = "986002026";
		int expected = 32;
		int result;

		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}
	
	@Test
	//Test Case 3¡Ginput¡G 975002070 expected output¡G1
	public void test3()
	{
		String input = "975002070";
		int expected = 1;
		int result;

		result = testGradeSystems.showRank(input);

		assertEquals(expected, result);
	}
}
