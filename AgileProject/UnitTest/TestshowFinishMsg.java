import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class TestshowFinishMsg
{
	UI testUI;

	@Before
	public void setUp() throws Exception
	{
		testUI = new UI();
	}

	
	@Test
	//Test Case 1�Ginput�G null expected output�Gprint "�����F"
	public void testshowFinishMsg()
	{
		String expected ="�����F";
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		
		System.setOut(new PrintStream(outContent));
		testUI.showFinishMsg();
		String[] result=outContent.toString().split("\r");
		assertEquals(expected, result[0]);
	}

}