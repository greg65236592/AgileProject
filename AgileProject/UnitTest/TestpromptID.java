import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import org.junit.Before;
import org.junit.Test;


public class TestPromptID
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		String inContent = "Q";
		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		testUI = new UI();
	}

	//promptID
	@Test
	//Test Case 1¡GinContent¡G "955002056" expected output¡G"955002056"
	public void testpromptID1()
	{
		String inContent = "955002056";
		String expected = "955002056";
		String result;

		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		result = testUI.promptID();

		assertEquals(expected, result);
	}

	@Test
	//Test Case 2¡GinContent¡G "12345" expected output¡G"12345"
	public void testpromptID2()
	{
		String inContent = "12345";
		String expected = "12345";
		String result;

		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		result = testUI.promptID();

		assertEquals(expected, result);
	}

}
