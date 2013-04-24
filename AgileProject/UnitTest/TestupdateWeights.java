import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestupdateWeights
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
	//Test Case ：input： null  expected output：null
	public void test()
	{

		String inContent = "20\r\n20\r\n20\r\n20\r\n20\r\nY\r\n";
		String expected = String.format("舊配分\n\tlab1\t\t10%%\n\tlab2\t\t10%%\n\tlab3\t\t10%%\n\tmid-term\t30%%\n\tfinal exam\t40%%\n輸入新配分\n\tlab1\t\t\tlab2\t\t\tlab3\t\t\tmid-term\t\tfinal exam\t請確認新配分\n\tlab1\t\t%d%%\n\tlab2\t\t%d%%\n\tlab3\t\t%d%%\n\tmid-term\t%d%%\n\tfinal exam\t%d%%\n", 20, 20, 20, 20, 20);
		String result;

		System.setIn(new ByteArrayInputStream(inContent.getBytes()));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		testGradeSystems.updateWeights();

		System.setOut(new PrintStream(outContent));
		result = outContent.toString();
		assertEquals(expected, result);
	}

}
