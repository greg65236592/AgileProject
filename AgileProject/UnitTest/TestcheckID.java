import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestcheckID
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		testUI = new UI();
	}

	@Test
	//Test Case 1¡Ginput¡G 955002056 expected output¡Gtrue
	public void testcheckID1()
	{
		String input = "955002056";
		Boolean expected = true;
		Boolean result;

		result = testUI.checkID(input);

		assertEquals(expected, result);
	}
	
	@Test
	//Test Case 2¡Ginput¡G 12345 expected output¡Gfalse
	public void testcheckID2()
	{
		String input = "12345";
		Boolean expected = false;
		Boolean result;

		result = testUI.checkID(input);

		assertEquals(expected, result);
	}

}
