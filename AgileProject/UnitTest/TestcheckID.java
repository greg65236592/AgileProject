import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;

public class TestCheckID
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		String inContent = "Q";
		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		testUI = new UI();
	}

	//checkID
	@Test
	//Test Case 1¡Ginput¡G 955002056 expected output¡Gtrue
	public void testcheckID1() throws NoSuchIDExceptions
	{
		String input = "955002056";
		Boolean expected = true;
		Boolean result;

		result = testUI.checkID(input);

		assertEquals(expected, result);
	}

	@Test
	//Test Case 2¡Ginput¡G962001044 expected output¡Gtrue
	public void testcheckID2() throws NoSuchIDExceptions
	{
		String input = "962001044";
		Boolean expected = true;
		Boolean result;

		result = testUI.checkID(input);

		assertEquals(expected, result);
	}

}
